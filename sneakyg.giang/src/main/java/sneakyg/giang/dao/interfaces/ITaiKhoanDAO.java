package sneakyg.giang.dao.interfaces;

import sneakyg.giang.model.TaiKhoan;

public interface ITaiKhoanDAO {

	TaiKhoan findByUserNameAndPasswordAndStatus(String taiKhoan,String matKhau,int trangThai);
	TaiKhoan findByUsername(String tenTaiKhoan);
}
