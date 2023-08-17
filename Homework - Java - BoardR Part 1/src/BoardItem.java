import java.time.LocalDate;

public class BoardItem {

    private static final int MIN_TITLE_LENGTH = 5;
    public static final int MAX_TITLE_LENGTH = 30;
     String title;
     LocalDate dueDate;
     Enums status;

    public BoardItem(String title, LocalDate dueDate) {
        setTitle(title);
        setDueDate(dueDate);
        setStatus(Enums.Open);
    }

    public void setTitle(String title) {
        if (title.length() >= MIN_TITLE_LENGTH && title.length() <= MAX_TITLE_LENGTH) {
            this.title = title;
        }
    }

    public void setDueDate(LocalDate dueDate) {
        if(LocalDate.now().isBefore(dueDate)) {
            this.dueDate = dueDate;
        }
    }

    public void setStatus(Enums status) {
        this.status = status;
    }

    public Enums advanceStatus(){
        if(status != Enums.Verified){
            status = status.next();
        }
        return status;
    }

    public Enums revertStatus(){
        if(status != Enums.Open){
            status = status.previous();
        }
        return status;
    }

    public String viewInfo() {
        return String.format("%s, [%s | %s]", title, status.toString(), dueDate.toString());
    }

}
