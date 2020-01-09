package sneakyg.giang.service;

import java.util.List;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.IDanhMucSachDAO;
import sneakyg.giang.model.DanhMucSach;
import sneakyg.giang.service.interfaces.IDanhMucSachService;

public class DanhMucSachService implements IDanhMucSachService {

	@Inject
	private IDanhMucSachDAO danhMucSachDAO;
	
	@Override
	public List<DanhMucSach> findAll() {
		return danhMucSachDAO.findAll();
	}

}
