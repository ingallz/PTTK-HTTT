package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO325 {

	protected Connection getConnection() {
		Connection connection = null;
		String jdbcURL = "jdbc:mysql://localhost:3333/cineman?allowPublicKeyRetrieval=true&useSSL=false";
		String jdbcUsername = "root";
		String jdbcPassword = "167218";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
