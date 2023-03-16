package LibraryManagementSystem;

import java.sql.Connection;
import java.util.Scanner;

public class LibraryMain {

	static boolean order = true;

	public static void menuStudent() {
		System.out.println("------------Welcome to The Library Management System------------");
		System.out.println("1. Add Student Record" + "\n2. Search Student" + "\n3. Update Student Record"
				+ "\n4. Delete Student Record" + "\n5. View All Student Record" + "\n6. Exit");
	}

	public static void menuBook() {
		System.out.println("------------Welcome to The Library Management System------------");
		System.out.println("1. Add Book Record" + "\n2. Search Book" + "\n3. Update Book Record"
				+ "\n4. Delete Book Record" + "\n5. View All Book Record" + "\n6. Exit");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = LMSDBConnection.getConnection("librarymanagementsystem");
		StudentOperation sop = new StudentOperation();
		BookOperation bop = new BookOperation();
//		sop.displayTable(conn);
//		System.out.println("Enter The Table Name to Perform Operation: student/book");
//		String table = sc.next();

		System.out.println("Press 1. For Perform Student Operation");
		System.out.println("Press 2. For Perform Book Operation");
		int num2 = sc.nextInt();
		
		switch (num2) {
		case 1:
			do {
				menuStudent();
				System.out.println("Enter Your Choice");
				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					sop.insertStudentData(conn);
					break;
				case 2:
					System.out.println("Press 1. For Search By Email");
					System.out.println("Press 2. For Search By ID");
					int num1 = sc.nextInt();
					switch (num1) {
					case 1:
						sop.searchStudentByEmail(conn);
						break;
					case 2:
						sop.searchStudentByID(conn);
						break;
					}
					break;
				case 3:
					System.out.println("Press 1. For Email Update");
					System.out.println("Press 2. For Contact Update");
					int num = sc.nextInt();
					switch (num) {
					case 1:
						sop.updateStudentEmail(conn);
						break;
					case 2:
						sop.updateStudentContact(conn);
						break;
					}
					break;
				case 4:
					sop.deleteStudentRecord(conn);
					break;
				case 5:
					sop.displayStudentRecord(conn);
					break;
				case 6:
					System.out.println("Thank You For Choosing Our Application");
					System.exit(0);
					break;
				default:
					System.out.println("Please Enter Valid Choice");
					break;
				}

			} while (order);
			break;
		case 2:
			do {
				menuBook();
				System.out.println("Enter Your Choice");
				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					bop.insertBookData(conn);
					break;
				case 2:
					bop.searchBookByID(conn);
					break;
				case 3:
					bop.updateBookDetails(conn);
					break;
				case 4:
					bop.deleteBookRecord(conn);
					break;
				case 5:
					bop.displayBookRecord(conn);
					break;
				case 6:
					System.out.println("Thank You For Choosing Our Application");
					System.exit(0);
					break;
				default:
					System.out.println("Please Enter Valid Choice");
					break;
				}

			} while (order);
			break;
		default:
			System.out.println("Please Enter Valid Choice");
			break;
		}

	}

}
