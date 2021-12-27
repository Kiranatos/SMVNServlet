package net.kiranatos.servlet;

import net.kiranatos.model.User;
import net.kiranatos.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AddUserServlet extends HttpServlet {
    private Map<Integer, User> users;
    private AtomicInteger id;

    @Override
    public void init() throws ServletException {
        final Object users = getServletContext().getAttribute("users");
        if (users == null || !(users instanceof ConcurrentHashMap)) {
            throw new IllegalStateException("You're repo does not initialize!");
        } else {
            this.users = (ConcurrentHashMap<Integer, User>) users;
        }

        id = new AtomicInteger(2);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        if (Utils.requestIsValid(req)) {
            final String name = req.getParameter("name");
            final String age = req.getParameter("age");

            final User user = new User();
            final int id = this.id.getAndIncrement();
            user.setId(id);
            user.setAge(Integer.valueOf(age));
            user.setName(name);

            users.put(id, user);
        }

        resp.sendRedirect(req.getContextPath() + "/");
        /* в отличие от req.getRequestDispatcher(index).forward(req, resp), 
        метод resp.sendRedirect(req.getContextPath() + "/") не отправляет данные, 
        а даёт команду серверу сделать запрос по определённому url. Из-за этого этот метод работает медленее */
    }
}
