package de.moviemanager.model;

public class Film {

    private String title;
    private Format format;
    private int rating;
    private String comment;
    private int likes;

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public Format getFormat() {
        return format;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }


}
