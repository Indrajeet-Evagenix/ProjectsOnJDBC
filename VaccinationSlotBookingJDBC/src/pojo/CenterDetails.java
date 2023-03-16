package pojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CenterDetails {

	PreparedStatement pst;
	Scanner sc = new Scanner(System.in);

	void addcenterDetails(Connection conn) {
		System.out.println("Enter Center Details: ");
		System.out.println("Enter Center ID: ");
		int cId = sc.nextInt();
		System.out.println("Enter Center Name: ");
		String cName = sc.next();
		System.out.println("Enter City id: ");
		int id = sc.nextInt();

		try {
			pst = conn.prepareStatement("insert into vaccinationcenter values(?,?,?)");
			pst.setInt(1, cId);
			pst.setString(2, cName);
			pst.setInt(3, id);

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
