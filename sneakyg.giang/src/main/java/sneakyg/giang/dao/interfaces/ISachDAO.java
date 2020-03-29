package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.model.Sach;
import sneakyg.giang.paging.IPageble;

public interface ISachDAO {
	List<Sach> findAll(IPageble pageble, String textSearch);
	
	List<Sach> findAllByCategoryId(Integer maDanhMuc);

	Sach findOne(Integer id);

	Integer save(Sach sach);

	void update(Sach sach);

	void delete(Integer id);

	int getTotalItem(String textSearch);

	List<Sach> search(IPageble pageble, String textSearch);
	
	List<Sach> getListName();
}
