package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.IKhachHangDAO;
import sneakyg.giang.mapper.KhachHangMapper;
import sneakyg.giang.model.KhachHang;
import sneakyg.giang.paging.IPageble;

public class KhachHangDAO extends CommonDAO<KhachHang> implements IKhachHangDAO{
	
	@Override
	public KhachHang findByUsername(String tenTaiKhoan) {
		StringBuilder sql = new StringBuilder("Select * FROM khachhang AS kh ");
		sql.append("INNER JOIN taikhoan AS tk ON tk.id = kh.mataikhoan ");
		sql.append("WHERE tentaikhoan = ?");
		List<KhachHang> ds = query(sql.toString(), new KhachHangMapper(), tenTaiKhoan);
		return ds.isEmpty() ? null : ds.get(0);
	}

	@Override
	public List<KhachHang> findAll(IPageble pageble, String textSearch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KhachHang findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer save(KhachHang kh) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(KhachHang kh) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalItem(String textSearch) {
		// TODO Auto-generated method stub
		return 0;
	}

}
