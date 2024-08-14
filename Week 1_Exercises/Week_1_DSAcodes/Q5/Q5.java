// Q5.java
public class Q5 {

    // Task class
    public static class Task {
        private int taskId;
        private String taskName;
        private String status;

        // Constructor
        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        // Getters and Setters
        public int getTaskId() {
            return taskId;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "taskId=" + taskId +
                    ", taskName='" + taskName + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

    // TaskNode class
    private static class TaskNode {
        private Task task;
        private TaskNode next;

        public TaskNode(Task task) {
            this.task = task;
            this.next = null;
        }

        public Task getTask() {
            return task;
        }

        public void setTask(Task task) {
            this.task = task;
        }

        public TaskNode getNext() {
            return next;
        }

        public void setNext(TaskNode next) {
            this.next = next;
        }
    }

    // TaskList class
    public static class TaskList {
        private TaskNode head;

        public TaskList() {
            this.head = null;
        }

        // Add Task
        public void addTask(Task task) {
            TaskNode newNode = new TaskNode(task);
            if (head == null) {
                head = newNode;
            } else {
                TaskNode current = head;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newNode);
            }
        }

        // Search Task
        public Task searchTask(int taskId) {
            TaskNode current = head;
            while (current != null) {
                if (current.getTask().getTaskId() == taskId) {
                    return current.getTask();
                }
                current = current.getNext();
            }
            return null; // Task not found
        }

        // Traverse Tasks
        public void traverseTasks() {
            TaskNode current = head;
            while (current != null) {
                System.out.println(current.getTask());
                current = current.getNext();
            }
        }

        // Delete Task
        public void deleteTask(int taskId) {
            if (head == null) return;

            if (head.getTask().getTaskId() == taskId) {
                head = head.getNext();
                return;
            }

            TaskNode current = head;
            while (current.getNext() != null && current.getNext().getTask().getTaskId() != taskId) {
                current = current.getNext();
            }

            if (current.getNext() != null) {
                current.setNext(current.getNext().getNext());
            }
        }
    }

    // Main method for demonstration
    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        // Adding tasks
        taskList.addTask(new Task(1, "Task 1", "Pending"));
        taskList.addTask(new Task(2, "Task 2", "Completed"));
        taskList.addTask(new Task(3, "Task 3", "In Progress"));

        // Traversing tasks
        System.out.println("Tasks in the list:");
        taskList.traverseTasks();

        // Searching for a task
        System.out.println("\nSearching for Task with ID 2:");
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println("Found: " + task);
        } else {
            System.out.println("Task not found");
        }

        // Deleting a task
        System.out.println("\nDeleting Task with ID 1");
        taskList.deleteTask(1);

        // Traversing tasks after deletion
        System.out.println("\nTasks in the list after deletion:");
        taskList.traverseTasks();
    }
}
