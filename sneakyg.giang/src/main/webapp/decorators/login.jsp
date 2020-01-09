<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="theme-color" content="#03a6f3">
<title>Book Store</title>
<link rel="stylesheet" href="<c:url value='/template/web/css/bootstrap.min.css'/>">
<link href="https://fonts.googleapis.com/css?family=Montserrat:200,300,400,500,600,700,800,900" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="<c:url value='/template/web/css/owl.carousel.min.css'/>">
<link rel="stylesheet" href="<c:url value='/template/web/css/styles.css'/>">
</head>
<body>
	<!-- header -->
		<%@include file="/common/web/header.jsp" %>
		<%@include file="/common/web/menu.jsp" %>
	<!-- header -->
	
	<dec:body/>
	
	<!-- footer -->
		<%@include file="/common/web/footer.jsp" %>
	<!-- footer -->
	<script src="<c:url value='/template/web/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/template/web/js/bootstrap.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/template/web/js/owl.carousel.min.js'/>"></script>
    <script src="<c:url value='/template/web/js/custom.js'/>"></script>
</body>
</html>