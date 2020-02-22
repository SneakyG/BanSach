package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.INhaXuatBanDAO;
import sneakyg.giang.mapper.NhaXuatBanMapper;
import sneakyg.giang.model.NhaXuatBan;
import sneakyg.giang.paging.IPageble;

public class NhaXuatBanDAO extends CommonDAO<NhaXuatBan> implements INhaXuatBanDAO {

	@Override
	public Integer save(NhaXuatBan nxb) {
		String sql = "INSERT INTO nhaxuatban(tennxb,sdt) VALUES(?,?)";
		return insert(sql, nxb.getTenNXB(), nxb.getSdt());
	}

	@Override
	public void update(NhaXuatBan nxb) {
		String sql = "UPDATE nhaxuatban SET tennxb = ?, sdt=? WHERE id = ?";
		update(sql, nxb.getTenNXB(), nxb.getSdt(), nxb.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM nhaxuatban WHERE id = ?";
		update(sql, id);
	}

	@Override
	public NhaXuatBan findOne(Integer id) {
		String sql = "SELECT * FROM nhaxuatban WHERE id = ?";
		List<NhaXuatBan> ds = query(sql, new NhaXuatBanMapper(), id);
		return ds.isEmpty() ? null : ds.get(0);
	}

	@Override
	public List<NhaXuatBan> findAll(IPageble pageble, String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT * FROM nhaxuatban");
		if (textSearch != null) {
			sql.append(" WHERE tennxb like '%" + textSearch + "%' or sdt like '%" + textSearch + "%'");
		}
		if (pageble.getSorter() != null) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if (pageble.getLimit() != 0) {
			sql.append(" LIMIT " + pageble.getOffSet() + "," + pageble.getLimit());
		}
		List<NhaXuatBan> ds = query(sql.toString(), new NhaXuatBanMapper());
		return ds;
	}

	@Override
	public int getTotalItem(String textSearch) {
		StringBuilder sql = new StringBuilder("SELECT count(*) from nhaxuatban");
		if (textSearch != null) {
			sql.append(" WHERE tennxb like '%" + textSearch + "%' or sdt like '%" + textSearch + "%'");
		}
		return count(sql.toString());
	}

	@Override
	public List<NhaXuatBan> search(String textSearch) {
		String sql = "SELECT * FROM nhaxuatban WHERE tennxb like '%" + textSearch + "%' or sdt like '%" + textSearch
				+ "%'";
		return query(sql, new NhaXuatBanMapper());
	}

	@Override
	public List<NhaXuatBan> getListName() {
		String sql = "SELECT nxb.tennxb,nxb.id FROM nhaxuatban AS nxb";
		List<NhaXuatBan> ds = query(sql, new NhaXuatBanMapper());
		return ds;
	}

}
