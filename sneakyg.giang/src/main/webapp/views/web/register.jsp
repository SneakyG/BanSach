<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<c:url var="APIurl" value="/api-admin-taikhoan" />
<c:url var="LISTurl" value="/shop" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
</head>
<body>
	<div class="breadcrumb">
        <div class="container">
            <a class="breadcrumb-item" href="index.html">Trang chủ</a>
            <span class="breadcrumb-item active">Đăng ký</span>
        </div>
    </div>
    <section class="static about-sec">
        <div class="container">
			<div class="form" align="center">
				<h1>Đăng ký tài khoản</h1>
				<form action="<c:url value = '/dang-ky'/>" id='formRegis'>
					<div class="col">
						<div class="col-md-4">
							<h6 style="color:red" hidden="true" id="tenTonTai">Tên tài khoản đã tồn tại</h6>
							<input placeholder="Tên đăng nhập" id="tenTaiKhoan"
								name="tenTaiKhoan" required>
						</div>
						<div class="col-md-4">
							<input type="password" placeholder="Mật khẩu" id="matKhau"
								name="matKhau" required>
						</div>
						<div class="col-md-4">
							<input type="password" placeholder="Nhập lại mật khẩu" id="password_confirm" oninput="check(this)" required>
						</div>
						<div class="col-md-3">
							<button class="btn black" id="btnDangKy">Đăng ký</button>
						</div>
						<div class="col-md-4">
							<h5>Nếu đã có tài khoản: <a href="<c:url value = '/dang-nhap?action=login'/>">Đăng nhập</a></h5>
						</div>
						<input type="hidden" value="1" name="maChucVu" id="maChucVu" />
					</div>
				</form>
			</div>
        </div>
	</section>
	<script src="<c:url value = '/template/admin/plugins/jquery/jquery.min.js'/>"></script>
    <script>
	function check(input) {
        if (input.value != document.getElementById('matKhau').value) {
            input.setCustomValidity('Mật khẩu không giống nhau.');
        } else {
            input.setCustomValidity('');
        }
    }
	$(document).ready(function () {
		$('#btnDangKy').click(function (e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formRegis').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			createTaiKhoan(data);
		});

		function createTaiKhoan(data) {
			$.ajax({
				url : '${APIurl}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					if(result != null){
						location.reload(true);
						alert("Đăng ký thành công");	
					}else{
						$('#tenTonTai').attr("hidden",false);
					}
				},
				error : function(error) {
					console.log(error);
					
				}
			});
		}
	});
	</script>	
</body>
</html>