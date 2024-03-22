<%@page import="dao.Phim325DAO"%>
<%@page import="model.Phim325"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm phim mới</title>
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
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a href="gdChinh325.jsp" class="navbar-brand" href="#">Cineman</a>
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
			<br>
			<div class="card">
				<div class="card-body">
					<form method="post">
						<div class="form-group">
							<label><strong>Tên phim</strong></label> <input type="text"
								class="form-control" id="tenphim" placeholder="Nhập tên phim" name="tenphim" required="required"
							> <label><strong>Thể lọai</strong></label> <input type="text"
								class="form-control" id="theloai" placeholder="Nhập thể loại" name="theloai" required="required"
							> <label><strong>Đạo diễn</strong></label> <input type="text"
								class="form-control" id="daodien" placeholder="Nhập tên đạo diễn" name="daodien" required="required"
							> <label><strong>Thời lượng</strong></label> <input type="text"
								class="form-control" id="thoiluong" placeholder="Thời lượng" name="thoiluong" required="required"
							> <label><strong>Mô tả</strong></label>
							<textarea class="form-control" id="mota" placeholder="Mô tả" name="mota" rows="8" required="required"></textarea>
						</div>
						<button type="submit" class="btn btn-primary form-control" name="nextButton">Thêm phim mới</button>
						<br><br>
						<a href="gdThemPhimChieuLichChieu325.jsp" class="btn btn-secondary form-control">Quay lại</a>
					</form>
				</div>
			</div>
		</div>
		<div class="col-3"></div>
	</div>
	<%
	Phim325DAO phim325dao = new Phim325DAO();
	Phim325 phim325 = new Phim325();
	phim325.setTen(request.getParameter("tenphim"));
	phim325.setTheloai(request.getParameter("theloai"));
	phim325.setDaodien(request.getParameter("daodien"));
	phim325.setThoiluong(request.getParameter("thoiluong"));
	phim325.setMota(request.getParameter("mota"));
	phim325.setDangchieu(true);
	if (request.getMethod().equals("POST") && request.getParameter("nextButton") != null) {
		phim325dao.insertPhim(phim325);
		phim325.setMota(request.getParameter("mota"));
		response.sendRedirect("gdThemPhimChieuLichChieu325.jsp");
	}
	
	%>

</body>
</html>