package sneakyg.giang.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.IChiTietHoaDonDAO;
import sneakyg.giang.dao.interfaces.IHoaDonDAO;
import sneakyg.giang.dao.interfaces.ISachDAO;
import sneakyg.giang.model.ChiTietHoaDon;
import sneakyg.giang.model.HoaDon;
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
	public ChiTietHoaDon save(ChiTietHoaDon cthd) {
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate currentDate = currentTime.toLocalDate();
		HoaDon hd = new HoaDon(Date.valueOf(currentDate),0);
		Sach sach = new Sach();
		if (hoaDonDAO.findOneByDate(currentDate.toString()) == null) {
			cthd.setMaHoaDon(hoaDonDAO.save(hd));
			hd = hoaDonDAO.findOne(cthd.getMaHoaDon());
		}else {
			hd = hoaDonDAO.findOneByDate(currentDate.toString());
			cthd.setMaHoaDon(hd.getId());
		}
		cthd.setThoiGian(Timestamp.valueOf(currentTime));
		sach = sachDAO.findOne(cthd.getMaSach());
		double thanhTien = cthd.getSoLuong() * sach.getDonGia();
		cthd.setThanhTien(thanhTien);
		int id = cthdDAO.save(cthd);
		double tongTien = cthdDAO.getTotalCostByMaHoaDon(cthd.getMaHoaDon());
		hd.setTongTien(tongTien);
		hoaDonDAO.update(hd);
		return cthdDAO.findOne(id);
	}

	@Override
	public ChiTietHoaDon update(ChiTietHoaDon cthd) {
		cthdDAO.update(cthd);
		return cthdDAO.findOne(cthd.getId());
	}

	@Override
	public void delete(Integer[] ids) {
		for (int id : ids) {
			cthdDAO.delete(id);
		}
	}

	@Override
	public int getTotalItem(String textSearch, Integer maHoaDon) {
		return cthdDAO.getTotalItem(textSearch,maHoaDon);
	}

	@Override
	public List<Sach> getBookName(Integer maSach) {
		List<Sach> ds = sachDAO.getName();
		for (int i = 0 ; i < ds.size() ; i++){
			if (ds.get(i).getId() == maSach) {
				ds.add(0,ds.get(i));
				break;
			}
		}
		return ds;
	}

	@Override
	public List<ChiTietHoaDon> findAllByMaHoaDon(IPageble pageble, Integer maHoaDon) {
		return cthdDAO.findAllByMaHoaDon(pageble, maHoaDon);
	}

}
