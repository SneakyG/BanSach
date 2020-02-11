package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.model.TacGia;
import sneakyg.giang.paging.IPageble;

public interface ITacGiaDAO {
	List<TacGia> findAll(IPageble pageble,String textSearch);

	TacGia findOne(Integer id);

	Integer save(TacGia tg);

	void update(TacGia tg);

	void delete(Integer id);

	int getTotalItem(String textSearch);

	List<TacGia> search(String textSearch);
}
