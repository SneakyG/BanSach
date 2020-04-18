<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
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
                            <span class="price final">${model.donGia} VNĐ</span>
                        </li>
                    </ul>
                    <div class="btn-sec">
                        <button class="btn ">Thêm vào giỏ hàng</button>
                        <button class="btn black">Mua ngay</button>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>