package test;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Task;


class TaskTest {
	
	private String id, name, dscrpt;
	private String longID, longName, longDscrpt;

	@BeforeEach
	void setUp() {
		id = "0987654321";
		name = "Name under 20 char";
		dscrpt = "Description is required";
		longID = "0987654321234567890";
		longName = "Daenerys Stormborn of the House Targaryen, "
				+ "First of Her Name, the Unburnt, Queen of the "
				+ "Andals and the First Men, Khaleesi of the "
				+ "Great Grass Sea, Breaker of Chains, and "
				+ "Mother of Dragons";
		longDscrpt = "The description field cannot be null and also cannot be greater than 50 "
				+ "characters long";
	}
	
	@Test
	void getTaskIdTest() {
		Task t = new Task(id);
		Assertions.assertEquals(id, t.getTaskID());
	}
	
	@Test
	void getNameTest() {
		Task t = new Task(id, name);
		Assertions.assertEquals(name, t.getName());
	}
	
	@Test
	void getDescriptionTest() {
		Task t = new Task(id, name, dscrpt);
		Assertions.assertEquals(dscrpt, t.getDescription());
	}
	
	@Test
	void setNameTest() {
		Task t = new Task();
		t.setName(name);
		Assertions.assertEquals(name, t.getName());
	}
	
	@Test
	void setDescriptionTest(){
		Task t = new Task();
		t.setDescription(dscrpt);
		Assertions.assertEquals(dscrpt, t.getDescription());
	}
	
	@Test
	void longIDTest() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Task(longID));
	}
	
	@Test
	void longNameTest() {
		Task t = new Task();
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> t.setName(longName));
		
	}
	
	@Test
	void longDscrptTest(){
		Task t = new Task();
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> t.setDescription(longDscrpt));		
	}
	
	@Test
	void nullIDTest() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Task(null));
	}
	
	@Test
	void nullNameTest() {
		Task t = new Task();
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> t.setName(null));
	}
	
	@Test
	void nullDscrptTest() {
		Task t = new Task();
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> t.setDescription(null));
	}
	
	@Test
	void nullDescriptionTest() {
		Task t = new Task();
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> t.setDescription(null));
	}

}
