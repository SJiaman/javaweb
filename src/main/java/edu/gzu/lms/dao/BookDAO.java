package edu.gzu.lms.dao;

import edu.gzu.lms.entity.Book;

import java.util.List;


public interface  BookDAO {
    /**
     * 获取全部书籍
     * @return
     */
    List<Book> getALLBooks(int page, int limit);

    /**
     * 通过id获取书籍
     * @param id
     * @return
     */
    Book getBookByName(String id);

    /**
     * 通过id删除书籍
      * @param id
     * @return
     */
    int deleteBookById(String id);

    /**
     * 插入书籍
     * @param book
     * @return
     */
    int insertBook(Book book);

    /**
     * 更新书籍
     * @param book
     * @return
     */
    int updateBook(Book book);


    /**
     * 获取书籍的数量
     * @return
     */
    Long countBook();
}
