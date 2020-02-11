<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<title>Quản lý</title>

<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="<c:url value = '/template/admin/plugins/fontawesome-free/css/all.min.css'/>">
<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value = '/template/admin/dist/css/adminlte.min.css'/>">
<%-- <link rel="stylesheet"
	href="<c:url value = '/template/admin/plugins/datables-bs4/css/dataTables.bootstrap4.min.css'/>"> --%>
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet" />
	<!-- jQuery -->
	<script
		src="<c:url value = '/template/admin/plugins/jquery/jquery.min.js'/>"></script>
<script src="<c:url value='/template/paging/jquery.twbsPagination.js'/>"></script>
<script	src="<c:url value = '/template/admin/js/fstdropdown.js'/>"></script>
<link rel="stylesheet" href="<c:url value = '/template/admin/css/fstdropdown.css'/>">
</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<!-- header -->
		<%@include file="/common/admin/header.jsp"%>
		<%@include file="/common/admin/menu.jsp"%>
		<!-- header -->

		<dec:body />

		<!-- footer -->
		<%@include file="/common/admin/footer.jsp"%>
		<!-- footer -->
	</div>


	
	<!-- Bootstrap 4 -->
	<script
		src="<c:url value = '/template/admin/plugins/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
	<!-- AdminLTE App -->
	<script
		src="<c:url value = '/template/admin/dist/js/adminlte.min.js'/>"></script>
</body>
</html>