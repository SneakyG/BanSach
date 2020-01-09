package sneakyg.giang.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import sneakyg.giang.model.TacGia;
import sneakyg.giang.service.interfaces.ITacGiaService;
import sneakyg.giang.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-tacgia" })
public class TacGiaAPI extends HttpServlet {

	private static final long serialVersionUID = -8761287065708228632L;

	@Inject
	private ITacGiaService tacGiaService;
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		TacGia capnhat = HttpUtil.of(req.getReader()).toModel(TacGia.class);
		capnhat = tacGiaService.update(capnhat);
		mapper.writeValue(resp.getOutputStream(), capnhat);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF8");
		resp.setContentType("application/json");
		TacGia model = HttpUtil.of(req.getReader()).toModel(TacGia.class);
		model = tacGiaService.save(model);
		mapper.writeValue(resp.getOutputStream(), model);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF8");
		resp.setContentType("application/json");
		Integer[] ids = HttpUtil.of(req.getReader()).toIntArray();
		tacGiaService.delete(ids);
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
