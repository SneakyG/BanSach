<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<c:url var="editurl" value="/admin-danhmucsach" />
<c:url var="APIurl" value="/api-admin-danhmucsach" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Danh mục sách</title>
</head>

<body>
	<div class="content-wrapper" style="min-height: 1200.88px;">
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>Danh mục sách</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Danh mục sách</li>
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
									<label>Tên danh mục</label> 
									<input type="text" class="form-control" id="tenDanhMuc" name="tenDanhMuc"
										value="${model.tenDanhMuc}">
									<label>Mã tên danh mục</label> 
									<input type="text" class="form-control" id="tenCode" name="tenCode"
										value="${model.tenCode}">
								</div>
								<div align="center">
									<div class="dt-buttons btn-overlap btn-group">
										<button id="btnXacNhan" type="submit"
											class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
											data-toggle="tooltip" title='Sửa'>
											<span> <i class="fa fa-check "></i>
											</span>
										</button>
										<a href="${editurl}?type=list&textSearch=&page=1&maxPageItem=5&sortName=tenDanhMuc&sortBy=asc"
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
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				var id = $("#id").val();
				if (id == "") {
					createDanhMucSach(data);
				} else {
					updateDanhMucSach(data);
				}
			});

			function updateDanhMucSach(data) {
				$.ajax({
					url : '${APIurl}',
					type : 'PUT',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						window.location.href = "${editurl}?type=list&page=1&maxPageItem=5&sortName=tenDanhMuc&sortBy=asc";
					},
					error : function(error) {
						console.log(error);
					}
				});
			}
			function createDanhMucSach(data) {
				$.ajax({
					url : '${APIurl}',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						window.location.href = "${editurl}?type=list&page=1&maxPageItem=5&sortName=tenDanhMuc&sortBy=asc";
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