package sneakyg.giang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import sneakyg.giang.model.DanhMucSach;
import sneakyg.giang.model.NhaXuatBan;
import sneakyg.giang.model.Sach;
import sneakyg.giang.model.TacGia;

public class SachMapper implements IRowMapper<Sach> {

	@Override
	public Sach mapRow(ResultSet resultSet) {
		Sach sach = new Sach();
		try {
			sach.setId(resultSet.getInt("id"));
			try {
				sach.setTenSach(resultSet.getString("tensach"));
				sach.setMoTaNgan(resultSet.getString("motangan"));
				sach.setSoLuong(resultSet.getInt("soluong"));
				sach.setDonGia(resultSet.getDouble("dongia"));
				sach.setTrangThai(resultSet.getInt("trangthai"));
				sach.setMaDanhMuc(resultSet.getInt("madanhmuc"));
				sach.setMaTacGia(resultSet.getInt("matacgia"));
				sach.setMaNXB(resultSet.getInt("manxb"));
				DanhMucSach dm = new DanhMucSach();
				TacGia tg = new TacGia();
				NhaXuatBan nxb = new NhaXuatBan();
				dm.setTenDanhMuc(resultSet.getString("tendanhmuc"));
				tg.setTenTG(resultSet.getString("tentg"));
				nxb.setTenNXB(resultSet.getString("tennxb"));
				sach.setDm(dm);
				sach.setTg(tg);
				sach.setNxb(nxb);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return sach;
		} catch (SQLException e) {
			return null;
		}
	}

}
