package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Contact;


class ContactTest {

	@Test
	void testContact() {
		Contact c = new Contact("54231", "Dyl");
		assertTrue(c.getContactID.equals("54231"));
		assertTrue(c.getFirstName.equals("Dyl"));
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
