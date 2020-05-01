<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<c:url var="APIurl" value="/api-admin-khachhang" />
<c:url var="LISTurl" value="/shop" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin cá nhân</title>
</head>
<body>
	<section class="static about-sec">
		<div class="container">
			<div class="form">
				<form id='formSubmit'>
					<div class="col">
						<div class="col-md-4">
							<label>Họ và tên</label>
							<input id="ten" name="ten" type="text" value="${model.ten}" required>
						</div>
						<div class="col-md-4">
							<label>Email</label>
							<input id="email" name="email" type="email" value="${model.email}" required>
						</div>
						<div class="col-md-4">
							<label>Số điện thoại</label>
							<input id="sdt" name="sdt" type="text" value="${model.sdt}"  required>
						</div>
						<div class="col-md-4">
							<label>Chứng minh thư</label>
							<input id="cmnd" name="cmnd" type="text" maxlength="9" value="${model.cmnd}" required>
						</div>
						<div class="col-md-4">
							<label>Ngày sinh</label>
							<input id="ngaySinh" name="ngaySinh" type="text" value="${model.ngaySinh}" required>
						</div>
						<div class="col-md-4">
							<label>Địa chỉ</label>
							<input type="text" id="diaChi" name="diaChi" value="${model.diaChi}" required>
						</div>
						<div class="col-md-3">
							<button id="btnCapNhat" class="btn black">Cập nhật</button>
						</div>
						<input type="hidden" value="${model.id}" id="id" name="id" />
						<input type="hidden" value="${model.maTaiKhoan}" id="maTaiKhoan" name="maTaiKhoan" />
					</div>
				</form>
			</div>
		</div>
	</section>
	<script src="<c:url value = '/template/admin/plugins/jquery/jquery.min.js'/>"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$('#btnCapNhat').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			updateKhachHang(data);
		});
		
		function updateKhachHang(data) {
			$.ajax({
				url : '${APIurl}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					location.reload(true);
					if(result != null){
						alert("Cập nhật thành công");
					}else{
						alert("Cập nhật thất bại");
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