package sneakyg.giang.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sneakyg.giang.model.TaiKhoan;
import sneakyg.giang.service.interfaces.ITaiKhoanService;
import sneakyg.giang.utils.FormUtil;
import sneakyg.giang.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/dang-ky", "/thoat" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 3868379978025734446L;

	ResourceBundle resource = ResourceBundle.getBundle("message");
	
	@Inject
	private ITaiKhoanService taiKhoanService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals("login")) {
				String message = req.getParameter("message");
				String alert = req.getParameter("alert");
				if(message != null && alert != null) {
					req.setAttribute("message", resource.getString(message));
					req.setAttribute("alert", alert);
				}
				RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
				rd.forward(req, resp);
			} else if (action.equals("logout")) {
				SessionUtil.getInstance().removeValue(req, "TAIKHOAN");
				resp.sendRedirect(req.getContextPath() + "/trang-chu");
			} else if (action.equals("regis")) {
				RequestDispatcher rd = req.getRequestDispatcher("/views/web/register.jsp");
				rd.forward(req, resp);
			}
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			TaiKhoan model = FormUtil.toModel(TaiKhoan.class, req);
			model = taiKhoanService.findByUserNameAndPasswordAndStatus(model.getTenTaiKhoan(), model.getMatKhau(),
					1);
			if (model != null) {
					Object object = taiKhoanService.findInfoByUsername(model.getTenTaiKhoan());
					SessionUtil.getInstance().putValue(req, "TAIKHOAN", object);
				if (model.getCv().getTenCode().equals("khach-hang")) {
					resp.sendRedirect(req.getContextPath() + "/trang-chu");
				} else if (model.getCv().getTenCode().equals("quan-ly") || model.getCv().getTenCode().equals("nhan-vien")  ) {
					resp.sendRedirect(req.getContextPath() + "/admin-home");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=username-password-invalid&alert=danger");
			}
		}
	}
}
