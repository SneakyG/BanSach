<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Thông tin cá nhân</title>
</head>

<body>
	<div class="content-wrapper" style="min-height: 1200.88px;">
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>Thông tin cá nhân</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Thông tin cá nhân</li>
						</ol>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->
		</section>
		<section class="content">
			<div class="row">
				<div class="col-4" align="center">
					<div class="card">
						<div class="card-body">
							<div class="form-group">
								<label>Họ tên</label> 
								<input type="text" class="form-control" id="ten" name="ten" disabled="disabled" value="${model.ten}">
								<label>Email</label> 
								<input type="text" class="form-control"	id="email" name="email" disabled="disabled"
									value="${model.email}"> 
								<label>Số điện thoại</label>
								<input type="text" class="form-control" id="sdt" name="sdt"
									disabled="disabled" value="${model.sdt}"> 
								<label>Chứng minh nhân dân</label> <input type="text" class="form-control" id="cmnd"
									name="cmnd" disabled="disabled" value="${model.cmnd}">
								<label>Địa chỉ</label> 
								<input type="text" class="form-control"	id="diaChi" name="diaChi" disabled="disabled"
									value="${model.diaChi}"> 
								<label>Ngày sinh</label> 
								<input type="text" class="form-control" id="ngaySinh" name="ngaySinh"
									disabled="disabled" value="${model.ngaySinh}"> 
								<label>Ngày vào làm</label> 
								<input type="text" class="form-control" id="ngaySinh" name="ngaySinh"
									disabled="disabled" value="${model.ngayVL}"> 
								<label>Lương</label>
								<input type="text" class="form-control" id="luong" name="luong"
									disabled="disabled" value="${model.luong}">
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>

</html>