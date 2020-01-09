package sneakyg.giang.service;

import java.util.List;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.ISachDAO;
import sneakyg.giang.model.Sach;
import sneakyg.giang.service.interfaces.ISachService;

public class SachService implements ISachService {

	@Inject
	private ISachDAO sachDAO;
	
	@Override
	public List<Sach> findByCategoryId(int maDanhMuc) {
		return sachDAO.findByCategoryId(maDanhMuc);
	}

	@Override
	public List<Sach> findAll() {
		return sachDAO.findAll();
	}

}
