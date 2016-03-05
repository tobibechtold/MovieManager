package de.moviemanager.view;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import de.moviemanager.control.FilmController;
import de.moviemanager.control.FilmViewController;

import javax.servlet.annotation.WebServlet;

/**
 *
 */
@Theme("mytheme")
@Widgetset("de.moviemanager.MyAppWidgetset")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        FilmController filmController = new FilmViewController();
        FilmVaadinView filmVaadinView = new FilmVaadinView(filmController);

        filmVaadinView.setMargin(true);
        filmVaadinView.setSpacing(true);

        setContent(filmVaadinView);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
