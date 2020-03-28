package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.IKhachHangDAO;
import sneakyg.giang.mapper.KhachHangMapper;
import sneakyg.giang.model.KhachHang;
import sneakyg.giang.paging.IPageble;

public class KhachHangDAO extends CommonDAO<KhachHang> implements IKhachHangDAO {

	@Override
	public KhachHang findByUsername(String tenTaiKhoan) {
		StringBuilder sql = new StringBuilder("Select * FROM khachhang AS kh ");
		sql.append("INNER JOIN taikhoan AS tk ON tk.id = kh.mataikhoan ");
		sql.append("WHERE tentaikhoan = ?");
		List<KhachHang> ds = query(sql.toString(), new KhachHangMapper(), tenTaiKhoan);
		return ds.isEmpty() ? null : ds.get(0);
	}

	@Override
	public List<KhachHang> findAll(IPageble pageble, String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT * FROM khachhang");
		if (textSearch != null) {
			sql.append(" WHERE tenkh like '%" + textSearch + "%' or cmnd like '%" + textSearch + "%'");
		}
		if (pageble.getSorter() != null) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if (pageble.getLimit() != 0) {
			sql.append(" LIMIT " + pageble.getOffSet() + "," + pageble.getLimit());
		}
		List<KhachHang> ds = query(sql.toString(), new KhachHangMapper());
		return ds;
	}

	@Override
	public KhachHang findOne(Integer id) {
		String sql = "SELECT * FROM khachhang WHERE id = ?";
		List<KhachHang> ds = query(sql, new KhachHangMapper(), id);
		return ds.isEmpty() ? null : ds.get(0);
	}

	@Override
	public Integer save(KhachHang kh) {
		String sql = "INSERT INTO khachhang(mataikhoan,tenkh,email,sdt,cmnd,ngaysinh,diachi) VALUES(?,?,?,?,?,?,?)";
		return insert(sql, kh.getMaTaiKhoan(), kh.getTen(), kh.getEmail(), kh.getSdt(), kh.getCmnd(), kh.getNgaySinh(),
				kh.getDiaChi());
	}

	@Override
	public void update(KhachHang kh) {
		String sql = "UPDATE khachhang SET mataikhoan = ?, tenkh = ?, email = ?, cmnd = ?, sdt = ?, ngaysinh = ?, diachi = ? WHERE id = ?";
		update(sql, kh.getMaTaiKhoan(), kh.getTen(), kh.getEmail(), kh.getCmnd(), kh.getSdt(), kh.getNgaySinh(),
				kh.getDiaChi(), kh.getId());
	}

	@Override
	public int getTotalItem(String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT count(*) from khachhang");
		if (textSearch != null) {
			sql.append(" WHERE tenkh like '%" + textSearch + "%' or cmnd like '%" + textSearch + "%'");
		}
		return count(sql.toString());
	}

	@Override
	public KhachHang findByUserId(Integer maTaiKhoan) {
		StringBuilder sql = new StringBuilder("Select * FROM khachhang AS kh ");
		sql.append("INNER JOIN taikhoan AS tk ON tk.id = kh.mataikhoan ");
		sql.append("WHERE mataikhoan = ?");
		List<KhachHang> ds = query(sql.toString(), new KhachHangMapper(), maTaiKhoan);
		return ds.isEmpty() ? null : ds.get(0);
	}

}
