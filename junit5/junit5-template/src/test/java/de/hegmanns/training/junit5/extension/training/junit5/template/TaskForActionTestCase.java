package de.hegmanns.training.junit5.extension.training.junit5.template;

public class TaskForActionTestCase {
    private TaskAction taskAction;
    private TaskState taskState;
//    private boolean possible;

    public TaskForActionTestCase(TaskAction taskAction, TaskState taskState) {
        this.taskAction = taskAction;
        this.taskState = taskState;
    }

    public TaskAction getTaskAction() {
        return taskAction;
    }

    public TaskState getTaskState() {
        return taskState;
    }

    public Task createTaskFromTestCase() {
        Task task = new Task();
        task.setState(taskState);
        return  task;
    }
}
