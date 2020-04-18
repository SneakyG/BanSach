package sneakyg.giang.service;

import java.util.List;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.IGioHangDAO;
import sneakyg.giang.model.GioHang;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.service.interfaces.IGioHangService;

public class GioHangService implements IGioHangService{

	@Inject
	private IGioHangDAO gioHangDAO;
	
	@Override
	public List<GioHang> findAll(IPageble pageble, int maTaiKhoan) {
		return gioHangDAO.findAll(pageble, maTaiKhoan);
	}

	@Override
	public GioHang save(GioHang cv) {
		int id = gioHangDAO.save(cv);
		return gioHangDAO.findOne(id);
	}

	@Override
	public GioHang update(GioHang cv) {
		gioHangDAO.update(cv);
		return gioHangDAO.findOne(cv.getId());
	}

	@Override
	public void delete(Integer[] ids) {
		for(int id : ids) {
			gioHangDAO.delete(id);
		}
	}

	@Override
	public int getTotalItem(int maTaiKhoan) {
		return gioHangDAO.getTotalItem(maTaiKhoan);
	}

}
