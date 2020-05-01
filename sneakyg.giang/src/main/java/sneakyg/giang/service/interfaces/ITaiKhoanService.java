package sneakyg.giang.service.interfaces;

import java.util.List;

import sneakyg.giang.model.TaiKhoan;
import sneakyg.giang.paging.IPageble;

public interface ITaiKhoanService {

	TaiKhoan findByUserNameAndPasswordAndStatus(String taiKhoan, String matKhau, int trangThai);

	Object findInfoByUsername(String tenTaiKhoa);
	
	List<TaiKhoan> findAll(IPageble pageble, String textSearch);
	
	List<TaiKhoan> findAllCustomer(IPageble pageble, String textSearch);
	
	List<TaiKhoan> findOneByID(Integer id);
	
	TaiKhoan findOne(Integer id);

	TaiKhoan save(TaiKhoan tk);

	TaiKhoan update(TaiKhoan tk);

	int getTotalItem(String textSearch);
}
