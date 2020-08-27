package com.bicubic.amusementpark.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by admin on 15-Nov-16.
 */

public class Movies {


    /**
     * title : Dawn of the Planet of the Apes
     * image : http://api.androidhive.info/json/movies/1.jpg
     * rating : 8.3
     * releaseYear : 2014
     * genre : ["Action","Drama","Sci-Fi"]
     */

    @SerializedName("title")
    private String title;
    @SerializedName("image")
    private String image;
    @SerializedName("rating")
    private double rating;
    @SerializedName("releaseYear")
    private int releaseYear;
    @SerializedName("genre")
    private List<String> genre;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                ", releaseYear=" + releaseYear +
                ", genre=" + genre +
                '}';
    }
}
