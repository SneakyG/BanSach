<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<c:url var="APIurl" value="/api-admin-nhaxuatban" />
<!DOCTYPE html>
<html>

<head>

	<meta charset="UTF-8">
	<title>Nhà xuất bản</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
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
							<li class="breadcrumb-item active">Nhà xuất bản</li>
						</ol>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->
		</section>
		<section class="content">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
						<div class = "row">
						<div class="col-4">
								<form action="" method="get">
									<input type="hidden" name = "type" value="list" />
									<input type="text" class="form-control" name="textSearch" placeholder="Search..."/>
								</form>
							</div>
							<div class="card-tool" align="right" style="margin-bottom: 5px">
								<div class="dt-buttons btn-overlap btn-group">
									<a class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
										data-toggle="tooltip" title='Thêm'
										href='<c:url value="/admin-tacgia?type=edit"/>'> <span>
											<i class="fa fa-plus-circle bigger-110 purple"></i>
										</span>
									</a>
									<button id="btnDelete" type="button"
										class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
										data-toggle="tooltip" title='Xóa'>
										<span> <i class="fa fa-trash"></i>
										</span>
									</button>
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
													<th><input type="checkbox" id="checkAllHead"></th>
													<th>Tên nhà xuất bản</th>
													<th>Sdt</th>
													<th>Thao tác</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult}">
													<tr>
														<td><input type="checkbox" id="checkbox_${item.id}"
																value="${item.id}"></td>
														<td>${item.tenNXB}</td>
														<td>${item.sdt}</td>
														<td>
															<c:url var="editUrl" value="/admin-nhaxuatban">
																<c:param name="type" value="edit" />
																<c:param name="id" value="${item.id}" />
															</c:url> <a class="btn btn-sm btn-primary btn-edit"
																data-toggle="tooltip" title="Cập nhật"
																href="${editUrl}"><i class="fa fa-edit"
																	aria-hidden="true"></i> </a>
														</td>
													</tr>
												</c:forEach>
											</tbody>
											<tfoot>
												<tr>
													<th><input type="checkbox" id="checkAllFoot"></th>
													<th>Tên nhà xuất bản</th>
													<th>Sdt</th>
													<th>Thao tác</th>
												</tr>
											</tfoot>
										</table>
										<input type="hidden" value="" id="page" name="page" /> <input type="hidden"
											value="" id="maxPageItem" name="maxPageItem" />
										<input type="hidden" value="" id="sortName" name="sortName" />
										<input type="hidden" value="" id="sortBy" name="sortBy" /> <input type="hidden"
											value="" id="type" name="type" />
									</div>
								</div>
							</div>
						</div>
						<ul class="pagination" id="pagination"></ul>
					</div>
				</div>
			</div>
		</section>
	</div>
	<script src="<c:url value = '/template/admin/plugins/jquery/jquery.min.js'/>"></script>
	<script>
		var totalPages = $ {
			model.totalPage
		};
		var currentPage = $ {
			model.page
		};
		var limit = 2;
		$(function () {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages: totalPages,
				visiblePages: 2,
				startPage: currentPage,
				onPageClick: function (event, page) {
					if (currentPage != page) {
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#sortName').val('tenTG');
						$('#sortBy').val('asc');
						$('#type').val('list');
						$('#formSubmit').submit();
					}
				}
			});
		});

		$('#checkAllHead').click(function () {
			$('input:checkbox').not(this).prop('checked', this.checked)
		});

		$('#checkAllFoot').click(function () {
			$('input:checkbox').not(this).prop('checked', this.checked)
		});

		$("#btnDelete").click(function () {
			var data = {};
			var ids = $('tbody input[type=checkbox]:checked').map(function () {
				return $(this).val();
			}).get();
			data['ids'] = ids;
			deleteNhaXuatBan(data);
		})

		function deleteNhaXuatBan(data) {
			$
				.ajax({
					url: '${APIurl}',
					type: 'DELETE',
					contentType: 'application/json',
					data: JSON.stringify(data),
					dataType: 'json',
					success: function (result) {
						window.location.href = "${editurl}?type=list&page=1&maxPageItem=2&sortName=title&sortBy=desc";
					},
					error: function (error) {
						console.log(error);
					}
				});
		}
	</script>
</body>

</html>