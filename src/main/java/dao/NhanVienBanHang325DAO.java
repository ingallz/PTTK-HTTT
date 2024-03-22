package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.NhanVienBanHang325;

public class NhanVienBanHang325DAO extends DAO325 {

	private static final String INSERT_NHANVIEN_SQL = "INSERT INTO nhanvienbanhang325 (id, nhanvien) VALUES (?, ?)";
	private static final String SELECT_NHANVIEN_BY_ID = "SELECT id, nhanvien FROM nhanvienbanhang325 WHERE id = ?";
	private static final String SELECT_ALL_NHANVIEN = "SELECT * FROM nhanvienbanhang325";
	private static final String DELETE_NHANVIEN_SQL = "DELETE FROM nhanvienbanhang325 WHERE id = ?";
	private static final String UPDATE_NHANVIEN_SQL = "UPDATE nhanvienbanhang325 SET nhanvien = ? WHERE id = ?";

	public NhanVienBanHang325DAO() {
	}

	public void insertNhanVien(NhanVienBanHang325 nhanVien) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NHANVIEN_SQL)) {
			preparedStatement.setInt(1, nhanVien.getId());
			preparedStatement.setInt(2, nhanVien.getNhanvien());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public NhanVienBanHang325 selectNhanVien(int id) {
		NhanVienBanHang325 nhanVien = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NHANVIEN_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int nhanvien = rs.getInt("nhanvien");
				nhanVien = new NhanVienBanHang325();
				nhanVien.setId(id);
				nhanVien.setNhanvien(nhanvien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nhanVien;
	}

	public List<NhanVienBanHang325> selectAllNhanVien() {
		List<NhanVienBanHang325> nhanViens = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NHANVIEN)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int nhanvien = rs.getInt("nhanvien");
				NhanVienBanHang325 nhanVien = new NhanVienBanHang325();
				nhanVien.setId(id);
				nhanVien.setNhanvien(nhanvien);
				nhanViens.add(nhanVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nhanViens;
	}

	public boolean deleteNhanVien(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_NHANVIEN_SQL)) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateNhanVien(NhanVienBanHang325 nhanVien) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_NHANVIEN_SQL)) {
			statement.setInt(1, nhanVien.getNhanvien());
			statement.setInt(2, nhanVien.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
