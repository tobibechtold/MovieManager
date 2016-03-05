package de.moviemanager.view;

import de.moviemanager.model.Film;

public interface FilmView {
    void showFilms();

    void addFilm(Film film);

    void deleteFilm(Film film);

    void go();
}
