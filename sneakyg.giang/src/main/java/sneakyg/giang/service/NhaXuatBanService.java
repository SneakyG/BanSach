package sneakyg.giang.service;

import java.util.List;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.INhaXuatBanDAO;
import sneakyg.giang.model.NhaXuatBan;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.service.interfaces.INhaXuatBanService;

public class NhaXuatBanService implements INhaXuatBanService {

	@Inject
	private INhaXuatBanDAO nhaxuatbanDAO;

	@Override
	public List<NhaXuatBan> findAll(IPageble pageble,String textSearch) {
		return nhaxuatbanDAO.findAll(pageble,textSearch);
	}

	@Override
	public NhaXuatBan save(NhaXuatBan tg) {
		int newID = nhaxuatbanDAO.save(tg);
		return nhaxuatbanDAO.findOne(newID);
	}

	@Override
	public NhaXuatBan update(NhaXuatBan tg) {
		nhaxuatbanDAO.update(tg);
		return nhaxuatbanDAO.findOne(tg.getId());
	}

	@Override
	public void delete(Integer[] ids) {
		for (int id : ids) {
			nhaxuatbanDAO.delete(id);
		}
	}

	@Override
	public NhaXuatBan findOne(int id) {
		return nhaxuatbanDAO.findOne(id);
	}

	@Override
	public int getTotalItem(String textSearch) {
		return nhaxuatbanDAO.getTotalItem(textSearch);
	}

	@Override
	public List<NhaXuatBan> search(String textSearch) {
		return nhaxuatbanDAO.search(textSearch);
	}

}