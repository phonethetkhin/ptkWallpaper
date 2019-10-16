package com.example.ptkwallpaper.Models;



import java.util.List;

public class PhotoModel {

private int total_results;
    private int page;

    private int perPage;

    private List<Photo> photos;

    public PhotoModel(int total_results, int page, int perPage, List<Photo> photos) {
        this.total_results = total_results;
        this.page = page;
        this.perPage = perPage;
        this.photos = photos;
    }

    public int getTotal_results() {
        return total_results;
    }

    public int getPage() {
        return page;
    }

    public int getPerPage() {
        return perPage;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public class Photo {


        private int id;


        private Src src;

        public Photo(int id, Src src) {
            super();
            this.id = id;
            this.src = src;
        }

        public int getId() {
            return id;
        }

        public Src getSrc() {
            return src;
        }

    }
    public class Src {


        private String original;

        public Src(String original) {
            super();
            this.original = original;

        }

        public String getOriginal() {
            return original;
        }



    }
}
