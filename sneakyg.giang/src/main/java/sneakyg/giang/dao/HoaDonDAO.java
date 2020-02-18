package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.IHoaDonDAO;
import sneakyg.giang.mapper.HoaDonMapper;
import sneakyg.giang.model.HoaDon;
import sneakyg.giang.paging.IPageble;

public class HoaDonDAO extends CommonDAO<HoaDon> implements IHoaDonDAO{

	@Override
	public List<HoaDon> findAll(IPageble pageble, String textSearch) {
		StringBuilder sql;
		if(textSearch != null ) {
//			sql = new StringBuilder("SELECT hd.id,hd.manv,hd.makh,hd.thoigiandat,hd.thoigianmua,hd.tongtien,hd.trangthai,nv.tennv,kh.tenkh");
//			sql.append(" FROM hoadon AS hd JOIN khachhang AS kh ON hd.makh = kh.id");
//			sql.append(" JOIN nhanvien AS nv ON hd.manv = nv.id");
//			sql.append(" WHERE kh.tenkh like '%" + textSearch + "%' or nv.tennv like '%" + textSearch + "%'");
//			sql.append(" or hd.id like '%" + textSearch + "%'");
			sql = new StringBuilder("SELECT * FROM hoadon");
		}else {
			sql = new StringBuilder("SELECT * FROM hoadon");
		}
		if (pageble.getSorter() != null) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + ",id ASC");
		}
		if (pageble.getLimit() != 0) {
			sql.append(" LIMIT " + pageble.getOffSet() + "," + pageble.getLimit());
		}
		List<HoaDon> ds = query(sql.toString(), new HoaDonMapper());
		return ds;
	}

	@Override
	public Integer save(HoaDon hd) {
		String sql = "INSERT INTO hoadon(manv,makh,thoigiandat,tongtien,trangthai) VALUES(?,?,?,?,?)";
		return insert(sql,hd.getMaNhanVien(),hd.getMaKhachHang(),hd.getThoiGianDat(),hd.getTongTien(),hd.getTrangThai());
	}

	@Override
	public void update(HoaDon hd) {
		String sql = "UPDATE hoadon SET manv = ?, tongtien = ?, thoigianmua = ?, trangthai = ? WHERE id = ?";
		update(sql,hd.getMaNhanVien(),hd.getTongTien(),hd.getThoiGianMua(),hd.getTrangThai(),hd.getId());
	}

	@Override
	public HoaDon findOneByDate(String ngayHD) {
		String sql = "SELECT * FROM hoadon WHERE thoigian = ?";
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
			sql.append(" WHERE thoigiandat like '%" + textSearch + "%' or tongtien like '%" + textSearch + "%'");
			sql.append(" or thoigianmua like '%" + textSearch + "%'");
		}
		return count(sql.toString());
	}

	@Override
	public HoaDon findOne(Integer id) {
		String sql = "SELECT * FROM hoadon WHERE id = ?";
		List<HoaDon> ds = query(sql, new HoaDonMapper(), id);
		return ds.isEmpty() ? null : ds.get(0);
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM hoadon WHERE id = ?";
		update(sql, id);
	}

}
