package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.model.TacGia;
import sneakyg.giang.paging.IPageble;

public interface ITacGiaDAO {
	List<TacGia> findAll(IPageble pageble,String textSearch);

	TacGia findOne(int id);

	int save(TacGia tg);

	void update(TacGia tg);

	void delete(int id);

	int getTotalItem(String textSearch);

	List<TacGia> search(String textSearch);
}
