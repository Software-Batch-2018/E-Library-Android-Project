package com.example.elibrary.model;

public class SubjectItem {
    public String subject_id;
    public String subject_name;
    public String subject_img;

    public SubjectItem(String subject_id, String subject_name, String subject_img) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.subject_img = subject_img;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_img() {
        return subject_img;
    }

    public void setSubject_img(String subject_img) {
        this.subject_img = subject_img;
    }
}
