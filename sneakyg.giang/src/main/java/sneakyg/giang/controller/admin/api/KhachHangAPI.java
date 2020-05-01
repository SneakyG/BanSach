package sneakyg.giang.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import sneakyg.giang.model.KhachHang;
import sneakyg.giang.service.interfaces.IKhachHangService;
import sneakyg.giang.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-khachhang" })
public class KhachHangAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IKhachHangService khachHangService;
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		KhachHang capnhat = HttpUtil.of(req.getReader()).toModel(KhachHang.class);
		capnhat = khachHangService.update(capnhat);
		mapper.writeValue(resp.getOutputStream(), capnhat);
	}
}
