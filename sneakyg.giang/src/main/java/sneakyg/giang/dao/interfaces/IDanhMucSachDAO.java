package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.model.DanhMucSach;
import sneakyg.giang.paging.IPageble;

public interface IDanhMucSachDAO {

	List<DanhMucSach> findAll(IPageble pageble,String textSearch);

	DanhMucSach findOne(Integer id);

	Integer save(DanhMucSach dms);

	void update(DanhMucSach dms);

	void delete(Integer id);

	int getTotalItem(String textSearch);

	List<DanhMucSach> search(String textSearch);
	
	List<DanhMucSach> getListName();
}
