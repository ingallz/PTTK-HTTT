package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TaiKhoan325;

public class TaiKhoan325DAO extends DAO325 {

	private static final String INSERT_TAIKHOAN_SQL = "INSERT INTO taikhoan325 (email, username, password, thanhvien) VALUES (?, ?, ?, ?)";
	private static final String SELECT_TAIKHOAN_BY_EMAIL = "SELECT email, username, password, thanhvien FROM taikhoan325 WHERE email = ?";
	private static final String SELECT_ALL_TAIKHOAN = "SELECT * FROM taikhoan325";
	private static final String DELETE_TAIKHOAN_SQL = "DELETE FROM taikhoan325 WHERE email = ?";
	private static final String UPDATE_TAIKHOAN_SQL = "UPDATE taikhoan325 SET username = ?, password = ?, thanhvien = ? WHERE email = ?";

	public TaiKhoan325DAO() {
	}

	public void insertTaiKhoan(TaiKhoan325 taiKhoan) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TAIKHOAN_SQL)) {
			preparedStatement.setString(1, taiKhoan.getEmail());
			preparedStatement.setString(2, taiKhoan.getUsername());
			preparedStatement.setString(3, taiKhoan.getPassword());
			preparedStatement.setInt(4, taiKhoan.getThanhvien());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public TaiKhoan325 selectTaiKhoanByEmail(String email) {
		TaiKhoan325 taiKhoan = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TAIKHOAN_BY_EMAIL)) {
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				int thanhvien = rs.getInt("thanhvien");
				taiKhoan = new TaiKhoan325(email, username, password, thanhvien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taiKhoan;
	}

	public TaiKhoan325 dangnhap(String email, String password) {
		TaiKhoan325 taiKhoan = null;
		try {
			taiKhoan = selectTaiKhoanByEmail(email);
			if (taiKhoan.getPassword().equals(password)) {
				return taiKhoan;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TaiKhoan325> selectAllTaiKhoan() {
		List<TaiKhoan325> taiKhoans = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TAIKHOAN)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String email = rs.getString("email");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int thanhvien = rs.getInt("thanhvien");
				taiKhoans.add(new TaiKhoan325(email, username, password, thanhvien));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taiKhoans;
	}

	public boolean deleteTaiKhoan(String email) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_TAIKHOAN_SQL)) {
			statement.setString(1, email);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateTaiKhoan(TaiKhoan325 taiKhoan) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_TAIKHOAN_SQL)) {
			statement.setString(1, taiKhoan.getUsername());
			statement.setString(2, taiKhoan.getPassword());
			statement.setInt(3, taiKhoan.getThanhvien());
			statement.setString(4, taiKhoan.getEmail());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
