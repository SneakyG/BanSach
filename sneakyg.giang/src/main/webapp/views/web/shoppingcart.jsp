<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
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
			                            	<input class="form-control" type="number" value="1" min />
			                            </td>
			                            <td class="text-right eachproduct">${item.tongTien}</td>
			                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
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
		                    <button class="btn btn-block btn-light">Tiếp tục mua sắm</button>
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
    </script>
</body>
</html>