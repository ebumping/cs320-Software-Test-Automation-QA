package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.ContactService;

class ContactServiceTest {


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
	

}
