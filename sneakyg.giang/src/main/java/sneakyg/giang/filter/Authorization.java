package sneakyg.giang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sneakyg.giang.model.KhachHang;
import sneakyg.giang.utils.SessionUtil;

public class Authorization implements Filter{

	@SuppressWarnings("unused")
	private ServletContext context;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String url = req.getRequestURI();
		url = url.replace("/sneakyg.giang", "");
		if(url.startsWith("/admin")) {
			KhachHang model = (KhachHang) SessionUtil.getInstance().getValue(req, "TAIKHOAN");
			if(model != null) {
				if(model.getTk().getCv().getTenCode().equals("quan-ly")) {
					chain.doFilter(req, resp);
				}else if(model.getTk().getCv().getTenCode().equals("nhan-vien")){
					if(checkRole(url)) {
						chain.doFilter(req, resp);
					}else {
						RequestDispatcher rd = req.getRequestDispatcher("/views/admin/home.jsp");
						rd.forward(req, resp);
					}
				}else if(model.getTk().getCv().getTenCode().equals("khach-hang")) {
					resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=no-permission&alert=warning");
				}
			}else {
				resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=not-login&alert=warning");
			}
		}else {
			chain.doFilter(req, resp);
		}
		
	}
	
	public boolean checkRole(String url) {
		String[] nhanVienRequired = {"/admin-hoadon","/admin-chitiethoadon","/admin-sach","/admin-khachhang", "/admin-taikhoan", "/admin-nhanvien"};
		
		for(String checkURL : nhanVienRequired) {
			if(url.contains(checkURL)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void destroy() {
		
	}

}
