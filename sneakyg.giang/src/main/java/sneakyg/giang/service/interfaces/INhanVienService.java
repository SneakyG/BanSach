package sneakyg.giang.service.interfaces;

import sneakyg.giang.model.NhanVien;

public interface INhanVienService {

	NhanVien findByUsername(String tenTaiKhoan);
}
