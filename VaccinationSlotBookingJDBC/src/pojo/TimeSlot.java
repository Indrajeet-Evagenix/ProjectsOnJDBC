package pojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TimeSlot {

	PreparedStatement pst;
	Scanner sc = new Scanner(System.in);

	void addcenterDetails(Connection conn) {
		System.out.println("Enter Slot Time Details: ");
		System.out.println("Enter Slot ID: ");
		int sId = sc.nextInt();
		System.out.println("Enter Slot Details: ");
		String slot = sc.next();

		try {
			pst = conn.prepareStatement("insert into timeslot values(?,?)");
			pst.setInt(1, sId);
			pst.setString(2, slot);

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
