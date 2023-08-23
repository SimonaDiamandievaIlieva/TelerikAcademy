package comtelerikacademy_BoardR;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class EventLog {

    protected static final String INVALID_DESCRIPTION = "Description can not be empty.";
    private final String description;
    private final LocalDateTime timeStamp;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");

    public EventLog(String description) {
        validateDescriptionLength(description);
        this.description = description;
        this.timeStamp = LocalDateTime.now();
    }

    private void validateDescriptionLength (String description) {
        if (description.isEmpty()) {
            throw new IllegalArgumentException(INVALID_DESCRIPTION);
        }
    }

    public EventLog() {
        throw new IllegalArgumentException(INVALID_DESCRIPTION);
    }

    public String getDescription() {
        return description;
    }

    public String viewInfo () {
        return String.format("[%s] %s", formatter.format(timeStamp), description);
    }
}
