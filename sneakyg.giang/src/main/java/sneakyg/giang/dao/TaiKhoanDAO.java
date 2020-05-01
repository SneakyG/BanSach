package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.ITaiKhoanDAO;
import sneakyg.giang.mapper.TaiKhoanMapper;
import sneakyg.giang.model.TaiKhoan;
import sneakyg.giang.paging.IPageble;

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

	@Override
	public List<TaiKhoan> findAll(IPageble pageble, String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT * FROM taikhoan as t INNER JOIN chucvu AS c ON c.id = t.machucvu");
		if (textSearch != null) {
			sql.append(" WHERE tentaikhoan like '%" + textSearch + "%' ");
		}
		if (pageble.getSorter() != null) {
			sql.append(" ORDER BY t." + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if (pageble.getLimit() != 0) {
			sql.append(" LIMIT " + pageble.getOffSet() + "," + pageble.getLimit());
		}
		List<TaiKhoan> ds = query(sql.toString(), new TaiKhoanMapper());
		return ds;
	}

	@Override
	public TaiKhoan findOne(Integer id) {
		String sql = "SELECT * FROM taikhoan as t INNER JOIN chucvu AS c ON c.id = t.machucvu WHERE t.id = ?";
		List<TaiKhoan> ds = query(sql, new TaiKhoanMapper(), id);
		return ds.isEmpty() ? null : ds.get(0);
	}

	@Override
	public Integer save(TaiKhoan tk) {
		String sql = "INSERT INTO taikhoan(machucvu,tentaikhoan,matkhau,trangthai) VALUES(?,?,?,?)";
		return insert(sql,tk.getMaChucVu(), tk.getTenTaiKhoan(), tk.getMatKhau(), 1);
	}

	@Override
	public void update(TaiKhoan tk) {
		String sql = "UPDATE taikhoan SET matkhau = ?, trangthai = ? WHERE id = ?";
		update(sql, tk.getMatKhau(), tk.getTrangThai(), tk.getId());
	}

	@Override
	public int getTotalItem(String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT count(*) from taikhoan");
		if (textSearch != null) {
			sql.append(" WHERE tentaikhoan like '%" + textSearch + "%'");
		}
		return count(sql.toString());
	}

	@Override
	public List<String> findAllUserName() {
		String sql = "SELECT tentaikhoan from taikhoan";
		List<String> ds = queryString(sql, "tentaikhoan");
		return ds;
	}

	@Override
	public List<TaiKhoan> findAllCustomer(IPageble pageble, String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT * FROM taikhoan as t INNER JOIN chucvu AS c ON c.id = t.machucvu");
		sql.append(" WHERE t.machucvu = 1");
		if (textSearch != null) {
			sql.append(" AND t.tentaikhoan like '%" + textSearch + "%' ");
		}
		if (pageble.getSorter() != null) {
			sql.append(" ORDER BY t." + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if (pageble.getLimit() != 0) {
			sql.append(" LIMIT " + pageble.getOffSet() + "," + pageble.getLimit());
		}
		List<TaiKhoan> ds = query(sql.toString(), new TaiKhoanMapper());
		return ds;
	}
}
