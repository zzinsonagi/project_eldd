package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBmanager;

public class DBmanager {

	private static DBmanager instance = new DBmanager();

	private DBmanager() {
	}

	public static DBmanager getinstance() {
		return instance;
	}

	public Connection getConnection() {

		Connection conn = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "jsl14";
		String pw = "1234";

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

	public void close(Connection conn, PreparedStatement pstmt) {

		try {

			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {

		try {
			if (rs != null) rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
