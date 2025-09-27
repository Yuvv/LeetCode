import java.util.*;
/**
 * 3408-design-task-manager.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/09/27
 */
public class TaskManager {
    private TreeSet<TaskItem> tasks;
    private Map<Integer, TaskItem> taskMap;

    public TaskManager(List<List<Integer>> tasks) {
        this.tasks = new TreeSet<>();
        this.taskMap = new TreeMap<>();
        for (List<Integer> task : tasks) {
            this.add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        TaskItem taskItem = new TaskItem(taskId, userId, priority);
        tasks.add(taskItem);
        taskMap.put(taskId, taskItem);
    }

    public void edit(int taskId, int newPriority) {
        TaskItem item = taskMap.get(taskId);
        if (item == null) {
            return;
        }
        tasks.remove(item);
        item.priority = newPriority;
        tasks.add(item);
    }

    public void rmv(int taskId) {
        TaskItem item = taskMap.get(taskId);
        if (item == null) {
            return;
        }
        tasks.remove(item);
    }

    public int execTop() {
        TaskItem item = tasks.pollLast();
        if (item == null) {
            return -1;
        }
        taskMap.remove(item.id);
        return item.uid;
    }

    public static void main(String[] args) {
        // Initializes with three tasks for Users 1, 2, and 3.
        TaskManager taskManager = new TaskManager(Arrays.asList(Arrays.asList(1, 101, 10), Arrays.asList(2, 102, 20), Arrays.asList(3, 103, 15)));
        taskManager.add(4, 104, 5); // Adds task 104 with priority 5 for User 4.
        taskManager.edit(102, 8); // Updates priority of task 102 to 8.
        taskManager.execTop(); // return 3. Executes task 103 for User 3.
        taskManager.rmv(101); // Removes task 101 from the system.
        taskManager.add(5, 105, 15); // Adds task 105 with priority 15 for User 5.
        // return 5. Executes task 105 for User 5.
        System.out.println(taskManager.execTop());
    }
}

class TaskItem implements Comparable<TaskItem> {
    int id;
    int uid;
    int priority;

    public TaskItem(int id, int uid, int priority) {
        this.id = id;
        this.uid = uid;
        this.priority = priority;
    }

    public int compareTo(TaskItem o) {
        int r = Integer.compare(priority, o.priority);
        if (r == 0) {
            r = Integer.compare(id, o.id);
        }
        return r;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TaskItem && id == ((TaskItem) obj).id;
    }
}