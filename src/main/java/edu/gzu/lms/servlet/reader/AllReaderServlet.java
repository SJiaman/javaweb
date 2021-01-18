package edu.gzu.lms.servlet.reader;

import com.google.gson.Gson;
import com.mysql.cj.util.StringUtils;
import edu.gzu.lms.dao.ReaderDAO;
import edu.gzu.lms.dao.impl.ReaderDAOImpl;
import edu.gzu.lms.entity.BaseResponse;
import edu.gzu.lms.entity.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/all/reader")
public class AllReaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");

        ReaderDAO rd = ReaderDAOImpl.getInstance();
        List<Reader> books = rd.getAllReader(StringUtils.isNullOrEmpty(page) ? 1 : Integer.parseInt(page),
                StringUtils.isNullOrEmpty(limit) ? 10 : Integer.parseInt(limit));

        BaseResponse<List<Reader>> baseResponse = new BaseResponse<>();
        //获取总行书数
        Long rows = rd.countReader();
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
