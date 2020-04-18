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
import sneakyg.giang.model.GioHang;
import sneakyg.giang.model.KhachHang;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.paging.PageRequest;
import sneakyg.giang.service.interfaces.IGioHangService;
import sneakyg.giang.sort.Sorter;
import sneakyg.giang.utils.FormUtil;
import sneakyg.giang.utils.SessionUtil;

@WebServlet(urlPatterns = { "/cart" })
public class GioHangController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IGioHangService gioHangService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GioHang model = FormUtil.toModel(GioHang.class, req);
		KhachHang user = (KhachHang) SessionUtil.getInstance().getValue(req, "TAIKHOAN");
		IPageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
		model.setListResult(gioHangService.findAll(pageble, user.getMaTaiKhoan()));
		model.setTotalItem(gioHangService.getTotalItem(user.getMaTaiKhoan()));
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/shoppingcart.jsp");
		rd.forward(req, resp);
	}
}
