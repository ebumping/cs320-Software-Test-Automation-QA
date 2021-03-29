package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.Calendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Appointment;


class AppointmentTest {
	private String id, description;
	private String longID, longDescription;
	private Date date, pastDate;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setup() {
		id = "0987654321";
		description = "This is an appropriate description";
		date = new Date(2077, Calendar.MARCH, 21);
		longID = "0987654321234567890";
		longDescription = "The description field cannot be null and also cannot be greater than 50 "
				+ "characters long";
		pastDate = new Date(0);
	}
	
	@Test
	void updateAppointmentIDtest() {
		Appointment apt = new Appointment();
		assertThrows(IllegalArgumentException.class,
				() -> apt.updateAppointmentID(null));
		assertThrows(IllegalArgumentException.class,
				() -> apt.updateAppointmentID(longID));
		apt.updateAppointmentID(id);
		assertEquals(id, apt.getAppointmentID());
	}
	
	@Test
	void getAppointmentIDtest(){
		Appointment apt = new Appointment(id);
		assertNotNull(apt.getAppointmentID());
		assertEquals(apt.getAppointmentID().length(), 10);
		assertEquals(id, apt.getAppointmentID());
	}
	
	@Test
	void updateDateTest() {
		Appointment apt = new Appointment();
		assertThrows(IllegalArgumentException.class, 
					() -> apt.updateDate(null));
		assertThrows(IllegalArgumentException.class,
					() -> apt.updateDate(pastDate));
		apt.updateDate(date);
		assertEquals(date, apt.getAppointmentDate());	
	}
	
	@Test
	void getAppointmentDateTest() {
		Appointment apt = new Appointment(id, date);
		assertNotNull(apt.getAppointmentDate());
		assertEquals(date, apt.getAppointmentDate());
	}
	
	@Test
	void updateDescriptionTest() {
		Appointment apt = new Appointment();
		assertThrows(IllegalArgumentException.class,
				() -> apt.updateDescription(null));
		assertThrows(IllegalArgumentException.class,
				() -> apt.updateDescription(longDescription));
		apt.updateDescription(description);
		assertEquals(description, apt.getDescription());
	}
	
	@Test
	void getDescriptionTest() {
		Appointment apt = new Appointment(id, date, description);
		assertNotNull(apt.getDescription());
		assertTrue(apt.getDescription().length() <= 50);
		assertEquals(description, apt.getDescription());
	}

}
