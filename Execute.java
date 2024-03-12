package FBLALibrary;

public class Execute {

	public static void main(String[] args) {
		MySQLConnect database = new MySQLConnect();
		//Creates the students and books tables if this program has not been run before on the computer
		database.doQuery("CREATE TABLE IF NOT EXISTS students(student_id INT PRIMARY KEY, name VARCHAR(30), age TINYINT, grade TINYINT, book1 INT, book2 INT, book3 INT, book4 INT, book5 INT, book6 INT);");
		database.doQuery("CREATE TABLE IF NOT EXISTS books(book_id INT PRIMARY KEY, title VARCHAR(30), author VARCHAR(30), owner INT);");
		
		//Manages the full appearance and functionality of the GUI
		LibraryGUI lib = new LibraryGUI();
	}
}