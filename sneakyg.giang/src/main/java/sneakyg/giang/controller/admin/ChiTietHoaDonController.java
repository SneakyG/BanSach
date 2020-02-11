package sneakyg.giang.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sneakyg.giang.common.SystemConstant;
import sneakyg.giang.model.ChiTietHoaDon;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.paging.PageRequest;
import sneakyg.giang.service.interfaces.IChiTietHoaDonService;
import sneakyg.giang.sort.Sorter;
import sneakyg.giang.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-chitiethoadon" })
public class ChiTietHoaDonController extends HttpServlet {

	private static final long serialVersionUID = 6304203863661881340L;

	@Inject
	private IChiTietHoaDonService cthdService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ChiTietHoaDon model = FormUtil.toModel(ChiTietHoaDon.class, req);
		String view = "";
		if (model.getType().equals(SystemConstant.LIST)) {
			IPageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
//			if(model.getTextSearch() != null) {
//				model.setListResult(cthdService.search(pageble,model.getTextSearch()));
//			}
			if(model.getMaHoaDon() != null) {
				model.setListResult(cthdService.findAllByMaHoaDon(pageble,model.getMaHoaDon()));
			}else {
				model.setListResult(cthdService.findAll(pageble,model.getTextSearch()));
			}
			model.setTotalItem(cthdService.getTotalItem(model.getTextSearch(),model.getMaHoaDon()));
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/cthd/list.jsp";
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId() != null) {
				model = cthdService.findOne(model.getId());
			} else {

			}
			model.setDsTenSach(cthdService.getBookName(model.getMaSach()));
			view = "/views/admin/cthd/edit.jsp";
		} 
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
}
