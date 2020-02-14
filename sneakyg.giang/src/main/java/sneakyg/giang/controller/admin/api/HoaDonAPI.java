package sneakyg.giang.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import sneakyg.giang.model.HoaDon;
import sneakyg.giang.service.interfaces.IHoaDonService;
import sneakyg.giang.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-hd" })
public class HoaDonAPI extends HttpServlet {

	private static final long serialVersionUID = -159641587490768268L;
	
	@Inject
	private IHoaDonService hoaDonService;
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		HoaDon capnhat = HttpUtil.of(req.getReader()).toModel(HoaDon.class);
		capnhat = hoaDonService.update(capnhat);
		mapper.writeValue(resp.getOutputStream(), capnhat);
	}
}
