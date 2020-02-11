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
			cthd.setMaNhanVien(resultSet.getInt("manv"));
			cthd.setMaKhachHang(resultSet.getInt("makh"));
			cthd.setMaSach(resultSet.getInt("masach"));
			cthd.setSoLuong(resultSet.getInt("soluong"));
			cthd.setThoiGian(resultSet.getTimestamp("thoigian"));
			cthd.setThanhTien(resultSet.getDouble("thanhtien"));
			return cthd;
		} catch (SQLException e) {
			return null;
		}
	}

}
