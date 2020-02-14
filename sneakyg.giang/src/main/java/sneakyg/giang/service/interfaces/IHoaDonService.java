package sneakyg.giang.service.interfaces;

import java.util.List;

import sneakyg.giang.model.HoaDon;
import sneakyg.giang.paging.IPageble;

public interface IHoaDonService {

	List<HoaDon> findAll(IPageble pageble, String textSearch);

	List<HoaDon> search(IPageble pageble, String textSearch);
	
	HoaDon update(HoaDon hd);
	
	int getTotalItem(String textSearch);
}
