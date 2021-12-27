package net.kiranatos.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;
import net.kiranatos.dao.UserDAO;
import net.kiranatos.model.User;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("[AuthFilter:init]");
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response,  final FilterChain filterChain) throws IOException, ServletException {        
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        @SuppressWarnings("unchecked")
        final AtomicReference<UserDAO> dao = (AtomicReference<UserDAO>) req.getServletContext().getAttribute("dao");

        final HttpSession session = req.getSession();

        System.out.printf("[class AuthFilter, method doFilter: %s %s]%n", login, password);
        //Logged user.
        if (nonNull(session) && nonNull(session.getAttribute("login")) && nonNull(session.getAttribute("password"))) {
            final User.ROLE role = (User.ROLE) session.getAttribute("role");
            System.out.print("\n{ 1 ");
            moveToMenu(req, res, role);
        } else if (dao.get().userIsExist(login, password)) {
            final User.ROLE role = dao.get().getRoleByLoginPassword(login, password);
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);
            System.out.print("\n{ 2 ");
            moveToMenu(req, res, role);
        } else {
            System.out.print("\n{ 3 ");
            moveToMenu(req, res, User.ROLE.UNKNOWN);
        }
    }

    /**
     * Move user to menu.
     * If access 'admin' move to admin menu.
     * If access 'user' move to user menu.
     */
    private void moveToMenu(final HttpServletRequest req, final HttpServletResponse res, final User.ROLE role) throws ServletException, IOException {        
        if (role.equals(User.ROLE.ADMIN)) {
            System.out.println(" admin_menu.jsp }");
            req.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(req, res);
        } else if (role.equals(User.ROLE.USER)) {
            System.out.println(" user_menu.jsp }");
            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, res);
        } else {
            System.out.println(" login.jsp }");
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
        }
    }

    @Override
    public void destroy() {    }
}