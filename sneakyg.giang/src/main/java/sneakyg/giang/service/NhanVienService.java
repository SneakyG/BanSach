package sneakyg.giang.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.INhanVienDAO;
import sneakyg.giang.model.NhanVien;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.service.interfaces.INhanVienService;

public class NhanVienService implements INhanVienService {

	@Inject
	private INhanVienDAO nhanVienDAO;
	
	@Override
	public NhanVien findByUsername(String tenTaiKhoan) {
		return nhanVienDAO.findByUsername(tenTaiKhoan);
	}

	@Override
	public List<NhanVien> findAll(IPageble pageble, String textSearch) {
		return nhanVienDAO.findAll(pageble, textSearch);
	}

	@Override
	public NhanVien findOne(Integer id) {
		return nhanVienDAO.findOne(id);
	}

	@Override
	public NhanVien save(NhanVien nv) {
		int id = nhanVienDAO.save(nv);
		return nhanVienDAO.findOne(id);
	}

	@Override
	public NhanVien update(NhanVien nv) {
		nhanVienDAO.update(nv);
		return nhanVienDAO.findOne(nv.getId());
	}

	@Override
	public int getTotalItem(String textSearch) {
		return nhanVienDAO.getTotalItem(textSearch);
	}

	@Override
	public List<NhanVien> findByUserId(Integer maTaiKhoan) {
		List<NhanVien> ds = new ArrayList<NhanVien>();
		ds.add(nhanVienDAO.findByUserId(maTaiKhoan));
		return ds;
	}

}
