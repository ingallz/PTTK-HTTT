<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chọn giờ chiếu</title>
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
ul.list-group {
	max-height: 200px; /* Giới hạn chiều cao của danh sách */
	overflow-y: auto;
	/* Thêm thanh cuộn dọc nếu danh sách vượt quá kích thước quy định */
}
</style>
</head>
<body>
	<%
	// Lấy giá trị từ session (nếu có)
	String ngayChieu = (String) session.getAttribute("ngayChieu");
	String gioBatDau = (String) session.getAttribute("gioBatDau");
	String gioKetThuc = (String) session.getAttribute("gioKetThuc");

	// Kiểm tra xem giá trị từ session có tồn tại hay không
	if (ngayChieu == null) {
		ngayChieu = "";
	}
	if (gioBatDau == null) {
		gioBatDau = "";
	}
	if (gioKetThuc == null) {
		gioKetThuc = "";
	}
	%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a href="gdChinh325.jsp" class="navbar-brand" href="#">Cineman</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
			aria-expanded="false" aria-label="Toggle navigation"
		>
			<span class="navbar-toggler-icon"></span>
		</button>

	</nav>
	<br>
	<br>
	<div class="row">
		<div class="col-3"></div>
		<div class="col-6">
			<br>
			<div class="card">
				<div class="card-body">
					<form method="post">
						<div class="form-group">
							<label for="inputDate">Ngày chiếu</label> <input type="date"
								class="form-control" id="inputDate"  name="inputDate" value="<%=ngayChieu%>" required="required"
							>
						</div>
						<label for="inputTime1">Giờ bắt đầu</label> <input type="time"
							class="form-control" id="inputTime1" name="inputTime1" value="<%=gioBatDau%>" required="required"
						> <label for="inputTime2">Giờ kết thúc</label> <input type="time"
							class="form-control" id="inputTime2" name="inputTime2" value="<%=gioKetThuc%>" required="required"
						> <br> <br> <br> <br>
						<div class="row">
							<div class="col-6">
								<a href="gdQuanLiLichChieu325.jsp"
									class="btn btn-outline-secondary form-control"
									name="returnButton"
								>Quay lại</a>
							</div>
							<div class="col-6">
								<button type="submit"
									class="btn btn-outline-success form-control"
									name="nextButton"
								>Tiếp theo</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-3"></div>
	</div>
	<%
	if (request.getMethod().equals("POST") && request.getParameter("nextButton") != null) {
		// Lưu giá trị vào sessionx
		session.setAttribute("ngayChieu", request.getParameter("inputDate"));
		session.setAttribute("gioBatDau", request.getParameter("inputTime1"));
		session.setAttribute("gioKetThuc", request.getParameter("inputTime2"));
		response.sendRedirect("gdThemPhongChieuLichChieu325.jsp");
	}
	%>
</body>
</html>