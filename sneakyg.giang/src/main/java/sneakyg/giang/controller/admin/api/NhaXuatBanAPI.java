package sneakyg.giang.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import sneakyg.giang.model.NhaXuatBan;
import sneakyg.giang.service.interfaces.INhaXuatBanService;
import sneakyg.giang.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-nhaxuatban" })
public class NhaXuatBanAPI extends HttpServlet {

	private static final long serialVersionUID = 3880373627823522212L;
	
	@Inject
	private INhaXuatBanService nhaXuatBanService;
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NhaXuatBan capnhat = HttpUtil.of(req.getReader()).toModel(NhaXuatBan.class);
		capnhat = nhaXuatBanService.update(capnhat);
		mapper.writeValue(resp.getOutputStream(), capnhat);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF8");
		resp.setContentType("application/json");
		NhaXuatBan model = HttpUtil.of(req.getReader()).toModel(NhaXuatBan.class);
		model = nhaXuatBanService.save(model);
		mapper.writeValue(resp.getOutputStream(), model);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF8");
		resp.setContentType("application/json");
		Integer[] ids = HttpUtil.of(req.getReader()).toIntArray();
		nhaXuatBanService.delete(ids);
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
