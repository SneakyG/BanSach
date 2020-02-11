package sneakyg.giang.service;

import java.util.List;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.IDanhMucSachDAO;
import sneakyg.giang.model.DanhMucSach;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.service.interfaces.IDanhMucSachService;

public class DanhMucSachService implements IDanhMucSachService {

	@Inject
	private IDanhMucSachDAO danhMucSachDAO;

	@Override
	public List<DanhMucSach> findAll(IPageble pageble, String textSearch) {
		return danhMucSachDAO.findAll(pageble, textSearch);
	}

	@Override
	public List<DanhMucSach> search(String textSearch) {
		return danhMucSachDAO.search(textSearch);
	}

	@Override
	public DanhMucSach findOne(Integer id) {
		return danhMucSachDAO.findOne(id);
	}

	@Override
	public DanhMucSach save(DanhMucSach dms) {
		int id = danhMucSachDAO.save(dms);
		return danhMucSachDAO.findOne(id);
	}

	@Override
	public DanhMucSach update(DanhMucSach dms) {
		danhMucSachDAO.update(dms);
		return findOne(dms.getId());
	}

	@Override
	public void delete(Integer[] ids) {
		for (int id : ids) {
			danhMucSachDAO.delete(id);
		}
	}

	@Override
	public int getTotalItem(String textSearch) {
		return danhMucSachDAO.getTotalItem(textSearch);
	}

}
