package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.model.NhaXuatBan;
import sneakyg.giang.paging.IPageble;

public interface INhaXuatBanDAO{
	List<NhaXuatBan> findAll(IPageble pageble,String textSearch);

	NhaXuatBan findOne(int id);

	int save(NhaXuatBan tg);

	void update(NhaXuatBan tg);

	void delete(int id);

	int getTotalItem(String textSearch);

	List<NhaXuatBan> search(String textSearch);
}
