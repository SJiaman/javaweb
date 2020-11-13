package fun.shijin.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @Author Shijin
 * @Date 2020/11/1 17:01
 */

public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String date = new Date().toString();
        String ip = request.getRemoteAddr();
        System.out.println(date + "ip:" + ip);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
