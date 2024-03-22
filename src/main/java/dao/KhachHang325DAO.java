package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.KhachHang325;

public class KhachHang325DAO extends DAO325 {

	private static final String INSERT_KHACHHANG_SQL = "INSERT INTO khachhang325 (id, thanhvien, thethanhvien) VALUES (?, ?, ?)";
	private static final String SELECT_KHACHHANG_BY_ID = "SELECT id, thanhvien, thethanhvien FROM khachhang325 WHERE id = ?";
	private static final String SELECT_ALL_KHACHHANG = "SELECT * FROM khachhang325";
	private static final String DELETE_KHACHHANG_SQL = "DELETE FROM khachhang325 WHERE id = ?";
	private static final String UPDATE_KHACHHANG_SQL = "UPDATE khachhang325 SET thanhvien = ?, thethanhvien = ? WHERE id = ?";

	public KhachHang325DAO() {
	}

	public void insertKhachHang(KhachHang325 khachHang) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_KHACHHANG_SQL)) {
			preparedStatement.setInt(1, khachHang.getId());
			preparedStatement.setInt(2, khachHang.getThanhvien());
			preparedStatement.setString(3, khachHang.getThethanhvien());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public KhachHang325 selectKhachHang(int id) {
		KhachHang325 khachHang = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_KHACHHANG_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int thanhvien = rs.getInt("thanhvien");
				String thethanhvien = rs.getString("thethanhvien");
				khachHang = new KhachHang325(id, thanhvien, thethanhvien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return khachHang;
	}

	public List<KhachHang325> selectAllKhachHang() {
		List<KhachHang325> khachHangs = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_KHACHHANG)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int thanhvien = rs.getInt("thanhvien");
				String thethanhvien = rs.getString("thethanhvien");
				khachHangs.add(new KhachHang325(id, thanhvien, thethanhvien));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return khachHangs;
	}

	public boolean deleteKhachHang(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_KHACHHANG_SQL)) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateKhachHang(KhachHang325 khachHang) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_KHACHHANG_SQL)) {
			statement.setInt(1, khachHang.getThanhvien());
			statement.setString(2, khachHang.getThethanhvien());
			statement.setInt(3, khachHang.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
