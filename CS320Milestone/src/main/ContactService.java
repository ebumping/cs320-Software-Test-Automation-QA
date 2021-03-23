package main;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {
	//I don't know why this is throwing this warning
	private List<Contact> contactList = new Arraylist<>();
	private String userID;
	
	{userID = UUID.randomUUID().toString().substring(
			0, Math.min(toString().length(), 10));}
	
	private String newUserID() {
		return userID = UUID.randomUUID().toString().substring(
				0, Math.min(toString().length(), 10));
				
	}
	
	public void newContact() {
		Contact c = new Contact(newUserID());
		contactList.add(c);
	}
}
