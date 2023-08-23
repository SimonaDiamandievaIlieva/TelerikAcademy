package comtelerikacademy_BoardR;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BoardItem {

    private static final String STATUS_CHANGED_NEXT = "Status changed from %s to %s";
    protected static final int MIN_LENGTH = 5;
    protected static final int MAX_LENGTH = 30;
    protected static final String LENGTH_ERROR =
            "Please provide a field with length between " + MIN_LENGTH + " and " + MAX_LENGTH + " chars";
    private static final String TITLE_CHANGED = "Title changed from %s to %s";
    private static final String DATE_ERROR = "Date should not be in the past.";
    private static final String DATE_CHANGED = "DueDate changed from %s to %s";
    private static final String STATUS_CHANGED_PREVIOUS = "Status changed from %s to %s";
    private String title;
    private LocalDate dueDate;
    protected Status status;
    protected final List<EventLog> logs = new ArrayList<>();

    public BoardItem(String title, LocalDate dueDate) {
        validateTitle(title);
        this.title = title;
        validateDueDate(dueDate);
        this.dueDate = dueDate;
        setStatus(Status.OPEN);
        logs.add(new EventLog("Item created: " + viewInfo()));
    }

    public BoardItem(String title,LocalDate dueDate,Status InitialStatus){
        validateTitle(title);
        this.title = title;
        validateDueDate(dueDate);
        this.dueDate = dueDate;
        this.status = InitialStatus;
    }

     private void validateTitle(String title) {
        if (title.length() < MIN_LENGTH || title.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR);
        }
    }

    protected void setTitle(String title) {
        validateTitle(title);
        logs.add(new EventLog(String.format(TITLE_CHANGED, this.title, title)));
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

     protected void validateDueDate(LocalDate dueDate) {
        if(!LocalDate.now().isBefore(dueDate)) {
            throw new IllegalArgumentException(DATE_ERROR);
        }
    }

    protected void setDueDate(LocalDate dueDate) {
        validateDueDate(dueDate);
        logs.add(new EventLog(String.format(DATE_CHANGED, this.dueDate, dueDate)));
        this.dueDate = dueDate;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    protected void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public List<EventLog> getLogs() {
        return logs;
    }

    public Status advanceStatus(){
        if (status == Status.VERIFIED) {
            logs.add(new EventLog("Can't advance, already at Verified."));
        }
        if(status != Status.VERIFIED){
            logs.add(new EventLog(String.format(STATUS_CHANGED_NEXT, this.status, status.next())));
            status = status.next();
        }
        return status;
    }

    public Status revertStatus(){
        if (status == Status.OPEN) {
            logs.add(new EventLog("Can't revert, already at Open."));
        }
        if(status != Status.OPEN){
            logs.add(new EventLog(String.format(STATUS_CHANGED_PREVIOUS, this.status, status.previous())));
            status = status.previous();
        }
        return status;
    }

    public String viewInfo() {
        return String.format("'%s', [%s | %s]", title, status.toString(), dueDate.toString());
    }

    public void displayHistory () {
       StringBuilder display = new StringBuilder();
        for (EventLog log : logs) {
            display.append(log.viewInfo()).append("\n");
        }
        System.out.println(display);
    }
}
