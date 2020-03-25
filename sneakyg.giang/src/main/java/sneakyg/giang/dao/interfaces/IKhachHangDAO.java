package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.model.KhachHang;
import sneakyg.giang.paging.IPageble;

public interface IKhachHangDAO {

	KhachHang findByUsername(String tenTaiKhoan);
	
	List<KhachHang> findAll(IPageble pageble, String textSearch);

	KhachHang findOne(Integer id);

	Integer save(KhachHang kh);

	void update(KhachHang kh);

	int getTotalItem(String textSearch);
}
