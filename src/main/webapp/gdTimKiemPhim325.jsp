<%@page import="model.Phim325"%>
<%@page import="java.util.List"%>
<%@page import="dao.Phim325DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tìm kiếm phim</title>
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
	<div class="row">
		<div class="col-1"></div>
		<div class="col-10">
			<br>
			<form method="post">
				<div class="row">
					<div class="col-10">
						<input class="form-control" type="search" placeholder="Tìm theo tên phim"
							name="word" aria-label="Search"
						>
					</div>
					<div class="col-2">
						<button class="btn btn-outline-success form-control" type="submit"
							name="search"
						>Tìm kiếm</button>
					</div>
				</div>
			</form>
			<br>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Tên phim</th>
						<th scope="col">Thể loại</th>
						<th scope="col">Đạp diễn</th>
						<th scope="col">Thời lượng</th>
						<th scope="col"><center>Chi tiết</center></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<%
						Phim325DAO phim325dao = new Phim325DAO();
						List<Phim325> phim325s = phim325dao.timPhim(request.getParameter("keyword"));
						for (Phim325 x : phim325s) {
						%>
					
					<tr>
						<th scope="row"><%=x.getId()%></th>
						<td><%=x.getTen()%></td>
						<td><%=x.getTheloai()%></td>
						<td><%=x.getDaodien()%></td>
						<td><%=x.getThoiluong()%></td>
						<td><a href="gdChiTietPhim325.jsp?id=<%=x.getId()%>"
							class="btn btn-outline-secondary form-control"
						>Xem chi tiết</a></td>
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
	<%
	String keyword = request.getParameter("word");
	if (request.getMethod().equals("POST") && request.getParameter("search") != null ) {
		System.out.println(keyword);
		response.sendRedirect("gdTimKiemPhim325.jsp?keyword=" + keyword);
	}
	%>
</body>
</html>