package sneakyg.giang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import sneakyg.giang.model.Sach;

public class SachMapper implements IRowMapper<Sach> {

	@Override
	public Sach mapRow(ResultSet resultSet) {
		Sach sach = new Sach();
		try {
			sach.setId(resultSet.getInt("id"));
			sach.setTenSach(resultSet.getString("tensach"));
			sach.setSoLuong(resultSet.getInt("soluong"));
			return sach;
		} catch (SQLException e) {
			return null;
		}
	}

}
