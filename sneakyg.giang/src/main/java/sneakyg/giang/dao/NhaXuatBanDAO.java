package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.INhaXuatBanDAO;
import sneakyg.giang.mapper.NhaXuatBanMapper;
import sneakyg.giang.model.NhaXuatBan;
import sneakyg.giang.paging.IPageble;

public class NhaXuatBanDAO extends CommonDAO<NhaXuatBan> implements INhaXuatBanDAO{

	@Override
	public List<NhaXuatBan> findAll(IPageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM nhaxuatban");
		if(pageble.getSorter().getSortBy() != null && pageble.getSorter().getSortName() != null) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if(pageble.getLimit() != 0) {
			sql.append(" LIMIT " + pageble.getOffSet() + ", " + pageble.getLimit());
		}
		return query(sql.toString(), new NhaXuatBanMapper());
	}

	@Override
	public NhaXuatBan findOne(int id) {
		String sql = "SELECT * FROM nhaxuatban WHERE id = ?";
		List<NhaXuatBan> ds = query(sql, new NhaXuatBanMapper(), id);
		return ds.isEmpty() ? null : ds.get(0);
	}

	@Override
	public int save(NhaXuatBan nxb) {
		StringBuilder sql = new StringBuilder("INSERT INTO nhaxuatban(tennxb,sdt) VALUES(?,?)");
		return insert(sql.toString(), nxb.getTenNXB(),nxb.getSdt());
	}

	@Override
	public void update(NhaXuatBan nxb) {
		String sql = "UPDATE nhaxuatban SET tennxb = ?, sdt = ? WHERE id = ?";
		update(sql, nxb.getTenNXB(),nxb.getSdt(),nxb.getId());
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM nhaxuatban WHERE id = ?";
		update(sql, id);
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM nhaxuatban";
		return count(sql);
	}

	@Override
	public List<NhaXuatBan> search(String textSearch) {
		String sql = "SELECT * FROM nhaxuatban WHERE tennxb LIKE '%" + textSearch + "%'or sdt LIKE '%" + textSearch + "%";
		return query(sql, new NhaXuatBanMapper());
	}

}
