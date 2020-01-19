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
		if (textSearch != null) {
			sql.append(" WHERE tenCV like '%" + textSearch + "%' or tenCode like '%" + textSearch + "%'");
		}
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
	public ChiTietHoaDon findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(ChiTietHoaDon cthd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(ChiTietHoaDon cthd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalItem(String textSearch) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ChiTietHoaDon> search(String textSearch) {
		// TODO Auto-generated method stub
		return null;
	}

}
