package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.ContactService;

class ContactServiceTest {
	
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
	
	@Test
	void testNewContact() {
		ContactService cs = new ContactService();
		cs.newContact();
		assertAll("ContactService", 
				() -> assertNotNull(cs.getContactList().get(0).getContactID()),
				() -> assertEquals("INIT", 
						cs.getContactList().get(0).getFirstName()),
				() -> assertEquals("INIT",
						cs.getContactList().get(0).getLastName()),
				() -> assertEquals("0123456789",
						cs.getContactList().get(0).getPhoneNumber()),
				() -> assertEquals("INIT",
						cs.getContactList().get(0).getAddress()));
		cs.newContact(fNameTest);
		
		assertAll("ContactService", 
				() -> assertNotNull(cs.getContactList().get(1).getContactID()),
				() -> assertEquals(fNameTest, 
						cs.getContactList().get(1).getFirstName()),
				() -> assertEquals("INIT",
						cs.getContactList().get(1).getLastName()),
				() -> assertEquals("0123456789",
						cs.getContactList().get(1).getPhoneNumber()),
				() -> assertEquals("INIT",
						cs.getContactList().get(1).getAddress()));
		cs.newContact(fNameTest, lNameTest);
		
		assertAll("ContactService", 
				() -> assertNotNull(cs.getContactList().get(2).getContactID()),
				() -> assertEquals(fNameTest, 
						cs.getContactList().get(2).getFirstName()),
				() -> assertEquals(lNameTest,
						cs.getContactList().get(2).getLastName()),
				() -> assertEquals("0123456789",
						cs.getContactList().get(2).getPhoneNumber()),
				() -> assertEquals("INIT",
						cs.getContactList().get(2).getAddress()));
		cs.newContact(fNameTest, lNameTest, longPhoneNum);
		
		assertAll("ContactService", 
				() -> assertNotNull(cs.getContactList().get(3).getContactID()),
				() -> assertEquals(fNameTest, 
						cs.getContactList().get(3).getFirstName()),
				() -> assertEquals(lNameTest,
						cs.getContactList().get(3).getLastName()),
				() -> assertEquals(pNumTest,
						cs.getContactList().get(3).getPhoneNumber()),
				() -> assertEquals("INIT",
						cs.getContactList().get(3).getAddress()));
		
		cs.newContact(fNameTest, lNameTest, longPhoneNum, addressTest);
		
		assertAll("ContactService", 
				() -> assertNotNull(cs.getContactList().get(4).getContactID()),
				() -> assertEquals(fNameTest, 
						cs.getContactList().get(4).getFirstName()),
				() -> assertEquals(lNameTest,
						cs.getContactList().get(4).getLastName()),
				() -> assertEquals(pNumTest,
						cs.getContactList().get(4).getPhoneNumber()),
				() -> assertEquals(addressTest,
						cs.getContactList().get(4).getAddress()));
	}
	
	@Test
	void testDelContact() {
		ContactService cs = new ContactService();
		cs.newContact();
		assertThrows(Exception.class, () -> cs.delContact(contactID));
		assertAll(
				() -> cs.delContact(
						cs.getContactList().get(0).getContactID()));
	}
	
	@Test
	void testFirstNameUpdate() throws Exception {
		ContactService cs = new ContactService();
		cs.newContact();
		cs.updateFirstName(cs.getContactList().get(0).getContactID(),
				fNameTest);
		assertEquals(fNameTest, cs.getContactList().get(0).getFirstName());
		assertThrows(IllegalArgumentException.class, 
				() -> cs.updateFirstName(
						cs.getContactList().get(0).getContactID(),
						longFirstName));
		assertThrows(IllegalArgumentException.class,
				() -> cs.updateFirstName(
						cs.getContactList().get(0).getContactID(), null));
		assertThrows(Exception.class,
				() -> cs.updateFirstName(contactID, fNameTest));
		
	}
	
	@Test
	void testLastNameUpdate() throws Exception {
		ContactService cs = new ContactService();
		cs.newContact();
		cs.updateLastName(cs.getContactList().get(0).getContactID(), lNameTest);
		
		assertEquals(lNameTest, cs.getContactList().get(0).getLastName());
		assertThrows(IllegalArgumentException.class, 
				() -> cs.updateLastName(
						cs.getContactList().get(0).getContactID(),
						longLastName));
		assertThrows(IllegalArgumentException.class,
				() -> cs.updateLastName(
						cs.getContactList().get(0).getContactID(), null));
		assertThrows(Exception.class,
				() -> cs.updateLastName(contactID, lNameTest));
		
	}
	
	@Test
	void testPhoneNumUpdate() throws Exception {
		ContactService cs = new ContactService();
		cs.newContact();
		cs.updatePhoneNum(cs.getContactList().get(0).getContactID(), pNumTest);
		
		assertEquals(pNumTest, cs.getContactList().get(0).getPhoneNumber());
		assertThrows(IllegalArgumentException.class,
				() -> cs.updatePhoneNum(
						cs.getContactList().get(0).getContactID(), longPhoneNum));
		assertThrows(IllegalArgumentException.class,
				() -> cs.updatePhoneNum(
						cs.getContactList().get(0).getContactID(), shortPhoneNum));
		assertThrows(IllegalArgumentException.class,
				() -> cs.updatePhoneNum(
						cs.getContactList().get(0).getContactID(), contactID));
		assertThrows(IllegalArgumentException.class,
				() -> cs.updatePhoneNum(
						cs.getContactList().get(0).getContactID(), null));
		assertThrows(Exception.class, () -> cs.updatePhoneNum(contactID, pNumTest));
	
	}
	
	@Test
	void testAddressUpdate() throws Exception {
		ContactService cs = new ContactService();
		cs.newContact();
		cs.updateAddress(cs.getContactList().get(0).getContactID(), addressTest);
		
		assertEquals(addressTest, cs.getContactList().get(0).getAddress());
		assertThrows(IllegalArgumentException.class,
				() -> cs.updateAddress(
				cs.getContactList().get(0).getContactID(), longAddress));
		assertThrows(IllegalArgumentException.class,
				() -> cs.updateAddress(
						cs.getContactList().get(0).getContactID(), null));
		assertThrows(Exception.class, () -> cs.updateAddress(contactID, addressTest));
		
	}

/*
		Old tests with low coverage
	@Test
	void testContactServiceAdd() {
		ContactService cs = new ContactService();
		cs.newContact();
		try {
			assertTrue(cs.contactList.contains(cs.searchContact(cs.userID)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testContactServiceDel() throws Exception {
		ContactService cs = new ContactService();
		cs.newContact();
		try {
			cs.delContact(cs.userID);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			assertFalse(cs.contactList.contains(cs.userID));

	}
	
	@Test
	//Test for passing new contact addition arguments, such as name, address, and #
	void testContactServiceUpdate() {
		ContactService cs = new ContactService();
		cs.newContact("Dylan", "Jeffery", "6038669534", "125 Henry Law Ave");
		try {
			assertTrue(cs.contactList.contains(cs.searchContact(cs.userID)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/

}
