package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.IHoaDonDAO;
import sneakyg.giang.mapper.HoaDonMapper;
import sneakyg.giang.model.HoaDon;
import sneakyg.giang.paging.IPageble;

public class HoaDonDAO extends CommonDAO<HoaDon> implements IHoaDonDAO{

	@Override
	public List<HoaDon> findAll(IPageble pageble, String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT * FROM hoadon");
		if (pageble.getSorter() != null) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if (pageble.getLimit() != 0) {
			sql.append(" LIMIT " + pageble.getOffSet() + "," + pageble.getLimit());
		}
		List<HoaDon> ds = query(sql.toString(), new HoaDonMapper());
		return ds;
	}

	@Override
	public Integer save(HoaDon hd) {
		String sql = "INSERT INTO hoadon(ngayhoadon,tongtien) VALUES(?,?)";
		return insert(sql, hd.getNgayHD(),hd.getTongTien());
	}

	@Override
	public void update(HoaDon hd) {
		String sql = "UPDATE hoadon SET tongtien = ? WHERE id = ?";
		update(sql, hd.getTongTien(),hd.getId());
	}

	@Override
	public HoaDon findOneByDate(String ngayHD) {
		String sql = "SELECT * FROM hoadon WHERE ngayhoadon = ?";
		List<HoaDon> ds = query(sql, new HoaDonMapper(), ngayHD);
		return ds.isEmpty() ? null : ds.get(0);
	}

	@Override
	public List<HoaDon> search(IPageble pageble, String textSearch) {
		String sql = "SELECT * FROM hoadon WHERE ngayhoadon like '%" + textSearch + "%' or tongtien like '%" + textSearch + "%'";
		return query(sql, new HoaDonMapper());
	}

	@Override
	public int getTotalItem(String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT count(*) from hoadon");
		if (textSearch != null) {
			sql.append(" WHERE ngayhoadon like '%" + textSearch + "%' or tongtien like '%" + textSearch + "%'");
		}
		return count(sql.toString());
	}

	@Override
	public HoaDon findOne(Integer id) {
		String sql = "SELECT * FROM hoadon WHERE id = ?";
		List<HoaDon> ds = query(sql, new HoaDonMapper(), id);
		return ds.isEmpty() ? null : ds.get(0);
	}

}
