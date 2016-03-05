package de.moviemanager.view;

import de.moviemanager.control.FilmController;
import de.moviemanager.model.Film;
import de.moviemanager.model.FilmBuilder;
import de.moviemanager.model.Format;

import java.util.List;
import java.util.Scanner;

public class FilmConsoleView implements FilmView {

    private FilmController filmController;
    private FilmBuilder builder;
    private Scanner s;

    public FilmConsoleView(FilmController filmController) {
        this.filmController = filmController;
    }

    @Override
    public void go() {
        while (true) {
            System.out.println("Willkommen im MovieManager");
            System.out.println("Wählen sie eine Aktion:");
            System.out.println("(1) Filme anzeigen");
            System.out.println("(2) Film hinzufügen");
            System.out.println("(3) Film löschen");
            s = new Scanner(System.in);
            int auswahl = s.nextInt();
            if (auswahl == 1) {
                showFilms();
            } else if (auswahl == 2) {
                readFilm();
            }
        }
    }

    private void readFilm() {
        System.out.println("Geben sie den Titel ein:");
        String titel = s.next();
        System.out.println("Geben sie das Format ein:");
        System.out.println("(1) DVD");
        System.out.println("(2) Blu-Ray");
        System.out.println("(3) Digital");
        Format format = getFormatFor(s.nextInt());
        System.out.println("Geben sie das Rating ein:");
        int rating = s.nextInt();
        builder = new FilmBuilder();
        Film film = builder.title(titel).format(format).rating(rating).build();
        addFilm(film);
    }

    private Format getFormatFor(int i) {
        if (i == 1) {
            return Format.DVD;
        } else if (i == 2) {
            return Format.BLURAY;
        }
        return Format.DIGITAL;
    }

    @Override
    public void showFilms() {
        List<Film> films = filmController.getFilms();

        for (Film movie : films) {
            System.out.println("Titel: " + movie.getTitle() + " ," + " Rating: " + movie.getRating() + " Format: " + movie.getFormat() + " Kommentar: " + movie.getComment());
        }
        System.out.println();
    }

    @Override
    public void addFilm(Film film) {
        filmController.add(film);
    }

    @Override
    public void deleteFilm(Film film) {
        filmController.delete(film);
    }
}
