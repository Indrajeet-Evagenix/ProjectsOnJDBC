package pojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CityDetails {

	PreparedStatement pst;
	Scanner sc = new Scanner(System.in);

	void addcityDetails(Connection conn) {
		System.out.println("Enter City Details: ");
		System.out.println("Enter City ID: ");
		int cId = sc.nextInt();
		System.out.println("Enter City Name: ");
		String cName = sc.next();

		try {
			pst = conn.prepareStatement("insert into city values(?,?)");
			pst.setInt(1, cId);
			pst.setString(2, cName);

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
