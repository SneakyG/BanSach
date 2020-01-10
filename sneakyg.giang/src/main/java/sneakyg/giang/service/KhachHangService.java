package sneakyg.giang.service;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.IKhachHangDAO;
import sneakyg.giang.dao.interfaces.ITaiKhoanDAO;
import sneakyg.giang.model.KhachHang;
import sneakyg.giang.service.interfaces.IKhachHangService;

public class KhachHangService implements IKhachHangService {

	@Inject
	private IKhachHangDAO khachHangDAO;
	
	@Inject
	private ITaiKhoanDAO taiKhoanDAO;
	
	@Override
	public KhachHang findByUsername(String tenTaiKhoan) {
		return khachHangDAO.findByUsername(tenTaiKhoan);
	}

}
