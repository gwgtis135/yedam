package co.yedam.bookmanagement;

import java.util.List;
import java.util.Scanner;




public class Main {
	static Scanner scn = new Scanner(System.in);
	BookDAO bd = new BookDAO();
	
	public static void main(String[] args) {
		FirstPage fp = new FirstPage();
		Main m = new Main();
		
		
		while (true) {
			fp.firstprint();
			int menu = scn.nextInt();scn.nextLine();
			if (menu == 1) {
				
				m.searchAll();
				m.search();
 				
				
				
				
			} else if (menu == 2) {
				
				System.out.println("login please");
				
			} else if (menu == 3) {
				System.out.println("?��?��?��?��?��.");
				modifyBook();
			} else if (menu == 4) {
				System.out.println("?��?��?��?��?��.");
			} else if (menu == 5) {
				break;
			}
		}
		scn.close();
		System.out.println("end of program");
	}

	
	
	public static void searchBook() {
		System.out.println("bookcode>");
		String bookcode = scn.nextLine();
	
		System.out.println("bookTitle>");
		String bookTitle = scn.nextLine();
		System.out.println("bookAuthor>");
		String bookAuthor = scn.nextLine();
		


		
		Bookvo book = new Bookvo();		//String = > null, int, double =>0,0.0
		book.setBookAuthor(bookAuthor);
		book.setBookTitle(bookTitle);
		
		
		BookDAO1 dao = new BookDAO1();
		List<Bookvo> list = dao.searchBook(book);
		for(Bookvo bkBook : list) {   //?��?��?�� for
			System.out.println(bkBook.toString());
			}
		}
	//?��?��?�� 코드�? ?���? �??��???��  �? 값들?�� �?�?�? ?��?���? 채워 ?��?��것이?��. 북코?���? ?���? 조회?�� 결과�? �?�?�? ???�� 
	// ?��?��?���? 값을 ?��?���? ?��?? 값으�? 
	public static void modifyBook() {
		System.out.println("?��?��?�� 책코?�� ?��?��>>");
		String bookcode = scn.nextLine();
		
		
		
		BookDAO1 dao = new BookDAO1();
		Bookvo rbook = dao.getBook(bookcode);
		
		System.out.println("?��?��명을 ?��?��>>");
		String bookTitle = scn.nextLine();
		if(!bookTitle.equals("")) {
			rbook.setBookTitle(bookTitle);
		}
		
		System.out.println("???��명을 ?��?��>>");
		String bookAuthor = scn.nextLine();
		if(!bookAuthor.equals("")) {
			rbook.setBookAuthor(bookAuthor);
		}
		
		System.out.println("출판?���? ?��?��>>");
		String bookPublish = scn.nextLine();
		if(!bookPublish.equals("")) {
		}
		
		System.out.println("?��?���?격을 ?��?��>>");
		String bookPrice = scn.nextLine();
		if(!bookPrice.equals("")) {
		}
		dao.updateBook(rbook);
		
		
	}
	//책�??��
	public void search() {
		System.out.print("BOOK_TITLE>");
		String title = scn.nextLine();
		bd.search(title);
	}

	public void searchAll() {
		bd.searchAll();
	}
	
	public void login() {
		
		System.out.println("ID>");
		String id = scn.nextLine();
		System.out.println("PW");
		String pw = scn.nextLine();
		
		
		
	}
	
	
	}

	
	
	
