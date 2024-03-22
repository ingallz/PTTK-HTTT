<%@page import="dao.TaiKhoan325DAO"%>
<%@page import="model.TaiKhoan325"%>
<%@page import="dao.ThanhVien325DAO"%>
<%@page import="model.ThanhVien325"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous"
>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"
></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"
></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"
></script>
<style type="text/css">
.left-align-form {
	text-align: left;
}
</style>
<meta charset="UTF-8">
<title>Đăng kí</title>
<script type="text/javascript">
	function showAlert() {
		alert("Passwords do not match. Please enter the same password in both fields.");
	}

	function checkPasswords() {
		var password1 = document.getElementById("password1").value;
		var password2 = document.getElementById("password2").value;

		if (password1 !== password2) {
			alert("Mật khẩu không giống nhau.");
			return false; // Prevent form submission
		}

		return true; // Allow form submission
	}
</script>
</head>
<body>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="card">
			<div class="card-body">
				<form class="left-align-form" method="post"
					onsubmit="return checkPasswords();"
				>
					<div class="form-group">
						<label for="exampleInputEmail1"><strong>Email</strong></label> <input
							type="email" class="form-control" id="exampleInputEmail1" name="email"
							aria-describedby="emailHelp" placeholder="Nhập email" required
						>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1"><strong>Họ tên</strong></label> <input
							type="text" class="form-control" id="name" name="name"
							placeholder="Nhập họ tên" required
						>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1"><strong>Mật khẩu</strong></label> <input
							type="password" class="form-control" id="password1" name="password1"
							placeholder="Nhập mật khẩu" required
						>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1"><strong>Nhập lại mật
								khẩu</strong></label> <input type="password" class="form-control" name="password2"
							id="password2" placeholder="Nhập lại mật khẩu" required
						>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1"><strong>Số điện thoại</strong></label>
						<input type="text" class="form-control" id="phonenumber"
							name="phonenumber" placeholder="Số điện thoại" required
						>
						<div class="form-group">
							<label for="exampleInputPassword1"><strong>Địa chỉ</strong></label> <input
								type="text" class="form-control" id="phonenumber" name="address"
								placeholder="Địa chỉ" required
							>
						</div>
						<br> <br>
						<button type="submit" class="btn btn-primary form-control" name="register">Đăng
							kí</button>
						<br> <br>
				</form>
				<a href="gdDangNhap325.jsp" class="btn btn-secondary form-control">Đăng
					nhập</a>
			</div>
		</div>
	</div>
	<%
	if (request.getMethod().equals("POST") && request.getParameter("register") != null) {
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password1 = request.getParameter("password1");
		String phonenumber = request.getParameter("phonenumber");
		String address = request.getParameter("address");
		ThanhVien325 thanhVien325 = new ThanhVien325();
		thanhVien325.setHoten(name);
		thanhVien325.setDiachi(address);
		thanhVien325.setSodienthoai(phonenumber);
		ThanhVien325DAO thanhVien325DAO = new ThanhVien325DAO();
		thanhVien325 = thanhVien325DAO.insertThanhVien(thanhVien325);
		TaiKhoan325 taiKhoan325 = new TaiKhoan325(email, "", password1, thanhVien325.getId());
		TaiKhoan325DAO taiKhoan325DAO = new TaiKhoan325DAO();
		taiKhoan325DAO.insertTaiKhoan(taiKhoan325);
		response.sendRedirect("gdDangNhap325.jsp");
	}
	%>
</body>
</html>