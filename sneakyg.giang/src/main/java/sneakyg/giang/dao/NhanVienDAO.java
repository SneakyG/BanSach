package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.INhanVienDAO;
import sneakyg.giang.mapper.NhanVienMapper;
import sneakyg.giang.model.NhanVien;

public class NhanVienDAO extends CommonDAO<NhanVien> implements INhanVienDAO{
	
	@Override
	public NhanVien findByUsername(String tenTaiKhoan) {
		
		StringBuilder sql = new StringBuilder("Select * FROM nhanvien AS nv ");
		sql.append("INNER JOIN taikhoan AS tk ON tk.id = nv.mataikhoan ");
		sql.append("WHERE tentaikhoan = ?");
		List<NhanVien> ds = query(sql.toString(), new NhanVienMapper(), tenTaiKhoan);
		return ds.isEmpty() ? null : ds.get(0);
	}

}
