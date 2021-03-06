package sneakyg.giang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import sneakyg.giang.model.NhaXuatBan;

public class NhaXuatBanMapper implements IRowMapper<NhaXuatBan> {

	@Override
	public NhaXuatBan mapRow(ResultSet resultSet) {
		try {
			NhaXuatBan nxb = new NhaXuatBan();
			nxb.setId(resultSet.getInt("id"));
			nxb.setTenNXB(resultSet.getString("tennxb"));
			try {
				nxb.setSdt(resultSet.getString("sdt"));
			} catch (Exception e) {
			}
			return nxb;
		} catch (SQLException e) {
			return null;
		}
	}

}
