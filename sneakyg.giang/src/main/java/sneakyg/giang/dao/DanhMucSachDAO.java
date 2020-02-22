package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.IDanhMucSachDAO;
import sneakyg.giang.mapper.DanhMucSachMapper;
import sneakyg.giang.model.DanhMucSach;
import sneakyg.giang.paging.IPageble;

public class DanhMucSachDAO extends CommonDAO<DanhMucSach> implements IDanhMucSachDAO{

	@Override
	public List<DanhMucSach> findAll(IPageble pageble, String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT * FROM danhmucsach");
		if (textSearch != null) {
			sql.append(" WHERE tendanhmuc like '%" + textSearch + "%' or tenCode like '%" + textSearch + "%'");
		}
		if (pageble.getSorter() != null) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if (pageble.getLimit() != 0) {
			sql.append(" LIMIT " + pageble.getOffSet() + "," + pageble.getLimit());
		}
		List<DanhMucSach> ds = query(sql.toString(), new DanhMucSachMapper());
		return ds;
	}

	@Override
	public DanhMucSach findOne(Integer id) {
		String sql = "SELECT * FROM danhmucsach WHERE id = ?";
		List<DanhMucSach> ds = query(sql, new DanhMucSachMapper(), id);
		return ds.isEmpty() ? null : ds.get(0);
	}

	@Override
	public Integer save(DanhMucSach dms) {
		String sql = "INSERT INTO danhmucsach(tendanhmuc,tencode) VALUES(?,?)";
		return insert(sql, dms.getTenDanhMuc(), dms.getTenCode());
	}

	@Override
	public void update(DanhMucSach dms) {
		String sql = "UPDATE danhmucsach SET tendanhmuc = ?, tencode = ? WHERE id = ?";
		update(sql, dms.getTenDanhMuc(), dms.getTenCode(), dms.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM danhmucsach WHERE id = ?";
		update(sql, id);
	}

	@Override
	public int getTotalItem(String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT count(*) from danhmucsach");
		if (textSearch != null) {
			sql.append(" WHERE tendanhmuc like '%" + textSearch + "%' or tenCode like '%" + textSearch + "%'");
		}
		return count(sql.toString());
	}

	@Override
	public List<DanhMucSach> search(String textSearch) {
		String sql = "SELECT * FROM danhmucsach WHERE tendanhmuc like '%" + textSearch + "%' or tenCode like '%"
				+ textSearch + "%'";
		return query(sql, new DanhMucSachMapper());
	}

	@Override
	public List<DanhMucSach> getListName() {
		String sql = "SELECT dms.tendanhmuc,dms.id FROM danhmucsach AS dms";
		List<DanhMucSach> ds = query(sql, new DanhMucSachMapper());
		return ds;
	}

}
