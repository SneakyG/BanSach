package sneakyg.giang.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sneakyg.giang.common.SystemConstant;
import sneakyg.giang.model.KhachHang;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.paging.PageRequest;
import sneakyg.giang.service.interfaces.IKhachHangService;
import sneakyg.giang.sort.Sorter;
import sneakyg.giang.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-khachhang" })
public class KhachHangController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private IKhachHangService khachHangService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		KhachHang model = FormUtil.toModel(KhachHang.class, req);
		String view = "";
		if (model.getType().equals(SystemConstant.LIST)) {
			IPageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
//			if(model.getTextSearch() != null) {
//				model.setListResult(chucVuService.search(model.getTextSearch()));
//			}
			if (model.getMaTaiKhoan() != null) {
				model.setDsKH(khachHangService.findByUserId(model.getMaTaiKhoan()));
			} else {
				model.setDsKH(khachHangService.findAll(pageble, model.getTextSearch()));
				model.setTotalItem(khachHangService.getTotalItem(model.getTextSearch()));
				model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			}
			view = "/views/admin/khachhang/list.jsp";
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId() != null) {
				model = khachHangService.findOne(model.getId());
			} else {

			}
			view = "/views/admin/khachhang/edit.jsp";
		}
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
}
