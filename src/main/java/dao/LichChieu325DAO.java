package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.LichChieu325;

public class LichChieu325DAO extends DAO325 {

	private static final String INSERT_LICHCHIEU_SQL = "INSERT INTO lichchieu325 (phim, phong, nhanvienquanli, thoigianbatdau, thoigianketthuc) VALUES (?, ?, ?, ?, ?)";
	private static final String SELECT_LICHCHIEU_BY_ID = "SELECT id, phim, phong, nhanvienquanli, thoigianbatdau, thoigianketthuc FROM lichchieu325 WHERE id = ?";
	private static final String SELECT_ALL_LICHCHIEU = "SELECT * FROM lichchieu325";
	private static final String DELETE_LICHCHIEU_SQL = "DELETE FROM lichchieu325 WHERE id = ?";
	private static final String UPDATE_LICHCHIEU_SQL = "UPDATE lichchieu325 SET phim = ?, phong = ?, nhanvienquanli = ?, thoigianbatdau = ?, thoigianketthuc = ? WHERE id = ?";

	public LichChieu325DAO() {
	}

	public void insertLichChieu(LichChieu325 lichChieu) throws SQLException {
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LICHCHIEU_SQL);
			preparedStatement.setInt(1, lichChieu.getPhim());
			preparedStatement.setString(2, lichChieu.getPhong());
			preparedStatement.setInt(3, lichChieu.getNhanvienquanli());
			preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(lichChieu.getThoigianbatdau()));
			preparedStatement.setTimestamp(5, java.sql.Timestamp.valueOf(lichChieu.getThoigianketthuc()));
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public LichChieu325 selectLichChieu(int id) {
		LichChieu325 lichChieu = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LICHCHIEU_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int phim = rs.getInt("phim");
				String phong = rs.getString("phong");
				int nhanvienquanli = rs.getInt("nhanvienquanli");
				LocalDateTime thoigianbatdau = rs.getTimestamp("thoigianbatdau").toLocalDateTime();
				LocalDateTime thoigianketthuc = rs.getTimestamp("thoigianketthuc").toLocalDateTime();
				lichChieu = new LichChieu325(id, phim, phong, nhanvienquanli, thoigianbatdau, thoigianketthuc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lichChieu;
	}

	public List<LichChieu325> selectAllLichChieu() {
		List<LichChieu325> lichChieus = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LICHCHIEU)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int phim = rs.getInt("phim");
				String phong = rs.getString("phong");
				int nhanvienquanli = rs.getInt("nhanvienquanli");
				LocalDateTime thoigianbatdau = rs.getTimestamp("thoigianbatdau").toLocalDateTime();
				LocalDateTime thoigianketthuc = rs.getTimestamp("thoigianketthuc").toLocalDateTime();
				lichChieus.add(new LichChieu325(id, phim, phong, nhanvienquanli, thoigianbatdau, thoigianketthuc));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (LichChieu325 lichChieu325 : lichChieus) {
			System.out.println(lichChieu325.toString());
		}

		return lichChieus;
	}

	public boolean deleteLichChieu(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_LICHCHIEU_SQL)) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateLichChieu(LichChieu325 lichChieu) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_LICHCHIEU_SQL)) {
			statement.setInt(1, lichChieu.getPhim());
			statement.setString(2, lichChieu.getPhong());
			statement.setInt(3, lichChieu.getNhanvienquanli());
			statement.setTimestamp(4, java.sql.Timestamp.valueOf(lichChieu.getThoigianbatdau()));
			statement.setTimestamp(5, java.sql.Timestamp.valueOf(lichChieu.getThoigianketthuc()));
			statement.setInt(6, lichChieu.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
