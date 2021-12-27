package net.kiranatos.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.servlet.ServletConfig;
import net.kiranatos.model.User;

public class GetIndexPageServlet extends HttpServlet {
    private final static String index = "/WEB-INF/view/index.jsp";
    private List<User> users;

    @Override
    public void init() throws ServletException {
        users = new CopyOnWriteArrayList<>(); //потокобезопасный
        users.add(new User("Java", 10));
        users.add(new User("Vision", 20));
        System.out.println("\n\n\n[my method init]");
    }
    
    /* ServletConfig - мета-информация о сервлете извлечённая из web.xml
     - init(ServletConfig config) - не переопределяют. В случае переопределения, 
    важно вызвать super.init(config) - иначе сервлет не создастся
     - init() - создан специально для переопределения и инициализации параметров, 
    чтоб не трогать метод init(ServletConfig config). super.init() вызывать не нужно.
    Метод init() заменяет конструктор.
    Сначала вызывается init(ServletConfig config) потом init(). Вызываются один раз
    т.к. servlet is singleton.  */
    @Override
    public void init(ServletConfig config) throws ServletException {        
        super.init(config);
    }

    @Override // при остановке приложения 
    public void destroy() {    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", users); //ключ-значение [s01], - так засовываем данные на страницу
        req.getRequestDispatcher(index).forward(req, resp); // отправляет клиенту данные
        System.out.println("\n\n\n[my method doGet]");        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8"); // в соответствии с <%@ page contentType="text/html;charset=UTF-8" language="java" %>

        if (!requestIsValid(req)) { 
            doGet(req, resp); /* из video, if data not valid: render page without data. But due to code below, it will be add in list anyway, so code is not quite correct */
            System.out.println("[if-not in doPost]");
        }

        final String name = req.getParameter("name"); // ключ из тега <input name="name">
        final String age = req.getParameter("age");

        final User user = new User(name, Integer.valueOf(age));

        users.add(user);
        doGet(req, resp); // вызываем метод, чтобы отрендерить страницу с новым объектом
    }

    private boolean requestIsValid(final HttpServletRequest req) {
        final String name = req.getParameter("name");
        final String age = req.getParameter("age");

        return name != null && name.length() > 0 &&
                age != null && age.length() > 0 &&
                age.matches("[+]?\\d+");
    }
}