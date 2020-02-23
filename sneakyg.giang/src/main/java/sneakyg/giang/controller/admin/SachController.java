package sneakyg.giang.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sneakyg.giang.common.SystemConstant;
import sneakyg.giang.model.Sach;
import sneakyg.giang.paging.IPageble;
import sneakyg.giang.paging.PageRequest;
import sneakyg.giang.service.interfaces.ISachService;
import sneakyg.giang.sort.Sorter;
import sneakyg.giang.utils.FormUtil;
import sneakyg.giang.utils.UpLoadFileUtil;

@WebServlet(urlPatterns = { "/admin-sach","/upload" })
public class SachController extends HttpServlet {
	
	private static final long serialVersionUID = -2711660483226721500L;
	
	@Inject
	private ISachService sachService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Sach model = FormUtil.toModel(Sach.class, req);
		String view = "";
		if (model.getType().equals(SystemConstant.LIST)) {
			IPageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
//			if(model.getTextSearch() != null) {
//				model.setListResult(cthdService.search(pageble,model.getTextSearch()));
//			}
			model.setListResult(sachService.findAll(pageble,model.getTextSearch()));
			model.setTotalItem(sachService.getTotalItem(model.getTextSearch()));
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/sach/list.jsp";
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			File f = new File(SystemConstant.UPLOAD_IMAGE_DIR);
			List<String> images = new ArrayList<String>(Arrays.asList(f.list()));
			if (model.getId() != null) {
				model = sachService.findOne(model.getId());
				int viTriCatChuoi = model.getHinhAnh().indexOf("/");
				String hinhAnhHienTai = model.getHinhAnh().substring(viTriCatChuoi+1);
				images.add(0, hinhAnhHienTai);
			} else {

			}
			
			model.setFileHinhAnh(images);
			model.setDsTenDanhMuc(sachService.getListCategoryName(model.getMaDanhMuc()));
			model.setDsTenTacGia(sachService.getListAuthorName(model.getMaTacGia()));
			model.setDsTenNXB(sachService.getListNXBName(model.getMaNXB()));
			view = "/views/admin/sach/edit.jsp";
		} 
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UpLoadFileUtil.upLoadFile(req);
		resp.sendRedirect(req.getContextPath() + "/admin-sach?type=list&textSearch=&page=1&maxPageItem=5&sortName=id&sortBy=asc");
	}
}
