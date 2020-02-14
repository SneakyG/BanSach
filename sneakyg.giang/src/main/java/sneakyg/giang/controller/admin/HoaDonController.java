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
import sneakyg.giang.model.HoaDon;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.paging.PageRequest;
import sneakyg.giang.service.interfaces.IHoaDonService;
import sneakyg.giang.sort.Sorter;
import sneakyg.giang.utils.FormUtil;

@WebServlet(urlPatterns = {"/admin-hoadon"})
public class HoaDonController extends HttpServlet {
	
	private static final long serialVersionUID = -4464251260532240774L;
	
	@Inject
	private IHoaDonService hoaDonService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HoaDon model = FormUtil.toModel(HoaDon.class, req);
		String view = "";
		if (model.getType().equals(SystemConstant.LIST)) {
			IPageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(hoaDonService.findAll(pageble,model.getTextSearch()));
			model.setTotalItem(hoaDonService.getTotalItem(model.getTextSearch()));
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/hoadon/list.jsp";
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId() != null) {
			} else {

			}
			view = "/views/admin/cthd/edit.jsp";
		} 
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
}
