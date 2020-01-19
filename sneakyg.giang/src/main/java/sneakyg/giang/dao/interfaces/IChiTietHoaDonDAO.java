package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.model.ChiTietHoaDon;
import sneakyg.giang.model.ChucVu;
import sneakyg.giang.paging.IPageble;

public interface IChiTietHoaDonDAO {

	List<ChiTietHoaDon> findAll(IPageble pageble, String textSearch);

	ChiTietHoaDon findOne(int id);

	int save(ChiTietHoaDon cthd);

	void update(ChiTietHoaDon cthd);

	void delete(int id);

	int getTotalItem(String textSearch);

	List<ChiTietHoaDon> search(String textSearch);
}
