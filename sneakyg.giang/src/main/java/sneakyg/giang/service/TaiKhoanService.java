package sneakyg.giang.service;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.IKhachHangDAO;
import sneakyg.giang.dao.interfaces.INhanVienDAO;
import sneakyg.giang.dao.interfaces.ITaiKhoanDAO;
import sneakyg.giang.model.TaiKhoan;
import sneakyg.giang.service.interfaces.ITaiKhoanService;

public class TaiKhoanService implements ITaiKhoanService {

	@Inject
	private ITaiKhoanDAO taiKhoanDAO;
	@Inject
	private IKhachHangDAO khachHangDAO;
	@Inject
	private INhanVienDAO nhanVienDAO;
	
	@Override
	public TaiKhoan findByUserNameAndPasswordAndStatus(String taiKhoan, String matKhau, int trangThai) {
		return taiKhoanDAO.findByUserNameAndPasswordAndStatus(taiKhoan, matKhau, trangThai);
	}

	@Override
	public Object findInfoByUsername(String tenTaiKhoan) {
		TaiKhoan tk = taiKhoanDAO.findByUsername(tenTaiKhoan);
		if(tk.getCv().getTenCode().equals("khach-hang")) {
			return khachHangDAO.findByUsername(tenTaiKhoan);
		}else if(tk.getCv().getTenCode().equals("quan-ly")) {
			return nhanVienDAO.findByUsername(tenTaiKhoan);
		}
		return null;
	}

}
