package edu.gzu.lms.servlet.reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.cj.util.StringUtils;
import edu.gzu.lms.dao.ReaderDAO;
import edu.gzu.lms.dao.impl.ReaderDAOImpl;
import edu.gzu.lms.entity.BaseResponse;
import edu.gzu.lms.entity.Reader;
import edu.gzu.lms.util.RequestUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/reader/update")
public class ReaderUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        ReaderDAO bd = ReaderDAOImpl.getInstance();

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String readerJson = RequestUtil.getRequestBody(req);
        // 修改时提交的数据
        Reader readerBody = gson.fromJson(readerJson, Reader.class);

        // 数据本地数据
        Reader reader = bd.getReaderByName(readerBody.getReaderName());
        if (!StringUtils.isNullOrEmpty(readerBody.getReaderName()))
        {
            reader.setReaderName(readerBody.getReaderName());
            reader.setSex(readerBody.getSex());
            reader.setBirth(readerBody.getBirth());
            reader.setAddress(readerBody.getAddress());
            reader.setPhone(readerBody.getPhone());
            reader.setPassword(readerBody.getPassword());
        }

        int rows = bd.updateReader(reader);
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
