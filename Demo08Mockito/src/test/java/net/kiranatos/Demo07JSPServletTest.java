package net.kiranatos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import org.junit.Test;
import org.mockito.Mockito;

public class Demo07JSPServletTest {
    private final static String path = "/WEB-INF/view/index.jsp";

    @Test
    public void whenCallDoGetThenServletReturnIndexPage() throws ServletException, IOException {

        final Demo07JSPServlet servlet = new Demo07JSPServlet();

        /* Mockito.mock - create mock-object of class, which we cant make in normal way. Use reflection inside.    */
        final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = Mockito.mock(RequestDispatcher.class);
        /* Создаем dispatcher для поведения описанного ниже. Мы не можем его заsetить в request, поэтому создаем мок-объект */

        /* задаем поведение, как он должен работать:
        .когда вызывается метод getRequestDispatcher с параметром path .вернуть dispatcher*/
        Mockito.when(request.getRequestDispatcher(path)).thenReturn(dispatcher); 
        /*       var... args => OngoingStubbing<T> thenReturn(T value, T... values);
        в метод возможно задать много параметров: .thenReturn(disp1, disp2, disp3, ...) 
        disp1 - вернётся на 1-м вызове, disp2 - на 2-м, disp3 - на 3-м, ...   */

        servlet.doGet(request, response);

        Mockito.verify(request, Mockito.times(1)).getRequestDispatcher(path); // проверка, что был вызван метод getRequestDispatcher один раз
        Mockito.verify(request, Mockito.never()).getSession(); // проверка, что метод getSession не вызывался
        Mockito.verify(dispatcher).forward(request, response); // проверка, что был вызван метод forward
    }
}