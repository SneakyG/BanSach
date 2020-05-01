package sneakyg.giang.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.IGioHangDAO;
import sneakyg.giang.dao.interfaces.IKhachHangDAO;
import sneakyg.giang.dao.interfaces.INhanVienDAO;
import sneakyg.giang.dao.interfaces.ITaiKhoanDAO;
import sneakyg.giang.model.KhachHang;
import sneakyg.giang.model.NhanVien;
import sneakyg.giang.model.TaiKhoan;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.service.interfaces.ITaiKhoanService;

public class TaiKhoanService implements ITaiKhoanService {

	@Inject
	private ITaiKhoanDAO taiKhoanDAO;
	@Inject
	private IKhachHangDAO khachHangDAO;
	@Inject
	private INhanVienDAO nhanVienDAO;
	@Inject
	private IGioHangDAO gioHangDAO;
	
	@Override
	public TaiKhoan findByUserNameAndPasswordAndStatus(String taiKhoan, String matKhau, int trangThai) {
		return taiKhoanDAO.findByUserNameAndPasswordAndStatus(taiKhoan, matKhau, trangThai);
	}

	@Override
	public Object findInfoByUsername(String tenTaiKhoan) {
		TaiKhoan tk = taiKhoanDAO.findByUsername(tenTaiKhoan);
		tk.setSoGioHang(gioHangDAO.getTotalItem(tk.getId()));
		if(tk.getCv().getTenCode().equals("khach-hang")) {
			KhachHang kh = khachHangDAO.findByUsername(tenTaiKhoan);
			kh.setTk(tk);
			return kh;
		}else if(tk.getCv().getTenCode().equals("quan-ly") || tk.getCv().getTenCode().equals("nhan-vien")) {
			NhanVien nv = nhanVienDAO.findByUsername(tenTaiKhoan);
			nv.setTk(tk);
			return nv;
		}
		return null;
	}

	@Override
	public List<TaiKhoan> findAll(IPageble pageble, String textSearch) {
		return taiKhoanDAO.findAll(pageble, textSearch);
	}

	@Override
	public TaiKhoan findOne(Integer id) {
		return taiKhoanDAO.findOne(id);
	}

	@Override
	public TaiKhoan save(TaiKhoan tk) {
//		Mã chức vụ khác nhau(trang đăng ký (machucvu = 1) thêm tk của admin(machucvu = 2))
		if(tk.getTenTaiKhoan() != null && checkUserName(tk.getTenTaiKhoan())) {
			return null;
		}
		if(tk.getMaChucVu() == null) {
			tk.setMaChucVu(2);
		}
		int id = taiKhoanDAO.save(tk);
		if(tk.getMaNV() != null) {
			NhanVien nv = new NhanVien();
			nv = nhanVienDAO.findOne(tk.getMaNV());
			nv.setMaTaiKhoan(id);
			nhanVienDAO.update(nv);
		}else {
			KhachHang kh = new KhachHang(id, tk.getTenTaiKhoan());
			khachHangDAO.save(kh);
		}
		return taiKhoanDAO.findOne(id);
	}

	@Override
	public TaiKhoan update(TaiKhoan tk) {
		if(tk.getTenTaiKhoan() == null) {
			if(tk.getMatKhau() == null) {
				tk = taiKhoanDAO.findOne(tk.getId());
				if(tk.getTrangThai() == 0) {
					tk.setTrangThai(1);
				}else {
					tk.setTrangThai(0);
				}
			}else {
				tk.setTrangThai(1);
			}
		}
		taiKhoanDAO.update(tk);
		return taiKhoanDAO.findOne(tk.getId());
	}

	@Override
	public int getTotalItem(String textSearch) {
		return taiKhoanDAO.getTotalItem(textSearch);
	}

	@Override
	public List<TaiKhoan> findOneByID(Integer id) {
		List<TaiKhoan> ds = new ArrayList<TaiKhoan>();
		ds.add(taiKhoanDAO.findOne(id));
		return ds;
	}

	
	public boolean checkUserName(String tenTaiKhoan) {
		List<String> ds = taiKhoanDAO.findAllUserName();
		String tenThuong = tenTaiKhoan.toLowerCase();
		for(String ten : ds) {
			ten = ten.toLowerCase();
			if(tenThuong.equals(ten)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<TaiKhoan> findAllCustomer(IPageble pageble, String textSearch) {
		return taiKhoanDAO.findAllCustomer(pageble, textSearch);
	}
}
