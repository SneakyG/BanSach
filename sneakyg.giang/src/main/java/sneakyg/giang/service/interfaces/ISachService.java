package sneakyg.giang.service.interfaces;

import java.util.List;

import sneakyg.giang.model.Sach;

public interface ISachService {
	List<Sach> findByCategoryId(Integer maDanhMuc);
	List<Sach> findAll();
}
