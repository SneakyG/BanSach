package sneakyg.giang.dao.interfaces;

import java.util.List;

import sneakyg.giang.model.NhaXuatBan;
import sneakyg.giang.paging.IPageble;

public interface INhaXuatBanDAO{
	List<NhaXuatBan> findAll(IPageble pageble,String textSearch);

	NhaXuatBan findOne(Integer id);

	Integer save(NhaXuatBan tg);

	void update(NhaXuatBan tg);

	void delete(Integer id);

	int getTotalItem(String textSearch);

	List<NhaXuatBan> search(String textSearch);
}
