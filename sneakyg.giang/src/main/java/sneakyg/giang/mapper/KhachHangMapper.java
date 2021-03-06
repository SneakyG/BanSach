package sneakyg.giang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import sneakyg.giang.model.KhachHang;
import sneakyg.giang.model.TaiKhoan;

public class KhachHangMapper implements IRowMapper<KhachHang> {

	@Override
	public KhachHang mapRow(ResultSet resultSet) {
		KhachHang kh = new KhachHang();
		try {
			kh.setId(resultSet.getInt("id"));
			kh.setTen(resultSet.getString("tenkh"));
			kh.setEmail(resultSet.getString("email"));
			kh.setSdt(resultSet.getString("sdt"));
			kh.setNgaySinh(resultSet.getDate("ngaysinh"));
			kh.setDiaChi(resultSet.getString("diachi"));
			kh.setCmnd(resultSet.getString("cmnd"));
			try {
				kh.setMaTaiKhoan(resultSet.getInt("mataikhoan"));
			} catch (Exception e) {
			}
			try {
				TaiKhoan tk = new TaiKhoan();
				tk.setMatKhau(resultSet.getString("matkhau"));
				kh.setTk(tk);
			}catch(Exception e) {
			}
			return kh;
		} catch (SQLException e) {
			return null;
		}
	}

}
