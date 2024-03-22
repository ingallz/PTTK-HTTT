package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Ghe325;

public class Ghe325DAO extends DAO325 {

	private static final String INSERT_GHE_SQL = "INSERT INTO ghe325 (maghe, phongchieu) VALUES (?, ?)";
	private static final String SELECT_GHE_BY_ID = "SELECT maghe, phongchieu FROM ghe325 WHERE maghe = ?";
	private static final String SELECT_ALL_GHE = "SELECT * FROM ghe325";
	private static final String DELETE_GHE_SQL = "DELETE FROM ghe325 WHERE maghe = ?";
	private static final String UPDATE_GHE_SQL = "UPDATE ghe325 SET phongchieu = ? WHERE maghe = ?";

	public Ghe325DAO() {
	}

	public void insertGhe(Ghe325 ghe) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GHE_SQL)) {
			preparedStatement.setString(1, ghe.getMaghe());
			preparedStatement.setString(2, ghe.getPhongchieu());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Ghe325 selectGhe(String maghe) {
		Ghe325 ghe = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GHE_BY_ID)) {
			preparedStatement.setString(1, maghe);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String phongchieu = rs.getString("phongchieu");
				ghe = new Ghe325(maghe, phongchieu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ghe;
	}

	public List<Ghe325> selectAllGhe() {
		List<Ghe325> ghes = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_GHE)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maghe = rs.getString("maghe");
				String phongchieu = rs.getString("phongchieu");
				ghes.add(new Ghe325(maghe, phongchieu));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ghes;
	}

	public boolean deleteGhe(String maghe) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_GHE_SQL)) {
			statement.setString(1, maghe);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateGhe(Ghe325 ghe) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_GHE_SQL)) {
			statement.setString(1, ghe.getPhongchieu());
			statement.setString(2, ghe.getMaghe());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
