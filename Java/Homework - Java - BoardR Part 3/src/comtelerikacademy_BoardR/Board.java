package comtelerikacademy_BoardR;

import java.util.ArrayList;

public class Board {

    private final ArrayList<BoardItem> items;

    public Board() {
         items = new ArrayList<>();
    }

    public ArrayList<BoardItem> getItems() {
         return new ArrayList<>(items);
    }

    public void addItem (BoardItem item) {
        if (getItems().contains(item)) {
            throw new IllegalArgumentException("Item already in the list.");
        }
        items.add(item);
    }

    public int totalItems () {
         int totalItem = items.size();
         return totalItem;
    }

}
