package sneakyg.giang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import sneakyg.giang.model.ChucVu;

public class ChucVuMapper implements IRowMapper<ChucVu> {

	@Override
	public ChucVu mapRow(ResultSet resultSet) {
		try {
			ChucVu cv = new ChucVu();
			cv.setId(resultSet.getInt("id"));
			cv.setTenCV(resultSet.getString("tencv"));
			cv.setTenCode(resultSet.getString("tencode"));
			return cv;
		} catch (SQLException e) {
			return null;
		}
	}

}
