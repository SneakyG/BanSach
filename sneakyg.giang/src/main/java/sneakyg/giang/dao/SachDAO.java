package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.ISachDAO;
import sneakyg.giang.mapper.SachMapper;
import sneakyg.giang.model.Sach;
import sneakyg.giang.paging.IPageble;

public class SachDAO extends CommonDAO<Sach> implements ISachDAO{

	@Override
	public List<Sach> findAll(IPageble pageble, String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT s.id,s.madanhmuc,s.matacgia,s.manxb,s.tensach,s.motangan,s.soluong,s.hinhanh,s.dongia,dm.tendanhmuc,tg.tentg,nxb.tennxb");
		sql.append(" FROM sach AS s JOIN danhmucsach AS dm ON s.madanhmuc = dm.id");
		sql.append(" JOIN tacgia AS tg ON s.matacgia = tg.id");
		sql.append(" JOIN nhaxuatban AS nxb ON s.manxb = nxb.id");
		if(textSearch != null) {
			sql.append(" WHERE s.tensach like '%" + textSearch + "%' or nxb.tennxb like '%" + textSearch + "%' or tg.tentg like '%" + textSearch + "%'");
		}
		if (pageble.getSorter() != null) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if (pageble.getLimit() != 0) {
			sql.append(" LIMIT " + pageble.getOffSet() + "," + pageble.getLimit());
		}
		List<Sach> ds = query(sql.toString(), new SachMapper());
		return ds;
	}

	@Override
	public Sach findOne(Integer id) {
		String sql = "SELECT * FROM sach WHERE id = ?";
		List<Sach> ds = query(sql, new SachMapper(), id);
		return ds.isEmpty() ? null : ds.get(0);
	}

	@Override
	public Integer save(Sach sach) {
		String sql = "INSERT INTO sach(manxb,matacgia,madanhmuc,tensach,motangan,soluong,dongia,hinhanh) VALUES(?,?,?,?,?,?,?,?)";
		return insert(sql, sach.getMaNXB(),sach.getMaTacGia(),sach.getMaDanhMuc(),sach.getTenSach(),sach.getMoTaNgan(),sach.getSoLuong(),sach.getDonGia(),sach.getHinhAnh());
	}

	@Override
	public void update(Sach sach) {
		String sql = "UPDATE sach SET manxb = ?, madanhmuc = ?, matacgia = ?,tensach = ?, motangan = ?, soluong = ?, dongia = ?, hinhanh = ? WHERE id = ?";
		update(sql,sach.getMaNXB(),sach.getMaTacGia(),sach.getMaDanhMuc(),sach.getTenSach(),sach.getMoTaNgan(),sach.getSoLuong(),sach.getDonGia(),sach.getHinhAnh(),sach.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM sach WHERE id = ?";
		update(sql, id);
	}

	@Override
	public int getTotalItem(String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT count(*) from sach");
		if (textSearch != null) {
			sql.append(" WHERE tensach like '%" + textSearch + "%'");
		}
		return count(sql.toString());
	}

	@Override
	public List<Sach> search(IPageble pageble, String textSearch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sach> getListName() {
		String sql = "SELECT s.tensach,s.id FROM sach as s";
		List<Sach> ds = query(sql, new SachMapper());
		return ds;
	}

}
