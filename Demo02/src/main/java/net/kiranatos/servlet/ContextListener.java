package net.kiranatos.servlet;

import net.kiranatos.model.User;
import net.kiranatos.util.Utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class ContextListener implements ServletContextListener {

    private Map<Integer, User> users;

    /* Тема: Область видимости всего приложения
    - интерафейс ServletContextListener позволяет записывать в контекст всего приложения данные, до того как будут созданы сервлеты
    - ServletContext реализует сущность области видимости для всего приложения
    - метод contextInitialized срабатывает до всех сервлетов и их init-методов
    - необходимо поставить аннотацию @WebListener
    - servletContextEvent.getServletContext() получить контекст всех сервлетов
    - servletContext.setAttribute("users", users) положить свой объект в контекст.
    */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        final ServletContext servletContext = servletContextEvent.getServletContext();

        users = new ConcurrentHashMap<>(); //потокобезопасный

        servletContext.setAttribute("users", users); //ключ-значение

        final User user = Utils.createStubUser(1, "Первый", 10);
        this.users.put(user.getId(), user);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[method contextDestroyed in ContextListener class]");
        //Close recourse.
        users = null;
    }
}