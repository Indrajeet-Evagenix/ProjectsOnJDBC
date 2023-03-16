package pojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class VaccinationDetails {

	PreparedStatement pst;
	Scanner sc = new Scanner(System.in);

	void addVaccinationDetails(Connection conn) {
		System.out.println("Enter Vaccination Details");
		System.out.println("Enter Vaccination ID: ");
		int id = sc.nextInt();
		System.out.println("Enter Vaccination Name: ");
		String name = sc.next();
		System.out.println("Enter Vaccination Type: ");
		String type = sc.next();
		System.out.println("Enter Vaccination Price'");
		int price = sc.nextInt();
		System.out.println("Enter Vaccination Company Name");
		String company = sc.next();

		try {
			pst = conn.prepareStatement("insert into vaccinationdetails values(?,?,?,?,?)");

			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, type);
			pst.setInt(4, price);
			pst.setString(5, company);

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
