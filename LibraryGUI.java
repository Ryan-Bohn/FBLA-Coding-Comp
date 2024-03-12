package FBLALibrary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LibraryGUI {
	//Connection to MySQL Database
	MySQLConnect mysql = new MySQLConnect();
	
	//GUI Elements for the home screen
	JFrame homeFrame = new JFrame("Home");
	JPanel homePanel = new JPanel();
	JTextField homeLabel = new JTextField("School Register");
	Dimension d = new Dimension(0, 15);	
	JPanel centerPanel = new JPanel();
	JButton viewAllStudents = new JButton("View Students");
	JButton addStudent = new JButton("Add Student");
	JButton removeStudent = new JButton("Remove Student");
	JButton editStudent = new JButton("Edit Student");
	JButton viewAllBooks = new JButton("View Books");
	JButton addBook = new JButton("Add Book");
	JButton assignBook = new JButton("Assign Book");
	JButton help = new JButton("Help");
	
	
	//GUI Elements for the student viewing screen
	JFrame sViewAllFrame = new JFrame();
	JButton sViewAllHome = new JButton("Home");
	JPanel sViewAllPanel = new JPanel();
	JTextField sViewAllLabel = new JTextField("Viewing all students");
	JPanel sViewAllGrid = new JPanel();
	
	
	//GUI Elements for the book viewing screen
	JFrame bViewAllFrame = new JFrame();
	JButton bViewAllHome = new JButton("Home");
	JPanel bViewAllPanel = new JPanel();
	JTextField bViewAllLabel = new JTextField("Viewing all books");
	JPanel bViewAllGrid = new JPanel();
	
	
	//GUI Elements for the student adding screen
	JFrame sAddFrame = new JFrame();
	JButton sAddEnter = new JButton("Enter");
	JPanel sAddPanel = new JPanel();
	JTextField sAddLabel = new JTextField("Enter the values you would like to add.");
	JTextField sAddIDLabel = new JTextField("student_id :");
	JTextField sAddNameLabel = new JTextField("name :");
	JTextField sAddAgeLabel = new JTextField("age :");
	JTextField sAddGradeLabel = new JTextField("grade :");
	JTextField sAddStudentID = new JTextField();
	JTextField sAddName = new JTextField();
	JTextField sAddAge = new JTextField();
	JTextField sAddGrade = new JTextField();
	
	
	//GUI Elements for the book adding screen
	JFrame bAddFrame = new JFrame();
	JButton bAddEnter = new JButton("Enter");
	JPanel bAddPanel = new JPanel();
	JTextField bAddLabel = new JTextField("Enter the values you would like to add.");
	JTextField bAddIDLabel = new JTextField("book_id :");
	JTextField bAddTitleLabel = new JTextField("title :");
	JTextField bAddAuthorLabel = new JTextField("author :");
	JPanel bAddInputs = new JPanel();
	JTextField bAddBookID = new JTextField();
	JTextField bAddTitle = new JTextField();
	JTextField bAddAuthor = new JTextField();
	
	
	//GUI Elements for the student removal screen
	JFrame sRemoveFrame = new JFrame();
	JButton sRemoveEnter = new JButton("Enter");
	JPanel sRemovePanel = new JPanel();
	JTextField sRemoveLabel = new JTextField("Enter the id of the student to be removed.");
	JTextField sRemoveID = new JTextField();
	
	
	//GUI Elements for the student editing screen 
	JFrame editStudentFrame = new JFrame();
	JButton editStudentEnter = new JButton("Enter");
	JPanel editStudentPanel = new JPanel();
	JPanel editStudentGrid = new JPanel();
	JTextField editStudentLabel = new JTextField("Enter the student id and new values for any fields you would like to edit.");
	JTextField editStudentID = new JTextField("student_id : ");
	JTextField editName = new JTextField("name : ");
	JTextField editAge = new JTextField("age : ");
	JTextField editGrade = new JTextField("grade : ");
	JTextField editIDValue = new JTextField();
	JTextField editNameValue = new JTextField();
	JTextField editAgeValue = new JTextField();
	JTextField editGradeValue = new JTextField();
	
	
	//GUI Elements for the book assignment screen
	JFrame assignBookFrame = new JFrame();
	JButton assignBookEnter = new JButton("Enter");
	JPanel assignBookPanel = new JPanel();
	JTextField assignBookLabel = new JTextField("Enter book id and intended owner id");
	JTextField assignBookIDLabel = new JTextField("book_id");
	JTextField assignBookID = new JTextField();
	JTextField assignStudentIDLabel = new JTextField("student_id");
	JTextField assignStudentID = new JTextField();
	
	
	//GUI Elements for help screen
	JFrame helpFrame = new JFrame();
	JPanel helpPanel = new JPanel();
	JTextField helpText1 = new JTextField("Press 'View Students' to view all students currently in the system.");
	JTextField helpText2 = new JTextField("Press 'View Books' to view all books currently in the system.");
	JTextField helpText3 = new JTextField("Press 'Add Student' to add a student and give values to its fields.");
	JTextField helpText4 = new JTextField("Press 'Add Book' to add a  book and give values to its fields.");
	JTextField helpText5 = new JTextField("Press 'Remove Student' to delete a student from the system based on their student id.");
	JTextField helpText6 = new JTextField("Press 'Assign Book' to assign an existing book to an existing student using their IDs.");
	JTextField helpText7 = new JTextField("Press 'Edit Student' to edit the fields of a student.");
	JButton helpHome = new JButton("Home");
	
	//Constructor which displays the home screen
	LibraryGUI() {
		createHomeScreen();
		homeFrame.setVisible(true);
	}
	
	
	//An action listener to handle GUI events and 
	//manage the MySQL database interactions
	private class ButtonEvent implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == viewAllStudents) {
				homeFrame.setVisible(false);
				createSViewAllScreen();
				
			} else if (e.getSource() == addStudent) {
				homeFrame.setVisible(false);
				createSAddScreen();
				
			} else if (e.getSource() == removeStudent) {
				homeFrame.setVisible(false);
				createSRemoveScreen();
				
			} else if (e.getSource() == editStudent) {
				homeFrame.setVisible(false);
				createEditStudentScreen();
				
			} else if (e.getSource() == viewAllBooks) {
				homeFrame.setVisible(false);
				createBViewAllScreen();
				
			} else if (e.getSource() == addBook) {
				homeFrame.setVisible(false);
				createBAddScreen();
				
			} else if (e.getSource() == assignBook) {
				homeFrame.setVisible(false);
				createAssignBookScreen();	
				
			} else if (e.getSource() == help) {
				homeFrame.setVisible(false);
				createHelpScreen();
			} else if (e.getSource() == sAddEnter) {
				
				if (sAddStudentID.getText() != null && sAddName.getText() != null && sAddAge.getText() != null && sAddGrade.getText() != null) {
					mysql.doQuery("INSERT INTO students (student_id, name, age, grade) VALUES (" + sAddStudentID.getText() +  ", '" + sAddName.getText() + "', " + sAddAge.getText() + ", " + sAddGrade.getText() + ");");
				} else {
					System.out.println("Must enter values for all student fields");
				}
				
			} else if (e.getSource() == bAddEnter) {
				
				if (bAddBookID.getText() != null && bAddTitle.getText() != null && bAddAuthor.getText() != null) {
					mysql.doQuery("INSERT INTO books(book_id, title, author) VALUES(" + bAddBookID.getText() + ", '" + bAddTitle.getText() + "', '" + bAddAuthor.getText() + "');");
				} else {
					System.out.println("Must enter values for all book fields");
				}
				
			} else if (e.getSource() == sRemoveEnter) {
				
				if (mysql.multiColumnQuery("SELECT * FROM students WHERE student_id = " + sRemoveID.getText() + ";") != null) {
					mysql.doQuery("DELETE FROM students WHERE student_id = " + sRemoveID.getText() + ";");
					mysql.doQuery("UPDATE books SET owner = null WHERE owner = " + sRemoveID.getText() + ";");
				} else {
					System.out.println("No such students fit given parameters");
				}
				
			} else if (e.getSource() == editStudentEnter) {
				
				if (mysql.multiColumnQuery("SELECT * FROM students WHERE student_id = " + editIDValue.getText() + ";") != null) {
					
					if (!editNameValue.getText().isBlank()) 
						mysql.doQuery("UPDATE students SET name = '" + editNameValue.getText() + "' WHERE student_id = " + editIDValue.getText() + ";");
					
					if (editAgeValue.getText() != "")
						mysql.doQuery("UPDATE students SET age = " + editAgeValue.getText() + " WHERE student_id = " + editIDValue.getText() + ";");
					
					if (editGradeValue.getText() != "")
						mysql.doQuery("UPDATE students SET grade = " + editGradeValue.getText() + " WHERE student_id = " + editIDValue.getText() + ";");
				
				} else {
					System.out.println("Student cannot be edited as student does not exist with given ID");
				}
				
			} else if (e.getSource() == assignBookEnter) {
				
				if (mysql.singleResQuery("SELECT owner FROM books WHERE book_id = " + assignBookID.getText() + ";") == null) {
					mysql.doQuery("UPDATE books SET owner = " + assignStudentID.getText() + " WHERE book_id = " + assignBookID.getText() + ";");
					
					int k = 1;
					while (k <= 6 && mysql.singleResQuery("SELECT book" + k + " FROM students WHERE student_id = " + assignStudentID.getText() + ";") != null) {
						k++;
					}
					if (k == 7) {
						System.out.println("Student already has 6 books, that is the maximum.");
					} else {
						mysql.doQuery("UPDATE students SET book" + k + " = " + assignBookID.getText() + " WHERE student_id = " + assignStudentID.getText() + ";");
					}
					
				} else {
					System.out.println("The book is owned by anoother student");
				}
			
			} else if (e.getSource() == helpHome) {
				
				homeFrame.setVisible(true);
				helpFrame.setVisible(false);	
			
			} else {	
				homeFrame.setVisible(true);
				sViewAllFrame.setVisible(false);
				bViewAllFrame.setVisible(false);
				sAddFrame.setVisible(false);
				bAddFrame.setVisible(false);
				sRemoveFrame.setVisible(false);
				editStudentFrame.setVisible(false);
				assignBookFrame.setVisible(false);
				helpFrame.setVisible(false);
			}
			
			
			if (e.getSource() == sViewAllHome || e.getSource() == bViewAllHome || e.getSource() == sAddEnter || e.getSource() == bAddEnter || e.getSource() == sRemoveEnter || e.getSource() == editStudentEnter || e.getSource() == assignBookEnter || e.getSource() == helpHome) {
				homeFrame.setVisible(true);
				sViewAllFrame.setVisible(false);
				bViewAllFrame.setVisible(false);
				sAddFrame.setVisible(false);
				bAddFrame.setVisible(false);
				sRemoveFrame.setVisible(false);
				editStudentFrame.setVisible(false);
				assignBookFrame.setVisible(false);
				helpFrame.setVisible(false);
			}
		}
	}
	
	
	//Creates and formats home screen
	public void createHomeScreen() {
		homePanel.setLayout(new BorderLayout());
		
		homeLabel.setEditable(false);
		homeLabel.setHorizontalAlignment(JTextField.CENTER);
		homePanel.add(homeLabel, BorderLayout.PAGE_START);
		
		centerPanel.setLayout(new GridLayout(0, 2));
		
		viewAllStudents.addActionListener(new ButtonEvent());
		addStudent.addActionListener(new ButtonEvent());
		removeStudent.addActionListener(new ButtonEvent());
		editStudent.addActionListener(new ButtonEvent());
		
		viewAllBooks.addActionListener(new ButtonEvent());
		addBook.addActionListener(new ButtonEvent());
		assignBook.addActionListener(new ButtonEvent());

		help.addActionListener(new ButtonEvent());
		
		centerPanel.add(viewAllStudents);
		centerPanel.add(viewAllBooks);
		centerPanel.add(addStudent);
		centerPanel.add(addBook);
		centerPanel.add(removeStudent);
		centerPanel.add(assignBook);
		centerPanel.add(editStudent);
		centerPanel.add(help);
		
		homePanel.add(centerPanel, BorderLayout.CENTER);
		
		homeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		homeFrame.add(homePanel);	
		homeFrame.setSize(350, 250);
	}

	
	//Creates and formats student viewing screen
	public void createSViewAllScreen() {
		
		sViewAllFrame.remove(sViewAllPanel);
		
		sViewAllPanel.setLayout(new BorderLayout());
		
		sViewAllLabel.setEditable(false);
		sViewAllPanel.add(sViewAllLabel, BorderLayout.PAGE_START);
		
		sViewAllGrid.setLayout(new GridLayout(0, 10));
		sViewAllGrid.removeAll();
		
		JTextField stuID = new JTextField("Student ID");
		stuID.setEditable(false);
		sViewAllGrid.add(stuID);
		JTextField name = new JTextField("Name");
		name.setEditable(false);
		sViewAllGrid.add(name);
		JTextField age = new JTextField("Age");
		age.setEditable(false);
		sViewAllGrid.add(age);
		JTextField grade = new JTextField("Grade");
		grade.setEditable(false);
		sViewAllGrid.add(grade);
		JTextField book1 = new JTextField("Book 1");
		book1.setEditable(false);
		sViewAllGrid.add(book1);
		JTextField book2 = new JTextField("Book 2");
		book2.setEditable(false);
		sViewAllGrid.add(book2);
		JTextField book3 = new JTextField("Book 3");
		book3.setEditable(false);
		sViewAllGrid.add(book3);
		JTextField book4 = new JTextField("Book 4");
		book4.setEditable(false);
		sViewAllGrid.add(book4);
		JTextField book5 = new JTextField("Book 5");
		book5.setEditable(false);
		sViewAllGrid.add(book5);
		JTextField book6 = new JTextField("Book 6");
		book6.setEditable(false);
		sViewAllGrid.add(book6);
		
		ArrayList<ArrayList<Object>> results = mysql.multiColumnQuery("SELECT * FROM students;", "student_id", "name", "age", "grade", "book1", "book2", "book3", "book4", "book5", "book6");
		for (ArrayList<Object> arr : results) {
			for (Object o : arr) {
				JTextField field;
				if (o == null) {
					field = new JTextField("");
				} else {
					field = new JTextField(o.toString());
				}
				field.setEditable(false);
				sViewAllGrid.add(field);
			}
		}
		sViewAllPanel.add(sViewAllGrid, BorderLayout.CENTER);
		
		sViewAllHome.addActionListener(new ButtonEvent());
		sViewAllPanel.add(sViewAllHome, BorderLayout.PAGE_END);
		
		sViewAllFrame.setSize(new Dimension(1300, 600));
		sViewAllFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sViewAllFrame.add(sViewAllPanel);
		sViewAllFrame.setVisible(true);
	}
	
	
	//Creates and formats book viewing screen
	public void createBViewAllScreen() {
		
		bViewAllFrame.remove(bViewAllPanel);
		
		bViewAllPanel.setLayout(new BorderLayout());
		
		bViewAllLabel.setEditable(false);
		bViewAllPanel.add(bViewAllLabel, BorderLayout.PAGE_START);
	
		bViewAllGrid.setLayout(new GridLayout(0, 4));
		bViewAllGrid.removeAll();
		
		JTextField bookID = new JTextField("Book ID");
		bookID.setEditable(false);
		bViewAllGrid.add(bookID);
		JTextField title = new JTextField("Title");
		title.setEditable(false);
		bViewAllGrid.add(title);
		JTextField author = new JTextField("Author");
		author.setEditable(false);
		bViewAllGrid.add(author);
		JTextField ownerId = new JTextField("Owner ID");
		ownerId.setEditable(false);
		bViewAllGrid.add(ownerId);
		
		ArrayList<ArrayList<Object>> results = mysql.multiColumnQuery("SELECT * FROM books;", "book_id", "title", "author", "owner");
		for (ArrayList<Object> arr : results) {
			for (Object o : arr) {
				JTextField field;
				if (o == null) {
					field = new JTextField("");
				} else {
					field = new JTextField(o.toString());
				}
				field.setEditable(false);
				bViewAllGrid.add(field);
			}
		}
		bViewAllPanel.add(bViewAllGrid, BorderLayout.CENTER);
		
		bViewAllHome.addActionListener(new ButtonEvent());
		bViewAllPanel.add(bViewAllHome, BorderLayout.PAGE_END);
		
		bViewAllFrame.setSize(new Dimension(1000, 600));
		bViewAllFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		bViewAllFrame.add(bViewAllPanel);
		bViewAllFrame.setVisible(true);
	}


	//Creates and formats student adding screen
	public void createSAddScreen() {
	
		
		sAddIDLabel.setEditable(false);
		sAddNameLabel.setEditable(false);
		sAddAgeLabel.setEditable(false);
		sAddGradeLabel.setEditable(false);
		JPanel sAddInputs = new JPanel();
		
		sAddPanel.setLayout(new BorderLayout());
		sAddPanel.add(sAddLabel, BorderLayout.PAGE_START);
		sAddInputs.setLayout(new GridLayout(0, 2, 0, 5));
		
		sAddInputs.add(sAddIDLabel);
		sAddInputs.add(sAddStudentID);
		sAddInputs.add(sAddNameLabel);
		sAddInputs.add(sAddName);
		sAddInputs.add(sAddAgeLabel);
		sAddInputs.add(sAddAge);
		sAddInputs.add(sAddGradeLabel);
		sAddInputs.add(sAddGrade);
		
		sAddPanel.add(sAddInputs, BorderLayout.CENTER);
		
		sAddEnter.addActionListener(new ButtonEvent());
		sAddPanel.add(sAddEnter, BorderLayout.PAGE_END);
		
		sAddFrame.setSize(350, 250);
		sAddFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sAddFrame.add(sAddPanel);
		sAddFrame.setVisible(true);
	}
	
	
	//Creates and formats book adding screen
	public void createBAddScreen() {
		
		bAddIDLabel.setEditable(false);
		bAddTitleLabel.setEditable(false);
		bAddAuthorLabel.setEditable(false);
		
		bAddPanel.setLayout(new BorderLayout());
		bAddPanel.add(bAddLabel, BorderLayout.PAGE_START);
		bAddInputs.setLayout(new GridLayout(0, 2, 0, 5));
		
		bAddInputs.add(bAddIDLabel);
		bAddInputs.add(bAddBookID);
		bAddInputs.add(bAddTitleLabel);
		bAddInputs.add(bAddTitle);
		bAddInputs.add(bAddAuthorLabel);
		bAddInputs.add(bAddAuthor);
		
		bAddPanel.add(bAddInputs, BorderLayout.CENTER);
		
		bAddEnter.addActionListener(new ButtonEvent());
		bAddPanel.add(bAddEnter, BorderLayout.PAGE_END);
		
		bAddFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		bAddFrame.add(bAddPanel);
		bAddFrame.setSize(350, 250);
		bAddFrame.setVisible(true);
	}

	 
	//Creates and formats student removal screen
	public void createSRemoveScreen() {
		
		sRemoveLabel.setEditable(false);
		
		sRemovePanel.setLayout(new BoxLayout(sRemovePanel, BoxLayout.Y_AXIS));
		
		sRemovePanel.add(sRemoveLabel);
		sRemovePanel.add(Box.createRigidArea(d));
		sRemovePanel.add(sRemoveID);
		sRemovePanel.add(Box.createRigidArea(d));
		sRemovePanel.add(sRemoveEnter);
		sRemovePanel.add(Box.createRigidArea(d));
		sRemovePanel.setVisible(true);
		
		sRemoveEnter.addActionListener(new ButtonEvent());
		sRemoveFrame.add(sRemovePanel);
		sRemoveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sRemoveFrame.setSize(350, 250);
		sRemoveFrame.setVisible(true);
	}
	
	
	//Creates and formats student editing screen
	public void createEditStudentScreen() {
		
		editStudentLabel.setEditable(false);
		editStudentID.setEditable(false);
		editName.setEditable(false);
		editAge.setEditable(false);
		editGrade.setEditable(false);
		
		editStudentPanel.setLayout(new BorderLayout());
		editStudentPanel.add(editStudentLabel, BorderLayout.PAGE_START);
		
		editStudentGrid.setLayout(new GridLayout(0, 2));
		
		editStudentGrid.add(editStudentID);
		editStudentGrid.add(editIDValue);
		editStudentGrid.add(editName);
		editStudentGrid.add(editNameValue);
		editStudentGrid.add(editAge);
		editStudentGrid.add(editAgeValue);
		editStudentGrid.add(editGrade);
		editStudentGrid.add(editGradeValue);
		
		editStudentPanel.add(editStudentGrid, BorderLayout.CENTER);
		
		editStudentEnter.addActionListener(new ButtonEvent());
		editStudentPanel.add(editStudentEnter, BorderLayout.PAGE_END);
		
		editStudentFrame.add(editStudentPanel);
		editStudentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		editStudentFrame.setSize(350, 250);
		editStudentFrame.setVisible(true);
	}
	
	
	//Creates and formats book assignment screen
	public void createAssignBookScreen() {
		

		
		assignBookEnter.addActionListener(new ButtonEvent());
		
		assignBookPanel.setLayout(new BoxLayout(assignBookPanel, BoxLayout.Y_AXIS));
		
		assignBookPanel.add(assignBookLabel);
		assignBookPanel.add(Box.createRigidArea(d));
		assignBookPanel.add(assignBookIDLabel);
		assignBookPanel.add(assignBookID);
		assignBookPanel.add(Box.createRigidArea(d));
		assignBookPanel.add(assignStudentIDLabel);
		assignBookPanel.add(assignStudentID);
		assignBookPanel.add(Box.createRigidArea(d));
		assignBookPanel.add(assignBookEnter);
		
		assignBookFrame.add(assignBookPanel);
		assignBookFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		assignBookFrame.setSize(350, 250);
		assignBookFrame.setVisible(true);
	}
	
	
	//Creates help screen
	public void createHelpScreen() {
		helpPanel.setLayout(new BoxLayout(helpPanel, BoxLayout.Y_AXIS));
		helpPanel.add(helpText1);
		helpPanel.add(helpText2);
		helpPanel.add(helpText3);
		helpPanel.add(helpText4);
		helpPanel.add(helpText5);
		helpPanel.add(helpText6);
		helpPanel.add(helpText7);
		helpPanel.add(helpHome);
		
		helpHome.addActionListener(new ButtonEvent());
		
		helpFrame.add(helpPanel);
		helpFrame.setSize(350, 250);
		helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		helpFrame.setVisible(true);
	}
}