<%@page import="model.NhanVienQuanLi325"%>
<%@page import="dao.NhanVienQuanLi325DAO"%>
<%@page import="dao.NhanVien325DAO"%>
<%@page import="model.NhanVien325"%>
<%@page import="dao.ThanhVien325DAO"%>
<%@page import="model.ThanhVien325"%>
<%@page import="dao.TaiKhoan325DAO"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="dao.LichChieu325DAO"%>
<%@page import="model.LichChieu325"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xác nhận lịch chiếu</title>
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
	<br>
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
							<label><strong>Phim</strong></label> <input type="text"
								class="form-control" id="phim"
								value="<%=session.getAttribute("tenphim")%>" disabled
							> <label><strong>Ngày</strong></label> <input type="date"
								class="form-control" id="ngay"
								value="<%=session.getAttribute("ngayChieu")%>" disabled
							> <label><strong>Thời gian bắt đầu</strong></label> <input type="time"
								class="form-control" id="thoigianbatdau"
								value="<%=session.getAttribute("gioBatDau")%>" disabled
							> <label><strong>Thời gian kết thúc</strong></label> <input type="time"
								class="form-control" id="thoigianketthuc"
								value="<%=session.getAttribute("gioKetThuc")%>" disabled
							> <label><strong>Phòng chiếu</strong></label> <input type="text"
								class="form-control" id="phong"
								value="<%=session.getAttribute("phong")%>" disabled
							>
						</div>
						<div class="row">

							<div class="col-6">
								<a href="gdThemPhimChieuLichChieu325.jsp"
									class="btn btn-secondary form-control"
								>Quay lại</a>
							</div>
							<div class="col-6">
								<button type="submit" class="btn btn-primary form-control"
									name="nextButton"
								>Thêm lịch chiếu</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-3"></div>
	</div>
	<%
	LichChieu325 lichChieu325 = new LichChieu325();
	LichChieu325DAO lichChieu325DAO = new LichChieu325DAO();
	LocalDate startDate = LocalDate.parse((String) session.getAttribute("ngayChieu"));
	LocalTime startTime = LocalTime.parse((String) session.getAttribute("gioBatDau"));
	LocalTime endTime = LocalTime.parse((String) session.getAttribute("gioKetThuc"));
	LocalDateTime startDateTime = startDate.atTime(startTime);
	LocalDateTime endDateTime = startDate.atTime(endTime);
	System.out.println(session.getAttribute("userID"));

	if (request.getMethod().equals("POST") && request.getParameter("nextButton") != null) {
		if (session.getAttribute("userID") == null) {
			response.sendRedirect("gdDangNhap325.jsp");
		} else {
			try {
				int userID = (Integer) session.getAttribute("userID");
				NhanVien325DAO nhanVien325DAO = new NhanVien325DAO();
				NhanVienQuanLi325DAO nhanVienQuanLi325DAO = new NhanVienQuanLi325DAO();
				NhanVien325 nhanVien325 = nhanVien325DAO.selectNhanVienByThanhVien(userID);
				NhanVienQuanLi325 nhanVienQuanLi325 = nhanVienQuanLi325DAO.selectNhanVienById(nhanVien325.getId());
				lichChieu325.setPhim(Integer.valueOf((String) session.getAttribute("phim")));
				lichChieu325.setPhong((String) session.getAttribute("phong"));
				lichChieu325.setThoigianbatdau(startDateTime);
				lichChieu325.setThoigianketthuc(endDateTime);
				lichChieu325.setNhanvienquanli(nhanVienQuanLi325.getId());
				lichChieu325DAO.insertLichChieu(lichChieu325);
				session.setAttribute("flag", "true");
				response.sendRedirect("gdQuanLiLichChieu325.jsp");
			} catch (Exception e) {
				response.sendRedirect("gdDangNhap325.jsp");
			}
		}

	}
	%>

</body>
</html>