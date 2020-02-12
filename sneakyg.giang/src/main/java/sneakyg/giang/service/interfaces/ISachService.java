package sneakyg.giang.service.interfaces;

import java.util.List;

import sneakyg.giang.model.Sach;
import sneakyg.giang.paging.IPageble;

public interface ISachService {
	List<Sach> findAll(IPageble pageble, String textSearch);

	Sach findOne(Integer id);

	Sach save(Sach sach);

	Sach update(Sach sach);

	void delete(Integer[] ids);

	int getTotalItem(String textSearch);
}
