<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<c:url var="editurl" value="/admin-tacgia" />
<c:url var="APIurl" value="/api-admin-tacgia" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Sửa tác giả</title>
</head>

<body>
	<div class="content-wrapper" style="min-height: 1200.88px;">
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>Tác giả</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Tác giả</li>
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
									<label for="exampleInputEmail1">Tên tác giả</label> <input
										type="text" class="form-control" id="tenTG" name="tenTG"
										value="${model.tenTG}">
								</div>
								<div align="center">
									<div class="dt-buttons btn-overlap btn-group">
										<button id="btnXacNhan" type="submit"
											class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
											data-toggle="tooltip" title='Sửa'>
											<span> <i class="fa fa-check "></i>
											</span>
										</button>
										<a href="<c:url value='/admin-tacgia?type=list'/>"
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
					createTacGia(data);
				} else {
					updateTacGia(data);
				}
			});

			function updateTacGia(data) {
				$.ajax({
					url : '${APIurl}',
					type : 'PUT',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						window.location.href = "${editurl}?type=list&page=1&maxPageItem=5&sortName=tenTG&sortBy=asc";
					},
					error : function(error) {
						console.log(error);
					}
				});
			}
			function createTacGia(data) {
				$.ajax({
					url : '${APIurl}',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						window.location.href = "${editurl}?type=list&page=1&maxPageItem=5&sortName=tenTG&sortBy=asc";
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