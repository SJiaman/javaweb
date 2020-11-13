package fun.shijin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author Shijin
 * @Date 2020/11/13 8:35
 * @Desc
 */

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username != null && password != null) {
            //获取session对象
            HttpSession session = req.getSession();

            //设置session属性
            session.setAttribute("name", username);
            session.setAttribute("password", password);

            //重导向index页面
            resp.sendRedirect(req.getContextPath() + "index.jsp");
        }
    }
}
