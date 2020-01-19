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
			return cthd;
		} catch (SQLException e) {
			return null;
		}
	}

}
