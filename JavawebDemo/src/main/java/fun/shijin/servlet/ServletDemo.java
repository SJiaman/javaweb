package fun.shijin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName ServletDemo
 * @Description
 * @Author Shijin
 * @Date 2020/10/17 9:20
 */

@WebServlet(urlPatterns = "/hi")
public class ServletDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        //设置cookie
        Cookie cookie = new Cookie("name", name);
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);

        //获取cookie
        Cookie[] cookies = req.getCookies();
        for (Cookie item : cookies){
            String j = item.getValue();
        }

        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        writer.write("<h1>Hello,World!</h1>" +
                name + "<h1>is a good man</h1>" );

        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

