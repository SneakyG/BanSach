package sneakyg.giang.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import sneakyg.giang.model.TaiKhoan;
import sneakyg.giang.service.interfaces.ITaiKhoanService;
import sneakyg.giang.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-taikhoan" })
public class TaiKhoanAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITaiKhoanService taiKhoanService;
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		TaiKhoan capnhat = HttpUtil.of(req.getReader()).toModel(TaiKhoan.class);
		capnhat = taiKhoanService.update(capnhat);
		mapper.writeValue(resp.getOutputStream(), capnhat);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF8");
		resp.setContentType("application/json");
		TaiKhoan model = HttpUtil.of(req.getReader()).toModel(TaiKhoan.class);
		model = taiKhoanService.save(model);
		mapper.writeValue(resp.getOutputStream(), model);
	}
}
