package de.moviemanager.control;

import de.moviemanager.model.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmViewController implements FilmController {

    private List<Film> filmList = new ArrayList<>();

    @Override
    public void add(Film film) {
        filmList.add(film);
    }

    @Override
    public void delete(Film film) {
        if (filmList.contains(film)) {
            filmList.remove(film);
        }
    }

    @Override
    public List<Film> getFilms() {
        return filmList;
    }
}
