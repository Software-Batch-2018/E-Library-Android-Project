package com.example.elibrary;

public class ListData {

        private String title;
        private String imageUrl;

        public ListData(String title, String imageUrl) {
            this.title = title;
            this.imageUrl = imageUrl;
        }

        public String getTitle() {
            return title;
        }

        public String getImageUrl() {
            return imageUrl;
        }

}
