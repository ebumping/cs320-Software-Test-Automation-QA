package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.AppointmentService;

import java.util.Date;
import java.util.Calendar;
import org.junit.jupiter.api.BeforeEach;



class AppointmentServiceTest {
	private String id, description, longDescription;
	private Date date, pastDate;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setup() {
		id = "0987654321";
		description = "This is an appropriate description";
		date = new Date(2077, Calendar.MARCH, 21);
		longDescription = "The description field cannot be null and also cannot be greater than 50 "
				+ "characters long";
		pastDate = new Date(0);
	}
	
	@Test
	void testNewAppointment() {
		AppointmentService as = new AppointmentService();
		
		as.newAppointment();
		assertNotNull(as.getAppointmentList().get(0).getAppointmentID());
		assertNotNull(as.getAppointmentList().get(0).getAppointmentDate());
		assertNotNull(as.getAppointmentList().get(0).getDescription());
		
		as.newAppointment(date);
		assertNotNull(as.getAppointmentList().get(1).getAppointmentID());
		assertEquals(date, as.getAppointmentList().get(1).getAppointmentDate());
		assertNotNull(as.getAppointmentList().get(1).getDescription());
		
		as.newAppointment(date, description);
		assertNotNull(as.getAppointmentList().get(2).getAppointmentID());
		assertEquals(date, 
					 as.getAppointmentList().get(2).getAppointmentDate());
		assertEquals(description,
					 as.getAppointmentList().get(2).getDescription());
		
		//tests for redundancy
		assertNotEquals(as.getAppointmentList().get(0).getAppointmentID(),
						as.getAppointmentList().get(1).getAppointmentID());
		assertNotEquals(as.getAppointmentList().get(0).getAppointmentID(),
				as.getAppointmentList().get(2).getAppointmentID());
		assertNotEquals(as.getAppointmentList().get(1).getAppointmentID(),
				as.getAppointmentList().get(2).getAppointmentID());
		
		assertThrows(IllegalArgumentException.class,
					 () -> as.newAppointment(pastDate));
		assertThrows(IllegalArgumentException.class,
					 () -> as.newAppointment(date, longDescription));
		
	}
	
	@Test
	void delAppointment() throws Exception{
		AppointmentService as = new AppointmentService();
		
		as.newAppointment();
		as.newAppointment();
		as.newAppointment();
		
		String firstID = as.getAppointmentList().get(0).getAppointmentID();
		String secondID = as.getAppointmentList().get(1).getAppointmentID();
		String thirdID = as.getAppointmentList().get(2).getAppointmentID();
		
		assertNotEquals(firstID,secondID);
		assertNotEquals(firstID,thirdID);
		assertNotEquals(secondID,thirdID);
		assertNotEquals(id, firstID);
		assertNotEquals(id, secondID);
		assertNotEquals(id, thirdID);
		
		assertThrows(Exception.class, () -> as.delAppointment(id));
		
		as.delAppointment(firstID);
		assertThrows(Exception.class, () -> as.delAppointment(firstID));
		assertNotEquals(firstID, 
					as.getAppointmentList().get(0).getAppointmentID());
	}

}
