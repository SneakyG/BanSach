<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<c:url var="APIurl" value="/api-admin-taikhoan" />
<c:url var="LISTurl" value="/admin-taikhoan" />
<!DOCTYPE html>
<html>

<head>

	<meta charset="UTF-8">
	<title>Tài khoản</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
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
			<form action="${LISTurl}" id="formSubmit" method="get" onsubmit="DoSubmit();">
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<div class="row">
									<div class="col-4">
											<input	type="hidden" name="type" value = "list" />
											<input type="text" class="form-control" name="textSearch" id="textSearch" value="${model.textSearch}"
												placeholder="Search..." />
									</div>
									<div class="card-tool" align="right" style="margin-bottom: 5px">
										<div class="dt-buttons btn-overlap btn-group">
											<a class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Thêm'
												href="${LISTurl}?type=edit"> <span>
													<i class="fa fa-plus-circle bigger-110 purple"></i>
												</span>
											</a>
										</div>
									</div>
								</div>
								<div id="example1_wrapper" class="dataTables_wrapper dt-bootstrap4">
										<div class="row">
											<div class="col-sm-12">
												<table id="example1" class="table table-bordered table-striped dataTable"
													role="grid" aria-describedby="example1_info">
													<thead>
														<tr>
															<th>Tên tài khoản</th>
															<th>Mật khẩu</th>
															<th>Chức vụ</th>
															<th>Trạng thái</th>
															<th>Thao tác</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${model.listResult}">
															<tr>
																<td>${item.tenTaiKhoan}</td>
																<td>${item.matKhau}</td>
																<td>${item.cv.tenCV}</td>
																<td>${item.trangThai}</td>
																<td>
																	<c:if test="${item.maChucVu == 2 or item.maChucVu == 3}">
																		<c:url var="nhanvienUrl" value="/admin-nhanvien">
																			<c:param name="type" value="list" />
																			<c:param name="maTaiKhoan" value="${item.id}" />
																			<c:param name="page" value="1" />
																			<c:param name="maxPageItem" value="5" />
																			<c:param name="sortName" value="id" />
																			<c:param name="sortBy" value="asc" />
																			<c:param name="trangThai" value="${item.trangThai}" />
																		</c:url> <a class="btn btn-sm btn-primary btn-edit"
																			data-toggle="tooltip" title="Chi tiết"
																			href="${nhanvienUrl}"><i class="fa fa-list"
																				aria-hidden="true"></i> </a>
																	</c:if>
																	<c:if test="${item.maChucVu == 1}">
																		<c:url var="khachhangUrl" value="/admin-khachhang">
																				<c:param name="type" value="list" />
																				<c:param name="maTaiKhoan" value="${item.id}" />
																				<c:param name="page" value="1" />
																				<c:param name="maxPageItem" value="5" />
																				<c:param name="sortName" value="id" />
																				<c:param name="sortBy" value="asc" />
																				<c:param name="trangThai" value="${item.trangThai}" />
																			</c:url> <a class="btn btn-sm btn-primary btn-edit"
																				data-toggle="tooltip" title="Chi tiết"
																				href="${khachhangUrl}"><i class="fa fa-list"
																					aria-hidden="true"></i> </a>
																	</c:if>
																	
																		
																	<c:if test="${item.trangThai == 0}">
																		<button class="btn btn-sm btn-primary btn-edit"  id="unlock"
																			data-toggle="tooltip" title="Mở khóa" value="${item.id}"
																			><i class="fa fa-unlock"
																				aria-hidden="true"></i>
																		</button>
																	</c:if>
																	<c:if test="${item.trangThai == 1}">
																		<c:url var="editUrl" value="/admin-taikhoan">
																				<c:param name="type" value="edit" />
																				<c:param name="id" value="${item.id}" />
																			</c:url> <a class="btn btn-sm btn-primary btn-edit"
																				data-toggle="tooltip" title="Cập nhật"
																				href="${editUrl}"><i class="fa fa-edit"
																					aria-hidden="true"></i> </a>
																					
																		<button class="btn btn-sm btn-primary btn-edit" id="lock"
																			data-toggle="tooltip" title="Khóa" value="${item.id}"
																			><i class="fa fa-lock"
																				aria-hidden="true"></i>
																		</button>
																	</c:if>
																</td>
															</tr>
														</c:forEach>
													</tbody>
													<tfoot>
														<tr>
															<th>Tên tài khoản</th>
															<th>Mật khẩu</th>
															<th>Trạng thái</th>
															<th>Thao tác</th>
														</tr>
													</tfoot>
												</table>
												<ul class="pagination" id="pagination"></ul>
												<input type="hidden" value="${model.page}" id="page" name="page" />
												<input type="hidden" value="${model.maxPageItem}" id="maxPageItem" name="maxPageItem" />
												<input type="hidden" value="${model.sortName}" id="sortName" name="sortName" />
												<input type="hidden" value="${model.sortBy}" id="sortBy" name="sortBy" />
											</div>
										</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</section>
	</div>
	<script>
		var totalPage = ${model.totalPage};
		var currentPage = ${model.page};
		var limit = 5;
		function DoSubmit() {
			if($('#textSearch').val()+"" != (${model.textSearch}+"")){
				$('#page').val(1);
			}
		}
		$(function () {
				window.pagObj = $('#pagination').twbsPagination({
					totalPages: totalPage,
					visiblePages: 10,
					startPage: currentPage,
					onPageClick: function (event, page) {
						if (currentPage != page) {
							$('#page').val(page);
							$('#maxPageItem').val(limit);
							$('#sortName').val('id');
							$('#sortBy').val('asc');
							$('#formSubmit').submit();
						}
					}
				});
		});
		
		$("#lock,#unlock").click(function(e) {
			e.preventDefault();
			var id1 = $(this).prop("value");
			var data = {id: id1+""};
			updateTaiKhoan(data);
		});
		
		function updateTaiKhoan(data) {
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
	</script>
</body>

</html>