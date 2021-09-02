package co.yedam.bookmanagement;

public class Bookvo {
	private String bookCode;
	private String bookTitle;
	private String bookAuthor;
	private String bookcomment;
	private char rentBk;
	private char returnBk;
	
	
	public String getBookCode() {
		return bookCode;
	}


	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}


	public String getBookTitle() {
		return bookTitle;
	}


	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}


	public String getBookcomment() {
		return bookcomment;
	}


	public void setBookcomment(String bookcomment) {
		this.bookcomment = bookcomment;
	}


	public char getRentBk() {
		return rentBk;
	}


	public void setRentBk(char rentBk) {
		this.rentBk = rentBk;
	}


	public char getReturnBk() {
		return returnBk;
	}


	public void setReturnBk(char returnBk) {
		this.returnBk = returnBk;
	}


	@Override
	public String toString() {
		return "Bookvo [bookCode=" + bookCode + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor
				+ ", bookcomment=" + bookcomment + ", rentBk=" + rentBk + ", returnBk=" + returnBk + "]";
	}


	
}
