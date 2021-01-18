package edu.gzu.lms.servlet.borrow;

import com.google.gson.Gson;
import com.mysql.cj.util.StringUtils;
import edu.gzu.lms.dao.BorrowDAO;
import edu.gzu.lms.dao.impl.BorrowDAOImpl;
import edu.gzu.lms.entity.BaseResponse;
import edu.gzu.lms.entity.Borrow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/all/borrow")
public class AllBorrowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");

        BorrowDAO bd = BorrowDAOImpl.getInstance();
        List<Borrow> books = bd.getAllBorrow(StringUtils.isNullOrEmpty(page) ? 1 : Integer.parseInt(page),
                StringUtils.isNullOrEmpty(limit) ? 10 : Integer.parseInt(limit));

        BaseResponse<List<Borrow>> baseResponse = new BaseResponse<>();
        Long rows = bd.countBorrow();
        baseResponse.setCount(rows);
        baseResponse.setCode(200);
        baseResponse.setData(books);
        baseResponse.setMsg("请求成功！");

        Gson gson = new Gson();
        String json = gson.toJson(baseResponse);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
    }
}
