package sneakyg.giang.dao.interfaces;

import sneakyg.giang.model.KhachHang;

public interface IKhachHangDAO {

	KhachHang findByUsername(String tenTaiKhoan);
}
