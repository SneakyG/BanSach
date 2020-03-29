package sneakyg.giang.service;

import java.util.List;

import javax.inject.Inject;

import sneakyg.giang.dao.interfaces.IDanhMucSachDAO;
import sneakyg.giang.dao.interfaces.INhaXuatBanDAO;
import sneakyg.giang.dao.interfaces.ISachDAO;
import sneakyg.giang.dao.interfaces.ITacGiaDAO;
import sneakyg.giang.model.DanhMucSach;
import sneakyg.giang.model.NhaXuatBan;
import sneakyg.giang.model.Sach;
import sneakyg.giang.model.TacGia;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.service.interfaces.ISachService;

public class SachService implements ISachService {

	@Inject
	private ISachDAO sachDAO;
	
	@Inject
	private IDanhMucSachDAO danhMucSachDAO;
	
	@Inject
	private ITacGiaDAO tacGiaDAO;
	
	@Inject
	private INhaXuatBanDAO nxbDAO;

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

	@Override
	public List<DanhMucSach> getListCategoryName(Integer maDanhMuc) {
		List<DanhMucSach> ds = danhMucSachDAO.getListName();
		for (int i = 0 ; i < ds.size() ; i++){
			if (ds.get(i).getId() == maDanhMuc) {
				ds.add(0,ds.get(i));
				break;
			}
		}
		return ds;
	}

	@Override
	public List<TacGia> getListAuthorName(Integer maTacGia) {
		List<TacGia> ds = tacGiaDAO.getListName();
		for (int i = 0 ; i < ds.size() ; i++){
			if (ds.get(i).getId() == maTacGia) {
				ds.add(0,ds.get(i));
				break;
			}
		}
		return ds;
	}

	@Override
	public List<NhaXuatBan> getListNXBName(Integer maNXB) {
		List<NhaXuatBan> ds = nxbDAO.getListName();
		for (int i = 0 ; i < ds.size() ; i++){
			if (ds.get(i).getId() == maNXB) {
				ds.add(0,ds.get(i));
				break;
			}
		}
		return ds;
	}

	@Override
	public List<Sach> findAllByCategoryId(Integer maDanhMuc) {
		return sachDAO.findAllByCategoryId(maDanhMuc);
	}

}
