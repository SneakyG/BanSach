<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<c:url var="APIurl" value="/api-admin-khachhang" />
<c:url var="LISTurl" value="/admin-khachhang" />
<!DOCTYPE html>
<html>

<head>

	<meta charset="UTF-8">
	<title>Khách hàng</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>

<body>
	<div class="content-wrapper" style="min-height: 1200.88px;">
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>Khách hàng</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Khách hàng</li>
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
															<th>Họ tên</th>
															<th>Mã tài khoản</th>
															<th>Số điện thoại</th>
															<th>CMND</th>
															<th>Địa chỉ</th>
															<th>Email</th>
															<th>Ngày sinh</th>
															<th>Thao tác</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${model.dsKH}">
															<tr>
																<td>${item.ten}</td>
																<td>${item.maTaiKhoan}</td>
																<td>${item.sdt}</td>
																<td>${item.cmnd}</td>
																<td>${item.diaChi}</td>
																<td>${item.email}</td>
																<td>${item.ngaySinh}</td>
																<td>
																	<c:url var="taikhoanUrl" value="/admin-taikhoan">
																		<c:param name="type" value="list" />
																		<c:param name="id" value="${item.maTaiKhoan}" />
																		<c:param name="maKH" value="${item.id}" />
																		<c:param name="page" value="1" />
																		<c:param name="maxPageItem" value="5" />
																		<c:param name="sortName" value="id" />
																		<c:param name="sortBy" value="asc" />
																	</c:url> <a class="btn btn-sm btn-primary btn-edit"
																		data-toggle="tooltip" title="Xem tài khoản"
																		href="${taikhoanUrl}"><i class="fa fa-list"
																			aria-hidden="true"></i> </a>
																</td>
															</tr>
														</c:forEach>
													</tbody>
													<tfoot>
														<tr>
															<th>Họ tên</th>
															<th>Mã tài khoản</th>
															<th>Số điện thoại</th>
															<th>CMND</th>
															<th>Đìa chỉ</th>
															<th>Email</th>
															<th>Ngày sinh</th>
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
	</script>
</body>

</html>