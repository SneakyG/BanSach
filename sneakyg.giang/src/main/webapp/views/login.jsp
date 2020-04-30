<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<div class="breadcrumb">
		<div class="container">
			<a class="breadcrumb-item" href="index.html">Trang chủ</a> <span
				class="breadcrumb-item active">Đăng nhập</span>
		</div>
	</div>
	<section class="static about-sec">
		<div class="container">

			<div class="form" align="center">

				<form action="<c:url value = '/dang-nhap'/>" id='formLogin'
					method='post'>
					<div class="col">
					<c:if test="${not empty message}">
						<div class="alert alert-${alert}">
							${message}
						</div>
					</c:if>
						<div class="col-md-4">
							<input placeholder="Tên đăng nhập" id="tenTaiKhoan"
								name="tenTaiKhoan" required>
						</div>
						<div class="col-md-4">
							<input type="password" placeholder="Mật khẩu" id="matKhau"
								name="matKhau" required>
						</div>
						<div class="col-md-3">
							<button type="submit" class="btn black">Đăng nhập</button>
						</div>

						<input type="hidden" value="login" name="action" />
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>