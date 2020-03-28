package sneakyg.giang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import sneakyg.giang.model.ChiTietHoaDon;

public class ChiTietHoaDonMapper implements IRowMapper<ChiTietHoaDon> {

	@Override
	public ChiTietHoaDon mapRow(ResultSet resultSet) {
		try {
			ChiTietHoaDon cthd = new ChiTietHoaDon();
			cthd.setId(resultSet.getInt("id"));
			cthd.setMaHoaDon(resultSet.getInt("mahoadon"));
			cthd.setMaSach(resultSet.getInt("masach"));
			cthd.setSoLuong(resultSet.getInt("soluong"));
			cthd.setThanhTien(resultSet.getDouble("thanhtien"));
			try {
				cthd.setTenSach(resultSet.getString("tensach"));
				cthd.setTrangThai(resultSet.getInt("trangthai"));
			} catch (Exception e) {
			}
			return cthd;
		} catch (SQLException e) {
			return null;
		}
	}

}
