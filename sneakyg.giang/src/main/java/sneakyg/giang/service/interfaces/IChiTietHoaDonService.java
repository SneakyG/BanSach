package sneakyg.giang.service.interfaces;

import java.util.List;

import sneakyg.giang.model.ChiTietHoaDon;
import sneakyg.giang.paging.IPageble;

public interface IChiTietHoaDonService {

	List<ChiTietHoaDon> findAll(IPageble pageble, String textSearch);

	List<ChiTietHoaDon> findAllByMaHoaDon(IPageble pageble,Integer maHoaDon);

	List<ChiTietHoaDon> search(IPageble pageble, String textSearch);

	ChiTietHoaDon findOne(Integer id);

	List<ChiTietHoaDon> save(List<ChiTietHoaDon> cthd, Integer maTaiKhoan);

	ChiTietHoaDon update(ChiTietHoaDon cthd);

	void delete(Integer[] ids);

	int getTotalItem(String textSearch, Integer maHoaDon);
	
	int checkTrangThaiHoaDon(Integer id);
//	List<Sach> getBookName(Integer maSach)O;
}
