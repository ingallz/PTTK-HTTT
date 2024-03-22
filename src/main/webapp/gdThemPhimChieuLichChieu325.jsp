
<%@page import="model.Phim325"%>
<%@page import="dao.Phim325DAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chọn phim</title>
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
	max-height: 300px; /* Giới hạn chiều cao của danh sách */
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
	<br>
	<br>
	<div class="row">
		<div class="col-3"></div>
		<div class="col-6">
			<br>
			<div class="card">
				<div class="card-body">
					<form method="post">
						<ul class="list-group list-group-flush">
							<%
							Phim325DAO phim325dao = new Phim325DAO();
							List<Phim325> phim325s = phim325dao.selectAllPhim();
							String phimdachon = (String) session.getAttribute("phim");
							for (Phim325 x : phim325s) {
								if (x.isDangchieu() == false) {
									continue;
								}
							%>
							<li class="list-group-item"><input type="radio" name="maphim"
								id="<%=x.getId()%>" value="<%=x.getId()%>"
								<%if (phimdachon != null && x.getId() == Integer.valueOf(phimdachon)) {%>
								checked="checked" <%}%>
							> <label for="<%=x.getId()%>"><%=x.getTen() + " - " + x.getDaodien()%></label></li>
							<%
							}
							%>

						</ul>
						<br> <br> <br> <br> <a href="gdThemPhim325.jsp"
							class="btn btn-outline-primary form-control"
						>Thêm Phim</a> <br> <br>
						<div class="row">
							<div class="col-6">
								<a href="gdThemPhongChieuLichChieu325.jsp"
									class="btn btn-outline-secondary form-control"
								>Quay lại</a>
							</div>
							<div class="col-6">
								<button type="submit" class="btn btn-outline-success form-control"
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
	String selectedPhim = (String) request.getParameter("maphim");

	if (request.getMethod().equals("POST") && request.getParameter("nextButton") != null && selectedPhim != null) {
		Phim325 phim325 = phim325dao.selectPhim(Integer.valueOf(selectedPhim));
		System.out.println(phim325.toString());
		session.setAttribute("tenphim", phim325.getTen());
		session.setAttribute("phim", selectedPhim);
		response.sendRedirect("gdThemLichChieu325.jsp");
	}
	%>
</body>
</html>