package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TheThanhVien325;

public class TheThanhVien325DAO extends DAO325 {

	private static final String INSERT_THANHVIEN_SQL = "INSERT INTO thethanhvien325 (loai, mota) VALUES (?, ?)";
	private static final String SELECT_THANHVIEN_BY_ID = "SELECT loai, mota FROM thethanhvien325 WHERE loai = ?";
	private static final String SELECT_ALL_THANHVIEN = "SELECT * FROM thethanhvien325";
	private static final String DELETE_THANHVIEN_SQL = "DELETE FROM thethanhvien325 WHERE loai = ?";
	private static final String UPDATE_THANHVIEN_SQL = "UPDATE thethanhvien325 SET mota = ? WHERE loai = ?";

	public TheThanhVien325DAO() {
	}

	public void insertThanhVien(TheThanhVien325 thanhVien) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_THANHVIEN_SQL)) {
			preparedStatement.setString(1, thanhVien.getLoai());
			preparedStatement.setString(2, thanhVien.getMota());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public TheThanhVien325 selectThanhVien(String loai) {
		TheThanhVien325 thanhVien = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_THANHVIEN_BY_ID)) {
			preparedStatement.setString(1, loai);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String mota = rs.getString("mota");
				thanhVien = new TheThanhVien325(loai, mota);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thanhVien;
	}

	public List<TheThanhVien325> selectAllThanhVien() {
		List<TheThanhVien325> thanhViens = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_THANHVIEN)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String loai = rs.getString("loai");
				String mota = rs.getString("mota");
				thanhViens.add(new TheThanhVien325(loai, mota));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thanhViens;
	}

	public boolean deleteThanhVien(String loai) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_THANHVIEN_SQL)) {
			statement.setString(1, loai);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateThanhVien(TheThanhVien325 thanhVien) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_THANHVIEN_SQL)) {
			statement.setString(1, thanhVien.getMota());
			statement.setString(2, thanhVien.getLoai());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
