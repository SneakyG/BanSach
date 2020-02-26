package sneakyg.giang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import sneakyg.giang.model.NhanVien;
import sneakyg.giang.model.TaiKhoan;

public class NhanVienMapper implements IRowMapper<NhanVien> {

	@Override
	public NhanVien mapRow(ResultSet resultSet) {
		NhanVien nv = new NhanVien();
		try {
			nv.setId(resultSet.getInt("id"));
			nv.setTen(resultSet.getString("tennv"));
			nv.setEmail(resultSet.getString("email"));
			nv.setSdt(resultSet.getString("sdt"));
			nv.setDiaChi(resultSet.getString("diachi"));
			nv.setCmnd(resultSet.getString("cmnd"));
			nv.setLuong(resultSet.getDouble("luong"));
			try {
				nv.setMaTaiKhoan(resultSet.getInt("mataikhoan"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				TaiKhoan tk = new TaiKhoan();
				tk.setMatKhau(resultSet.getString("matkhau"));
				nv.setTk(tk);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return nv;
		} catch (SQLException e) {
			return null;
		}
		
	}

}
