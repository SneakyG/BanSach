package sneakyg.giang.service;

import java.util.List;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.ITacGiaDAO;
import sneakyg.giang.model.TacGia;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.service.interfaces.ITacGiaService;

public class TacGiaService implements ITacGiaService {

	@Inject
	private ITacGiaDAO tacGiaDAO;

	@Override
	public List<TacGia> findAll(IPageble pageble,String textSearch) {
		return tacGiaDAO.findAll(pageble,textSearch);
	}

	@Override
	public TacGia save(TacGia tg) {
		int newID = tacGiaDAO.save(tg);
		return tacGiaDAO.findOne(newID);
	}

	@Override
	public TacGia update(TacGia tg) {
		tacGiaDAO.update(tg);
		return tacGiaDAO.findOne(tg.getId());
	}

	@Override
	public void delete(Integer[] ids) {
		for (int id : ids) {
			tacGiaDAO.delete(id);
		}
	}

	@Override
	public TacGia findOne(Integer id) {
		return tacGiaDAO.findOne(id);
	}

	@Override
	public int getTotalItem(String textSearch) {
		return tacGiaDAO.getTotalItem(textSearch);
	}

	@Override
	public List<TacGia> search(String textSearch) {
		return tacGiaDAO.search(textSearch);
	}

}
