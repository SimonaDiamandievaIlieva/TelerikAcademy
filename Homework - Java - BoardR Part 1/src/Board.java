import java.util.ArrayList;
import java.util.List;

public class Board {

    static ArrayList<BoardItem> items = new ArrayList<>();

    private Board() {
    }

    public void addItem (BoardItem item) {
        if (getItems().contains(item)){
            throw new IllegalArgumentException("-1");
        }
        items.add(item);
    }

    public ArrayList<BoardItem> getItems() {
        return new ArrayList<>(items);
    }
}
