<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="index3.html" class="brand-link"> <img
		src="<c:url value = '/template/admin/dist/img/AdminLTELogo.png'/>"
		alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
		style="opacity: .8"> <span class="brand-text font-weight-light">AdminLTE
			3</span>
	</a>

	<!-- Sidebar -->
	<div class="sidebar">
		<!-- Sidebar user panel (optional) -->
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="info">
				<a style="color:yellow;font-weight: bold" href="<c:url value = 'admin-nhanvien?type=info&id=${TAIKHOAN.id}'/>" class="d-block">Chào,${TAIKHOAN.ten}</a>
				<a style="color:red" href="<c:url value = '/thoat?action=logout'/>">Thoát</a>
			</div>
		</div>
		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column"
				data-widget="treeview" role="menu" data-accordion="false">
				<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
				<li class="nav-item has-treeview menu-open"><a href="#"
					class="nav-link active"> <i
						class="nav-icon fas fa-tachometer-alt"></i>
						<p>
							Quản lý <i class="right fas fa-angle-left"></i>
						</p>
				</a>
					<ul class="nav nav-treeview">
						<c:if test="${TAIKHOAN.tk.maChucVu == 3}">
							<li class="nav-item"><a href="<c:url value = '/admin-tacgia?type=list&textSearch=&page=1&maxPageItem=5&sortName=tenTG&sortBy=asc'/>" class="nav-link">
									<p>Quản lý tác giả</p>
							</a></li>
							<li class="nav-item"><a href="<c:url value = '/admin-nhaxuatban?type=list&textSearch=&page=1&maxPageItem=5&sortName=tenNXB&sortBy=asc'/>" class="nav-link">
									<p>Quản lý nhà xuất bản</p>
							</a></li>
							<li class="nav-item"><a href="<c:url value = '/admin-chucvu?type=list&textSearch=&page=1&maxPageItem=5&sortName=tenCV&sortBy=asc'/>" class="nav-link">
									<p>Quản lý chức vụ</p>
							</a></li>
							<li class="nav-item"><a href="<c:url value = '/admin-danhmucsach?type=list&textSearch=&page=1&maxPageItem=5&sortName=tenDanhMuc&sortBy=asc'/>" class="nav-link">
									<p>Quản lý danh mục sách</p>
							</a></li>
							<li class="nav-item"><a href="<c:url value = '/admin-nhanvien?type=list&textSearch=&page=1&maxPageItem=5&sortName=id&sortBy=asc'/>" class="nav-link">
									<p>Quản lý nhân viên</p>		
							</a></li>
						</c:if>
							<li class="nav-item"><a href="<c:url value = '/admin-khachhang?type=list&textSearch=&page=1&maxPageItem=5&sortName=id&sortBy=asc'/>" class="nav-link">
									<p>Quản lý khách hàng</p>		
							</a></li>
							<li class="nav-item"><a href="<c:url value = '/admin-chitiethoadon?type=list&textSearch=&page=1&maxPageItem=5&sortName=trangThai&sortBy=asc'/>" class="nav-link">
									<p>Quản lý chi tiết hóa đơn</p>
							</a></li>
							<li class="nav-item"><a href="<c:url value = '/admin-hoadon?type=list&textSearch=&page=1&maxPageItem=5&sortName=trangThai&sortBy=asc'/>" class="nav-link">
									<p>Quản lý hóa đơn</p>
							</a></li>
							<li class="nav-item"><a href="<c:url value = '/admin-sach?type=list&textSearch=&page=1&maxPageItem=5&sortName=id&sortBy=asc'/>" class="nav-link">
									<p>Quản lý sách</p>
							</a></li>
							<li class="nav-item"><a href="<c:url value = '/admin-taikhoan?type=list&textSearch=&page=1&maxPageItem=5&sortName=id&sortBy=asc'/>" class="nav-link">
									<p>Quản lý tài khoản</p>		
							</a></li>
					</ul></li>
				<li class="nav-item"><a href="#" class="nav-link"> <i
						class="nav-icon fas fa-th"></i>
						<p>
							Chức năng thêm <span class="right badge badge-danger">New</span>
						</p>
				</a></li>
			</ul>
		</nav>
		<!-- /.sidebar-menu -->
	</div>
	<!-- /.sidebar -->
</aside>