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
import sneakyg.giang.model.KhachHang;
import sneakyg.giang.service.interfaces.IKhachHangService;
import sneakyg.giang.utils.SessionUtil;

@WebServlet(urlPatterns = { "/profile" })
public class KhachHangController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IKhachHangService khachHangDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		KhachHang user = (KhachHang) SessionUtil.getInstance().getValue(req, "TAIKHOAN");
		KhachHang model = khachHangDAO.findOne(user.getId());
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/profile.jsp");
		rd.forward(req, resp);
	}
}
