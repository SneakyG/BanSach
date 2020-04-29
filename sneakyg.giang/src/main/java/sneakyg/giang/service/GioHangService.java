package sneakyg.giang.service;

import java.util.List;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.IGioHangDAO;
import sneakyg.giang.dao.interfaces.ISachDAO;
import sneakyg.giang.model.GioHang;
import sneakyg.giang.model.Sach;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.service.interfaces.IGioHangService;

public class GioHangService implements IGioHangService{

	@Inject
	private IGioHangDAO gioHangDAO;
	
	@Inject
	private ISachDAO sachDAO;
	
	@Override
	public List<GioHang> findAll(IPageble pageble, int maTaiKhoan) {
		return gioHangDAO.findAll(pageble, maTaiKhoan);
	}

	@Override
	public GioHang save(GioHang gh) {
		Sach sach = sachDAO.findOne(gh.getMaSach());
		int maSach = gh.getMaSach();
		int maTaiKhoan = gh.getMaTaiKhoan();
		double donGia = sach.getDonGia();
		if(kiemTraTonTai(maSach, maTaiKhoan)) {
			GioHang gh1 = gioHangDAO.findOneByBookIdAndUserId(maSach,maTaiKhoan);
			int soLuongThem = gh1.getSoLuongMua() + gh.getSoLuongMua();
			gh1.setSoLuongMua(soLuongThem);
			gh1.setTongTien(tongTien(gh1.getSoLuongMua(), donGia));
			gioHangDAO.update(gh1);
			return gioHangDAO.findOne(gh1.getId());
		}else {
			gh.setTongTien(tongTien(gh.getSoLuongMua(), donGia));
			int id = gioHangDAO.save(gh);
			return gioHangDAO.findOne(id);
		}
	}

	@Override
	public GioHang update(GioHang gh) {
		Sach sach = sachDAO.findOne(gh.getMaSach());
		gh.setTongTien(tongTien(gh.getSoLuongMua(), sach.getDonGia()));
		gioHangDAO.update(gh);
		return gioHangDAO.findOne(gh.getId());
	}

	@Override
	public void delete(Integer[] ids) {
		for(int id : ids) {
			gioHangDAO.delete(id);
		}
	}

	@Override
	public int getTotalItem(int maTaiKhoan) {
		return gioHangDAO.getTotalItem(maTaiKhoan);
	}
	
	public double tongTien(int soLuong, double donGia) {
		return soLuong * donGia;
	}

	public boolean kiemTraTonTai(int maSach, int maTaiKhoan) {
		boolean check = false;
		List<GioHang> ds = gioHangDAO.findAll(null, maTaiKhoan);
		for(int i = 0; i < ds.size() ; i++) {
			if(maSach == ds.get(i).getMaSach()) {
				check = true;
				break;
			}
		}
		return check;
	}
}
