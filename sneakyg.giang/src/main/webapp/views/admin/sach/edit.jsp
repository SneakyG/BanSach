<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<c:url var="editurl" value="/admin-sach" />
<c:url var="APIurl" value="/api-admin-sach" />
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
				<div class="col-12" align="center">
					<div>
						<img alt="" src="${model.hinhAnh}">
					</div>
					<div>
						<h5>Hình hiện tại</h5>
					</div>
				</div>
			</div>
			<div class="row">
			<div class="col-3"></div>
				<div class="col-6" >
					<div class="card" >
						<div class="card-body align-items-center"  >
							<form id="formSubmit" enctype="multipart/form-data">
								<div class="form-group">
									<div>
										<label>Hình ảnh:&nbsp&nbsp&nbsp&nbsp&nbsp</label>
										<input class="border" type="file" name="fileHinhAnh" id="fileHinhAnh"/>
									</div>
									<div>
										<label>Loại sách:&nbsp&nbsp&nbsp&nbsp&nbsp</label>
										<select class="fstdropdown-select" id="maDanhMuc" name="maDanhMuc">
												<c:forEach var="item" items="${model.dsTenDanhMuc}">
													<option value="${item.id}" class="form-control">${item.tenDanhMuc}</option>
												</c:forEach>
										</select>
									</div>
									<div>
										<label>Tên sách:&nbsp&nbsp&nbsp&nbsp&nbsp</label>
										<input type="text" class="form-control" id="tenSach" name="tenSach"
											value="${model.tenSach}">
									</div>
									<div>
										<label>Tác giả:&nbsp&nbsp&nbsp&nbsp&nbsp</label>
										<select class="fstdropdown-select" id="maTacGia" name="maTacGia">
												<c:forEach var="item" items="${model.dsTenTacGia}">
													<option value="${item.id}" class="form-control">${item.tenTG}</option>
												</c:forEach>
										</select>
									</div>
									<div>
										<label>Số lượng:&nbsp&nbsp&nbsp&nbsp&nbsp</label>
										<input type="text" class="form-control" id="soLuong" name="soLuong"
											value="${model.soLuong}">
									</div>
									<div>
										<label>Đơn giá:&nbsp&nbsp&nbsp&nbsp&nbsp</label>
										<input type="text" class="form-control" id="donGia" name="donGia"
											value="${model.donGia}">
									</div>
									<div>
										<label>Nhà xuất bản:&nbsp&nbsp&nbsp&nbsp&nbsp</label>
										<select class="fstdropdown-select" id="maNXB" name="maNXB">
												<c:forEach var="item" items="${model.dsTenNXB}">
													<option value="${item.id}" class="form-control">${item.tenNXB}</option>
												</c:forEach>
										</select>
									</div>
									<div>
										<label>Mô tả ngắn:</label>
										<div>
											<textarea class="form-control" rows="10" name="moTaNgan" id="moTaNgan">${model.moTaNgan}</textarea>
										</div>
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
										<a href="${editurl}?type=list&textSearch=&page=1&maxPageItem=5&sortName=id&sortBy=asc"
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
				var data = {};
				var formData = $('#formSubmit').serializeArray();
				var file = $('#fileHinhAnh')[0];
				formData.push('file',file);
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				var id = $("#id").val();
				var d = $("#fileHinhAnh")[0].val();
				if (id == "") {
					createSach(data);
				} else {
					updateSach(data);
				}
			});

			function updateSach(data) {
				$.ajax({
					url : '${APIurl}',
					type : 'PUT',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						window.location.href = "${editurl}?type=list&page=1&maxPageItem=5&sortName=id&sortBy=asc";
					},
					error : function(error) {
						console.log(error);
					}
				});
			}
			function createSach(data) {
				$.ajax({
					url : '${APIurl}',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						window.location.href = "${editurl}?type=list&page=1&maxPageItem=5&sortName=id&sortBy=asc";
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