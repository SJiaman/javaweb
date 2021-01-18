package edu.gzu.lms.dao.impl;

import edu.gzu.lms.dao.BaseDAO;
import edu.gzu.lms.dao.BookDAO;
import edu.gzu.lms.entity.Book;

import java.util.List;


public class BookDAOImpl extends BaseDAO implements BookDAO {

    private static BookDAOImpl instance;

    public static final BookDAOImpl getInstance() {
        if (instance == null) {
            instance = new BookDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Book> getALLBooks(int page, int limit) {
        String sql = "select * from book limit ?, ?";
        return getForList(Book.class, sql, page, limit);
    }


    @Override
    public Book getBookByName(String name) {
        String sql = "select * from book where bookName = ?";
        return getInstanceByName(Book.class, sql, name);
    }

    @Override
    public int deleteBookById(String id) {
        String sql = "delete from book where bookId = ?";
        return update(sql, id);
    }

    @Override
    public int insertBook(Book book) {
        String sql = "insert into book(bookName,author,publish,isbn,language,price,type,number) values(?,?,?,?,?,?,?,?)";
        return update(sql, book.getBookName(), book.getAuthor(), book.getPublish(), book.getIsbn(),
                book.getLanguage(), book.getPrice(), book.getType(), book.getNumber());
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update book set bookName = ?,author = ?, publish = ?, isbn = ?, language = ?, " +
                "price = ?, type = ?, number = ? where bookId = ?";
        return update(sql, book.getBookName(), book.getAuthor(), book.getPublish(), book.getIsbn(),
                book.getLanguage(), book.getPrice(), book.getType(), book.getNumber(), book.getBookId());
    }

    @Override
    public Long countBook() {
        String sql = "select count(*) from book";
        return getValue(sql);
    }

}
