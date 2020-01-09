package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.model.NhaXuatBan;
import sneakyg.giang.paging.IPageble;

public interface INhaXuatBanDAO{
	List<NhaXuatBan> findAll(IPageble pageble);
	NhaXuatBan findOne(int id);
	int save(NhaXuatBan nxb);
	void update(NhaXuatBan nxb);
	void delete(int id);
	int getTotalItem();
	List<NhaXuatBan> search(String textSearch);
}
