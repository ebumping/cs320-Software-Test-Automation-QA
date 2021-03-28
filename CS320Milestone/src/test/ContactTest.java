package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Contact;


class ContactTest {

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
