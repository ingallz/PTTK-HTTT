<%@page import="dao.Phim325DAO"%>
<%@page import="model.Phim325"%>
<%@page import="model.LichChieu325"%>
<%@page import="java.util.List"%>
<%@page import="dao.LichChieu325DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lí lịch chiếu</title>
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
		<a href="gdChinh325.jsp" class="navbar-brand" href="#">Cineman</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
			aria-expanded="false" aria-label="Toggle navigation"
		>
			<span class="navbar-toggler-icon"></span>
		</button>

	</nav>
	<%
	if (session.getAttribute("flag") != null) {
	%>
	<script type="text/javascript">alert("Thêm lịch chiếu thành công")</script>
	<%
	session.removeAttribute("flag");
	}
	%>
	<div class="row">
		<div class="col-1"></div>
		<div class="col-10">
			<br> <br> <br> <a href="gdThemGioChieuLichChieu325.jsp"
				class="btn btn-outline-success form-control" type="submit"
			>Thêm lịch chiếu</a> <br> <br>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Phim</th>
						<th scope="col">Phòng</th>
						<th scope="col">Thời gian bắt đầu</th>
						<th scope="col">Thời gian kết thức</th>
					</tr>
				</thead>
				<tbody>
					<%
					LichChieu325DAO lichChieu325DAO = new LichChieu325DAO();
					Phim325DAO phim325dao = new Phim325DAO();
					List<LichChieu325> lichChieu325s = lichChieu325DAO.selectAllLichChieu();
					for (LichChieu325 x : lichChieu325s) {
						Phim325 phim325 = phim325dao.selectPhim(x.getPhim());
					%>
					<tr>
						<th scope="row"><%=x.getId()%></th>
						<td><%=phim325.getTen()%></td>
						<td><%=x.getPhong()%></td>
						<td><%=x.getThoigianbatdau()%></td>
						<td><%=x.getThoigianketthuc()%></td>
					</tr>

					<%
					}
					%>

				</tbody>
			</table>
			<a href="gdChinh325.jsp" class="btn btn-outline-secondary form-control">Quay
				lại</a>
		</div>
		<div class="col-1"></div>
	</div>

</body>
</html>