package sneakyg.giang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import sneakyg.giang.model.TacGia;

public class TacGiaMapper implements IRowMapper<TacGia> {

	@Override
	public TacGia mapRow(ResultSet resultSet) {
		try {
			TacGia tg = new TacGia();
			tg.setId(resultSet.getInt("id"));
			tg.setTenTG(resultSet.getString("tentg"));
			return tg;
		} catch (SQLException e) {
			return null;
		}
	}

}
