package week1.day2;

public class LibraryManagement {

	public static void main(String[] args) {
		Library lm = new Library();
		String newBookTitle= lm.addBook("MARVEL AVENGERS");
		lm.issueBook();
		System.out.println("Book title printed from LibraryManagement class: " +newBookTitle);
	}
}
