package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import main.TaskService;

import org.junit.jupiter.api.Assertions;

class TaskServiceTest {

	private String id, name, dscrpt;
	private String longName, longDescription;
	
	@BeforeEach
	void setUp() {
		id = "0987654321";
		name = "Name under 20 char";
		dscrpt = "Description is required";
		longName = "Daenerys Stormborn of the House Targaryen, "
				+ "First of Her Name, the Unburnt, Queen of the "
				+ "Andals and the First Men, Khaleesi of the "
				+ "Great Grass Sea, Breaker of Chains, and "
				+ "Mother of Dragons";
		longDescription = "The description field cannot be null and also cannot be greater than 50 "
				+ "characters long";
	}
	
	@Test
	void serviceTest() {
		TaskService ts = new TaskService();
		ts.newTask();
		Assertions.assertNotNull(ts.getTaskList().get(0).getTaskID());
		Assertions.assertNotEquals("init", ts.getTaskList().get(0).getTaskID());
	}
	
	@Test
	void newNameTest() {
		TaskService ts = new TaskService();
		ts.newTask(name);
		Assertions.assertNotNull(ts.getTaskList().get(0).getName());
		Assertions.assertEquals(name, ts.getTaskList().get(0).getName());
	}
	
	@Test
	void newDescriptionTest() {
		TaskService ts = new TaskService();
		ts.newTask(name, dscrpt);
		Assertions.assertNotNull(ts.getTaskList().get(0).getDescription());
		Assertions.assertEquals(dscrpt, ts.getTaskList().get(0).getDescription());
	}
	
	@Test
	void longNameServiceTest() {
		TaskService ts = new TaskService();
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> ts.newTask(name, longName));
	}
	
	@Test
	void longDescriptionServiceTest() {
		TaskService ts = new TaskService();
		assertThrows(IllegalArgumentException.class,
				() -> ts.newTask(name, longDescription));
	}
	
	@Test
	void nullNameServiceTest() {
		TaskService ts = new TaskService();
		assertThrows(IllegalArgumentException.class,
				() -> ts.newTask(null));
	}
	
	@Test
	void nullDescriptionServiceTest() {
		TaskService ts = new TaskService();
		assertThrows(IllegalArgumentException.class,
				() -> ts.newTask(name, null));
	}
	
	@Test
	void delTaskTest() throws Exception{
		TaskService ts = new TaskService();
		ts.newTask();
		assertEquals(1, ts.getTaskList().size());
		ts.delTask(ts.getTaskList().get(0).getTaskID());
		assertEquals(0, ts.getTaskList().size());
	}
	
	@Test
	void delTaskNotFound() throws Exception{
		TaskService ts = new TaskService();
		ts.newTask();
		assertEquals(1, ts.getTaskList().size());
		assertThrows(Exception.class, () -> ts.delTask(id));
		assertEquals(1, ts.getTaskList().size());
	}
	
	@Test
	void updateNameTest() throws Exception{
		TaskService ts = new TaskService();
		ts.newTask();
		ts.updateName(ts.getTaskList().get(0).getTaskID(), name);
		assertEquals(name, ts.getTaskList().get(0).getName());
	}
	
	@Test
	void updateDescTest() throws Exception{
		TaskService ts = new TaskService();
		ts.newTask();
		ts.updateDescription(ts.getTaskList().get(0).getTaskID(), dscrpt);
		assertEquals(dscrpt, ts.getTaskList().get(0).getDescription());
	}
	
	@Test
	void updateNoNameFoundTest() throws Exception{
		TaskService ts = new TaskService();
		ts.newTask();
		assertThrows(Exception.class, () -> ts.updateName(id, name));
	}
	
	@Test 
	void updateDescNoFoundTest() throws Exception{
		TaskService ts = new TaskService();
		ts.newTask();
		assertThrows(Exception.class, () -> ts.updateDescription(id, dscrpt));
	}
	
	@RepeatedTest(4)
	void uuidTest() {
		TaskService ts = new TaskService();
		ts.newTask();
		ts.newTask();
		ts.newTask();
		assertEquals(3, ts.getTaskList().size());
		assertNotEquals(ts.getTaskList().get(0).getTaskID(), 
						ts.getTaskList().get(1).getTaskID());
		assertNotEquals(ts.getTaskList().get(0).getTaskID(), 
						ts.getTaskList().get(2).getTaskID());
		assertNotEquals(ts.getTaskList().get(1).getTaskID(), 
						ts.getTaskList().get(2).getTaskID());
	}
}
