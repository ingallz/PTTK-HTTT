package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Ve325;

public class Ve325DAO extends DAO325 {

	private static final String INSERT_VE_SQL = "INSERT INTO ve325 (id, lichchieu, ghe, giave, hoadon, khachhang, phim) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_VE_BY_ID = "SELECT id, lichchieu, ghe, giave, hoadon, khachhang, phim FROM ve325 WHERE id = ?";
	private static final String SELECT_ALL_VE = "SELECT * FROM ve325";
	private static final String DELETE_VE_SQL = "DELETE FROM ve325 WHERE id = ?";
	private static final String UPDATE_VE_SQL = "UPDATE ve325 SET lichchieu = ?, ghe = ?, giave = ?, hoadon = ?, khachhang = ?, phim = ? WHERE id = ?";

	public Ve325DAO() {
	}

	public void insertVe(Ve325 ve) {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VE_SQL)) {
			preparedStatement.setInt(1, ve.getId());
			preparedStatement.setInt(2, ve.getLichchieu());
			preparedStatement.setString(3, ve.getGhe());
			preparedStatement.setInt(4, ve.getGiave());
			preparedStatement.setInt(5, ve.getHoadon());
			preparedStatement.setInt(6, ve.getKhachhang());
			preparedStatement.setInt(7, ve.getPhim());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Ve325 selectVe(int id) {
		Ve325 ve = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VE_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int lichchieu = rs.getInt("lichchieu");
				String ghe = rs.getString("ghe");
				int giave = rs.getInt("giave");
				int hoadon = rs.getInt("hoadon");
				int khachhang = rs.getInt("khachhang");
				int phim = rs.getInt("phim");
				ve = new Ve325(id, lichchieu, ghe, giave, hoadon, khachhang, phim);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ve;
	}

	public List<Ve325> selectAllVe() {
		List<Ve325> ves = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_VE)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int lichchieu = rs.getInt("lichchieu");
				String ghe = rs.getString("ghe");
				int giave = rs.getInt("giave");
				int hoadon = rs.getInt("hoadon");
				int khachhang = rs.getInt("khachhang");
				int phim = rs.getInt("phim");
				ves.add(new Ve325(id, lichchieu, ghe, giave, hoadon, khachhang, phim));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ves;
	}

	public boolean deleteVe(int id) {
		boolean rowDeleted = false;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_VE_SQL)) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

	public boolean updateVe(Ve325 ve) {
		boolean rowUpdated = false;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_VE_SQL)) {
			statement.setInt(1, ve.getLichchieu());
			statement.setString(2, ve.getGhe());
			statement.setInt(3, ve.getGiave());
			statement.setInt(4, ve.getHoadon());
			statement.setInt(5, ve.getKhachhang());
			statement.setInt(6, ve.getPhim());
			statement.setInt(7, ve.getId());
			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}
}
