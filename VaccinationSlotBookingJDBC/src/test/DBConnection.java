package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static String driver = "com.mysql.cj.jdbc.Driver";

	// url,username,password
	static String url = "jdbc:mysql://localhost:3306/";
	static String username = "root";
	static String password = "root";

	public static Connection getConnection(String dbName) {

		Connection conn = null;
		url = url + dbName;
		try {
			Class.forName(driver);
			System.out.println("Driver Loaded");

			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return conn;
	}

}
