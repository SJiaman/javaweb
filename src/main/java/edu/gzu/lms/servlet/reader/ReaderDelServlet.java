package edu.gzu.lms.servlet.reader;

import com.google.gson.Gson;
import edu.gzu.lms.dao.ReaderDAO;
import edu.gzu.lms.dao.impl.ReaderDAOImpl;
import edu.gzu.lms.entity.BaseResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/reader/del")
public class ReaderDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("readerId");

        ReaderDAO rd = ReaderDAOImpl.getInstance();
        int rows = rd.deleteReaderById(id);
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

        Gson gson = new Gson();
        String json = gson.toJson(baseResponse);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
    }
}
