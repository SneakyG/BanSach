<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<c:url var="LISTurl" value="/shop" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cửa hàng</title>
</head>
<body>
	<div class="breadcrumb">
        <div class="container">
            <a class="breadcrumb-item" href='<c:url value = "/trang-chu"/>'>Trang chủ</a>
            <span class="breadcrumb-item active">Cửa hàng</span>
        </div>
    </div>
    <section class="static about-sec">
    <form action="${LISTurl}" name="formSubmit" id="formSubmit"  method="get">
    	<div class="container">
        	<div>
				<label>Loại sách:&nbsp&nbsp&nbsp&nbsp&nbsp</label>
				<select id="maDanhMuc" name="maDanhMuc">
					<option value="0" class="form-control" >Tất cả</option>
					<c:forEach var="item" items="${model.dsTenDanhMuc}">
						<option value="${item.id}" class="form-control" id="itemSelect">${item.tenDanhMuc}</option>
					</c:forEach>
				</select>
			</div>
            <div class="recent-book-sec">
                <div class="row">
                	<c:forEach var="item" items="${model.listResult}">
	                    <div class="col-md-3">
	                        <div class="item">
	                        		<a href="<c:url value ='/shop?id=${item.id}'/>"><img src="${item.hinhAnh}" alt="img" width="180" height="250" ></a>
	                        		
		                            <h3 class="short-text">
		                            	<a href="<c:url value ='/shop?id=${item.id}'/>">${item.tenSach}</a>
		                            </h3>
		                            <h6><span class="price">${item.donGia}</span> / <a href="<c:url value ='/shop?id=${item.id}'/>">Mua ngay</a></h6>
	                        	
	                        </div>
	                    </div>
                    </c:forEach>
                </div>
                <!-- <div class="btn-sec">
                    <button class="btn gray-btn">load More books</button>
                </div> -->
            </div>
        </div>
    </form>
    </section>
    
    <script src="<c:url value = '/template/admin/plugins/jquery/jquery.min.js'/>"></script>
	<script type="text/javascript">
		var index = ${model.maDanhMuc};
		$('#maDanhMuc option')[index].selected = true;
	    $("#maDanhMuc").on('change',function(){
			$("#formSubmit").submit();
		});
    </script>
</body>
</html>