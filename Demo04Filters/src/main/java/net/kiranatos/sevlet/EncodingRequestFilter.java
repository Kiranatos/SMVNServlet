package net.kiranatos.sevlet;

import javax.servlet.*;
import java.io.IOException;

public class EncodingRequestFilter implements Filter {
    @Override
    public void destroy() {    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {  }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("[EncodingRequestFilter]");
        req.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }
}