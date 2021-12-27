package net.kiranatos.sevlet;

import javax.servlet.*;
import java.io.IOException;

public class EncodingResponseFilter implements Filter {

    public void destroy() { }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        System.out.println("[EncodingResponseFilter]");
        chain.doFilter(req, resp); /* passing to other filters in chain
        если не передать, остальные сервлеты и фильтры не запустятся */
    }

    public void init(FilterConfig config) throws ServletException { }
}