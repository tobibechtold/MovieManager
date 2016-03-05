package de.moviemanager.model;

public class FilmBuilder {

    private Film film = new Film();

    public FilmBuilder title(String title) {
        film.setTitle(title);
        return this;
    }

    public FilmBuilder format(Format format) {
        film.setFormat(format);
        return this;
    }

    public FilmBuilder rating(int rating) {
        film.setRating(rating);
        return this;
    }

    public FilmBuilder comment(String comment) {
        film.setComment(comment);
        return this;
    }

    public Film build() {
        return film;
    }
}
