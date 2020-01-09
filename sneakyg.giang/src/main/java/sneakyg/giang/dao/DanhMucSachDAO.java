package sneakyg.giang.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sneakyg.giang.dao.interfaces.IDanhMucSachDAO;
import sneakyg.giang.model.DanhMucSach;

public class DanhMucSachDAO implements IDanhMucSachDAO {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bookstore";
			String user = "root";
			String password = "1234";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public List<DanhMucSach> findAll() {
		List<DanhMucSach> results = new ArrayList<>();
		String sql = "SELECT * FROM danhmucsach";
		Connection conn = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (conn != null) {
			try {
				statement = conn.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					DanhMucSach ds = new DanhMucSach();
					ds.setId(resultSet.getInt("id"));
					ds.setTenCode(resultSet.getString("tencode"));
					ds.setTenDanhMuc(resultSet.getString("tendanhmuc"));
					results.add(ds);
				}
				return results;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (resultSet != null) {
						resultSet.close();
					}
				} catch (SQLException e) {
					return null;
				}

			}
		}
		return null;
	}

}
