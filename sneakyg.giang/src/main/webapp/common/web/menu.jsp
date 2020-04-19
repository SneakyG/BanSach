<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<div class="main-menu">
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light">
				<a class="navbar-brand" href="<c:url value = '/trang-chu'/>"><img
					src="<c:url value ='/template/web/images/logo.png'/>" alt="logo"></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ml-auto">
						<li class="navbar-item"><a
							href="<c:url value = '/trang-chu'/>" class="nav-link">Trang chủ</a></li>
						<li class="navbar-item"><a href="<c:url value = '/shop?maDanhMuc=0'/>" class="nav-link">Cửa hàng</a>
						</li>
						<li class="navbar-item"><a href="about.html" class="nav-link">About</a>
						</li>
						<li class="navbar-item"><a href="faq.html" class="nav-link">FAQ</a>
						</li>
						<c:if test="${empty TAIKHOAN}">
							<li class="navbar-item"><a
								href="<c:url value = '/dang-nhap?action=login'/>"
								class="nav-link">Login</a></li>
						</c:if>

					</ul>
					<c:if test="${not empty TAIKHOAN}">
							<div class="cart my-2 my-lg-0">
								<a href="<c:url value = '/cart?page=1&maxPageItem=5&sortName=id&sortBy=asc'/>" style="color:black">
									<span><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>
									<span class="quntity">${TAIKHOAN.tk.soGioHang}</span>
								</a>
							</div>
					</c:if>
					<form class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="search"
							placeholder="Search here..." aria-label="Search"> <span
							class="fa fa-search"></span>
					</form>
				</div>
			</nav>
		</div>
	</div>
</header>
