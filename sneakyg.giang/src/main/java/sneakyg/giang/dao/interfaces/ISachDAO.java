package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.model.Sach;

public interface ISachDAO {
	List<Sach> findByCategoryId(Integer maDanhMuc);
	List<Sach> findAll();
	List<Sach> getName();
}
