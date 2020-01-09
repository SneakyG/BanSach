package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.IKhachHangDAO;
import sneakyg.giang.mapper.KhachHangMapper;
import sneakyg.giang.model.KhachHang;

public class KhachHangDAO extends CommonDAO<KhachHang> implements IKhachHangDAO{
	
	@Override
	public KhachHang findByUsername(String tenTaiKhoan) {
		StringBuilder sql = new StringBuilder("Select * FROM khachhang AS kh ");
		sql.append("INNER JOIN taikhoan AS tk ON tk.id = kh.mataikhoan ");
		sql.append("WHERE tentaikhoan = ?");
		List<KhachHang> ds = query(sql.toString(), new KhachHangMapper(), tenTaiKhoan);
		return ds.isEmpty() ? null : ds.get(0);
	}

}
