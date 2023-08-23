import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class EventLog {

    private final String description;
    private final LocalDateTime timeStamp;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");



    public EventLog(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Description can not be empty.");
        }
        this.description = description;
        this.timeStamp = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public String viewInfo () {
        return String.format("[%s], %s", formatter.format(timeStamp), description);
    }
}
