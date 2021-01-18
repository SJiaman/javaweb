package edu.gzu.lms.servlet.book;

import com.google.gson.Gson;
import com.mysql.cj.util.StringUtils;
import edu.gzu.lms.dao.BookDAO;
import edu.gzu.lms.dao.impl.BookDAOImpl;
import edu.gzu.lms.entity.BaseResponse;
import edu.gzu.lms.entity.Book;
import edu.gzu.lms.util.RequestUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/book/update")
public class BookUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        BookDAO bd = BookDAOImpl.getInstance();

        Gson gson = new Gson();
        String bookJson = RequestUtil.getRequestBody(req);
        // 修改时提交的数据
        Book bookBody = gson.fromJson(bookJson, Book.class);

        // 数据本地数据
        Book book = bd.getBookByName(bookBody.getBookName());
        if (!StringUtils.isNullOrEmpty(bookBody.getBookName()))
        {
            book.setBookName(bookBody.getBookName());
            book.setAuthor(bookBody.getAuthor());
            book.setPublish(bookBody.getPublish());
            book.setIsbn(bookBody.getIsbn());
            book.setLanguage(bookBody.getLanguage());
            book.setPrice(bookBody.getPrice());
            book.setType(bookBody.getType());
            book.setNumber(bookBody.getNumber());
        }

        int rows = bd.updateBook(book);
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
