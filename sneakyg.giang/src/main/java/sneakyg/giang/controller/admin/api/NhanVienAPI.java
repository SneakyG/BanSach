package sneakyg.giang.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import sneakyg.giang.model.NhanVien;
import sneakyg.giang.service.interfaces.INhanVienService;
import sneakyg.giang.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-nhanvien" })
public class NhanVienAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private INhanVienService nhanVienService;
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NhanVien capnhat = HttpUtil.of(req.getReader()).toModel(NhanVien.class);
		capnhat = nhanVienService.update(capnhat);
		mapper.writeValue(resp.getOutputStream(), capnhat);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF8");
		resp.setContentType("application/json");
		NhanVien model = HttpUtil.of(req.getReader()).toModel(NhanVien.class);
		model = nhanVienService.save(model);
		mapper.writeValue(resp.getOutputStream(), model);
	}
}
