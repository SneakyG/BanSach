package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.IGioHangDAO;
import sneakyg.giang.mapper.GioHangMapper;
import sneakyg.giang.model.GioHang;
import sneakyg.giang.paging.IPageble;

public class GioHangDAO extends CommonDAO<GioHang> implements IGioHangDAO {

	@Override
	public List<GioHang> findAll(IPageble pageble, int maTaiKhoan) {
		StringBuilder sql = new StringBuilder("SELECT gh.id, gh.mataikhoan, gh.masach, gh.soluong, gh.tongtien,s.tensach, s.hinhanh, tg.tentg FROM giohang AS gh");
		sql.append(" JOIN sach AS s ON gh.masach = s.id");
		sql.append(" JOIN tacgia AS tg ON s.matacgia = tg.id");
		sql.append(" WHERE maTaiKhoan = ?");
		if (pageble.getSorter() != null) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if (pageble.getLimit() != 0) {
			sql.append(" LIMIT " + pageble.getOffSet() + "," + pageble.getLimit());
		}
		List<GioHang> ds = query(sql.toString(), new GioHangMapper(),maTaiKhoan);
		return ds;
	}
	
	@Override
	public GioHang findOne(Integer id) {
		String sql = "SELECT * FROM giohang WHERE id = ?";
		List<GioHang> ds = query(sql, new GioHangMapper(), id);
		return ds.isEmpty() ? null : ds.get(0);
	}

	@Override
	public Integer save(GioHang gh) {
		String sql = "INSERT INTO giohang(mataikhoan,masach,soluong,tongtien) VALUES(?,?,?,?)";
		return insert(sql, gh.getMaTaiKhoan(), gh.getMaSach(), gh.getSoLuong(), gh.getTongTien());
	}

	@Override
	public void update(GioHang gh) {
		String sql = "UPDATE giohang SET soluong = ? WHERE id = ?";
		update(sql, gh.getSoLuong(),gh.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM giohang WHERE id = ?";
		update(sql, id);
	}

	@Override
	public int getTotalItem(int maTaiKhoan) {
		StringBuilder sql = new StringBuilder("SELECT count(*) FROM giohang WHERE mataikhoan = ?");
		return count(sql.toString(),maTaiKhoan);
	}

}
