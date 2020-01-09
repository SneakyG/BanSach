package sneakyg.giang.paging;

import sneakyg.giang.sort.Sorter;

public interface IPageble {

	int getPage();
	int getOffSet();
	int getLimit();
	Sorter getSorter();
}
