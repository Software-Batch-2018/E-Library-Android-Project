package com.example.elibrary.model;

import com.example.elibrary.model.LevelItem;

import java.util.ArrayList;


public class Levels{
    public ArrayList<LevelItem> items;
    public LevelItem.Meta meta;


    public ArrayList<LevelItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<LevelItem> items) {
        this.items = items;
    }

    public LevelItem.Meta getMeta() {
        return meta;
    }

    public void setMeta(LevelItem.Meta meta) {
        this.meta = meta;
    }

}
