package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.mapper.IRowMapper;

public interface ICommonDAO<T> {
	List<T> query(String sql, IRowMapper<T> rowMapper,Object... parameters);
	List<String> queryString(String sql,String colName,Object... parameters);
	void update(String sql,Object... parameters);
	int insert(String sql,Object... parameters);
	int count(String sql,Object... parameters);
	double total(String sql,Object... parameters);
}
