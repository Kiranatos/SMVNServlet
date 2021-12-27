package net.kiranatos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo07JSPServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("simpleOutput", new Poem());
        final List<String> operations = new ArrayList<>();
        operations.add("eq – == проверка на равенство");
        operations.add("ne – != проверка на неравенство");
        operations.add("lt – < строго менее чем");
        operations.add("gt – > строго более чем");
        operations.add("le – <= меньше либо равно чему-то");
        operations.add("ge – >= больше или равно чему-то");
        req.setAttribute("keyOperations", operations);

        req.setAttribute("myCondition", true);

        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
    }

    public static class Poem {
        private String text = "Peace is a lie. There is only Passion. \n"
                + "Through Passion I gain Strength. \n"
                + "Through Strength I gain Power. \n"
                + "Through Power I gain Victory. \n"
                + "Through Victory my chains are Broken. The Force shall free me.";

        public String getText() {
            return text;
        }
    }
}