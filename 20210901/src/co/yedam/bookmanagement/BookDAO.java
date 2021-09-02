package co.yedam.bookmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {

private Connection getConnection() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String passwd = "hr";
		Connection conn = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("db connect success");
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	//closeJDBC
	private void closeJDBC(Connection conn, PreparedStatement pstmt, ResultSet rs){ 
		try {
		
		if(rs != null) {
			rs.close();     
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
		if(pstmt != null){
			pstmt.close();
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			if(rs !=null) {
				rs.close();
			}
			}catch(SQLException e){
				e.printStackTrace();
			}
		 
		
	}
	// search all
	public void searchAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		ResultSet rs = null;
		
		try {
			conn  = this.getConnection();
			sql = "SELECT * FROM BOOK";
			pstmt = conn.prepareStatement(sql);          
			rs = pstmt.executeQuery();
			
			while(rs.next()) {		
	    		System.out.print("BOOK_CODE: "+ rs.getString("BOOK_CODE")); 
	    		System.out.print("\tBOOK_TITLE: "+ rs.getString("BOOK_TITLE"));
	    		System.out.print("\tBOOK_AUTHOR: "+ rs.getString("BOOK_AUTHOR"));
	    		System.out.print("\t개요: "+ rs.getString("BOOK_COMENT"));
	    		
	    	
	    		
	    		System.out.println();
	    		}
			
		} catch ( SQLException e) {
			e.printStackTrace();
		}finally {
			closeJDBC(conn, pstmt, null);
		}
		
	}
	
	
	

		public void search(String name) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "";
			ResultSet rs = null;
			
			try {
				conn  = this.getConnection();
				sql = "SELECT * FROM book WHERE BOOK_TITLE = ? ";
				pstmt = conn.prepareStatement(sql);         
				pstmt.setString(1,name);
				rs = pstmt.executeQuery();
//				
//				while(rs.next()) {
//					Book book = new Book();
//					book.setIsbn(rs.getString("isbn"));
//					book.setName(rs.getString("name"));
//					book.setContent(rs.getString("content"));
//				}
				if(rs !=null) {
				while(rs.next()) {		
					System.out.print("BOOK_CODE "+ rs.getString("BOOK_CODE")); 
		    		System.out.print("\tBOOK_TITLE: "+ rs.getString("BOOK_TITLE"));
		    		System.out.print("\tBOOK_AUTHOR: "+ rs.getString("BOOK_AUTHOR"));
		    		System.out.print("\t개요: "+ rs.getString("BOOK_COMENT"));
		    		
		    		System.out.println("search success");
		    		}
				}
				else {
					System.out.println("serach false  ");
				}
							
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				closeJDBC(conn, pstmt, rs);
			}
		}
		
		public boolean loginCheck() {
			return false;
			
			
		}
		
		public void rent() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "";
			ResultSet rs = null;
			try {
				conn  = this.getConnection();
				sql = "INSERT INTO book_rent VALUES(001, 'aaa','a001',SYSDATE,'N');";
				pstmt = conn.prepareStatement(sql);         
				pstmt.setString(1,name);
				rs = pstmt.executeQuery();
//				
//				while(rs.next()) {
//					Book book = new Book();
//					book.setIsbn(rs.getString("isbn"));
//					book.setName(rs.getString("name"));
//					book.setContent(rs.getString("content"));
//				}
				if(rs !=null) {
				while(rs.next()) {		
					System.out.print("BOOK_CODE "+ rs.getString("BOOK_CODE")); 
		    		System.out.print("\tBOOK_TITLE: "+ rs.getString("BOOK_TITLE"));
		    		System.out.print("\tBOOK_AUTHOR: "+ rs.getString("BOOK_AUTHOR"));
		    		System.out.print("\t개요: "+ rs.getString("BOOK_COMENT"));
		    		
		    		System.out.println("search success");
		    		}
				}
				else {
					System.out.println("serach false  ");
				}
							
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				closeJDBC(conn, pstmt, rs);
			}
		}
	
	
}
