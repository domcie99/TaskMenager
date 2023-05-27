import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        tasks.add(task);
    }
    public void removeTask(Task task){
        tasks.remove(task);
    }
    public ArrayList<Task> getAllTasks(){
        return tasks;
    }

    public ArrayList<Task> getTasksByStatus(String status){
        ArrayList<Task> TasksByStatus = new ArrayList<>();
        for (Task t: tasks){
            if(t.getStatus().equalsIgnoreCase(status)) {
                TasksByStatus.add(t);
            }
        }
        return TasksByStatus;
    }

    public boolean updateTaskStatus(Task task, String newStatus){
        if(tasks.contains(task)){
            task.setStatus(newStatus);
            return true;
        } else {
            return false;
        }
    }
}
