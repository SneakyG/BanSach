package sneakyg.giang.service.interfaces;

import java.util.List;

import sneakyg.giang.model.GioHang;
import sneakyg.giang.paging.IPageble;

public interface IGioHangService {

	List<GioHang> findAll(IPageble pageble, int maTaiKhoan);

	GioHang save(GioHang gh);

	GioHang update(GioHang gh);

	void delete(Integer[] ids);

	int getTotalItem(int maTaiKhoan);
}
