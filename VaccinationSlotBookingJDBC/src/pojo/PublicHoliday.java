package pojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PublicHoliday {

	PreparedStatement pst;
	Scanner sc = new Scanner(System.in);

	void addPersonDetails(Connection conn) {
		System.out.println("Enter Public Holiday Details");
		System.out.println("Enter Holiday ID: ");
		int id = sc.nextInt();
		System.out.println("Enter Holiday Name: ");
		String name = sc.next();
		System.out.println("Enter Holiday Date in 'yyyy-mm-dd' ");
		String date = sc.next();

		try {
			pst = conn.prepareStatement("insert into publicholiday values(?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, date);

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
