package comtelerikacademy_BoardR;

import java.time.LocalDate;

public class Task extends BoardItem{

    private String assignee;
    private static final String ASSIGNEE_CHANGED = "Assignee changed from %s to %s";

    public Task(String title, String assignee, LocalDate dueDate) {
        super(title, dueDate,Status.TODO);
        validateAssignee(assignee);
        this.assignee = assignee;
        logs.add(new EventLog("Item created: " + viewInfo()));
    }

    public String getAssignee() {
        return assignee;
    }
     protected void setAssignee(String assignee) {
        validateAssignee(assignee);
        logs.add(new EventLog(String.format(ASSIGNEE_CHANGED, this.assignee, assignee)));
        this.assignee = assignee;
    }

    private void validateAssignee (String assignee) {
        if (assignee == null) {
            throw new IllegalArgumentException("This filed should never be empty.");
        }
        if (assignee.length() < MIN_LENGTH || assignee.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR);
        }
    }

    @Override
    public Status advanceStatus() {
        return super.advanceStatus();
    }

    @Override
    public Status revertStatus() {
        return super.revertStatus();
    }

    @Override
    public String viewInfo() {
        return super.viewInfo();
    }

    @Override
    public void displayHistory() {
        super.displayHistory();
    }
}
