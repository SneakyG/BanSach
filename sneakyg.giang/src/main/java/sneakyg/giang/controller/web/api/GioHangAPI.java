package sneakyg.giang.controller.web.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import sneakyg.giang.model.GioHang;
import sneakyg.giang.model.KhachHang;
import sneakyg.giang.model.TaiKhoan;
import sneakyg.giang.service.interfaces.IGioHangService;
import sneakyg.giang.utils.HttpUtil;
import sneakyg.giang.utils.SessionUtil;

@WebServlet(urlPatterns = { "/api-giohang" })
public class GioHangAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IGioHangService gioHangService;
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		GioHang capnhat = HttpUtil.of(req.getReader()).toModel(GioHang.class);
		capnhat = gioHangService.update(capnhat);
		mapper.writeValue(resp.getOutputStream(), capnhat);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF8");
		resp.setContentType("application/json");
		GioHang model = HttpUtil.of(req.getReader()).toModel(GioHang.class);
		KhachHang user = (KhachHang) SessionUtil.getInstance().getValue(req, "TAIKHOAN");
		model.setMaTaiKhoan(user.getMaTaiKhoan());
		model = gioHangService.save(model);
		mapper.writeValue(resp.getOutputStream(), model);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF8");
		resp.setContentType("application/json");
		Integer[] ids = HttpUtil.of(req.getReader()).toIntArray();
		KhachHang user = (KhachHang) SessionUtil.getInstance().getValue(req, "TAIKHOAN");
		gioHangService.delete(ids, user.getMaTaiKhoan());
		SessionUtil.getInstance().putValue(req, "TAIKHOAN", user);
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
