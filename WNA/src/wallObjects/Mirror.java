package wallObjects;

import Items.Item;

import java.util.ArrayList;
import java.util.List;

public class Mirror extends WallObject implements Checkable {
    private boolean containsKey = false;
    private List<Item> mirrorItems = new ArrayList<>();
    private int id = 0;

    public List<Item> getMirrorItems() {
        return mirrorItems;
    }

    public void addItems(Item key1) {
        mirrorItems.add(key1);
    }

    @Override
    public List<Item> check() {
        for (Item item: mirrorItems
             ) {
            System.out.println(item.toString()+" was acquired”");
        }
        return getMirrorItems();
    }

    @Override
    public String getObjectName() {
        return String.valueOf("You See a silhouette of you.");
    }
    public void printItems() {
        for (Item item : mirrorItems) {
            System.out.println(item.toString() + " was acquired.");
        }
    }
}