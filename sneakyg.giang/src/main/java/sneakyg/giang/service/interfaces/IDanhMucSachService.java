package sneakyg.giang.service.interfaces;

import java.util.List;

import sneakyg.giang.model.DanhMucSach;
import sneakyg.giang.paging.IPageble;

public interface IDanhMucSachService {
	
	List<DanhMucSach> findAll(IPageble pageble, String textSearch);

	List<DanhMucSach> search(String textSearch);

	DanhMucSach findOne(Integer id);

	DanhMucSach save(DanhMucSach dms);

	DanhMucSach update(DanhMucSach dms);

	void delete(Integer[] ids);

	int getTotalItem(String textSearch);
}
