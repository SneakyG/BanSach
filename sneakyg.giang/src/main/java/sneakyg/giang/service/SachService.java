package sneakyg.giang.service;

import java.util.List;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.ISachDAO;
import sneakyg.giang.model.Sach;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.service.interfaces.ISachService;

public class SachService implements ISachService {

	@Inject
	private ISachDAO sachDAO;

	@Override
	public List<Sach> findAll(IPageble pageble, String textSearch) {
		return sachDAO.findAll(pageble, textSearch);
	}

	@Override
	public Sach findOne(Integer id) {
		return sachDAO.findOne(id);
	}

	@Override
	public Sach save(Sach sach) {
		int id = sachDAO.save(sach);
		return sachDAO.findOne(id);
	}

	@Override
	public Sach update(Sach sach) {
		sachDAO.update(sach);
		return sachDAO.findOne(sach.getId());
	}

	@Override
	public void delete(Integer[] ids) {
		for(int id : ids) {
			sachDAO.delete(id);
		}
	}

	@Override
	public int getTotalItem(String textSearch) {
		return sachDAO.getTotalItem(textSearch);
	}

}
