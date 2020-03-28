package sneakyg.giang.service.interfaces;

import java.util.List;

import sneakyg.giang.model.NhanVien;
import sneakyg.giang.paging.IPageble;

public interface INhanVienService {

	List<NhanVien> findAll(IPageble pageble, String textSearch);

	NhanVien findByUsername(String tenTaiKhoan);
	
	List<NhanVien> findByUserId(Integer maTaiKhoan);

	NhanVien findOne(Integer id);

	NhanVien save(NhanVien nv);

	NhanVien update(NhanVien nv);

	int getTotalItem(String textSearch);
}
