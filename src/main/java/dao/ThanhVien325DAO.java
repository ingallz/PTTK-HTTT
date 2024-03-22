package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.ThanhVien325;

public class ThanhVien325DAO extends DAO325 {

	private static final String INSERT_THANHVIEN_SQL = "INSERT INTO thanhvien325 (hoten, sodienthoai, ngaysinh, diachi) VALUES (?, ?, ?, ?)";
	private static final String SELECT_THANHVIEN_BY_ID = "SELECT id, hoten, sodienthoai, ngaysinh, diachi FROM thanhvien325 WHERE id = ?";
	private static final String SELECT_ALL_THANHVIEN = "SELECT * FROM thanhvien325";
	private static final String DELETE_THANHVIEN_SQL = "DELETE FROM thanhvien325 WHERE id = ?";
	private static final String UPDATE_THANHVIEN_SQL = "UPDATE thanhvien325 SET hoten = ?, sodienthoai = ?, ngaysinh = ?, diachi = ? WHERE id = ?";

	public ThanhVien325DAO() {
	}

	public ThanhVien325 insertThanhVien(ThanhVien325 thanhVien) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_THANHVIEN_SQL,
						Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1, thanhVien.getHoten());
			preparedStatement.setString(2, thanhVien.getSodienthoai());
			preparedStatement.setObject(3, thanhVien.getNgaysinh());
			preparedStatement.setString(4, thanhVien.getDiachi());
			int affectedRows = preparedStatement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Inserting thành viên failed, no rows affected.");
			}

			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					int id = generatedKeys.getInt(1);
					thanhVien.setId(id);
				} else {
					throw new SQLException("Inserting thành viên failed, no ID obtained.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Xử lý lỗi hoặc ném nó ra để xử lý ở lớp gọi hàm
			throw e;
		}

		return thanhVien;
	}

	public ThanhVien325 selectThanhVien(int id) {
		ThanhVien325 thanhVien = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_THANHVIEN_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String hoten = rs.getString("hoten");
				String sodienthoai = rs.getString("sodienthoai");
				LocalDate ngaysinh = rs.getObject("ngaysinh", LocalDate.class);
				String diachi = rs.getString("diachi");
				thanhVien = new ThanhVien325(id, hoten, sodienthoai, ngaysinh, diachi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thanhVien;
	}

	public List<ThanhVien325> selectAllThanhVien() {
		List<ThanhVien325> thanhViens = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_THANHVIEN)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String hoten = rs.getString("hoten");
				String sodienthoai = rs.getString("sodienthoai");
				LocalDate ngaysinh = rs.getObject("ngaysinh", LocalDate.class);
				String diachi = rs.getString("diachi");
				thanhViens.add(new ThanhVien325(id, hoten, sodienthoai, ngaysinh, diachi));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thanhViens;
	}

	public boolean deleteThanhVien(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_THANHVIEN_SQL)) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateThanhVien(ThanhVien325 thanhVien) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_THANHVIEN_SQL)) {
			statement.setString(1, thanhVien.getHoten());
			statement.setString(2, thanhVien.getSodienthoai());
			statement.setObject(3, thanhVien.getNgaysinh());
			statement.setString(4, thanhVien.getDiachi());
			statement.setInt(5, thanhVien.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
