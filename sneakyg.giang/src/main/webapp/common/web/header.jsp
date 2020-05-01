<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<div class="header-top">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<a href="#" class="web-url">www.bookstore.com</a>
				</div>
				<c:if test="${not empty TAIKHOAN}">
					<div class="col-md-6" align="right">
						<label><a href="<c:url value = 'profile'/>" style="color:black;"
								class="nav-link">${TAIKHOAN.ten}</a></label>/
						<a href="<c:url value = '/thoat?action=logout'/>">Thoát</a>
					</div>
				</c:if>
				<c:if test="${empty TAIKHOAN}">
					<div class="col-md-6" align="right">
						<span class="ph-number">Call : 800 1234 5678</span>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</header>
