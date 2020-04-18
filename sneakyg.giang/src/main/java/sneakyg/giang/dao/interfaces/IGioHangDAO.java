package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.model.GioHang;
import sneakyg.giang.paging.IPageble;

public interface IGioHangDAO {

	List<GioHang> findAll(IPageble pageble,int maTaiKhoan);
	
	GioHang findOne(Integer id);

	Integer save(GioHang gh);

	void update(GioHang gh);

	void delete(Integer id);

	int getTotalItem(int maTaiKhoan);
}
