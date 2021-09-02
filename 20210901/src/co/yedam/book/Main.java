package co.yedam.book;

import java.util.List;
import java.util.Scanner;


public class Main {
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while (true) {
			System.out.println("1.입력 2.조회 3.수정 4.삭제 5.종료");
			int menu = scn.nextInt();scn.nextLine();
			if (menu == 1) {
				System.out.println("입력하세요.");
				// 입력..
				addBook();
			} else if (menu == 2) {
				System.out.println("조회하세요.");
				// 조회..
				searchBook();
			} else if (menu == 3) {
				System.out.println("수정하세요.");
				modifyBook();
			} else if (menu == 4) {
				System.out.println("삭제하세요.");
			} else if (menu == 5) {
				break;
			}
		}
		scn.close();
		System.out.println("end of program");
	}

	public static void addBook() {
		System.out.println("도서코드 입력>>");
		String bookcode = scn.nextLine();
		System.out.println("도서명을 입력>>");
		String bookTitle = scn.nextLine();
		System.out.println("저자명을 입력>>");
		String bookAuthor = scn.nextLine();
		System.out.println("출판사를 입력>>");
		String bookPublish = scn.nextLine();
		System.out.println("도서가격을 입력>>");
		int bookPrice = scn.nextInt();

		
		Book book = new Book();
		book.setBookCode(bookcode);
		book.setBookTitle(bookTitle);
		book.setBookAuthor(bookAuthor);
		book.setBookPublish(bookPublish);
		book.setBookPrice(bookPrice);
		
		BookDAO dao = new BookDAO();
		dao.insertBook(book);
		
			

	}
	public static void searchBook() {
		System.out.println("저자를 입력>>");
		String bookcode = scn.nextLine();
	
		System.out.println("도서명을 입력>>");
		String bookTitle = scn.nextLine();
		System.out.println("저자명을 입력>>");
		String bookAuthor = scn.nextLine();
		System.out.println("출판사를 입력>>");
		String bookPublish = scn.nextLine();


		
		Book book = new Book();		//String = > null, int, double =>0,0.0
		book.setBookAuthor(bookAuthor);
		book.setBookTitle(bookTitle);
		book.setBookPublish(bookPublish);
		
		
		BookDAO dao = new BookDAO();
		List<Book> list = dao.searchBook(book);
		for(Book bkBook : list) {   //확장된 for
			System.out.println(bkBook.toString());
			}
		}
	//수정할 코드를 한건 가져와서  그 값들을 가지고 필드를 채워 넣을것이다. 북코드로 한건 조회한 결과를 가지고 와서 
	// 사용자가 값을 넣으면 넣은 값으로 
	public static void modifyBook() {
		System.out.println("수정할 책코드 입력>>");
		String bookcode = scn.nextLine();
		
		
		
		BookDAO dao = new BookDAO();
		Book rbook = dao.getBook(bookcode);
		
		System.out.println("도서명을 입력>>");
		String bookTitle = scn.nextLine();
		if(!bookTitle.equals("")) {
			rbook.setBookTitle(bookTitle);
		}
		
		System.out.println("저자명을 입력>>");
		String bookAuthor = scn.nextLine();
		if(!bookAuthor.equals("")) {
			rbook.setBookAuthor(bookAuthor);
		}
		
		System.out.println("출판사를 입력>>");
		String bookPublish = scn.nextLine();
		if(!bookPublish.equals("")) {
			rbook.setBookPublish(bookPublish);
		}
		
		System.out.println("도서가격을 입력>>");
		String bookPrice = scn.nextLine();
		if(!bookPrice.equals("")) {
			rbook.setBookPrice(Integer.parseInt(bookPrice));
		}
		dao.updateBook(rbook);
		
		
	}
	public void delete() {
		
	}
	
	
	
	}

	
	
	
