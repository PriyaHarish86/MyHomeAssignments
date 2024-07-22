package week1.day2;

public class Library {
	
	public String addBook(String bookTitle) {
		System.out.println("Book added successfully");
		return bookTitle;
	}
	
	void  issueBook() {
		System.out.println("Book issued successfully");
	}

	public static void main(String[] args) {
		Library l = new Library();
		String newBookTitle = l.addBook("MARVEL AVENGERS");
		l.issueBook();
		System.out.println("The issued book is : " + newBookTitle);
	}

}

