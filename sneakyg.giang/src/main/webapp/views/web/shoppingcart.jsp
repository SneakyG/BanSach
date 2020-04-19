<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<c:url var="ShopURL" value="/shop" />
<c:url var="CartURL" value="/cart" />
<c:url var="APIurl" value="/api-giohang" />
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
    <c:if test="${empty model.listResult}">
	    <section class="static about-sec">
	    	<div class="container" align="center">
	    		<h1><a href="${ShopURL}?maDanhMuc=0">Hãy đi mua sắm nào</a></h1>
	    	</div>
	    </section>
    </c:if>
    <c:if test="${not empty model.listResult}">
	    <section class="static about-sec">
	    <form action="${LISTurl}" name="formSubmit" id="formSubmit"  method="get">
	    	<div class="container">
	        	<div class="row">
			        <div class="col-12">
			            <div class="table-responsive">
			                <table class="table table-striped" id="cartTable">
			                    <thead>
			                        <tr>
			                            <th scope="col" width="10%"> </th>
			                            <th scope="col" width="30%">Sản phẩm</th>
			                            <th scope="col" width="20%" >Tên tác giả</th>
			                            <th scope="col" class="text-center" width="10%">Số lượng</th>
			                            <th scope="col" class="text-right" width="20%">Tổng giá(VND)</th>
			                            <th class="text-right" width="20%">Thao tác</th>
			                        </tr>
			                    </thead>
			                    <tbody>
			                        <!-- <tr>
			                            <td><img src="https://dummyimage.com/50x50/55595c/fff" /> </td>
			                            <td>Product Name Dada</td>
			                            <td>SneakyG</td>
			                            <td><input class="form-control" type="text" value="1" /></td>
			                            <td class="text-right">124,90 €</td>
			                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
			                        </tr>
			                        <tr>
			                            <td><img src="https://dummyimage.com/50x50/55595c/fff" /> </td>
			                            <td>Product Name Toto</td>
			                            <td>SneakyG</td>
			                            <td><input class="form-control" type="text" value="1" /></td>
			                            <td class="text-right">33,90 €</td>
			                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
			                        </tr>
			                        <tr>
			                            <td><img src="https://dummyimage.com/50x50/55595c/fff" /> </td>
			                            <td>Product Name Titi</td>
			                            <td>SneakyG</td>
			                            <td><input class="form-control" type="text" value="1" /></td>
			                            <td class="text-right">70,00 €</td>
			                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
			                        </tr> -->
			                        <c:forEach var="item" items="${model.listResult}">
			                        	<tr>	
			                        		<td><img src="${item.hinhAnh}"/> </td>
				                            <td>${item.tenSach}</td>
				                            <td>${item.tenTG}</td>
				                            <td>
				                            	<input class="form-control" type="number" value="${item.soLuong}" min="1" />
				                            </td>
				                            <td class="text-right eachproduct">${item.tongTien}</td>
				                            <td class="text-right"><button class="btn btn-sm btn-danger"  id="btnDelete" data-toggle="tooltip" name="btnDelete" title="Xóa khỏi giỏ hàng" value="${item.id}"><i class="fa fa-trash"></i> </button> </td>
				                            
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
			                    <button class="btn btn-lg btn-block btn-success text-uppercase">Thanh toán</button>
			                </div>
			            </div>
			        </div>
		        </div>
	    	</div>
	    </form>
	    </section>
    </c:if>
    
    <script src="<c:url value = '/template/admin/plugins/jquery/jquery.min.js'/>"></script>
    <script>
	    $(document).ready(function() {
			var table = document.getElementById("cartTable").getElementsByTagName("td");
			var sum = 0;
			for (var i = 0; i < table.length; i++){
				if(table[i].className == "text-right eachproduct"){
					sum += isNaN(table[i].innerHTML) ? 0 : parseInt(table[i].innerHTML);
				}
			}
			document.getElementById("subtotal").innerHTML = sum + " VND";
			document.getElementById("total").innerHTML = sum + 20000 + " VND";
		});
		
		$('#btnMuaSam').click(function(e) {
			e.preventDefault();
			window.location.href="${ShopURL}?maDanhMuc=0";
		});
		
		$("#btnDelete").click(function(e) {
			e.preventDefault();
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
    </script>
</body>
</html>