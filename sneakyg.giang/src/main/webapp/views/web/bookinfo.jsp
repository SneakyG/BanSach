<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<c:url var="APIurl" value="/api-giohang" />
<c:url var="GETurl" value="/shop" />
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
            <a class="breadcrumb-item" href='<c:url value = "/shop"/>'>Cửa hàng</a>
            <span class="breadcrumb-item active">${model.tenSach}</span>
        </div>
    </div>
    <section class="product-sec">
        <form name="formSubmit" id="formSubmit">
            <div class="container">
                <h1>${model.tenSach}</h1>
                <div class="row">
                    <div class="col-md-6 slider-sec">
                        <!-- main slider carousel -->
                        <div id="myCarousel" class="carousel slide">
                            <!-- main slider carousel items -->
                            <div class="carousel-inner">
                                <div class="active item carousel-item" data-slide-number="0">
                                    <img src="${model.hinhAnh}" class="img-fluid">
                                </div>
                                <div class="item carousel-item" data-slide-number="1">
                                    <img src="${model.hinhAnh}" class="img-fluid">
                                </div>
                                <div class="item carousel-item" data-slide-number="2">
                                    <img src="${model.hinhAnh}" class="img-fluid">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 slider-content">
                        <p>${model.moTaNgan}</p>
                        <ul>
                            <li>
                                <span class="name">Đơn giá</span><span class="clm">:</span>
                               	<span class="price final">
                                	<fmt:setLocale value="vi_VN"/>
                                	<fmt:formatNumber value = "${model.donGia}" type = "currency"/>
                                </span>
                                	
                            </li>
                        </ul>
                        <ul>
                            <li>
                                <span class="name">Số lượng còn</span><span class="clm">:</span>
                                <span class="price final" style="color:black">${model.soLuong}</span>
                            </li>
                        </ul>
                        <ul>
                            <li>
                                <span class="name">Số lượng</span><span class="clm">:</span>
                                <input type="number" class="form-control"  min = "1" max="${model.soLuong}" value="1" name="soLuongMua" id="soLuongMua">
                            </li>
                        </ul>
                        <div class="btn-sec">
                            <button class="btn" id="btnThemGioHang">Thêm vào giỏ hàng</button>
                            <button class="btn black">Mua ngay</button>
                        </div>
                        <input type="hidden" value="${model.id}" id="maSach" name="maSach" />
                    </div>
                </div>
            </div>
        </form>
        <input type="hidden" value="${TAIKHOAN}" id="user" name="user" />
    </section>
    <script
		src="<c:url value = '/template/admin/plugins/jquery/jquery.min.js'/>"></script>
    <script type="text/javascript">
        
		$(document).ready(function() {
			$('#btnThemGioHang').click(function(e) {
                e.preventDefault();
                var user = $('#user').val();
                if(user != ""){
                	var soLuong = $('#soLuongMua').val() * "1";
                    var soLuongCon = $('#soLuongMua').attr('max') * "1";
                    if(soLuongCon === 0){
                        alert("Đã hết hàng mong quý khách quay lại sau");
                    }else if(soLuong < 1 || Number.isInteger(soLuong) === false){
                        alert("Số lượng không phù hợp");
                    }else if(soLuong > soLuongCon){
                        alert("Số lượng vượt quá số lượng còn");
                    }else{
                        var data = {};
                        var formData = $('#formSubmit').serializeArray();
                        $.each(formData, function(i, v) {
                            data["" + v.name + ""] = v.value;
                        });
                        createGioHang(data);
                    }
                }else{
                	alert("Hãy đăng nhập");
                }
            });
            
			function createGioHang(data) {
                var maSach = $('#maSach').val();
				$.ajax({
					url : '${APIurl}',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						location.reload(true);
					},
					error : function(error) {
						console.log(error);
					}
				});
                alert("Thêm vào giỏ hàng thành công!");
			}
		});
	</script>
</body>
</html>