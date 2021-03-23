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
	
	public void newContact(String fname) {
		Contact c = new Contact(newUserID(), fname);
		contactList.add(c);
	}
	
	public void newContact(String fname,String lname) {
		Contact c = new Contact(newUserID(), fname, lname);
		contactList.add(c);
	}
	
	public void newContact(String fname,String lname, String phonenum) {
		Contact c = new Contact(newUserID(), fname, lname, phonenum);
		contactList.add(c);
	}
	
	public void newContact(String fname,String lname, String phonenum, String address) {
		Contact c = new Contact(newUserID(), fname, lname, phonenum, address);
		contactList.add(c);
	}
	private Contact searchContact(String id) throws Exception{
		int i = 0;
		while (i < contactList.size()) {
			if (id.equals(contactList.get(i).getContactID())) {
				return contactList.get(i);
			}
			i++;
		}
		throw new Exception("Woops...Something went wrong.");
	}
	public void delContact(String id) throws Exception{
		contactList.remove(searchContact(id));
	}
	
	public void updateFirstName(String id, String fname) throws Exception{
		searchContact(id).updateFirstName(fname);
	}
	
	public void updateLastName(String id, String lname) throws Exception{
		searchContact(id).updateLastName(lname);
	}
	
	public void updatePhoneNum(String id, String pnum) throws Exception{
		searchContact(id).updatePhoneNumber(pnum);
	}
	
	public void updateAddress(String id, String address) throws Exception{
		searchContact(id).updateAddress(address);
	}
	
	protected List<Contact> getContactList(){
		return contactList;
	}
}
