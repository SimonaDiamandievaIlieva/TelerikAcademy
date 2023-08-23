package comtelerikacademy_BoardR;

import java.time.LocalDate;

public class Issue extends BoardItem {

    private String description;
    public Issue (String title, String description, LocalDate dueDate) {
        super(title, dueDate);
        setDescription(description);
        setStatus(Status.OPEN);
    }

    public String getDescription() {
        return description;
    }

    final public void setDescription(String description) {
        if (description == null || description.equals("")) {
            throw new IllegalArgumentException("No description");
        }
        this.description = description;
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
