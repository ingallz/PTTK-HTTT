<%@page import="dao.TaiKhoan325DAO"%>
<%@page import="model.TaiKhoan325"%>
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
<title>Đăng nhập</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="card">
			<div class="card-body">
				<form class="left-align-form" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1"><strong>Email</strong></label> <input
							type="email" class="form-control" id="exampleInputEmail1" name="email"
							aria-describedby="emailHelp" placeholder="Nhập email" required
						>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1"><strong>Mật khẩu</strong></label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							name="password" placeholder="Nhập mật khẩu" required
						>
					</div>
					<br> <br>
					<button type="submit" class="btn btn-primary form-control" name="login">Đăng
						nhập</button>
					<br> <br>
				</form>
				<a href="gdDangKi325.jsp" type="submit"
					class="btn btn-secondary form-control"
				>Đăng kí</a>
			</div>
		</div>
	</div>
	<%
	if (request.getMethod().equals("POST") && request.getParameter("login") != null) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		TaiKhoan325DAO taiKhoan325DAO = new TaiKhoan325DAO();
		TaiKhoan325 taiKhoan325 = taiKhoan325DAO.dangnhap(email, password);
		if (taiKhoan325 != null) {
			session.setAttribute("userID", taiKhoan325.getThanhvien());
			response.sendRedirect("gdChinh325.jsp");
		} else {
	%>
	<script type="text/javascript">
		alert("Sai tài khoản hoặc mật khẩu")
	</script>
	<%
	}
	}
	%>
</body>
</html>