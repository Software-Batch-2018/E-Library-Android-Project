package com.example.elibrary.model;

import java.util.ArrayList;

public class LevelItem{
    public String level_id;
    public String level;
    public String level_img;
    public ArrayList<Object> subjects;

    public LevelItem(String level_id, String level, String level_img, ArrayList<Object> subjects) {
        this.level_id = level_id;
        this.level = level;
        this.level_img = level_img;
        this.subjects = subjects;
    }

    public String getLevel_id() {
        return level_id;
    }

    public void setLevel_id(String level_id) {
        this.level_id = level_id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel_img() {
        return level_img;
    }

    public void setLevel_img(String level_img) {
        this.level_img = level_img;
    }

    public ArrayList<Object> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Object> subjects) {
        this.subjects = subjects;
    }

    public static class Meta{
        public int totalItems;
        public int itemCount;
        public int itemsPerPage;
        public int totalPages;
        public int currentPage;
    }
}
