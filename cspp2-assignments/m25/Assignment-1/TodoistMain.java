/**
 * @author:manojbandari.
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/**
  * write your code below this comment
  */

/**
 * Class for todoist main.
 */
class Task {
    /**
     * { var_description }.
     */
    private String title;
    /**
     * { var_description }.
     */
    private String assignedTo;
    /**
     * { var_description }.
     */
    private int timeToComplete;
    /**
     * { var_description }.
     */
    private String important;
    /**
     * { var_description }.
     */
    private String urgent;
    /**
     * { var_description }.
     */
    private String status;

    /**
     * Constructs the object.
     *
     * @param      title1           The title 1
     * @param      assignedTo1      The assigned to 1
     * @param      timeToComplete1  The time to complete 1
     * @param      important1       The important 1
     * @param      urgent1          The urgent 1
     * @param      status1          The status 1
     */
    Task(final String title1, final String assignedTo1, final int timeToComplete1, final boolean important1, final boolean urgent1 , final String status1) throws Exception {
        if (title1.equals("")) {
            throw new Exception("Title not provided");
        }
        if (timeToComplete1 < 0) {
            throw new Exception("Invalid timeToComplete " + timeToComplete1);
        }
        if (!(status1.equals("todo") || status1.equals("done"))) {
            throw new Exception("Invalid status " + status1);
        }
        this.title = title1;
        this.assignedTo = assignedTo1;
        this.timeToComplete = timeToComplete1;
        if (important1) {
            this.important = "Important";
        } else {
            this.important = "Not Important";
        }
        if (urgent1) {
            this.urgent = "Urgent";
        } else {
            this.urgent = "Not Urgent";
        }
        this.status = status1;

    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return assignedTo;
    }
    /**
     * Gets the status.
     *
     * @return     The status.
     */
    public String getStatus() {
        return status;
    }
    /**
     * Gets the time to complete.
     *
     * @return     The time to complete.
     */
    public int getTimeToComplete() {
        return timeToComplete;
    }
    /**
     * Gets the important.
     *
     * @return     The important.
     */
    public String getImportant() {
        return important;
    }
    /**
     * Gets the urgent.
     *
     * @return     The urgent.
     */
    public String getUrgent() {
        return urgent;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String a = title + ", " + assignedTo +
                   ", " + timeToComplete + ", " +
                   important + ", " + urgent + ", " + status;
        return a;
    }
}
/**
 * Class for todoist.
 */
class Todoist {
    /**
     * { var_description }.
     */
    ArrayList<Task> tasks;
    /**
     * Constructs the object.
     */
    Todoist() {
        tasks = new ArrayList<Task>();
    }
    /**
     * Adds a task.
     *
     * @param      task  The task
     */
    public void addTask(final Task task) {
        tasks.add(task);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String m = "";
        for (Task s : tasks) {
            m += s;
            m += "\n";
        }
        return m;
    }
    /**
     * Gets the next task.
     *
     * @param      nextTask  The next task
     *
     * @return     The next task.
     */
    public Task getNextTask(final String nextTask) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(nextTask)) {
                if (tasks.get(i).getStatus().equals("todo")) {
                    if (tasks.get(i).getImportant().equals("Important") &&
                            tasks.get(i).getUrgent().equals("Not Urgent")) {
                        return tasks.get(i);
                    }
                }
            }
        }
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(nextTask)) {
                if (tasks.get(i).getStatus().equals("todo")) {
                    if (tasks.get(i).getImportant().equals("Important") &&
                            tasks.get(i).getUrgent().equals("Urgent")) {
                        return tasks.get(i);
                    }
                }
            }
        }
        return null;
    }
    /**
     * Gets the next task.
     *
     * @param      nextTask  The next task
     * @param      count     The count
     *
     * @return     The next task.
     */
    public Task[] getNextTask(final String nextTask, final int count) {
        Task[] tas = new Task[count];
        int temp = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(nextTask)) {
                if (tasks.get(i).getStatus().equals("todo")) {
                    if (tasks.get(i).getImportant().equals("Important") &&
                            tasks.get(i).getUrgent().equals("Not Urgent")) {
                        if (temp < 3)
                            tas[temp++] = tasks.get(i);
                    }
                }
            }
        }
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(nextTask)) {
                if (tasks.get(i).getStatus().equals("todo")) {
                    if (tasks.get(i).getImportant().equals("Important") &&
                            tasks.get(i).getUrgent().equals("Urgent")) {
                        if (temp < 3)
                            tas[temp++] = tasks.get(i);
                    }
                }
            }
        }
        return tas;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int totalTime4Completion() {
        int count = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getStatus().equals("todo")) {
                count += tasks.get(i).getTimeToComplete();
            }
        }
        return count;
    }
}
/**
 * Class for todoist main.
 */
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
