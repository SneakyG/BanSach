package sneakyg.giang.controller.admin.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import sneakyg.giang.model.ChiTietHoaDon;
import sneakyg.giang.service.interfaces.IChiTietHoaDonService;
import sneakyg.giang.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-cthd" })
public class ChiTietHoaDonAPI extends HttpServlet {

	private static final long serialVersionUID = -9074536102947279721L;
	
	@Inject
	private IChiTietHoaDonService cthdService;
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ChiTietHoaDon capnhat = HttpUtil.of(req.getReader()).toModel(ChiTietHoaDon.class);
		capnhat = cthdService.update(capnhat);
		mapper.writeValue(resp.getOutputStream(), capnhat);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF8");
		resp.setContentType("application/json");
		List<ChiTietHoaDon> model = HttpUtil.of(req.getReader()).toListModel(ChiTietHoaDon.class);
		model = cthdService.save(model);
		mapper.writeValue(resp.getOutputStream(), model);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF8");
		resp.setContentType("application/json");
		Integer[] ids = HttpUtil.of(req.getReader()).toIntArray();
		cthdService.delete(ids);
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
