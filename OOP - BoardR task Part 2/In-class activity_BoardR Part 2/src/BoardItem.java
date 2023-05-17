import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BoardItem {

    private static final String STATUS_CHANGED_NEXT = "Status changed from %s to %s";
    private static final int MIN_TITLE_LENGTH = 5;
    private static final int MAX_TITLE_LENGTH = 30;
    private static final String TITLE_LENGTH_ERROR =
            "Please provide a title with length between " + MIN_TITLE_LENGTH + " and " + MAX_TITLE_LENGTH + " chars";
    private static final String TITLE_CHANGED = "Title changed from %s to %s";
    private static final String DATE_ERROR = "Date should not be in the past.";
    private static final String DATE_CHANGED = "DueDate changed from %s to %s";
    public static final String STATUS_CHANGED_PREVIOUS = "Status changed from %s to %s";
    private String title;
    private LocalDate dueDate;
    private Enums status;
    private List<EventLog> logs = new ArrayList<>();

    public BoardItem(String title, LocalDate dueDate) {
        validateTitle(title);
        this.title = title;
        validateDueDate(dueDate);
        this.dueDate = dueDate;
        setStatus(Enums.Open);
        logs.add(new EventLog("Item created: " + viewInfo()));
    }

    private void validateTitle(String title) {
        if (title.length() < MIN_TITLE_LENGTH || title.length() > MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException(TITLE_LENGTH_ERROR);
        }
    }

    public void setTitle(String title) {
        validateTitle(title);
        logs.add(new EventLog(String.format(TITLE_CHANGED, this.title, title)));
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    private void validateDueDate(LocalDate dueDate) {
        if(!LocalDate.now().isBefore(dueDate)) {
            throw new IllegalArgumentException(DATE_ERROR);
        }
    }

    public void setDueDate(LocalDate dueDate) {
        validateDueDate(dueDate);
        logs.add(new EventLog(String.format(DATE_CHANGED, this.dueDate, dueDate)));
        this.dueDate = dueDate;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    private void setStatus(Enums status) {
        this.status = status;
    }

    public Enums getStatus() {
        return status;
    }

    public List<EventLog> getLogs() {
        return logs;
    }

    public Enums advanceStatus(){
        if (status == Enums.Verified) {
            logs.add(new EventLog("Can't advance, already at Verified."));
        }
        if(status != Enums.Verified){
            logs.add(new EventLog(String.format(STATUS_CHANGED_NEXT, this.status, status.next())));
            status = status.next();
        }
        return status;
    }

    public Enums revertStatus(){
        if (status == Enums.Open) {
            logs.add(new EventLog("Can't revert, already at Open."));
        }
        if(status != Enums.Open){
            logs.add(new EventLog(String.format(STATUS_CHANGED_PREVIOUS, this.status, status.previous())));
            status = status.previous();
        }
        return status;
    }

    public String viewInfo() {
        return String.format("%s, [%s | %s]", title, status.toString(), dueDate.toString());
    }

    public void displayHistory () {
       StringBuilder display = new StringBuilder();
        for (EventLog log : logs) {
            display.append(log.viewInfo()).append("\n");
        }
        System.out.println(display.toString());
    }
}
