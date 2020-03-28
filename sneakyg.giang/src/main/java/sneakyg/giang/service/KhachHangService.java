package sneakyg.giang.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.IKhachHangDAO;
import sneakyg.giang.model.KhachHang;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.service.interfaces.IKhachHangService;

public class KhachHangService implements IKhachHangService {

	@Inject
	private IKhachHangDAO khachHangDAO;
	
	@Override
	public KhachHang findByUsername(String tenTaiKhoan) {
		return khachHangDAO.findByUsername(tenTaiKhoan);
	}

	@Override
	public List<KhachHang> findAll(IPageble pageble, String textSearch) {
		return khachHangDAO.findAll(pageble, textSearch);
	}

	@Override
	public List<KhachHang> findByUserId(Integer maTaiKhoan) {
		List<KhachHang> ds = new ArrayList<KhachHang>();
		ds.add(khachHangDAO.findByUserId(maTaiKhoan));
		return ds;
	}

	@Override
	public KhachHang findOne(Integer id) {
		return khachHangDAO.findOne(id);
	}

	@Override
	public KhachHang save(KhachHang kh) {
		int id = khachHangDAO.save(kh);
		return khachHangDAO.findOne(id);
	}

	@Override
	public KhachHang update(KhachHang kh) {
		khachHangDAO.update(kh);
		return khachHangDAO.findOne(kh.getId());
	}

	@Override
	public int getTotalItem(String textSearch) {
		return khachHangDAO.getTotalItem(textSearch);
	}

}
