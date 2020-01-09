package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.model.Sach;

public interface ISachDAO {
	List<Sach> findByCategoryId(int maDanhMuc);
	List<Sach> findAll();
}
