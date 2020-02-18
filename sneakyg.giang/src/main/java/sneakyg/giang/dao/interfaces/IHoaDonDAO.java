package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.model.HoaDon;
import sneakyg.giang.paging.IPageble;

public interface IHoaDonDAO {

	List<HoaDon> findAll(IPageble pageble, String textSearch);
	
	HoaDon findOne(Integer id);

	Integer save(HoaDon hd);
	
	void update(HoaDon hd);
	
	void delete(Integer id);
	
	HoaDon findOneByDate(String ngayHD);
	
	int getTotalItem(String textSearch);
	
	List<HoaDon> search(IPageble pageble, String textSearch);
}
