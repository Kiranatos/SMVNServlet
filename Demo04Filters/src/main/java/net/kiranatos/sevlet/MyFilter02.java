package net.kiranatos.sevlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter02 implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fchain) throws IOException, ServletException {
        System.out.println("[My Filter # 02]");
        fchain.doFilter(req, resp);
    }

}
