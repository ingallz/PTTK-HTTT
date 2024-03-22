package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.HoaDon325;

public class HoaDon325DAO extends DAO325 {

	private static final String INSERT_HOA_DON_SQL = "INSERT INTO hoadon325 (id, khachhang, tongtien, nhanvienbanhang, thoigianxuat) VALUES (?, ?, ?, ?, ?)";
	private static final String SELECT_HOA_DON_BY_ID = "SELECT id, khachhang, tongtien, nhanvienbanhang, thoigianxuat FROM hoadon325 WHERE id = ?";
	private static final String SELECT_ALL_HOA_DON = "SELECT * FROM hoadon325";
	private static final String DELETE_HOA_DON_SQL = "DELETE FROM hoadon325 WHERE id = ?";
	private static final String UPDATE_HOA_DON_SQL = "UPDATE hoadon325 SET khachhang = ?, tongtien = ?, nhanvienbanhang = ?, thoigianxuat = ? WHERE id = ?";

	public HoaDon325DAO() {
	}

	public void insertHoaDon(HoaDon325 hoaDon) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HOA_DON_SQL)) {
			preparedStatement.setInt(1, hoaDon.getId());
			preparedStatement.setInt(2, hoaDon.getKhachhang());
			preparedStatement.setInt(3, hoaDon.getTongtien());
			preparedStatement.setInt(4, hoaDon.getNhanvienbanhang());
			preparedStatement.setString(5, hoaDon.getThoigianxuat().toString());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public HoaDon325 selectHoaDon(int id) {
		HoaDon325 hoaDon = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOA_DON_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int khachhang = rs.getInt("khachhang");
				int tongtien = rs.getInt("tongtien");
				int nhanvienbanhang = rs.getInt("nhanvienbanhang");
				LocalDateTime thoigianxuat = rs.getObject("thoigianxuat", LocalDateTime.class);
				hoaDon = new HoaDon325(id, khachhang, tongtien, nhanvienbanhang, thoigianxuat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hoaDon;
	}

	public List<HoaDon325> selectAllHoaDon() {
		List<HoaDon325> hoaDons = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOA_DON)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int khachhang = rs.getInt("khachhang");
				int tongtien = rs.getInt("tongtien");
				int nhanvienbanhang = rs.getInt("nhanvienbanhang");
				LocalDateTime thoigianxuat = rs.getObject("thoigianxuat", LocalDateTime.class);
				hoaDons.add(new HoaDon325(id, khachhang, tongtien, nhanvienbanhang, thoigianxuat));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hoaDons;
	}

	public boolean deleteHoaDon(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_HOA_DON_SQL)) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateHoaDon(HoaDon325 hoaDon) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_HOA_DON_SQL)) {
			statement.setInt(1, hoaDon.getKhachhang());
			statement.setInt(2, hoaDon.getTongtien());
			statement.setInt(3, hoaDon.getNhanvienbanhang());
			statement.setObject(4, hoaDon.getThoigianxuat());
			statement.setInt(5, hoaDon.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
