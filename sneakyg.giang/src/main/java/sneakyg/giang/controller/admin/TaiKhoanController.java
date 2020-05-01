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
import sneakyg.giang.model.TaiKhoan;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.paging.PageRequest;
import sneakyg.giang.service.interfaces.ITaiKhoanService;
import sneakyg.giang.sort.Sorter;
import sneakyg.giang.utils.FormUtil;
import sneakyg.giang.utils.SessionUtil;

@WebServlet(urlPatterns = { "/admin-taikhoan" })
public class TaiKhoanController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private ITaiKhoanService taiKhoanService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TaiKhoan model = FormUtil.toModel(TaiKhoan.class, req);
		String view = "";
		if (model.getType().equals(SystemConstant.LIST)) {
			IPageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			KhachHang user = (KhachHang) SessionUtil.getInstance().getValue(req, "TAIKHOAN"); 
			if (model.getId() != null) {
				model.setListResult(taiKhoanService.findOneByID(model.getId()));
			}else {
				if(user.getTk().getMaChucVu() == 2) {
					model.setListResult(taiKhoanService.findAllCustomer(pageble, model.getTextSearch()));
				}else {
					model.setListResult(taiKhoanService.findAll(pageble, model.getTextSearch()));
				}
				model.setTotalItem(taiKhoanService.getTotalItem(model.getTextSearch()));
				model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			}
			view = "/views/admin/taikhoan/list.jsp";
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId() != null) {
				model = taiKhoanService.findOne(model.getId());
			} else {
				
			}
			view = "/views/admin/taikhoan/edit.jsp";
		}
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
}
