package com.example.elibrary.model;

import java.util.ArrayList;

public class Subjects {
    public ArrayList<SubjectItem> items;
    public LevelItem.Meta meta;


    public ArrayList<SubjectItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<SubjectItem> items) {
        this.items = items;
    }

    public LevelItem.Meta getMeta() {
        return meta;
    }

    public void setMeta(LevelItem.Meta meta) {
        this.meta = meta;
    }

}
