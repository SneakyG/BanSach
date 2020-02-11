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
	public NhaXuatBan save(NhaXuatBan nxb) {
		int newID = nhaxuatbanDAO.save(nxb);
		return nhaxuatbanDAO.findOne(newID);
	}

	@Override
	public NhaXuatBan update(NhaXuatBan nxb) {
		nhaxuatbanDAO.update(nxb);
		return nhaxuatbanDAO.findOne(nxb.getId());
	}

	@Override
	public void delete(Integer[] ids) {
		for (int id : ids) {
			nhaxuatbanDAO.delete(id);
		}
	}

	@Override
	public NhaXuatBan findOne(Integer id) {
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
