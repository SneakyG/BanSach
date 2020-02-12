<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<c:url var="editurl" value="/admin-chitiethoadon" />
<c:url var="APIurl" value="/api-admin-cthd" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Sách</title>
</head>

<body>
	<div class="content-wrapper" style="min-height: 1200.88px;">
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>Sách</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Sách</li>
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
									<div>
										<label>Sách</label> 
											<select class="fstdropdown-select" id="maSach" name="maSach">
												<c:forEach var="item" items="${model.dsTenSach}">
													<option value="${item.id}" class="form-control">${item.tenSach}</option>
												</c:forEach>
											</select>
									</div>
									<div>
										<label>Số lượng</label> 
										<input type="text" class="form-control" id="soLuong" name="soLuong"
											value="${model.soLuong}">
									</div>
								</div>
								<div align="center">
									<div class="dt-buttons btn-overlap btn-group">
										<button id="btnXacNhan" type="submit"
											class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
											data-toggle="tooltip" title='Sửa'>
											<span> <i class="fa fa-check "></i>
											</span>
										</button>
										<a href="${editurl}?type=list&textSearch=&page=1&maxPageItem=5&sortName=thanhTien&sortBy=asc"
											class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
											style="margin-left: 10px" data-toggle="tooltip"
											title='Thoát'>
											<span> <i class="fa fa-times-circle"></i>
											</span>
										</a>
									</div>
									<input type="hidden" value="${model.id}" id="id" name="id" />
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
				console.log($("#maSach").val());
				var data = {};
				var formData = $('#formSubmit').serializeArray();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				var id = $("#id").val();
				if (id == "") {
					createChucVu(data);
				} else {
					updateChiTietHoaDon(data);
				}
			});

			function updateChiTietHoaDon(data) {
				$.ajax({
					url : '${APIurl}',
					type : 'PUT',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						window.location.href = "${editurl}?type=list&page=1&maxPageItem=5&sortName=thanhTien&sortBy=asc";
					},
					error : function(error) {
						console.log(error);
					}
				});
			}
			function createChucVu(data) {
				$.ajax({
					url : '${APIurl}',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						window.location.href = "${editurl}?type=list&page=1&maxPageItem=5&sortName=thanhTien&sortBy=asc";
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