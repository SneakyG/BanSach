package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.ITaiKhoanDAO;
import sneakyg.giang.mapper.TaiKhoanMapper;
import sneakyg.giang.model.TaiKhoan;

public class TaiKhoanDAO extends CommonDAO<TaiKhoan> implements ITaiKhoanDAO {

	@Override
	public TaiKhoan findByUserNameAndPasswordAndStatus(String taiKhoan, String matKhau, int trangThai) {

		StringBuilder sql = new StringBuilder("SELECT * FROM taikhoan as t ");
		sql.append("INNER JOIN chucvu AS c ON c.id = t.machucvu ");
		sql.append("WHERE tentaikhoan = ? AND matkhau = ? AND trangthai = ?");
		List<TaiKhoan> ds = query(sql.toString(), new TaiKhoanMapper(), taiKhoan, matKhau, trangThai);
		return ds.isEmpty() ? null : ds.get(0);
	}

	@Override
	public TaiKhoan findByUsername(String tenTaiKhoan) {
		StringBuilder sql = new StringBuilder("SELECT * FROM taikhoan as t ");
		sql.append("INNER JOIN chucvu AS c ON c.id = t.machucvu ");
		sql.append("WHERE tentaikhoan = ?");
		List<TaiKhoan> ds = query(sql.toString(), new TaiKhoanMapper(), tenTaiKhoan);
		return ds.isEmpty() ? null : ds.get(0);

	}
}
