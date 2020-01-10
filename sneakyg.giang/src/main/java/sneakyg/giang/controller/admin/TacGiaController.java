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
import sneakyg.giang.model.TacGia;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.paging.PageRequest;
import sneakyg.giang.service.interfaces.ITacGiaService;
import sneakyg.giang.sort.Sorter;
import sneakyg.giang.utils.FormUtil;

@WebServlet(urlPatterns = {"/admin-tacgia"})
public class TacGiaController extends HttpServlet {

	private static final long serialVersionUID = -4836305926870668345L;
	
	@Inject
	private ITacGiaService tacGiaService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TacGia model = FormUtil.toModel(TacGia.class, req);
		String view = "";
		if (model.getType().equals(SystemConstant.LIST)) {
			IPageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			if(model.getTextSearch() != null) {
				model.setListResult(tacGiaService.search(model.getTextSearch()));
			}
			model.setListResult(tacGiaService.findAll(pageble,model.getTextSearch()));
			model.setTotalItem(tacGiaService.getTotalItem(model.getTextSearch()));
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/tacgia/list.jsp";
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId() != null) {
				model = tacGiaService.findOne(model.getId());
			} else {

			}
			view = "/views/admin/tacgia/edit.jsp";
		} 
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
}
