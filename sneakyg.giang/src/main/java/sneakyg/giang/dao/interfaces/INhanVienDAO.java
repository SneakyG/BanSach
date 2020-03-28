package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.model.NhanVien;
import sneakyg.giang.paging.IPageble;

public interface INhanVienDAO {
	List<NhanVien> findAll(IPageble pageble, String textSearch);

	NhanVien findOne(Integer id);

	NhanVien findByUsername(String tenTaiKhoan);
	
	NhanVien findByUserId(Integer maTaiKhoan);

	Integer save(NhanVien nv);

	void update(NhanVien nv);

	int getTotalItem(String textSearch);
}
