package sneakyg.giang.dao;

import java.util.List;

import sneakyg.giang.dao.interfaces.ISachDAO;
import sneakyg.giang.mapper.SachMapper;
import sneakyg.giang.model.Sach;

public class SachDAO extends CommonDAO<Sach> implements ISachDAO{
	
	@Override
	public List<Sach> findByCategoryId(int maDanhMuc) {
		String sql = "SELECT * FROM sach WHERE madanhmuc = ?";
		List<Sach> results = query(sql,new SachMapper(), maDanhMuc);
		return results;
	}

	@Override
	public List<Sach> findAll() {
		String sql = "SELECT * FROM sach";
		List<Sach> results = query(sql,new SachMapper());
		return results;
	}

}
