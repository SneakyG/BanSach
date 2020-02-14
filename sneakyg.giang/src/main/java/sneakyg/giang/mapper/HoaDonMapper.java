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
				hd.setThoiGianDat(resultSet.getTimestamp("thoigiandat"));
				hd.setThoiGianMua(resultSet.getTimestamp("thoigianmua"));
				hd.setTongTien(resultSet.getDouble("tongtien"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			hd.setTrangThai(resultSet.getInt("trangthai"));
			return hd;
		} catch (SQLException e) {
			return null;
		}
	}

}
