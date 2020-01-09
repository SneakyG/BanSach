<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<div class="header-top">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<a href="#" class="web-url">www.bookstore.com</a>
				</div>
				<div class="col-md-6">
					<h5>Free Shipping Over $99 + 3 Free Samples With Every Order</h5>
				</div>
				<c:if test="${not empty TAIKHOAN}">
					<div class="col-md-3">
						<span class="ph-number">Welcome, ${TAIKHOAN.ten}</span>
					</div>
					<div class="col-md-3">
						<span class="ph-number" href="<c:url value = '/thoat?action=logout'/>">Thoát</span>
					</div>
				</c:if>
				<c:if test="${empty TAIKHOAN}">
					<div class="col-md-3">
						<span class="ph-number">Call : 800 1234 5678</span>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</header>
