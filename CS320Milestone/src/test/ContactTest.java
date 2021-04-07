package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import main.Contact;


public class ContactTest {
	
	protected String contactID, fNameTest, lNameTest, pNumTest, addressTest;
	protected String longID, longFirstName, longLastName, longPhoneNum, 
					shortPhoneNum, longAddress;
	
	@BeforeEach
	void setup() {
		contactID = "0987654321";
		fNameTest = "Dylan";
		lNameTest = "Jeffery";
		pNumTest = "16038669533";
		addressTest = "25 PVC Dover NH 03820";
		longID = "0987654321234567890";
		longFirstName = "Daenerys Stormborn of the House Targaryen";
		longLastName = "First of Her Name, the Unburnt, Queen of the "
				+ "Andals and the First Men, Khaleesi of the "
				+ "Great Grass Sea, Breaker of Chains, and "
				+ "Mother of Dragons";
		longPhoneNum = "1166038669533";
		shortPhoneNum = "603866953";
		longAddress = "Menzoberranzan, the \"City of Spiders\", "
				+ "Upper Northdark, two miles below the Surbrin Vale";		
	}
	//Test for null values
	@Test
	void testContact() {
		Contact c = new Contact();
		assertAll("constructor", 
				() -> assertNotNull(c.getContactID()),
				() -> assertNotNull(c.getFirstName()),
				() -> assertNotNull(c.getLastName()),
				() -> assertNotNull(c.getPhoneNumber()),
				() -> assertNotNull(c.getAddress()));
	}
	//Tests for the different constructors
	@Test
	void testContactIDConstructor(){
		Contact c = new Contact(contactID);
		assertAll("constructor 1", 
				() -> assertNotNull(contactID, c.getContactID()),
				() -> assertNotNull(c.getFirstName()),
				() -> assertNotNull(c.getLastName()),
				() -> assertNotNull(c.getPhoneNumber()),
				() -> assertNotNull(c.getAddress()));
		
	}
	
	@Test
	void testContactIDFnameConstructor(){
		Contact c = new Contact(contactID, fNameTest);
		assertAll("constructor 2", 
				() -> assertNotNull(contactID, c.getContactID()),
				() -> assertNotNull(fNameTest, c.getFirstName()),
				() -> assertNotNull(c.getLastName()),
				() -> assertNotNull(c.getPhoneNumber()),
				() -> assertNotNull(c.getAddress()));
		
	}
	
	@Test
	void testContactIDFullnameConstructor(){
		Contact c = new Contact(contactID, fNameTest, lNameTest);
		assertAll("constructor 3", 
				() -> assertNotNull(contactID, c.getContactID()),
				() -> assertNotNull(fNameTest, c.getFirstName()),
				() -> assertNotNull(lNameTest,c.getLastName()),
				() -> assertNotNull(c.getPhoneNumber()),
				() -> assertNotNull(c.getAddress()));
		
	}
	
	@Test
	void testContactIDFullnameAndNumConstructor(){
		Contact c = new Contact(contactID, fNameTest, lNameTest, pNumTest);
		assertAll("constructor 4", 
				() -> assertNotNull(contactID, c.getContactID()),
				() -> assertNotNull(fNameTest, c.getFirstName()),
				() -> assertNotNull(lNameTest, c.getLastName()),
				() -> assertNotNull(pNumTest, c.getPhoneNumber()),
				() -> assertNotNull(c.getAddress()));
		
	}
	
	@Test
	void testAllTheThingsConstructor(){
		Contact c = new Contact(contactID, fNameTest, lNameTest, pNumTest, addressTest);
		assertAll("constructor 5", 
				() -> assertNotNull(contactID, c.getContactID()),
				() -> assertNotNull(fNameTest, c.getFirstName()),
				() -> assertNotNull(lNameTest, c.getLastName()),
				() -> assertNotNull(pNumTest, c.getPhoneNumber()),
				() -> assertNotNull(addressTest, c.getAddress()));
		
	}
	
	@Test
	void testFirstNameUpdate() {
		Contact c = new Contact();
		c.updateFirstName(fNameTest);
		assertAll("first name", 
				() -> assertEquals(fNameTest, c.getFirstName()),
				() -> assertThrows(IllegalArgumentException.class,
						() -> c.updateFirstName(null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> c.updateFirstName(longFirstName)));
	}
	
	@Test
	void testLastNameUpdate() {
		Contact c = new Contact();
		c.updateLastName(lNameTest);
		assertAll("last name",
				() -> assertEquals(lNameTest, c.getLastName()),
				() -> assertThrows(IllegalArgumentException.class,
						() -> c.updateLastName(null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> c.updateLastName(longLastName)));
	}
	
	@Test
	void testNumberUpdate() {
		Contact c = new Contact();
		c.updatePhoneNumber(pNumTest);
		assertAll("phone number",
				() -> assertEquals(pNumTest, c.getPhoneNumber()),
				() -> assertThrows(IllegalArgumentException.class,
						() -> c.updatePhoneNumber(null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> c.updatePhoneNumber(longPhoneNum)));		
	}
	
	@Test
	void testAddressUpdate() {
		Contact c = new Contact();
		c.updateAddress(addressTest);
		assertAll("address",
				() -> assertEquals(addressTest, c.getAddress()),
				() -> assertThrows(IllegalArgumentException.class,
						() -> c.updateAddress(null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> c.updateAddress(longAddress)));
	}
	
	@Test
	void testContactIDUpdate() {
		Contact c = new Contact();
		c.updateContactID(contactID);
		assertAll("CID",
				() -> assertEquals(contactID, c.getContactID()),
				() -> assertThrows(IllegalArgumentException.class,
						() -> c.updateContactID(null)),
				() -> assertThrows(IllegalArgumentException.class,
						() -> c.updateContactID(longID)));
	}
/*
			These are old tests that did not pass the coverage req's
			
	@Test
	void testContact() {
		Contact c = new Contact("11111", "Dylan");
		//System.out.println(c.getContactID());
		//System.out.println(c.getFirstName());
		assertTrue(c.getContactID().equals("11111"));
		assertTrue(c.getFirstName().equals("Dylan"));
	}
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123451234512345", "Adelle");
		});
	}
	
	@Test
	void testContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Adelle");
		});
	}
	
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Daenerys Stormborn of the House Targaryen, First of Her Name, the Unburnt, Queen of the Andals and the First Men, "
					+ "Khaleesi of the Great Grass Sea, Breaker of Chains, and Mother of Dragons");
		});
	}
	
	@Test
	void testContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", null);
		});
	}
	
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Daenerys", "Stormborn of the House Targaryen, First of Her Name, the Unburnt, Queen of the Andals and the First Men, "
					+ "Khaleesi of the Great Grass Sea, Breaker of Chains, and Mother of Dragons");
		});
	}
	
	@Test
	void testContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Daenerys", null);
		});
	}
	
	@Test
	void testContactPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("54231", "Dyl", "Jeffery", "603866953");
		});
	}
	@Test
	void testContactPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("54231", "Dyl", "Jeffery", "603866953231");
		});
	}
	
	@Test
	void testContactPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("54231", "Dyl", "Jeffery", null);
		});
	}
	
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("54231", "Dyl", "Jeffery", "6038669534",
					"25 Box car lane, Boxington estates, Boxington, Boxingshire Binglebangle"
					+ "Lorem ipsum");
		});
	}
	
	@Test
	void testContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("54231", "Dyl", "Jeffery", "6038669534",
					null);
		});
	}
	
	/*
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void contactTest() {
		
	}
*/
}
