package sneakyg.giang.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import sneakyg.giang.model.Sach;
import sneakyg.giang.service.interfaces.ISachService;
import sneakyg.giang.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-sach" })
public class SachAPI extends HttpServlet {
	
	private static final long serialVersionUID = 1581248617476689052L;
	
	@Inject
	private ISachService sachService;
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		Sach capnhat = HttpUtil.of(req.getReader()).toModel(Sach.class);
		capnhat = sachService.update(capnhat);
		mapper.writeValue(resp.getOutputStream(), capnhat);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF8");
		resp.setContentType("application/json");
		Sach model = HttpUtil.of(req.getReader()).toModel(Sach.class);
		model = sachService.save(model);
		mapper.writeValue(resp.getOutputStream(), model);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF8");
		resp.setContentType("application/json");
		Integer[] ids = HttpUtil.of(req.getReader()).toIntArray();
		sachService.delete(ids);
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
