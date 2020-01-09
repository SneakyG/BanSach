package sneakyg.giang.service;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.INhanVienDAO;
import sneakyg.giang.model.NhanVien;
import sneakyg.giang.service.interfaces.INhanVienService;

public class NhanVienService implements INhanVienService {

	@Inject
	private INhanVienDAO nhanVienDAO;
	
	@Override
	public NhanVien findByUsername(String tenTaiKhoan) {
		return nhanVienDAO.findByUsername(tenTaiKhoan);
	}

}
