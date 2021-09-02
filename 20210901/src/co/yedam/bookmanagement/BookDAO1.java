package co.yedam.bookmanagement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookDAO1  {
	
	public void deleteBook(String bookCode ) {
		
	}
	
	public void updateBook(Bookvo book) {
		String sql = "update book_info set book_title = ?, "
			+ "book_author=?, book_publish=?, book_price=?"
			+ "where book_code =?";
		connect();
		
		try {
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookTitle());
			psmt.setString(2, book.getBookAuthor());
			psmt.setString(3, book.getBookPublish());
			psmt.setInt(4, book.getBookPrice());
			psmt.setString(5, book.getBookCode());
			
			int r = psmt.executeUpdate();
			System.out.println("?†ï?ÉÅ ?àò?†ï?ôÑÎ£?, " + r );
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	} 
	
	
	public Bookvo getBook(String bookcode) {
		connect();
		String sql= "select * from book_info where book_code = ?";
		Bookvo book = null;
		
		try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, bookcode);
		rs = psmt.executeQuery();
		if(rs.next()) {
			book = new Bookvo();
			book.setBookAuthor(rs.getString("book_author"));
			book.setBookCode(rs.getString("book_code"));
			book.setBookPrice(rs.getInt("book_price"));
			book.setBookPublish(rs.getString("book_publish"));
			book.setBookTitle(rs.getString("book_title"));
		}
		
		} catch (Exception e) {
		e.printStackTrace();
		}
		return book;
	}

	public List<Bookvo> searchBook(Bookvo book) {
		String sql = " select * from book_info ";
		if(book.getBookAuthor() != null) {
			sql += "where book_author like '%'||?||'%' ";
		}else if(book.getBookTitle() !=null) {
			sql += "where book_title like '%'||?||'%' ";
		}else if(book.getBookPublish() != null) {
			sql += "where book_publish like '%'||?||'%' ";
		}
		 List<Bookvo> bookList = new ArrayList<Bookvo>();
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			if(book.getBookAuthor() !=null) { //Ï°∞ÌöåÏ°∞Í±¥ : ???ûêÎ™?.
			psmt.setString(1, book.getBookAuthor());
		}else if(book.getBookTitle() != null) {
			psmt.setString(1, book.getBookTitle());
		}else if (book.getBookPublish() != null) {
			psmt.setString(1, book.getBookPublish());
		}
			rs = psmt.executeQuery();
			while(rs.next()) {
//				System.out.print("ÏΩîÎìú: " + rs.getString("book_code"));
//				System.out.print("\t?†úÎ™?: " + rs.getString("book_title"));
//				System.out.print("\t???ûê: " + rs.getString("book_author"));
//				System.out.println();
				
				Bookvo bk = new Bookvo();
				bk.setBookCode(rs.getString("book_code"));
				bk.setBookAuthor(rs.getString("book_author"));
				bk.setBookCode(rs.getString("book_title"));
				bk.setBookAuthor(rs.getString("book_publish"));
				bk.setBookAuthor(rs.getString("book_price"));
				
				bookList.add(bk);
															
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}finally {
			disconnect();
		}
		return bookList;
	}
	
	
	public void insertBook(Bookvo book) {
		String sql = "insert into book_info(book_code, book_title, book_author, book_publish, book_price) values(?,?,?,?,?)";
				
		
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookCode());
			psmt.setString(2, book.getBookTitle());
			psmt.setString(3, book.getBookAuthor());
			psmt.setString(4, book.getBookPublish());
			psmt.setInt(5, book.getBookPrice());
			int r = psmt.executeUpdate();
		    System.out.println("?ûÖ?†•?ôÑÎ£? " + r);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
}

