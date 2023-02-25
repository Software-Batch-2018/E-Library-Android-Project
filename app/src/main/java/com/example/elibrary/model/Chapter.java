package com.example.elibrary.model;

import java.util.ArrayList;

public class Chapter {
    public ArrayList<ChapterItem> items;
    public LevelItem.Meta meta;


    public ArrayList<ChapterItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<ChapterItem> items) {
        this.items = items;
    }

    public LevelItem.Meta getMeta() {
        return meta;
    }

    public void setMeta(LevelItem.Meta meta) {
        this.meta = meta;
    }

}
