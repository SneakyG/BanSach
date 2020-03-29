package sneakyg.giang.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sneakyg.giang.common.SystemConstant;
import sneakyg.giang.model.Sach;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.paging.PageRequest;
import sneakyg.giang.service.interfaces.ISachService;
import sneakyg.giang.utils.FormUtil;

@WebServlet(urlPatterns = { "/shop" })
public class ShopController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private ISachService sachService;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Sach model = FormUtil.toModel(Sach.class, req);
		String view = "";
		if(model.getId() != null) {
			model = sachService.findOne(model.getId());
			view = "/views/web/bookinfo.jsp";
		}else {
			IPageble pageble = new PageRequest(0, model.getMaxPageItem(), null);
			if(model.getMaDanhMuc() != null) {
				if(model.getMaDanhMuc() == 0) {
					model.setListResult(sachService.findAll(pageble, ""));
				}else {
					model.setListResult(sachService.findAllByCategoryId(model.getMaDanhMuc()));
				}
			}else {
				model.setListResult(sachService.findAll(pageble, ""));
			}
			model.setDsTenDanhMuc(sachService.getListCategoryName(model.getMaDanhMuc()));
			view = "/views/web/shop.jsp";
		}
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
}
