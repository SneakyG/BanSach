package sneakyg.giang.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.IChiTietHoaDonDAO;
import sneakyg.giang.dao.interfaces.IGioHangDAO;
import sneakyg.giang.dao.interfaces.IHoaDonDAO;
import sneakyg.giang.dao.interfaces.IKhachHangDAO;
import sneakyg.giang.dao.interfaces.ISachDAO;
import sneakyg.giang.model.ChiTietHoaDon;
import sneakyg.giang.model.HoaDon;
import sneakyg.giang.model.KhachHang;
import sneakyg.giang.model.Sach;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.service.interfaces.IChiTietHoaDonService;

public class ChiTietHoaDonService implements IChiTietHoaDonService {

	@Inject
	private IChiTietHoaDonDAO cthdDAO;

	@Inject
	private ISachDAO sachDAO;

	@Inject
	private IHoaDonDAO hoaDonDAO;
	
	@Inject 
	private IKhachHangDAO khachHangDAO;

	@Inject 
	private IGioHangDAO gioHangDAO;
	
	@Override
	public List<ChiTietHoaDon> findAll(IPageble pageble, String textSearch) {
		return cthdDAO.findAll(pageble, textSearch);
	}

	@Override
	public List<ChiTietHoaDon> search(IPageble pageble, String textSearch) {
		return cthdDAO.search(pageble, textSearch);
	}

	@Override
	public ChiTietHoaDon findOne(Integer id) {
		return cthdDAO.findOne(id);
	}

	@Override
	public List<ChiTietHoaDon> save(List<ChiTietHoaDon> cthd, Integer maTaiKhoan) {
		LocalDateTime currentTime = LocalDateTime.now();
		List<ChiTietHoaDon> ds = new ArrayList<ChiTietHoaDon>();
		Sach sach = new Sach();
		HoaDon hd = new HoaDon(Timestamp.valueOf(currentTime),0,0);
		KhachHang user = khachHangDAO.findByUserId(maTaiKhoan);
		hd.setMaKhachHang(user.getId());
		int maHoaDon = hoaDonDAO.save(hd);
		hd = hoaDonDAO.findOne(maHoaDon);
		for (ChiTietHoaDon item : cthd) {
			sach = sachDAO.findOne(item.getMaSach());
			item.setThanhTien(item.getSoLuong() * sach.getDonGia());
			item.setMaHoaDon(maHoaDon);
			int soLuongCon = sach.getSoLuong() - item.getSoLuong();
			if (soLuongCon >= 0) {
				int id = cthdDAO.save(item);
				sach.setSoLuong(soLuongCon);
				sachDAO.update(sach);
				gioHangDAO.deleteAll(maTaiKhoan);
				ds.add(cthdDAO.findOne(id));
			} else {
				hoaDonDAO.delete(maHoaDon);
				break;
			}
		}
		double tongTien = cthdDAO.getTotalCostByMaHoaDon(maHoaDon) + 20000;
		hd.setTongTien(tongTien);
		hoaDonDAO.update(hd);
		return ds;
	}

	@Override
	public ChiTietHoaDon update(ChiTietHoaDon cthd) {
		int soLuong = cthd.getSoLuong();
		cthd = cthdDAO.findOne(cthd.getId());
		Sach sach = sachDAO.findOne(cthd.getMaSach());
		HoaDon hd = hoaDonDAO.findOne(cthd.getMaHoaDon());
		int soLuongCon = sach.getSoLuong() + cthd.getSoLuong() - soLuong;
		if (soLuongCon >= 0) {
			sach.setSoLuong(soLuongCon);
			cthd.setSoLuong(soLuong);
			cthd.setThanhTien(sach.getDonGia() * cthd.getSoLuong());
			sachDAO.update(sach);
			cthdDAO.update(cthd);
			double tongTien = cthdDAO.getTotalCostByMaHoaDon(cthd.getMaHoaDon());
			hd.setTongTien(tongTien);
			hoaDonDAO.update(hd);
		}
		return cthdDAO.findOne(cthd.getId());
	}

	@Override
	public void delete(Integer[] ids) {
		HoaDon hd = new HoaDon();
		int soThanhPhanCuaHD;
		ChiTietHoaDon cthd = new ChiTietHoaDon();
		Sach sach = new Sach();
		double tongTien;
		int soLuongCon;
		for (int id : ids) {
			cthd = cthdDAO.findOne(id);
			cthdDAO.delete(id);
			soThanhPhanCuaHD = cthdDAO.countByMaHoaDon(cthd.getMaHoaDon());
			if(soThanhPhanCuaHD == 0) {
				hoaDonDAO.delete(cthd.getMaHoaDon());
			}else {
				hd = hoaDonDAO.findOne(cthd.getMaHoaDon());
				tongTien = cthdDAO.getTotalCostByMaHoaDon(hd.getId());
				hd.setTongTien(tongTien);
				hoaDonDAO.update(hd);
			}
			sach = sachDAO.findOne(cthd.getMaSach());
			soLuongCon = sach.getSoLuong() + cthd.getSoLuong();
			sach.setSoLuong(soLuongCon);
			sachDAO.update(sach);
		}
	}

	@Override
	public int getTotalItem(String textSearch, Integer maHoaDon) {
		return cthdDAO.getTotalItem(textSearch, maHoaDon);
	}

//	@Override
//	public List<Sach> getBookName(Integer maSach) {
//		List<Sach> ds = sachDAO.getName();
//		for (int i = 0 ; i < ds.size() ; i++){
//			if (ds.get(i).getId() == maSach) {
//				ds.add(0,ds.get(i));
//				break;
//			}
//		}
//		return ds;
//	}

	@Override
	public List<ChiTietHoaDon> findAllByMaHoaDon(IPageble pageble, Integer maHoaDon) {
		return cthdDAO.findAllByMaHoaDon(pageble, maHoaDon);
	}

	@Override
	public int checkTrangThaiHoaDon(Integer id) {
		ChiTietHoaDon cthd = cthdDAO.findOne(id);
		HoaDon hd = hoaDonDAO.findOne(cthd.getMaHoaDon());
		return hd.getTrangThai();
	}

}
