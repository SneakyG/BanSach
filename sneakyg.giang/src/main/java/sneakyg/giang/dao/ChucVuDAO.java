package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.IChucVuDAO;
import sneakyg.giang.mapper.ChucVuMapper;
import sneakyg.giang.model.ChucVu;
import sneakyg.giang.paging.IPageble;

public class ChucVuDAO extends CommonDAO<ChucVu> implements IChucVuDAO {

	@Override
	public List<ChucVu> findAll(IPageble pageble, String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT * FROM chucvu");
		if (textSearch != null) {
			sql.append(" WHERE tenCV like '%" + textSearch + "%' or tenCode like '%" + textSearch + "%'");
		}
		if (pageble.getSorter() != null) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if (pageble.getLimit() != 0) {
			sql.append(" LIMIT " + pageble.getOffSet() + "," + pageble.getLimit());
		}
		List<ChucVu> ds = query(sql.toString(), new ChucVuMapper());
		return ds;
	}

	@Override
	public ChucVu findOne(Integer id) {
		String sql = "SELECT * FROM chucvu WHERE id = ?";
		List<ChucVu> ds = query(sql, new ChucVuMapper(), id);
		return ds.isEmpty() ? null : ds.get(0);
	}

	@Override
	public Integer save(ChucVu cv) {
		String sql = "INSERT INTO chucvu(tencv,tencode) VALUES(?,?)";
		return insert(sql, cv.getTenCV(),cv.getTenCode());
	}

	@Override
	public void update(ChucVu cv) {
		String sql = "UPDATE chucvu SET tencv = ?, tencode = ? WHERE id = ?";
		update(sql, cv.getTenCV(),cv.getTenCode(), cv.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM chucvu WHERE id = ?";
		update(sql, id);
	}

	@Override
	public int getTotalItem(String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT count(*) from chucvu");
		if (textSearch != null) {
			sql.append(" WHERE tenCV like '%" + textSearch + "%' or tenCode like '%" + textSearch + "%'");
		}
		return count(sql.toString());
	}

	@Override
	public List<ChucVu> search(String textSearch) {
		String sql = "SELECT * FROM chucvu WHERE tenCV like '%" + textSearch + "%' or tenCode like '%" + textSearch + "%'";
		return query(sql, new ChucVuMapper());
	}

}
