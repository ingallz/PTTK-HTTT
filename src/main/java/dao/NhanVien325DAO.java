package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.NhanVien325;

public class NhanVien325DAO extends DAO325 {

	private static final String INSERT_NV_SQL = "INSERT INTO nhanvien325 (id, thanhvien) VALUES (?, ?)";
	private static final String SELECT_NV_BY_ID = "SELECT id, thanhvien FROM nhanvien325 WHERE id = ?";
	private static final String SELECT_ALL_NV = "SELECT * FROM nhanvien325";
	private static final String DELETE_NV_SQL = "DELETE FROM nhanvien325 WHERE id = ?";
	private static final String UPDATE_NV_SQL = "UPDATE nhanvien325 SET thanhvien = ? WHERE id = ?";

	public NhanVien325DAO() {
	}

	public void insertNhanVien(NhanVien325 nhanVien) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NV_SQL)) {
			preparedStatement.setInt(1, nhanVien.getId());
			preparedStatement.setInt(2, nhanVien.getThanhvien());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public NhanVien325 selectNhanVien(int id) {
		NhanVien325 nhanVien = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NV_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int thanhVien = rs.getInt("thanhvien");
				nhanVien = new NhanVien325(id, thanhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nhanVien;
	}

	public NhanVien325 selectNhanVienByThanhVien(int id) {
		NhanVien325 nhanVien = null;
		try {
			List<NhanVien325> nhanVien325s = selectAllNhanVien();
			for (NhanVien325 nhanVien325 : nhanVien325s) {
				if (nhanVien325.getThanhvien() == id) {
					return nhanVien325;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nhanVien;
	}

	public List<NhanVien325> selectAllNhanVien() {
		List<NhanVien325> nhanViens = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NV)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int thanhVien = rs.getInt("thanhvien");
				nhanViens.add(new NhanVien325(id, thanhVien));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nhanViens;
	}

	public boolean deleteNhanVien(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_NV_SQL)) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateNhanVien(NhanVien325 nhanVien) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_NV_SQL)) {
			statement.setInt(1, nhanVien.getThanhvien());
			statement.setInt(2, nhanVien.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
