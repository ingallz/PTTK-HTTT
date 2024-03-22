package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.NhanVienQuanLi325;

public class NhanVienQuanLi325DAO extends DAO325 {

	private static final String INSERT_NV_SQL = "INSERT INTO nhanvienquanli325 (id, nhanvien) VALUES (?, ?)";
	private static final String SELECT_NV_BY_ID = "SELECT id, nhanvien FROM nhanvienquanli325 WHERE id = ?";
	private static final String SELECT_ALL_NV = "SELECT * FROM nhanvienquanli325";
	private static final String DELETE_NV_SQL = "DELETE FROM nhanvienquanli325 WHERE id = ?";
	private static final String UPDATE_NV_SQL = "UPDATE nhanvienquanli325 SET nhanvien = ? WHERE id = ?";

	public NhanVienQuanLi325DAO() {
	}

	public void insertNhanVien(NhanVienQuanLi325 nhanVien) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NV_SQL)) {
			preparedStatement.setInt(1, nhanVien.getId());
			preparedStatement.setInt(2, nhanVien.getNhanvien());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public NhanVienQuanLi325 selectNhanVien(int id) {
		NhanVienQuanLi325 nhanVien = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NV_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int nhanvien = rs.getInt("nhanvien");
				nhanVien = new NhanVienQuanLi325(id, nhanvien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nhanVien;
	}

	public NhanVienQuanLi325 selectNhanVienById(int id) {
		NhanVienQuanLi325 nhanVien = null;
		try {
			List<NhanVienQuanLi325> nhanVienQuanLi325s = selectAllNhanVien();
			for (NhanVienQuanLi325 nhanVienQuanLi325 : nhanVienQuanLi325s) {
				if (nhanVienQuanLi325.getNhanvien() == id) {
					return nhanVienQuanLi325;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return nhanVien;
	}

	public List<NhanVienQuanLi325> selectAllNhanVien() {
		List<NhanVienQuanLi325> nhanViens = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NV)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int nhanvien = rs.getInt("nhanvien");
				nhanViens.add(new NhanVienQuanLi325(id, nhanvien));
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

	public boolean updateNhanVien(NhanVienQuanLi325 nhanVien) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_NV_SQL)) {
			statement.setInt(1, nhanVien.getNhanvien());
			statement.setInt(2, nhanVien.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
