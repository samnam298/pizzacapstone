package com.pluralsight;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getAll() {
        return items;
    }
}
