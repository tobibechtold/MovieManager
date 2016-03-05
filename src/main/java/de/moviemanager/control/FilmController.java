package de.moviemanager.control;

import de.moviemanager.model.Film;

import java.util.List;

public interface FilmController {

    void add(Film film);

    void delete(Film film);

    List<Film> getFilms();





}
