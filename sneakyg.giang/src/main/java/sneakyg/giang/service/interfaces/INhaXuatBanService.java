package sneakyg.giang.service.interfaces;

import java.util.List;

import sneakyg.giang.model.NhaXuatBan;
import sneakyg.giang.paging.IPageble;

public interface INhaXuatBanService {

	List<NhaXuatBan> findAll(IPageble pageble, String textSearch);

	List<NhaXuatBan> search(String textSearch);

	NhaXuatBan findOne(int id);

	NhaXuatBan save(NhaXuatBan tg);

	NhaXuatBan update(NhaXuatBan tg);

	void delete(Integer[] ids);

	int getTotalItem(String textSearch);
}