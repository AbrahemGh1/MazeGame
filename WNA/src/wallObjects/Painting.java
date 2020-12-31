package wallObjects;

import Items.Item;
import wallObjects.Checkable;
import wallObjects.WallObject;

import java.util.ArrayList;
import java.util.List;

public class Painting extends WallObject implements Checkable {
    private List<Item> paintingItems = new ArrayList<>();
    private int id = 0;

    public List<Item> getItems() {
        return paintingItems;
    }

    public void addItems(Item key1) {
        paintingItems.add(key1);
    }

    @Override
    public List<Item> check() {
        printItems();
        return getItems();
    }

    @Override
    public String getObjectName() {
        return "painting";
    }

    public void printItems() {
        for (Item item : paintingItems) {
            System.out.println(item.toString() + " was acquired.");
        }
    }
}
