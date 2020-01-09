package sneakyg.giang.service.interfaces;

import java.util.List;

import sneakyg.giang.model.NhaXuatBan;
import sneakyg.giang.paging.IPageble;

public interface INhaXuatBan {

	List<NhaXuatBan> findAll(IPageble pageble);

	NhaXuatBan findOne(int id);

	NhaXuatBan save(NhaXuatBan nxb);

	NhaXuatBan update(NhaXuatBan nxb);

	void delete(int id);

	int getTotalItem();

	List<NhaXuatBan> search(String textSearch);
}
