package sneakyg.giang.service.interfaces;

import java.util.List;

import sneakyg.giang.model.TacGia;
import sneakyg.giang.paging.IPageble;

public interface ITacGiaService {
	List<TacGia> findAll(IPageble pageble,String textSearch);
	
	List<TacGia> search(String textSearch);
	
	TacGia findOne(Integer id);

	TacGia save(TacGia tg);

	TacGia update(TacGia tg);

	void delete(Integer[] ids);
	
	int getTotalItem(String textSearch);
}
