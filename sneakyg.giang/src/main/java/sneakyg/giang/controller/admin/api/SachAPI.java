package sneakyg.giang.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sneakyg.giang.model.Sach;
import sneakyg.giang.service.interfaces.ISachService;

@WebServlet(urlPatterns = {"/admin-sach"})
public class SachAPI extends HttpServlet {
	
	private static final long serialVersionUID = -7733449846643695233L;

	@Inject
	private ISachService sachService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Sach model = new Sach();
		model.setListResult(sachService.findAll());
		req.setAttribute("model", model);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/sach/list.jsp");
		rd.forward(req, resp);
	}
}
