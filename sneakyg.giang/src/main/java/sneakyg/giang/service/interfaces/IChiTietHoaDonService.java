package sneakyg.giang.service.interfaces;

import java.util.List;

import sneakyg.giang.model.ChiTietHoaDon;
import sneakyg.giang.model.Sach;
import sneakyg.giang.paging.IPageble;

public interface IChiTietHoaDonService {

	List<ChiTietHoaDon> findAll(IPageble pageble, String textSearch);

	List<ChiTietHoaDon> findAllByMaHoaDon(IPageble pageble,Integer maHoaDon);

	List<ChiTietHoaDon> search(IPageble pageble, String textSearch);

	ChiTietHoaDon findOne(Integer id);

	ChiTietHoaDon save(ChiTietHoaDon cthd);

	ChiTietHoaDon update(ChiTietHoaDon cthd);

	void delete(Integer[] ids);

	int getTotalItem(String textSearch, Integer maHoaDon);

	List<Sach> getBookName(Integer maSach);
}
