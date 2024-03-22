<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lí</title>
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
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Cineman</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
			aria-expanded="false" aria-label="Toggle navigation"
		>
			<span class="navbar-toggler-icon"></span>
		</button>

	</nav>
	<div class="row">
		<div class="col-3"></div>
		<div class="col-6">
			<br> <br> <br>
			<br> <br> <br>
			<br> <br> <br>
			<div class="card">
				<div class="card-body">
					<form method="post">
						<a href="gdTimKiemPhim325.jsp" type="button"
							class="btn btn-outline-success form-control"
						>Tìm kiếm phim theo tên</a> <br>
						<br> <a href="gdQuanLiLichChieu325.jsp" type="button"
							class="btn btn-outline-primary form-control"
						>Quản lí lịch chiếu</a> <br>
						<br>
						<button type="submit" class="btn btn-outline-danger form-control"
							name="logout"
						>Đăng xuất</button>
					</form>
				</div>
			</div>
		</div>
		<div class="col-3"></div>
	</div>
	<%
	if (request.getMethod().equals("POST") && request.getParameter("logout") != null) {
		session.invalidate();
		response.sendRedirect("gdDangNhap325.jsp");
	}
	%>

</body>
</html>