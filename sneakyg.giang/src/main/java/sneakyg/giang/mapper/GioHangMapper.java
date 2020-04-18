package sneakyg.giang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import sneakyg.giang.model.GioHang;

public class GioHangMapper implements IRowMapper<GioHang> {

	@Override
	public GioHang mapRow(ResultSet resultSet) {
		try {
			GioHang gh = new GioHang();
			gh.setId(resultSet.getInt("id"));
			gh.setMaSach(resultSet.getInt("masach"));
			gh.setMaTaiKhoan(resultSet.getInt("mataikhoan"));
			gh.setSoLuong(resultSet.getInt("soluong"));
			gh.setTongTien(resultSet.getDouble("tongtien"));
			try {
				gh.setHinhAnh(resultSet.getString("hinhanh"));
				gh.setTenSach(resultSet.getString("tensach"));
				gh.setTenTG(resultSet.getString("tentg"));
			} catch (Exception e) {
			}
			return gh;
		} catch (SQLException e) {
			return null;
		}
	}

}
