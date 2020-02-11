package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.model.ChucVu;
import sneakyg.giang.paging.IPageble;

public interface IChucVuDAO {

	List<ChucVu> findAll(IPageble pageble,String textSearch);

	ChucVu findOne(Integer id);

	Integer save(ChucVu cv);

	void update(ChucVu cv);

	void delete(Integer id);

	int getTotalItem(String textSearch);

	List<ChucVu> search(String textSearch);
}
