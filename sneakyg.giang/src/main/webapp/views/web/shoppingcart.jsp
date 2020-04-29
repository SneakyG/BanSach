<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<c:url var="ShopURL" value="/shop"/>
<c:url var="CartURL" value="/cart"/>
<c:url var="APIurl" value="/api-giohang" />
<c:url var="APIThanhToanurl" value="/api-admin-cthd" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
</head>
<body>
	<div class="breadcrumb">
        <div class="container">
            <a class="breadcrumb-item" href='<c:url value = "/trang-chu"/>'>Trang chủ</a>
            <span class="breadcrumb-item active">Giỏ hàng</span>
        </div>
	</div>
	<section class="content">
    <c:if test="${empty model.listResult}">
	    
	    	<div class="container" align="center">
	    		<h1><a href="${ShopURL}?maDanhMuc=0">Hãy đi mua sắm nào</a></h1>
	    	</div>
    </c:if>
    <c:if test="${not empty model.listResult}">
	    <form action="${CartURL}?page=1&maxPageItem=5&sortName=id&sortBy=asc" id="formSubmit"  method="get">
	    	<div class="container">
	        	<div class="row">
			        <div class="col-12">
			            <div class="table-responsive">
			                <table class="table table-striped" id="cartTable">
			                    <thead>
			                        <tr>
			                            <th scope="col" width="10%"> </th>
			                            <th scope="col" width="25%">Sản phẩm</th>
			                            <th scope="col" width="15%" >Tên tác giả</th>
			                            <th scope="col" class="text-center" width="10%">Số lượng</th>
			                            <th scope="col" class="text-right" width="15%">Tổng giá(VND)</th>
			                            <th class="text-right" width="25%">Thao tác</th>
			                        </tr>
			                    </thead>
			                    <tbody>
			                        <c:forEach var="item" items="${model.listResult}">
			                        	<tr>	
			                        		<td><img src="${item.hinhAnh}"/> </td>
				                            <td>${item.tenSach} 
				                            <input type="hidden" value="${item.maSach}">
				                            </td>
				                            <td>${item.tenTG}</td>
				                            <td>
												<input class="form-control" type="number" value="${item.soLuongMua}" min="1" max="${item.soLuong}"/>
				                            </td>
				                            <td class="text-right eachproduct">${item.tongTien}</td>
				                            <td class="text-right">
												<button class="btn btn-sm btnBuyOne" data-toggle="tooltip" title="Mua sản phẩm này" value="${item.id}">
													<i class="fa fa-usd"></i> 
												</button>
												<button class="btn btn-sm btnEdit" data-toggle="tooltip" title="Cập nhật" value="${item.id}">
													<i class="fa fa-edit"></i> 
												</button>
												<button class="btn btn-sm btnDelete" data-toggle="tooltip" title="Xóa khỏi giỏ hàng" value="${item.id}">
													<i class="fa fa-trash"></i> 
												</button>
											</td>
				                            
				                    	</tr>
			                        </c:forEach>
			                        <tr>
			                            <td></td>
			                            <td></td>
			                            <td></td>
			                            <td></td>
			                            <td>Tổng tiền :</td>
			                            <td class="text-right" id="subtotal"></td>
			                        </tr>
			                        <tr>
			                            <td></td>
			                            <td></td>
			                            <td></td>
			                            <td></td>
			                            <td>Tiền Ship :</td>
			                            <td class="text-right">20000 VND</td>
			                        </tr>
			                        <tr>
			                            <td></td>
			                            <td></td>
			                            <td></td>
			                            <td></td>
			                            <td><strong>Tổng cộng :</strong></td>
			                            <td class="text-right" id="total"><strong></strong></td>
			                        </tr>
			                    </tbody>
			                </table>
			            </div>
			        </div>
			        <div class="col mb-2">
						<div class="row">
							<div class="col-sm-12  col-md-6">
								<button class="btn btn-block btn-light" id="btnMuaSam">Tiếp tục mua sắm</button>
							</div>
							<div class="col-sm-12 col-md-6 text-right">
								<button class="btn btn-lg btn-block btn-success text-uppercase" id="btnThanhToan">Thanh toán</button>
							</div>
						</div>
					</div>
		        </div>
	    	</div>
	    </form>
	    
	</c:if>
	
</section>
    <script src="<c:url value = '/template/admin/plugins/jquery/jquery.min.js'/>"></script>
    <script>
			var table = document.getElementById("cartTable").getElementsByTagName("td");
			var sum = 0;
			for (var i = 0; i < table.length; i++){
				if(table[i].className == "text-right eachproduct"){
					sum += isNaN(table[i].innerHTML) ? 0 : parseInt(table[i].innerHTML);
				}
			}
			document.getElementById("subtotal").innerHTML = sum + " VND";
			document.getElementById("total").innerHTML = sum + 20000 + " VND";
		
		$('#btnMuaSam').click(function(e) {
			e.preventDefault();
			window.location.href="${ShopURL}?maDanhMuc=0";
		});
		
		$(".btnEdit").click(function(e) {
			e.preventDefault();
			var currentRow=$(this).closest("tr");
			var soLuong = currentRow.find("td:eq(3) input").attr("max") * "1";
			var soLuongMua = currentRow.find("td:eq(3) input").val() * "1";
			if (soLuongMua > soLuong) {
				alert("Số lượng sách chỉ còn " + soLuong);
			} else {
				var data = {};
				data['id'] = $(this).prop("value");
				data['soLuongMua'] = soLuongMua;
				data['maSach'] = currentRow.find("td:eq(1) input").val();
				$.ajax({
					url : '${APIurl}',
					type : 'PUT',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						window.location.href = "${CartURL}?page=1&maxPageItem=5&sortName=id&sortBy=asc";
					},
					error : function(error) {
						console.log(error);
					}
				});
			}
		});

		$(".btnDelete").click(function(e) {
			e.preventDefault();
			var id = $(this).prop("value");
			var data = {};
			data['ids'] = [$(this).prop("value")];
			$.ajax({
				url : '${APIurl}',
				type : 'DELETE',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${CartURL}?page=1&maxPageItem=5&sortName=id&sortBy=asc";
				},
				error : function(error) {
					console.log(error);
				}
			});
		});
		
		
		
		$(".btnBuyOne").click(function(e) {
			e.preventDefault();
			var id = $(this).prop("value");
			var data = {};
			data['ids'] = [$(this).prop("value")];
			$.ajax({
				url : '${APIurl}',
				type : 'DELETE',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${CartURL}?page=1&maxPageItem=5&sortName=id&sortBy=asc";
				},
				error : function(error) {
					console.log(error);
				}
			});
		});
		
		$('#btnThanhToan').click(function(e) {
			e.preventDefault();
			var data = new Array();
            $("#cartTable TBODY TR").each(function () {
                var row = $(this);
                var item = {};
				item.maSach = row.find("TD").eq(1).find("input").val();
				if(item.maSach === undefined) return false;
				item.soLuong = row.find("TD").eq(3).find("input").val();
                data.push(item);
			});
            $.ajax({
                url: '${APIThanhToanurl}',
                type: 'POST',
				data: JSON.stringify({'cthds':data}),
                contentType: "application/json",
				dataType: "json",
                success : function(result) {
					window.location.href = "${CartURL}?&page=1&maxPageItem=5&sortName=id&sortBy=asc";
				},
				error : function(error) {
					console.log(error);
				}
            });
		});
    </script>
</body>
</html>