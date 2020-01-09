package sneakyg.giang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import sneakyg.giang.model.ChucVu;
import sneakyg.giang.model.TaiKhoan;

public class TaiKhoanMapper implements IRowMapper<TaiKhoan> {

	@Override
	public TaiKhoan mapRow(ResultSet resultSet) {
		TaiKhoan tk = new TaiKhoan();
		try {
			tk.setId(resultSet.getInt("id"));
			tk.setTenTaiKhoan(resultSet.getString("tentaikhoan"));
			tk.setMatKhau(resultSet.getString("matkhau"));
			tk.setTrangThai(resultSet.getInt("trangthai"));
			try {
				ChucVu cv = new ChucVu();
				cv.setTenCode(resultSet.getString("tencode"));
				cv.setTenCV(resultSet.getString("tencv"));
				tk.setCv(cv);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return tk;
		} catch (SQLException e) {
			return null;
		}
	}

}
