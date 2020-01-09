package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.ITacGiaDAO;
import sneakyg.giang.mapper.TacGiaMapper;
import sneakyg.giang.model.TacGia;
import sneakyg.giang.paging.IPageble;

public class TacGiaDAO extends CommonDAO<TacGia> implements ITacGiaDAO{

	@Override
	public int save(TacGia tg) {
		String sql = "INSERT INTO tacgia(tentg) VALUES(?)";
		return insert(sql,tg.getTenTG());
	}

	@Override
	public void update(TacGia tg) {
		String sql = "UPDATE tacgia SET tentg = ? WHERE id = ?";
		update(sql, tg.getTenTG(),tg.getId());
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM tacgia WHERE id = ?";
		update(sql, id);
	}

	@Override
	public TacGia findOne(int id) {
		String sql = "SELECT * FROM tacgia WHERE id = ?";
		List<TacGia> ds = query(sql, new TacGiaMapper(), id);
		return ds.isEmpty() ? null : ds.get(0);
	}

	@Override
	public List<TacGia> findAll(IPageble pageble,String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT * FROM tacgia");
		if(textSearch != null) {
			sql.append(" WHERE tenTG like '%" + textSearch + "%' or id like '%" + textSearch + "%'");
		}
		if(pageble.getSorter() != null) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if(pageble.getLimit() != 0) {
			sql.append(" LIMIT " + pageble.getOffSet() + "," + pageble.getLimit());
		}
		List<TacGia> ds = query(sql.toString(), new TacGiaMapper());
		return ds;
	}

	@Override
	public int getTotalItem(String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT count(*) from tacgia");
		if(textSearch != null) {
			sql.append(" WHERE tenTG like '%" + textSearch + "%' or id like '%" + textSearch + "%'");
		}
		return count(sql.toString());
	}

	@Override
	public List<TacGia> search(String textSearch) {
		String sql = "SELECT * FROM tacgia WHERE tenTG like '%" + textSearch + "%' or id like '%" + textSearch + "%'";
		return query(sql, new TacGiaMapper());
	}

}
