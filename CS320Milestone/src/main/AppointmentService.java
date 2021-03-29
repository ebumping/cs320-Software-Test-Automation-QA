package main;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {
	final private List<Appointment> appointmentList = new ArrayList<>();
	
	private String newUniqueID() {
		return UUID.randomUUID().toString().substring(
				0, Math.min(toString().length(), 10));
	}
	
	public void newAppointment() {
		Appointment apt = new Appointment(newUniqueID());
		appointmentList.add(apt);
	}
	
	public void newAppointment(Date date) {
		Appointment apt = new Appointment(newUniqueID(), date);
		appointmentList.add(apt);
	}
	
	public void newAppointment(Date date, String description) {
		Appointment apt = new Appointment(newUniqueID(), date, description);
		appointmentList.add(apt);
	}
	
	public void delAppointment(String id) throws Exception{
		appointmentList.remove(searchAppointment(id));
	}
	
	public List<Appointment> getAppointmentList(){
		return appointmentList;
	}
	
	private Appointment searchAppointment(String id) throws Exception{
		int i = 0;
		while (i < appointmentList.size()) {
			if(id.equals(appointmentList.get(i).getAppointmentID())) {
				return appointmentList.get(i);
			}
			i++;
		}
		throw new Exception("No appointment found");
	}
}
