package main;

public class Task {

	private String taskID;
	private String name;
	private String dscrpt;
	//dscrpt = description
	
	public Task() {
		taskID = "init";
		name = "init";
		dscrpt = "init description";
	}
	
	public Task(String taskID) {
		checkTaskID(taskID);
		name = "init";
		dscrpt = "init description";
	}
	
	public Task(String taskID, String name) {
		checkTaskID(taskID);
		setName(name);
		dscrpt = "init description";
	}
	
	public Task(String taskID, String name, String dsc) {
		checkTaskID(taskID);
		setName(name);
		setDescription(dsc);
	}
	
	public final String getTaskID() {
		return taskID;
	}
	
	public final String getName() {
		return name;
	}
	
	public final String getDescription() {
		return dscrpt;
	}
	
	private void checkTaskID(String taskID) {
		if(taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("ID cannot be null or longer than 10 chars ");
		} else {
			this.taskID = taskID;
		}
	}
	
	void setName(String name) {
		if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid task, either null or too long");
		} else {
			this.name = name;
		}
	}
	
	
	
	
	void setDescription(String taskDescription) {
		if(taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid description, either null or too long");
		} else {
			this.dscrpt = taskDescription;
		}
	}
	
	
}
