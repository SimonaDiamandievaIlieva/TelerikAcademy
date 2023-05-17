import java.util.ArrayList;

public class Board {

    private ArrayList<BoardItem> items = new ArrayList<>();

     Board() {
    }

    public ArrayList<BoardItem> getItems() {
        return items;
    }

    public void addItem (BoardItem item) {
        if (getItems().contains(item)) {
            throw new IllegalArgumentException("This item already exist.");
        }
        items.add(item);
    }

    public int totalItems () {
         int totalItem = items.size();
         return totalItem;
    }

}
