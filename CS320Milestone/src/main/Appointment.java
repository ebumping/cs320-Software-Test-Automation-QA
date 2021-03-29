package main;

import java.util.Date;

public class Appointment {
	
	final private byte APPOINTMENT_ID_LEN;
	final private byte APPOINTMENT_DESC_LEN;
	final private String INIT;
	private String appointmentID;
	private Date appointmentDate;
	private String description;
	
	//initialize final vars
	{
		APPOINTMENT_ID_LEN = 10;
		APPOINTMENT_DESC_LEN = 50;
		INIT = "INIT";
	}
	
	//Appointment Constructors
	
	public Appointment(){
		Date d = new Date();
		appointmentID = INIT;
		appointmentDate = d;
		description = INIT;
	}
	
	public Appointment(String id){
		Date d = new Date();
		updateAppointmentID(id);
		appointmentDate = d;
		description = INIT;
	}
	
	public Appointment(String id, Date date){
		Date d = new Date();
		updateAppointmentID(id);
		updateDate(date);
		description = INIT;
	}
	
	public Appointment(String id, Date date, String description){
		Date d = new Date();
		updateAppointmentID(id);
		updateDate(date);
		updateDescription(description);
	}
	
	public void updateAppointmentID(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Appointment ID can't be null");
		} else if (id.length() > APPOINTMENT_ID_LEN) {
			throw new IllegalArgumentException("ID can't be longer than " + 
												APPOINTMENT_ID_LEN +
												" characters");
		} else {
			this.appointmentID = id;
		}
	}
	
	public String getAppointmentID() {
		return appointmentID;
	}
	
	public void updateDate(Date d) {
		if (d == null) {
			throw new IllegalArgumentException("Null date, invalid");
		} else if (d.before(new Date())) {
			throw new IllegalArgumentException("Date has passed");
		} else {
			this.appointmentDate = d;
		}
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void updateDescription(String description) {
		if (description == null) {
			throw new IllegalArgumentException("Null description, invalid");
		}else if (description.length() > APPOINTMENT_DESC_LEN) {
			throw new IllegalArgumentException("Description can't be longer " +
												"than" + APPOINTMENT_DESC_LEN +
												"characters");
		}else {
			this.description = description;
		}
	}
	
	public String getDescription() {
		return description;
	}
	
}