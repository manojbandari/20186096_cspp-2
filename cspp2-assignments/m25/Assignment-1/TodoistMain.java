import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

/**
  * write your code below this comment
  */

/**
 * Class for todoist main.
 */
class Task {
	String title;
	String assignedTo;
	int timeToComplete;
	boolean important;
	boolean urgent;
	String status;
	Task(String title1, String assignedTo1, int timeToComplete1,boolean important1,boolean urgent1 ,String status1) throws Exception{
		if(title1.equals(""))
			throw new Exception("Title not provided");
		if(timeToComplete1<0)
			throw new Exception("Invalid timeToComplete "+timeToComplete1);
		if(!(status1.equals("todo") || status1.equals("done"))) {
			throw new Exception("Invalid status "+status1);
		}
		this.title=title1;
		this.assignedTo=assignedTo1;
		this.timeToComplete=timeToComplete1;
		this.important=important1;
		this.urgent=urgent1;
		this.status= status1;

	}
	public String toString() {
		return title+", "+assignedTo+", "+timeToComplete+", "+important+", "+urgent+", "+status;
	}
}
class Todoist{
	ArrayList<Task> tasks;
	Todoist() {
		tasks= new ArrayList<Task>();
	}
	public void addTask(Task task) {
		tasks.add(task);
	}
	public String toString() {
		String m=" ";
		for(Task s: tasks) {
			m+=s;
			m+="\n";
		}
		return m;
	}
	public String getNextTask(String nextTask) {
		return null;
	}
	public Task[] getNextTask(String nextTask,int count){
		return null;
	}
	public int totalTime4Completion() {
		return 0;
	}
}
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    System.out.println(todo);
                break;
                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    Task[] tasks = todo.getNextTask(tokens[1], n);
                    System.out.println(Arrays.deepToString(tasks));
                break;
                case "total-time":
                    System.out.println(todo.totalTime4Completion());
                break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}