package sneakyg.giang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import sneakyg.giang.model.DanhMucSach;

public class DanhMucSachMapper implements IRowMapper<DanhMucSach> {

	@Override
	public DanhMucSach mapRow(ResultSet resultSet) {
		try {
			DanhMucSach dms = new DanhMucSach();
			dms.setId(resultSet.getInt("id"));
			dms.setTenDanhMuc(resultSet.getString("tendanhmuc"));
			try {
				dms.setTenCode(resultSet.getString("tencode"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return dms;
		} catch (SQLException e) {
			return null;
		}
	}

}
