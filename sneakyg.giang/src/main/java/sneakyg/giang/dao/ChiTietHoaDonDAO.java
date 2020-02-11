package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.IChiTietHoaDonDAO;
import sneakyg.giang.mapper.ChiTietHoaDonMapper;
import sneakyg.giang.model.ChiTietHoaDon;
import sneakyg.giang.paging.IPageble;

public class ChiTietHoaDonDAO extends CommonDAO<ChiTietHoaDon> implements IChiTietHoaDonDAO {

	@Override
	public List<ChiTietHoaDon> findAll(IPageble pageble, String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT * FROM chitiethoadon");
//		if (textSearch != null) {
//			sql.append(" WHERE masach like '%" + textSearch + "%' or makh like '%" + textSearch + "%' or manv like '%" + textSearch + "%'");
//		}
		if (pageble.getSorter() != null) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if (pageble.getLimit() != 0) {
			sql.append(" LIMIT " + pageble.getOffSet() + "," + pageble.getLimit());
		}
		List<ChiTietHoaDon> ds = query(sql.toString(), new ChiTietHoaDonMapper());
		return ds;
	}

	@Override
	public ChiTietHoaDon findOne(Integer id) {
		String sql = "SELECT * FROM chitiethoadon WHERE id = ?";
		List<ChiTietHoaDon> ds = query(sql, new ChiTietHoaDonMapper(), id);
		return ds.isEmpty() ? null : ds.get(0);
	}

	@Override
	public Integer save(ChiTietHoaDon cthd) {
		String sql = "INSERT INTO chitiethoadon(mahoadon,masach,manv,makh,soluong,thanhtien,thoigian) VALUES(?,?,?,?,?,?,?)";
		return insert(sql, cthd.getMaHoaDon(),cthd.getMaSach(),cthd.getMaNhanVien(),cthd.getMaKhachHang(),
				cthd.getSoLuong(),cthd.getThanhTien(),cthd.getThoiGian());
	}

	@Override
	public void update(ChiTietHoaDon cthd) {
		String sql = "UPDATE chitiethoadon SET soluong = ?, masach = ? WHERE id = ?";
		update(sql, cthd.getSoLuong(),cthd.getMaSach(), cthd.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM chitiethoadon WHERE id = ?";
		update(sql, id);
	}

	@Override
	public int getTotalItem(String textSearch, Integer maHoaDon) {
		StringBuilder sql = new StringBuilder("SELECT count(*) from chitiethoadon");
		if (maHoaDon != null) {
			sql.append(" WHERE mahoadon = ?");
			return count(sql.toString(),maHoaDon);
		}
		if (textSearch != null) {
			sql.append(" WHERE masach like '%" + textSearch + "%' or makh like '%" + textSearch + "%' or manv like '%" + textSearch + "%'");
		}
		return count(sql.toString());
	}

	@Override
	public List<ChiTietHoaDon> search(IPageble pageble, String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT cthd.id,cthd.mahoadon,cthd.masach,cthd.manv,cthd.makh,cthd.soluong,cthd.thanhtien,kh.tenkh,nv.tennv,s.tensach");
		sql.append(" FROM chitiethoadon AS cthd JOIN khachhang AS kh ON cthd.makh = kh.id");
		sql.append(" JOIN nhanvien AS nv ON cthd.manv = nv.id");
		sql.append(" JOIN sach AS s ON cthd.masach = s.id");
		sql.append(" WHERE masach like '%" + textSearch + "%' or makh like '%" + textSearch + "%' or manv like '%" + textSearch + "%'");
		sql.append(" or tenkh like '%" + textSearch + "%' or tennv like '%" + textSearch + "%' or tensach like '%" + textSearch + "%'");
		sql.append(" or thoigian like '%" + textSearch + "%'");
		if (pageble.getSorter() != null) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if (pageble.getLimit() != 0) {
			sql.append(" LIMIT " + pageble.getOffSet() + "," + pageble.getLimit());
		}
		List<ChiTietHoaDon> ds = query(sql.toString(), new ChiTietHoaDonMapper());
		return ds;
	}

	@Override
	public double getTotalCostByMaHoaDon(Integer maHoaDon) {
		String sql = "SELECT SUM(thanhtien) FROM chitiethoadon WHERE mahoadon = ?";
		return total(sql, maHoaDon);
	}

	@Override
	public List<ChiTietHoaDon> findAllByMaHoaDon(IPageble pageble, Integer maHoaDon) {
		StringBuilder sql = new StringBuilder("SELECT * FROM chitiethoadon WHERE mahoadon = ?");
		if (pageble.getSorter() != null) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if (pageble.getLimit() != 0) {
			sql.append(" LIMIT " + pageble.getOffSet() + "," + pageble.getLimit());
		}
		List<ChiTietHoaDon> ds = query(sql.toString(), new ChiTietHoaDonMapper(), maHoaDon);
		return ds;
	}

}
