package sneakyg.giang.dao.interfaces;

import sneakyg.giang.model.NhanVien;

public interface INhanVienDAO {

	NhanVien findByUsername(String tenTaiKhoan);
}
