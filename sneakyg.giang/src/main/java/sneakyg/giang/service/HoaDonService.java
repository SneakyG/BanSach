package sneakyg.giang.service;

import java.util.List;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.IHoaDonDAO;
import sneakyg.giang.model.HoaDon;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.service.interfaces.IHoaDonService;

public class HoaDonService implements IHoaDonService {

	@Inject
	private IHoaDonDAO hoaDonDAO;
	
	@Override
	public List<HoaDon> findAll(IPageble pageble, String textSearch) {
		return hoaDonDAO.findAll(pageble, textSearch);
	}

	@Override
	public List<HoaDon> search(IPageble pageble, String textSearch) {
		return hoaDonDAO.search(pageble, textSearch);
	}

	@Override
	public int getTotalItem(String textSearch) {
		return hoaDonDAO.getTotalItem(textSearch);
	}

}
