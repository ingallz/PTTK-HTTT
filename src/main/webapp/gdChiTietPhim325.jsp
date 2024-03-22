<%@page import="dao.Phim325DAO"%>
<%@page import="model.Phim325"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết phim</title>
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
		String id = request.getParameter("id");
		Phim325DAO phim325dao = new Phim325DAO();
		Phim325 phim325 = phim325dao.selectPhim(Integer.valueOf(id));
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
	<div class="row">
		<div class="col-3"></div>
		<div class="col-6">
			<br>
			<div class="card">
				<div class="card-body">
					<form>
						<div class="form-group">
							<label><strong>Tên phim</strong></label> <input type="text" value="<%=phim325.getId() %>"
								class="form-control" id="tenphim" disabled="disabled"
							> <label><strong>Thể lọai</strong></label> <input type="text" value="<%= phim325.getTheloai() %>"
								class="form-control" id="theloai" disabled="disabled"
							> <label><strong>Đạo diễn</strong></label> <input type="text" value="<%= phim325.getDaodien() %>"
								class="form-control" id="daodien" disabled="disabled"
							> <label><strong>Thời lượng</strong></label> <input type="text" value="<%=phim325.getThoiluong() %>"
								class="form-control" id="thoiluong" disabled="disabled"
							> <label><strong>Mô tả</strong></label>
							<textarea class="form-control" id="mota" rows="8" disabled="disabled"><%= phim325.getMota() %></textarea>
						</div>
						<br>
						<br> <a href="gdTimKiemPhim325.jsp"
							class="btn btn-secondary form-control"
						>Quay lại</a>
					</form>
				</div>
			</div>
		</div>
		<div class="col-3"></div>
	</div>

</body>
</html>