package com.example.elibrary.model;

public class ChapterItem {

    public String content_id;
    public String content_title;
    public String title_image;
    public String content;
    public String created_at;
    public String updated_at;

    public ChapterItem(String content_id, String content_title, String title_image, String content) {
        this.content_id = content_id;
        this.content_title = content_title;
        this.title_image = title_image;
        this.content = content;
    }

    public String getContent_id() {
        return content_id;
    }

    public void setContent_id(String content_id) {
        this.content_id = content_id;
    }

    public String getContent_title() {
        return content_title;
    }

    public void setContent_title(String content_title) {
        this.content_title = content_title;
    }

    public String getTitle_image() {
        return title_image;
    }

    public void setTitle_image(String title_image) {
        this.title_image = title_image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
