package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.model.ChiTietHoaDon;
import sneakyg.giang.paging.IPageble;

public interface IChiTietHoaDonDAO {

	List<ChiTietHoaDon> findAll(IPageble pageble, String textSearch);

	List<ChiTietHoaDon> findAllByMaHoaDon(IPageble pageble, Integer maHoaDon);

	ChiTietHoaDon findOne(Integer id);

	Integer save(ChiTietHoaDon cthd);

	void update(ChiTietHoaDon cthd);

	void delete(Integer id);
	
	int countByMaHoaDon(Integer maHoaDon);

	int getTotalItem(String textSearch,Integer maHoaDon);

	double getTotalCostByMaHoaDon(Integer maHoaDon);

	List<ChiTietHoaDon> search(IPageble pageble, String textSearch);
}
