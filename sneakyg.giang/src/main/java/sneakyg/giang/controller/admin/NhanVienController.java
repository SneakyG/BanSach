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
import sneakyg.giang.model.NhanVien;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.paging.PageRequest;
import sneakyg.giang.service.interfaces.INhanVienService;
import sneakyg.giang.sort.Sorter;
import sneakyg.giang.utils.FormUtil;
import sneakyg.giang.utils.SessionUtil;

@WebServlet(urlPatterns = {"/admin-nhanvien"})
public class NhanVienController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private INhanVienService nhanVienService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NhanVien model = FormUtil.toModel(NhanVien.class, req);
		String view = "";
		KhachHang user = (KhachHang) SessionUtil.getInstance().getValue(req, "TAIKHOAN");
		if(user.getTk().getMaChucVu() == 3) {
			if (model.getType().equals(SystemConstant.LIST)) {
				IPageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
						new Sorter(model.getSortName(), model.getSortBy()));
				if (model.getMaTaiKhoan() != null) {
					model.setDsNV(nhanVienService.findByUserId(model.getMaTaiKhoan()));
				}else {
					model.setDsNV(nhanVienService.findAll(pageble,model.getTextSearch()));
					model.setTotalItem(nhanVienService.getTotalItem(model.getTextSearch()));
					model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
				}
				view = "/views/admin/nhanvien/list.jsp";
			} else if (model.getType().equals(SystemConstant.EDIT)) {
				if (model.getId() != null) {
					model = nhanVienService.findOne(model.getId());
				} else {

				}
				view = "/views/admin/nhanvien/edit.jsp";
			}
		}else {
			view = "/views/admin/home.jsp";
		}
		if (model.getType().equals(SystemConstant.INFO)){
			if(user.getTk().getMaChucVu() == 2) {
				model = nhanVienService.findOne(user.getId());
			}else {
				model = nhanVienService.findOne(model.getId());
			}
			view = "/views/admin/nhanvien/profile.jsp";
		}
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
}
