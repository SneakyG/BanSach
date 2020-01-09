package sneakyg.giang.service.interfaces;

import sneakyg.giang.model.TaiKhoan;

public interface ITaiKhoanService {

	TaiKhoan findByUserNameAndPasswordAndStatus(String taiKhoan, String matKhau, int trangThai);
	Object findInfoByUsername(String tenTaiKhoa);
}
