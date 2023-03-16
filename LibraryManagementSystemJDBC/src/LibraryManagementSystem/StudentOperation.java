package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentOperation {
	Scanner sc = new Scanner(System.in);
	PreparedStatement stmt;

	void insertStudentData(Connection conn) {
		System.out.println("Enter Student Details");
		System.out.println("Enter The Student Id");
		int id = sc.nextInt();
		System.out.println("Enter Student Name");
		String name = sc.next();
		System.out.println("Enter Student Email");
		String email = sc.next();
		System.out.println("Enter Student Contact Number");
		String contact = sc.next();
		System.out.println("Enter Student Department Name");
		String deptName = sc.next();
		System.out.println("Enter Student Age");
		int age = sc.nextInt();

		try {
			stmt = conn.prepareStatement("insert into studentinfo values(?,?,?,?,?,?)");
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, email);
			stmt.setString(4, contact);
			stmt.setString(5, deptName);
			stmt.setInt(6, age);

			int i = stmt.executeUpdate();
			if (i != 0) {
				System.out.println("Student Record Inserted Successfully");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void displayTable(Connection conn) {
		try {
			stmt = conn.prepareStatement("show tables");
			ResultSet rs = stmt.executeQuery();
			System.out.println("Name of Tables in Database");
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void displayStudentRecord(Connection conn) {
		try {
			stmt = conn.prepareStatement("select * from studentinfo");
			ResultSet rs = stmt.executeQuery();
			System.out.println("Student_ID\t" + "Student_Name\t" + "Student_Email\t\t" + "Student_Contact\t"
					+ "Student_Department\t" + "Student_Age\t");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString("student_email")
						+ "\t\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t\t" + rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void updateStudentEmail(Connection conn) {

		System.out.println("Enter Student Id");
		int id = sc.nextInt();
		System.out.println("Enter Student Email");
		String email = sc.next();

		try {
			stmt = conn.prepareStatement("update studentinfo set student_email=? where student_id=?");
			stmt.setString(1, email);
			stmt.setInt(2, id);

			int i = stmt.executeUpdate();
			if (i != 0) {
				System.out.println("Student Email Updated Successfully");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void updateStudentContact(Connection conn) {

		System.out.println("Enter Student Id");
		int id = sc.nextInt();
		System.out.println("Enter Student Contact");
		String contact = sc.next();

		try {
			stmt = conn.prepareStatement("update studentinfo set student_contact=? where student_id=?");
			stmt.setString(1, contact);
			stmt.setInt(2, id);

			int i = stmt.executeUpdate();
			if (i != 0) {
				System.out.println("Student Email Updated Successfully");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void deleteStudentRecord(Connection conn) {

		System.out.println("Enter Student Id");
		int id = sc.nextInt();

		try {
			stmt = conn.prepareStatement("delete from studentinfo where student_id=?");
			stmt.setInt(1, id);

			int i = stmt.executeUpdate();
			if (i != 0) {
				System.out.println("Student Record Deleted Successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void searchStudentByID(Connection conn) {

		System.out.println("Enter Student Id");
		int id = sc.nextInt();

		try {
			stmt = conn.prepareStatement("select * from studentinfo where student_id=?");
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			System.out.println("Student_ID\t" + "Student_Name\t" + "Student_Email\t\t" + "Student_Contact\t"
					+ "Student_Department\t" + "Student_Age\t");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString("student_email")
						+ "\t\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t\t" + rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void searchStudentByEmail(Connection conn) {

		System.out.println("Enter Student Email");
		String email = sc.next();

		try {
			stmt = conn.prepareStatement("select * from studentinfo where student_email=?");
			stmt.setString(1, email);

			ResultSet rs = stmt.executeQuery();
			System.out.println("Student_ID\t" + "Student_Name\t" + "Student_Email\t\t" + "Student_Contact\t"
					+ "Student_Department\t" + "Student_Age\t");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString("student_email")
						+ "\t\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t\t" + rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
