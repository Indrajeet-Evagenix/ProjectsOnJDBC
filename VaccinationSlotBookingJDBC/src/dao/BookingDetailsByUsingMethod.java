package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BookingDetailsByUsingMethod {

	int cid, centerId, vId, tId;
	String centerName = "", first, last, cityName;
	String timeSlot = "";
	String vaccinationName = "", adhar, booking_date, firstDate, secondDate;
	PreparedStatement pst;
	ResultSet rs;
	Scanner sc = new Scanner(System.in);

	public void bookingDate(Connection conn) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		booking_date = formatter.format(date);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Enter The Date:(yyyy-mm-dd) Format: ");
		firstDate = sc.next();
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = sdf.parse(firstDate);
			date2 = sdf.parse(booking_date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (date1.compareTo(date2) > 0) {
			callCity(conn);
			callCenter(conn);
			callTimeSlot(conn);
			callVaccinationDetails(conn);
			callPersonDetails(conn);
			secondDoseDate();
			callBookingDetails(conn);
			displayBookingInfo(conn);
		} else {
			System.out.println("Invalid Booking Date");
		}
	}

	public void callCity(Connection conn) {

		System.out.println("Select City From Below:");

		try {
			pst = conn.prepareStatement("select * from city");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\nEnter City Name: ");
		cityName = sc.next();

		try {
			pst = conn.prepareStatement("select city_id from city where city_name like ?");
			pst.setString(1, cityName);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				cid = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void callCenter(Connection conn) {
		try {
			pst = conn.prepareStatement("select center_id,center_name from vaccinationcenter where city_id=?");
			pst.setInt(1, cid);
			rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));

			}

			System.out.println("Enter Center Id: ");
			centerId = sc.nextInt();
			pst = conn.prepareStatement("select center_name from vaccinationcenter where center_id=?");
			pst.setInt(1, centerId);

			rs = pst.executeQuery();
			while (rs.next()) {
				centerName = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void callTimeSlot(Connection conn) {
		try {
			pst = conn.prepareStatement("select * from timeslot");
			rs = pst.executeQuery();
			System.out.println("Choose any one time slot from below table");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
			}

			System.out.println("Enter Time Slot Id Which You Want to Book");
			tId = sc.nextInt();
			pst = conn.prepareStatement("select slot_time from timeslot where slot_id=?");
			pst.setInt(1, tId);
			rs = pst.executeQuery();
			while (rs.next()) {
				timeSlot = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void callVaccinationDetails(Connection conn) {
		try {
			pst = conn.prepareStatement("select * from vaccinationdetails");
			rs = pst.executeQuery();
			System.out.println("Choose any one below table");
			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
			}

			System.out.println("Enter Vaccination Id Which You Want to Book");
			vId = sc.nextInt();
			pst = conn.prepareStatement("select vccination_name from vaccinationdetails where vaccination_id=?");
			pst.setInt(1, vId);
			rs = pst.executeQuery();
			while (rs.next()) {
				vaccinationName = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void callPersonDetails(Connection conn) {

		try {
			System.out.println("Enter Person Details");
			System.out.println("Enter First Name: ");
			first = sc.next();
			System.out.println("Enter Last Name: ");
			last = sc.next();
			System.out.println("Enter Adhar Number: ");
			adhar = sc.next();
			System.out.println("Enter DOB in 'yyyy-mm-dd'");
			String dob = sc.next();
			System.out.println("Enter Contact Number");
			String contact = sc.next();
			System.out.println("Email ID: ");
			String email = sc.next();

			pst = conn.prepareStatement("insert into persondetails values(?,?,?,?,?,?)");

			pst.setString(1, adhar);
			pst.setString(2, first);
			pst.setString(3, last);
			pst.setString(4, dob);
			pst.setString(5, contact);
			pst.setString(6, email);

			int i = pst.executeUpdate();
			if (i != 0) {
				System.out.println("Record Inserted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void secondDoseDate() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

		// create instance of the Calendar class and set the date to the given date
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf1.parse(firstDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// use add() method to add the days to the given date
		cal.add(Calendar.DAY_OF_MONTH, 60);
		secondDate = sdf1.format(cal.getTime());
	}

	public void callBookingDetails(Connection conn) {

		try {
			pst = conn.prepareStatement("insert into bookingdetails(adhar_number,center_id,"
					+ "vaccination_id,booking_date,slot_id,first_dose_date,"
					+ "second_dose_date) values(?,?,?,?,?,?,?)");

			pst.setString(1, adhar);
			pst.setInt(2, centerId);
			pst.setInt(3, vId);
			pst.setString(4, booking_date);
			pst.setInt(5, tId);
			pst.setString(6, firstDate);
			pst.setString(7, secondDate);

			int num = pst.executeUpdate();
			if (num != 0) {
//				System.out.println("Record Inserted");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void displayBookingInfo(Connection conn) {
		System.out.println("\nThank You " + first + " " + last + " Your Vaccination Details are as Follows:");
		System.out.println("City Name: " + cityName);
		System.out.println("Center Name: " + centerName);
		System.out.println("Vaccination Name: " + vaccinationName);
		System.out.println("First Dose: " + firstDate + " Time: " + timeSlot);
		System.out.println("Second Dose: (On or After): " + secondDate);
	}

}
