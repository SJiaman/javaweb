package edu.gzu.lms.servlet.borrow;

import com.google.gson.Gson;
import edu.gzu.lms.dao.BorrowDAO;
import edu.gzu.lms.dao.impl.BookDAOImpl;
import edu.gzu.lms.dao.impl.BorrowDAOImpl;
import edu.gzu.lms.entity.BaseResponse;
import edu.gzu.lms.entity.Borrow;
import edu.gzu.lms.util.RequestUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/borrow/add")
public class BorrowAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        Gson gson = new Gson();
        String borrowJson = RequestUtil.getRequestBody(req);
        // 修改时提交的数据
        Borrow borrowBody = gson.fromJson(borrowJson, Borrow.class);

        BorrowDAO bd = BorrowDAOImpl.getInstance();

        int rows = bd.insertBorrow(borrowBody);

        BaseResponse<Integer> baseResponse = new BaseResponse<Integer>();
        if (rows > 0)
        {
            baseResponse.setCode(200);
            baseResponse.setMsg("操作成功");
        }
        else
        {
            baseResponse.setCode(600);
            baseResponse.setMsg("操作失败");
        }
        baseResponse.setData(rows);

        String json = gson.toJson(baseResponse);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
    }
}
