package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.LichChieu325;
import model.PhongChieu325;

public class PhongChieu325DAO extends DAO325 {

	private static final String INSERT_PHONGCHIEU_SQL = "INSERT INTO phongchieu325 (maphong, mota) VALUES (?, ?)";
	private static final String SELECT_PHONGCHIEU_BY_ID = "SELECT maphong, mota FROM phongchieu325 WHERE maphong = ?";
	private static final String SELECT_ALL_PHONGCHIEU = "SELECT * FROM phongchieu325";
	private static final String DELETE_PHONGCHIEU_SQL = "DELETE FROM phongchieu325 WHERE maphong = ?";
	private static final String UPDATE_PHONGCHIEU_SQL = "UPDATE phongchieu325 SET mota = ? WHERE maphong = ?";

	public PhongChieu325DAO() {
	}

	public void insertPhongChieu(PhongChieu325 phongChieu) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PHONGCHIEU_SQL)) {
			preparedStatement.setString(1, phongChieu.getMaphong());
			preparedStatement.setString(2, phongChieu.getMota());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public PhongChieu325 selectPhongChieu(String maphong) {
		PhongChieu325 phongChieu = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PHONGCHIEU_BY_ID)) {
			preparedStatement.setString(1, maphong);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String mota = rs.getString("mota");
				phongChieu = new PhongChieu325(maphong, mota);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phongChieu;
	}

	public List<PhongChieu325> selectAllPhongChieu() {
		List<PhongChieu325> phongChieus = new ArrayList<>();

		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PHONGCHIEU);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maphong = rs.getString("maphong");
				String mota = rs.getString("mota");
				phongChieus.add(new PhongChieu325(maphong, mota));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return phongChieus;
	}

	public List<PhongChieu325> timPhongTrong(LocalDate startDate, LocalTime startTime, LocalTime endTime) {
		LichChieu325DAO lichChieu325DAO = new LichChieu325DAO();
		List<PhongChieu325> phongChieus = selectAllPhongChieu();
		List<LichChieu325> lichChieu325s = lichChieu325DAO.selectAllLichChieu();
		LocalDateTime startDateTime = startDate.atTime(startTime);
		LocalDateTime endDateTime = startDate.atTime(endTime);
		List<PhongChieu325> returns = new ArrayList<PhongChieu325>();
		System.out.println(startDateTime);
		System.out.println(endDateTime);

		try {
			for (PhongChieu325 phongChieu325 : phongChieus) {
				boolean flag = true;
				for (LichChieu325 lichChieu325 : lichChieu325s) {
					if (phongChieu325.getMaphong().equals(lichChieu325.getPhong())) {
						if (startDateTime.isAfter(lichChieu325.getThoigianbatdau())
								&& startDateTime.isBefore(lichChieu325.getThoigianketthuc())) {
							flag = false;
							break;
						}
						if (endDateTime.isAfter(lichChieu325.getThoigianbatdau())
								&& endDateTime.isBefore(lichChieu325.getThoigianketthuc())) {
							flag = false;
							break;
						}
						if (startDateTime.isBefore(lichChieu325.getThoigianbatdau())
								&& endDateTime.isAfter(lichChieu325.getThoigianketthuc())) {
							flag = false;
							break;
						}
						if (startDateTime.equals(lichChieu325.getThoigianbatdau())
								|| startDateTime.equals(lichChieu325.getThoigianketthuc())) {
							flag = false;
							break;
						}
						if (endDateTime.equals(lichChieu325.getThoigianbatdau())
								|| endDateTime.equals(lichChieu325.getThoigianketthuc())) {
							flag = false;
							break;
						}

					}
				}
				if (flag == true)
					returns.add(phongChieu325);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return returns;
	}

	public boolean deletePhongChieu(String maphong) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PHONGCHIEU_SQL)) {
			statement.setString(1, maphong);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updatePhongChieu(PhongChieu325 phongChieu) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PHONGCHIEU_SQL)) {
			statement.setString(1, phongChieu.getMota());
			statement.setString(2, phongChieu.getMaphong());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
