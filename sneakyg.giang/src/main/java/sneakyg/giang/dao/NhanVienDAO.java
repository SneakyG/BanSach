package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.INhanVienDAO;
import sneakyg.giang.mapper.NhanVienMapper;
import sneakyg.giang.model.NhanVien;
import sneakyg.giang.paging.IPageble;

public class NhanVienDAO extends CommonDAO<NhanVien> implements INhanVienDAO{
	
	@Override
	public NhanVien findByUsername(String tenTaiKhoan) {
		
		StringBuilder sql = new StringBuilder("Select * FROM nhanvien AS nv ");
		sql.append("INNER JOIN taikhoan AS tk ON tk.id = nv.mataikhoan ");
		sql.append("WHERE tentaikhoan = ?");
		List<NhanVien> ds = query(sql.toString(), new NhanVienMapper(), tenTaiKhoan);
		return ds.isEmpty() ? null : ds.get(0);
	}

	@Override
	public List<NhanVien> findAll(IPageble pageble, String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT * FROM nhanvien");
		if (textSearch != null) {
			sql.append(" WHERE tennv like '%" + textSearch + "%' or cmnd like '%" + textSearch + "%'");
			sql.append(" or ngayvl like '%" + textSearch + "%'");
		}
		if (pageble.getSorter() != null) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if (pageble.getLimit() != 0) {
			sql.append(" LIMIT " + pageble.getOffSet() + "," + pageble.getLimit());
		}
		List<NhanVien> ds = query(sql.toString(), new NhanVienMapper());
		return ds;
	}

	@Override
	public NhanVien findOne(Integer id) {
		String sql = "SELECT * FROM nhanvien WHERE id = ?";
		List<NhanVien> ds = query(sql, new NhanVienMapper(), id);
		return ds.isEmpty() ? null : ds.get(0);
	}

	@Override
	public Integer save(NhanVien nv) {
		String sql = "INSERT INTO nhanvien(mataikhoan,tennv,email,sdt,cmnd,ngaysinh,ngayvl,luong,diachi) VALUES(?,?,?,?,?,?,?,?,?)";
		return insert(sql, nv.getMaTaiKhoan(),nv.getTen(),nv.getEmail(),nv.getSdt(),nv.getCmnd(),nv.getNgaySinh(),nv.getNgayVL(),nv.getLuong(),nv.getDiaChi());
	}

	@Override
	public void update(NhanVien nv) {
		String sql = "UPDATE nhanvien SET mataikhoan = ?, tennv = ?, email = ?, cmnd = ?, sdt = ?, ngaysinh = ?,luong = ?, diachi = ? WHERE id = ?";
		update(sql,nv.getMaTaiKhoan(),nv.getTen(),nv.getEmail(),nv.getCmnd(),nv.getSdt(),nv.getNgaySinh(),nv.getLuong(),nv.getDiaChi(), nv.getId());
	}

	@Override
	public int getTotalItem(String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT count(*) from nhanvien");
		if (textSearch != null) {
			sql.append(" WHERE tennv like '%" + textSearch + "%' or cmnd like '%" + textSearch + "%'");
			sql.append(" or ngayvl like '%" + textSearch + "%'");
		}
		return count(sql.toString());
	}

}
