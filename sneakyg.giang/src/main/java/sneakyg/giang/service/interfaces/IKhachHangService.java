package sneakyg.giang.service.interfaces;

import java.util.List;

import sneakyg.giang.model.KhachHang;
import sneakyg.giang.paging.IPageble;

public interface IKhachHangService {

	List<KhachHang> findAll(IPageble pageble, String textSearch);

	KhachHang findByUsername(String tenTaiKhoan);

	List<KhachHang> findByUserId(Integer maTaiKhoan);

	KhachHang findOne(Integer id);

	KhachHang save(KhachHang kh);

	KhachHang update(KhachHang kh);

	int getTotalItem(String textSearch);
}
