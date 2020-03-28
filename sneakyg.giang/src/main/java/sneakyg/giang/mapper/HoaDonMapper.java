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
			try {
				hd.setThoiGianMua(resultSet.getTimestamp("thoigianmua"));
			} catch (Exception e) {
			}
			hd.setThoiGianDat(resultSet.getTimestamp("thoigiandat"));
			hd.setTongTien(resultSet.getDouble("tongtien"));
			hd.setTrangThai(resultSet.getInt("trangthai"));
			return hd;
		} catch (SQLException e) {
			return null;
		}
	}

}
