package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Phim325;

public class Phim325DAO extends DAO325 {

	private static final String INSERT_PHIM_SQL = "INSERT INTO phim325 (ten, mota, theloai, daodien, thoiluong, dangchieu) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SELECT_PHIM_BY_ID = "SELECT id, ten, mota, theloai, daodien, thoiluong, dangchieu FROM phim325 WHERE id = ?";
	private static final String SELECT_ALL_PHIM = "SELECT * FROM phim325";
	private static final String DELETE_PHIM_SQL = "DELETE FROM phim325 WHERE id = ?";
	private static final String UPDATE_PHIM_SQL = "UPDATE phim325 SET ten = ?, mota = ?, theloai = ?, daodien = ?, thoiluong = ?, dangchieu = ? WHERE id = ?";

	public Phim325DAO() {
	}

	public void insertPhim(Phim325 phim) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PHIM_SQL)) {
			preparedStatement.setString(1, phim.getTen());
			preparedStatement.setString(2, phim.getMota());
			preparedStatement.setString(3, phim.getTheloai());
			preparedStatement.setString(4, phim.getDaodien());
			preparedStatement.setString(5, phim.getThoiluong());
			preparedStatement.setBoolean(6, phim.isDangchieu());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Phim325 selectPhim(int id) {
		System.out.println("passsssssssss");
		System.out.println(id);
		Phim325 phim = null;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PHIM_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String ten = rs.getString("ten");
				String mota = rs.getString("mota");
				String theloai = rs.getString("theloai");
				String daodien = rs.getString("daodien");
				String thoiluong = rs.getString("thoiluong");
				boolean dangchieu = rs.getBoolean("dangchieu");
				phim = new Phim325(id, ten, mota, theloai, daodien, thoiluong, dangchieu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phim;
	}

	public List<Phim325> selectAllPhim() {
		List<Phim325> phims = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PHIM)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String ten = rs.getString("ten");
				String mota = rs.getString("mota");
				String theloai = rs.getString("theloai");
				String daodien = rs.getString("daodien");
				String thoiluong = rs.getString("thoiluong");
				boolean dangchieu = rs.getBoolean("dangchieu");
				phims.add(new Phim325(id, ten, mota, theloai, daodien, thoiluong, dangchieu));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phims;
	}

	public List<Phim325> timPhim(String keyword) {
		if (keyword == null)
			return selectAllPhim();
		List<Phim325> phims = selectAllPhim();
		List<Phim325> returns = new ArrayList<Phim325>();
		try {
			for (Phim325 phim325 : phims) {
				if (phim325.getTen().contains(keyword)) {
					returns.add(phim325);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returns;
	}

	public boolean deletePhim(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PHIM_SQL)) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updatePhim(Phim325 phim) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PHIM_SQL)) {
			statement.setString(1, phim.getTen());
			statement.setString(2, phim.getMota());
			statement.setString(3, phim.getTheloai());
			statement.setString(4, phim.getDaodien());
			statement.setString(5, phim.getThoiluong());
			statement.setBoolean(6, phim.isDangchieu());
			statement.setInt(7, phim.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}