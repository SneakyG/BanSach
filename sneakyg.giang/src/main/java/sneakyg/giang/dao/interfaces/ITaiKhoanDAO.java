package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.model.TaiKhoan;
import sneakyg.giang.paging.IPageble;

public interface ITaiKhoanDAO {

	List<TaiKhoan> findAll(IPageble pageble, String textSearch);
	
	List<String> findAllUserName();
	
	TaiKhoan findByUserNameAndPasswordAndStatus(String taiKhoan, String matKhau, int trangThai);

	TaiKhoan findByUsername(String tenTaiKhoan);
	
	TaiKhoan findOne(Integer id);
	
	Integer save(TaiKhoan tk);
	
	void update(TaiKhoan tk);
	
	int getTotalItem(String textSearch);
}
