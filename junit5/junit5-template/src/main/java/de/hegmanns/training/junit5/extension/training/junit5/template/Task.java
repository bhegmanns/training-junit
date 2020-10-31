package de.hegmanns.training.junit5.extension.training.junit5.template;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task {
    private TaskState taskState;

    /**
     * There is a matrix
     * @return
     */
    public List<TaskAction> getPossibleTaskActions() {
        List<TaskAction> possibleActions = null;

        switch (taskState) {
            case RAW:
                possibleActions = Arrays.asList(TaskAction.CREATE);
                break;
            case CREATED:
            case SCHEDULED:
                possibleActions = Arrays.asList(TaskAction.START, TaskAction.CANCEL);
                break;
            case PROGRESS:
                possibleActions = Arrays.asList(TaskAction.TERMINATE, TaskAction.CANCEL, TaskAction.ERROR);
                break;
            case DONE:
                possibleActions = Arrays.asList(TaskAction.TERMINATE, TaskAction.CANCEL, TaskAction.ERROR);
                break;
            case CANCELED:
            case TERMINATED:
                possibleActions = Collections.EMPTY_LIST;
                break;
            case CLEARING:
                possibleActions = Arrays.asList(TaskAction.TERMINATE, TaskAction.CANCEL, TaskAction.ERROR);
                break;
            case WAITING:
                possibleActions = Arrays.asList(TaskAction.TERMINATE, TaskAction.CANCEL, TaskAction.ERROR);
                break;
        }

        return possibleActions;
    }

    public boolean doAction(TaskAction action, Collection<TaskActionInformation> additionalInformation) {
        if (!getPossibleTaskActions().contains(action)) {
            return false;
        }
        // to somewhat
        return true;
    }

    public void setState(TaskState taskState) {
        this.taskState = taskState;
    }
}
