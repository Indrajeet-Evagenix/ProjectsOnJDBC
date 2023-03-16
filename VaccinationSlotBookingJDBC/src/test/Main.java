package test;
import java.sql.Connection;

import dao.BookingDetails;
import dao.BookingDetailsByUsingMethod;

public class Main {

	static void menu() {
		System.out.println("------Welcome to The Vaccination Slot Booking------\n");
	}

	public static void main(String[] args) {
		Connection conn = DBConnection.getConnection("vaccinationproject");

		menu();

		BookingDetails bd=new BookingDetails();
		bd.bookVaccination(conn);

//		BookingDetailsByUsingMethod bdm = new BookingDetailsByUsingMethod();
//		bdm.bookingDate(conn);
//		bdm.callCity(conn);
//		bdm.callCenter(conn);
//		bdm.callTimeSlot(conn);
//		bdm.callVaccinationDetails(conn);
//		bdm.callPersonDetails(conn);
//		bdm.callBookingDetails(conn);
//		bdm.secondDoseDate();
//		bdm.displayBookingInfo(conn);

	}

}
