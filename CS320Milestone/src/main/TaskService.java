package main;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskService {
	private final List<Task> taskList = new ArrayList<>();
	
	private String newUniqueID() {
		return UUID.randomUUID().toString().substring(
				0, Math.min(toString().length(), 10));
	}
	
	private Task searchTask(String id) throws Exception{
		int i = 0;
		while (i < taskList.size()) {
			if (id.equals(taskList.get(i).getTaskID())) {
				return taskList.get(i);
			}
			i++;
		}
		throw new Exception("Task encountered an error");
	}
	
	public void newTask() {
		Task t = new Task(newUniqueID());
		taskList.add(t);
	}
	
	public void newTask(String name) {
		Task t = new Task(newUniqueID(), name);
		taskList.add(t);
	}
	
	public void newTask(String name, String dsc) {
		Task t = new Task(newUniqueID(), name, dsc);
		taskList.add(t);
	}
	
	public void delTask(String id) throws Exception{
		taskList.remove(searchTask(id));
	}
	
	public void updateName(String id, String name) throws Exception{
		searchTask(id).setName(name);
	}
	
	public void updateDescription(String id, String dsc) throws Exception{
		searchTask(id).setDescription(dsc);
	}
	
	public List<Task> getTaskList(){
		return taskList;
	}
}
