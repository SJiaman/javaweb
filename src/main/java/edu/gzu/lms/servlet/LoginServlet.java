package edu.gzu.lms.servlet;

import edu.gzu.lms.dao.AdminDAO;
import edu.gzu.lms.dao.impl.AdminDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        AdminDAO ad = AdminDAOImpl.getInstance();

        if (ad.checkUsernameAndPassword(username, password)) {
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            req.setAttribute("msg", "登录成功");
            resp.sendRedirect(req.getContextPath() + "/");
        }else if (ad.checkUsername(username)) {
            req.setAttribute("msg","密码错误");
            req.getRequestDispatcher("/page/login.jsp").forward(req, resp);
        }else {
            req.setAttribute("msg", "登录失败,用户不存在");
            req.getRequestDispatcher("/page/login.jsp").forward(req, resp);
        }
    }
}
