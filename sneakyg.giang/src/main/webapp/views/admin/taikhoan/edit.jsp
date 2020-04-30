<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<c:url var="editurl" value="/admin-taikhoan" />
<c:url var="NVurl" value="/admin-nhanvien" />
<c:url var="KHurl" value="/admin-khachhang" />
<c:url var="APIurl" value="/api-admin-taikhoan" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Tài khoản</title>
</head>

<body>
	<div class="content-wrapper" style="min-height: 1200.88px;">
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>Tài khoản</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Tài khoản</li>
						</ol>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->
		</section>
		<section class="content">
			<div class="row">
				<div class="col-4">
					<div class="card">
						<div class="card-body">
							<form id="formSubmit">
								<div class="form-group">
								<c:if test="${empty model.id}">
									<label>Tên tài khoản</label> 
									<input type="text" class="form-control" id="tenTaiKhoan" name="tenTaiKhoan"
									>
								</c:if>
									
									<label>Mật khẩu</label> 
									<input type="text" class="form-control" id="matKhau" name="matKhau"
										value="${model.matKhau}">
								</div>
								<div align="center">
									<div class="dt-buttons btn-overlap btn-group">
										<button id="btnXacNhan" type="submit"
											class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
											data-toggle="tooltip" title='Sửa'>
											<span> <i class="fa fa-check "></i>
											</span>
										</button>
										<a href="${editurl}?type=list&textSearch=&page=1&maxPageItem=5&sortName=id&sortBy=asc"
											class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
											style="margin-left: 10px" data-toggle="tooltip"
											title='Thoát'>
											<span> <i class="fa fa-times-circle"></i>
											</span>
										</a>
									</div>
									<input type="hidden" value="${model.id}" id="id" name="id" />
									<input type="hidden" value="${model.maNV}" id="maNV" name="maNV" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<script
		src="<c:url value = '/template/admin/plugins/jquery/jquery.min.js'/>"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#btnXacNhan').click(function(e) {
				e.preventDefault();
				var data = {};
				var formData = $('#formSubmit').serializeArray();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				var id = $("#id").val();
				if (id == "") {
					createTaiKhoan(data);
				} else {
					updateTaiKhoan(data);
				}
			});

			function updateTaiKhoan(data) {
				$.ajax({
					url : '${APIurl}',
					type : 'PUT',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						window.location.href = "${editurl}?type=list&id="+data.id+"&page=1&maxPageItem=5&sortName=id&sortBy=asc";
					},
					error : function(error) {
						console.log(error);
					}
				});
			}
			function createTaiKhoan(data) {
				$.ajax({
					url : '${APIurl}',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						/* if(data.maNV != ""){
							window.location.href = "${NVurl}?type=list&page=1&maxPageItem=5&sortName=id&sortBy=asc";
						}else {
							window.location.href = "${editurl}?type=list&page=1&maxPageItem=5&sortName=id&sortBy=asc";
						} */
						window.location.href = "${editurl}?type=list&id="+data.id+"&page=1&maxPageItem=5&sortName=id&sortBy=asc";
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