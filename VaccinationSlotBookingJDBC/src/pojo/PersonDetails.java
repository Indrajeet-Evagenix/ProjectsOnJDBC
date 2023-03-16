package pojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonDetails {

	PreparedStatement pst;
	Scanner sc = new Scanner(System.in);

	void addPersonDetails(Connection conn) {
		System.out.println("Enter Person Details");
		System.out.println("Enter Person ID: ");
		int id = sc.nextInt();
		System.out.println("Enter First Name: ");
		String first = sc.next();
		System.out.println("Enter Last Name: ");
		String last = sc.next();
		System.out.println("Enter Adhar Number: ");
		String adhar = sc.next();
		System.out.println("Enter DOB in 'yyyy-mm-dd'");
		String dob = sc.next();
		System.out.println("Enter Contact Number");
		String contact = sc.next();
		System.out.println("Email ID: ");
		String email = sc.next();
		try {
			pst = conn.prepareStatement("insert into persondetails values(?,?,?,?,?,?,?)");

			pst.setInt(1, id);
			pst.setString(2, first);
			pst.setString(3, last);
			pst.setString(4, adhar);
			pst.setString(5, dob);
			pst.setString(6, contact);
			pst.setString(7, email);

			int i = pst.executeUpdate();
			if (i != 0) {
				System.out.println("Record Inserted");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
