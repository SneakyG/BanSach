package sneakyg.giang.service.interfaces;

import java.util.List;

import sneakyg.giang.model.ChucVu;
import sneakyg.giang.paging.IPageble;

public interface IChucVuService {

	List<ChucVu> findAll(IPageble pageble, String textSearch);

	List<ChucVu> search(String textSearch);

	ChucVu findOne(Integer id);

	ChucVu save(ChucVu cv);

	ChucVu update(ChucVu cv);

	void delete(Integer[] ids);

	int getTotalItem(String textSearch);
}
