<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<c:url var="APIurl" value="/api-admin-sach" />
<c:url var="LISTurl" value="/admin-sach" />
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
				<div class="col-12">
					<div align="right">
						<form action="${LISTurl}" method="POST" enctype="multipart/form-data">
							<label for="file-upload"
								class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
								data-toggle="tooltip" title='Tải hình từ máy'>
								<span> <i class="fa fa-upload"></i>
								</span>
							</label>
							<input id="file-upload" type="file" name="file-upload" style="display : none;" multiple/>
							<input type="submit">
						</form>
					</div>
				</div>
			</div>
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
															<th>Hình ảnh</th>
															<th>Tên sách</th>
															<th>Mô tả ngắn</th>
															<th>Danh mục</th>
															<th>Tên tác giả</th>
															<th>Nhà xuất bản</th>
															<th>Số lượng</th>
															<th>Đơn giá</th>
															<th>Thao tác</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${model.listResult}">
															<tr>
																<td><input type="checkbox" id="checkbox_${item.id}"
																		value="${item.id}"></td>
																<td><img alt="" src="${item.hinhAnh}"></td>
																<td style="width:20%">${item.tenSach}</td>
																<td style="width:20%"> 
																	<div class="content hideContent">
																	${item.moTaNgan}
																	</div>
																	<div class="show-more" style="color:blue">
        																<h4>...</h4>
    																</div></td>
																<td>${item.dm.tenDanhMuc}</td>
																<td>${item.tg.tenTG}</td>
																<td>${item.nxb.tenNXB}</td>
																<td>${item.soLuong}</td>
																<td>${item.donGia}</td>
																<td>
																	<c:url var="editUrl" value="/admin-sach">
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
															<th>Hình ảnh</th>
															<th>Tên sách</th>
															<th>Mô tả ngắn</th>
															<th>Danh mục</th>
															<th>Tên tác giả</th>
															<th>Nhà xuất bản</th>
															<th>Số lượng</th>
															<th>Đơn giá</th>
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
			deleteSach(data);
		});
 		$(".show-more h4").on("click", function() {
		    var $this = $(this); 
		    var $content = $this.parent().prev("div.content");
		    var linkText = $this.text().toUpperCase();    
		    
		    if(linkText === "..."){
		        linkText = "Show less";
		        $content.addClass('showcontent').removeClass('hideContent');
		    } else {
		        linkText = "...";
		        $content.addClass('hideContent').removeClass('showContent');
		    };
	
		    $this.text(linkText);
		});
		function deleteSach(data) {
			$.ajax({
				url: '${APIurl}',
				type: 'DELETE',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function (result) {
					window.location.href = "${LISTurl}?type=list&page=1&maxPageItem=5&sortName=id&sortBy=asc";
				},
				error: function (error) {
					console.log(error);
				}
			});
		}
	</script>
</body>
</html>