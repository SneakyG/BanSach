<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="dangnhap"  value="/dangnhap" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<div class="breadcrumb">
		<div class="container">
			<a class="breadcrumb-item" href="index.html">Home</a> <span
				class="breadcrumb-item active">Login</span>
		</div>
	</div>
	<section class="static about-sec">
		<div class="container">
			<!-- <h1>My Account / Login</h1> -->
			<!-- <p>Lorem Ipsum is simply dummy text of the printing and
				typesetting industry. Lorem Ipsum has been the industry's printer
				took a galley of type and scrambled it to make a type specimen book.
				It has survived not only fiveLorem Ipsum is simply dummy text of the
				printing and typesetting industry. Lorem</p> -->

			<div class="form" align="center">
			
				<form action="${dangnhap}" id='formLogin'
					method='post'>
					<div class="col">
						<div class="col-md-4">
							<input placeholder="Tên đăng nhập" id="tenTaiKhoan" name="tenTaiKhoan"
								required>
						</div>
						<div class="col-md-4">
							<input type="password" placeholder="Mật khẩu" id="matKhau"
								name="matKhau" required>
						</div>
						<div class="col-md-3">
						<button type="submit" class="btn black">Đăng
							nhập</button>
						</div>
		
						<input type="hidden" value="login" name="action" />
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>