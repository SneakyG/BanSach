package sneakyg.giang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import sneakyg.giang.model.HoaDon;

public class HoaDonMapper implements IRowMapper<HoaDon> {

	@Override
	public HoaDon mapRow(ResultSet resultSet) {
		try {
			HoaDon hd = new HoaDon();
			hd.setId(resultSet.getInt("id"));
			hd.setNgayHD(resultSet.getDate("ngayhoadon"));
			hd.setTongTien(resultSet.getDouble("tongtien"));
			return hd;
		} catch (SQLException e) {
			return null;
		}
	}

}
