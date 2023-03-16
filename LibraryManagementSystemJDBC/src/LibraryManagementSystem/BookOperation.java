package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookOperation {

	Scanner sc = new Scanner(System.in);
	PreparedStatement stmt;

	void insertBookData(Connection conn) {
		System.out.println("Enter Book Details");
		System.out.println("Enter The Book Id");
		int id = sc.nextInt();
		System.out.println("Enter Book Name");
		String name = sc.next();
		System.out.println("Enter Pulish Date");
		String date = sc.next();
		System.out.println("Enter Book Quentity");
		int qnt = sc.nextInt();

		try {
			stmt = conn.prepareStatement("insert into bookinfo values(?,?,?,?)");
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, date);
			stmt.setInt(4, qnt);

			int i = stmt.executeUpdate();
			if (i != 0) {
				System.out.println("Book Record Inserted Successfully");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void displayBookRecord(Connection conn) {
		try {
			stmt = conn.prepareStatement("select * from bookinfo");
			ResultSet rs = stmt.executeQuery();
			System.out.println("Book_ID\t\t" + "Book_Name\t\t" + "Publish_Date\t\t" 
			+ "Book_Quentity\t\t");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + "\t" 
			+ rs.getString(3) + "\t\t"+ rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void updateBookDetails(Connection conn) {

		System.out.println("Enter Book Id");
		int id = sc.nextInt();
		System.out.println("Enter Book Quentity");
		int qnt = sc.nextInt();

		try {
			stmt = conn.prepareStatement("update bookinfo set book_quentity=? where book_id=?");
			stmt.setInt(1, qnt);
			stmt.setInt(2, id);

			int i = stmt.executeUpdate();
			if (i != 0) {
				System.out.println("Book Quentity Updated Successfully");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void deleteBookRecord(Connection conn) {

		System.out.println("Enter Book Id");
		int id = sc.nextInt();

		try {
			stmt = conn.prepareStatement("delete from bookinfo where book_id=?");
			stmt.setInt(1, id);

			int i = stmt.executeUpdate();
			if (i != 0) {
				System.out.println("Book Record Deleted Successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void searchBookByID(Connection conn) {

		System.out.println("Enter Book Id");
		int id = sc.nextInt();

		try {
			stmt = conn.prepareStatement("select * from bookinfo where book_id=?");
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			System.out.println("Book_ID\t\t" + "Book_Name\t\t" + "Publish_Date\t\t" 
					+ "Book_Quentity\t\t");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + "\t" + rs.getString(3) + "\t\t"
						+ rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
