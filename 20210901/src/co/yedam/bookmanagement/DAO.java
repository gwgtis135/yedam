package co.yedam.bookmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	protected Connection conn;
	protected PreparedStatement psmt;
	protected ResultSet rs;
	

	String user = "hr";
	String pass = "hr";
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 

	void connect() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ������ Ŭ������ �ִ��� Ȯ�� ���� ?
			conn = DriverManager.getConnection(url, user, pass); // Ŀ�ؼ� ��ü�� db�� ����
		System.out.println("?��결성�?");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}
	}

	void disconnect() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
