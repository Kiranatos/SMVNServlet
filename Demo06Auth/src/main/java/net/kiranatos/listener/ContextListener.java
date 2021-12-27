package net.kiranatos.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicReference;
import net.kiranatos.dao.UserDAO;
import net.kiranatos.model.User;
import static net.kiranatos.model.User.ROLE.ADMIN;
import static net.kiranatos.model.User.ROLE.USER;

// ContextListener put user dao to servlet context. 
@WebListener
public class ContextListener implements ServletContextListener {
    // Fake database connector.
    private AtomicReference<UserDAO> dao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("[ContextListener:contextInitialized]");
        dao = new AtomicReference<>(new UserDAO());
        dao.get().add(new User(1, "dima", "111", ADMIN));
        dao.get().add(new User(2, "kira", "222", USER));

        final ServletContext servletContext = servletContextEvent.getServletContext();

        servletContext.setAttribute("dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dao = null;
    }
}