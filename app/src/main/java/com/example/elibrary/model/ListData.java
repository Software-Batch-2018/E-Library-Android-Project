package com.example.elibrary.model;

public class ListData {
        private String id;
        private String title;
        private String imageUrl;

        public ListData(String title, String imageUrl, String id) {
            this.title = title;
            this.imageUrl = imageUrl;
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public String getLevelId(){
            return id;
        }

}
