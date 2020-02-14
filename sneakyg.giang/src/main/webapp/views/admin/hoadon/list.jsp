<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<c:url var="APIurl" value="/api-admin-hd" />
<c:url var="LISTurl" value="/admin-hoadon" />
<!DOCTYPE html>
<html>

<head>

	<meta charset="UTF-8">
	<title>Hóa đơn</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>

<body>
	<div class="content-wrapper" style="min-height: 1200.88px;">
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>Hóa đơn</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Hóa đơn</li>
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
								</div>
								<div id="example1_wrapper" class="dataTables_wrapper dt-bootstrap4">
										<div class="row">
											<div class="col-sm-12">
												<table id="example1" class="table table-bordered table-striped dataTable"
													role="grid" aria-describedby="example1_info">
													<thead>
														<tr>
															<th>Mã hóa đơn</th>
															<th>Thời gian đặt</th>
															<th>Thời gian mua</th>
															<th>Tổng tiền</th>
															<th>Trạng thái</th>
															<th>Thao tác</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${model.listResult}" varStatus="loop">
															<tr>
																<td>${item.id}</td>
																<td>${item.thoiGianDat}</td>
																<td>${item.thoiGianMua}</td>
																<td>${item.tongTien}</td>
																<td>${item.trangThai}</td>
																<td>
																	<c:url var="cthdsUrl" value="/admin-chitiethoadon">
																		<c:param name="type" value="list" />
																		<c:param name="maHoaDon" value="${item.id}" />
																		<c:param name="page" value="1" />
																		<c:param name="maxPageItem" value="5" />
																		<c:param name="sortName" value="id" />
																		<c:param name="sortBy" value="asc" />
																	</c:url> <a class="btn btn-sm btn-primary btn-edit"
																		data-toggle="tooltip" title="Chi tiết"
																		href="${cthdsUrl}"><i class="fa fa-list"
																			aria-hidden="true"></i> </a>
																	<c:if test="${item.trangThai == 0}">
																		<button class="btn btn-sm btn-primary btn-edit"
																			data-toggle="tooltip" title="Check" value="${item.id}"
																			><i class="fa fa-check"
																				aria-hidden="true"></i>
																			
																		</button>
																	</c:if>
																	
																	
																</td>
															</tr>
														</c:forEach>
													</tbody>
													<tfoot>
														<tr>
															<th>Mã hóa đơn</th>
															<th>Thời gian đặt</th>
															<th>Thời gian mua</th>
															<th>Tổng tiền</th>
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
		
		$("button").click(function(e) {
			e.preventDefault();
			var id1 = $(this).prop("value");
			var data = {trangThai: "1",id: id1+""};
			if (id1 == "") {
				createHoaDon(data);
			} else {
				updateHoaDon(data);
			}
		});
		
		function updateHoaDon(data) {
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
		function createHoaDon(data) {
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
	</script>
</body>

</html>