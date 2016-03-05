package de.moviemanager.view;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.*;
import de.moviemanager.control.FilmController;
import de.moviemanager.model.Film;
import de.moviemanager.model.FilmBuilder;
import de.moviemanager.model.Format;

import java.util.ArrayList;
import java.util.Collection;

public class FilmVaadinView extends HorizontalLayout implements FilmView {

    private FilmController filmController;
    private Grid grid;
    private BeanItemContainer<Film> container;

    public FilmVaadinView(FilmController filmController) {
        this.filmController = filmController;
        init();
    }

    private void init() {
        container = new BeanItemContainer<>(Film.class, new ArrayList<>());
        grid = new Grid(container);
        grid.setHeight(500.0f, Unit.PIXELS);
        grid.setWidth(800.0f, Unit.PIXELS);
        grid.setColumnOrder("title", "format", "rating", "comment");
        Button buttonAdd = new Button("Hinzufügen");
        buttonAdd.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                showAddWindow();
            }
        });
        addComponent(grid);
        addComponent(buttonAdd);
        setSizeFull();
        showFilms();
    }

    private void showAddWindow() {
        Window window = new Window();
        FormLayout formLayout = new FormLayout();

        TextField textTitel = new TextField();
        textTitel.setInputPrompt("Titel eingeben");

        TextField textRating = new TextField();
        textRating.setInputPrompt("Film bewerten");

        ComboBox comboFormat = new ComboBox();
        comboFormat.setNullSelectionAllowed(false);
        comboFormat.addItem(Format.BLURAY);
        comboFormat.addItem(Format.DIGITAL);
        comboFormat.addItem(Format.DVD);

        TextField textComment = new TextField();
        textComment.setInputPrompt("Kommentar");

        Button btnAdd = new Button("Hinzufügen");
        btnAdd.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                String titel = textTitel.getValue();
                int rating = 0;
                try {
                    rating = Integer.parseInt(textRating.getValue());
                }
                catch (Exception e)
                {
                    rating = 0;
                }
                Format format = (Format) comboFormat.getValue();
                String comment = textComment.getValue();

                FilmBuilder filmBuilder = new FilmBuilder();
                Film film = filmBuilder//
                        .rating(rating)//
                        .title(titel)//
                        .format(format)//
                        .comment(comment)//
                        .build();
                addFilm(film);
                showFilms();
                window.close();
            }
        });

        formLayout.addComponents(textTitel, textRating, comboFormat, textComment, btnAdd);
        window.setContent(formLayout);
        window.setWidth(300.0f, Unit.PIXELS);

        UI.getCurrent().addWindow(window);
    }

    @Override
    public void showFilms() {
        Collection<Film> films = filmController.getFilms();
        container.removeAllItems();
        container.addAll(films);
    }

    @Override
    public void deleteFilm(Film film) {
        filmController.delete(film);
    }

    @Override
    public void addFilm(Film film) {
        filmController.add(film);
    }

    @Override
    public void go() {

    }
}
