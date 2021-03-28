package main;

public class Contact {

	private static final byte CONTACT_ID_LEN = 10;
	private static final int CONTACT_PNUM_LENGTH = 10;
	private static final byte CONTACT_FNAME_LEN = 10;
	private static final byte CONTACT_LNAME_LEN = 10;
	private static final byte CONTACT_ADDRESS_LEN = 30;
	private static final String INIT = "Init";
	private static final String INIT_NUM = "0123456789";
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	public Object getContactID;
	public Object getFirstName;
	//these fixed in test??
	public Contact(){
		this.contactID = INIT;
		this.firstName = INIT;
		this.lastName = INIT;
		this.phoneNumber = INIT_NUM;
		this.address = INIT;
	}
	
	public Contact(String contactID){
		updateContactID(contactID);
		this.firstName = INIT;
		this.lastName = INIT;
		this.phoneNumber = INIT_NUM;
		this.address = INIT;
	}
	
	public Contact(String contactID, String firstName){
		updateContactID(contactID);
		updateFirstName(firstName);
		this.lastName = INIT;
		this.phoneNumber = INIT_NUM;
		this.address = INIT;
	}
	
	public Contact(String contactID, String firstName, String lastName){
		updateContactID(contactID);
		updateFirstName(firstName);
		updateLastName(lastName);
		this.phoneNumber = INIT_NUM;
		this.address = INIT;
	}
	
	public Contact(String contactID, String firstName, String lastName, String phoneNumber){
		updateContactID(contactID);
		updateFirstName(firstName);
		updateLastName(lastName);
		updatePhoneNumber(phoneNumber);
		this.address = INIT;
	}
	
	public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address){
		updateContactID(contactID);
		updateFirstName(firstName);
		updateLastName(lastName);
		updatePhoneNumber(phoneNumber);
		updateAddress(address);
	}
	
	public final String getContactID() {
		return contactID;
	}
	
	public final String getFirstName() {
		return firstName;
	}
	
	protected final String getLastName() {
		return lastName;
	}
	
	protected final String getPhoneNumber() {
		return phoneNumber;
	}
	
	protected final String getAddress() {
		return address;
	}
	
	protected void updateFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("First name shouldn't be null");
		}else if (firstName.length() > CONTACT_FNAME_LEN) {
			throw new IllegalArgumentException("First name can be no longer than " + 
												CONTACT_FNAME_LEN + "characters");
		}else {
			this.firstName = firstName;						
		}
	}
	
	protected void updateLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Last name shouldn't be null");
		}else if (lastName.length() > CONTACT_LNAME_LEN) {
			throw new IllegalArgumentException("Last name can be no longer than " +
												CONTACT_LNAME_LEN + "characters");
		}
	}
	
	protected void updatePhoneNumber(String phoneNumber) {
		//use a regular expression to match input as digits
		String regex = "[0-9]+";
		if (phoneNumber == null) {
			throw new IllegalArgumentException("Phone # cannot be empty.");
		} else if (phoneNumber.length() != CONTACT_PNUM_LENGTH) {
			throw new IllegalArgumentException("Invalid # length. " + CONTACT_PNUM_LENGTH
												+ " digit number is required");
		}else if (!phoneNumber.matches(regex)) {
			throw new IllegalArgumentException("# Can only consist of integers");
		}else {
			this.phoneNumber = phoneNumber;
		}
	}
	
	protected void updateAddress(String address) {
		if(address == null) {
			throw new IllegalArgumentException("Address cannot be null");
		}else if (address.length() > CONTACT_ADDRESS_LEN) {
			throw new IllegalArgumentException("Address cannot be greater than " +
												CONTACT_ADDRESS_LEN + 
												" characters long.");
		} else {
			this.address = address;
		}
	}
	
	protected void updateContactID(String contactID) {
		//I am not sure why the requirements would like this to not have update capability.
		if(contactID == null) {
			throw new IllegalArgumentException("Contact ID field cannot be null");
		} else if (contactID.length() > CONTACT_ID_LEN) {
			throw new IllegalArgumentException("ContactID cannot be greater than " +
												CONTACT_ID_LEN + 
												" characters long.");
		} else {
			this.contactID = contactID;
		}
		
	}
}
