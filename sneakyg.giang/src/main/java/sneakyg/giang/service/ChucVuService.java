package sneakyg.giang.service;

import java.util.List;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.IChucVuDAO;
import sneakyg.giang.model.ChucVu;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.service.interfaces.IChucVuService;

public class ChucVuService implements IChucVuService{

	@Inject
	private IChucVuDAO chucVuDAO;
	
	@Override
	public List<ChucVu> findAll(IPageble pageble, String textSearch) {
		return chucVuDAO.findAll(pageble, textSearch);
	}

	@Override
	public List<ChucVu> search(String textSearch) {
		return chucVuDAO.search(textSearch);
	}

	@Override
	public ChucVu findOne(int id) {
		return chucVuDAO.findOne(id);
	}

	@Override
	public ChucVu save(ChucVu cv) {
		int id = chucVuDAO.save(cv);
		return chucVuDAO.findOne(id);
	}

	@Override
	public ChucVu update(ChucVu cv) {
		chucVuDAO.update(cv);
		return chucVuDAO.findOne(cv.getId());
	}

	@Override
	public void delete(Integer[] ids) {
		for(int id : ids) {
			chucVuDAO.delete(id);
		}
	}

	@Override
	public int getTotalItem(String textSearch) {
		return chucVuDAO.getTotalItem(textSearch);
	}

}
