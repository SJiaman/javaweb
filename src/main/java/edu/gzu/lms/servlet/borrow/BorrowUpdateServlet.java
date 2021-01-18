package edu.gzu.lms.servlet.borrow;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.cj.util.StringUtils;
import edu.gzu.lms.dao.BorrowDAO;
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


@WebServlet(urlPatterns = "/borrow/update")
public class BorrowUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        BorrowDAO bd = BorrowDAOImpl.getInstance();

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String borrowJson = RequestUtil.getRequestBody(req);
        // 修改时提交的数据
        Borrow borrowBody = gson.fromJson(borrowJson, Borrow.class);

        // 数据本地数据
        Borrow borrow = bd.getBorrowById(borrowBody.getBorrowId());

        borrow.setBookId(borrowBody.getBookId());
        borrow.setReaderId(borrowBody.getReaderId());
        borrow.setLendDate(borrowBody.getLendDate());
        borrow.setBackDate(borrowBody.getBackDate());

        int rows = bd.updateBorrow(borrow);
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
