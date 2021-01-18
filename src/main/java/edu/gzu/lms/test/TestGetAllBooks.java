package edu.gzu.lms.test;

import edu.gzu.lms.dao.impl.BookDAOImpl;
import edu.gzu.lms.entity.Book;
import org.junit.Test;
import java.util.List;

public class TestGetAllBooks {
    BookDAOImpl instance = BookDAOImpl.getInstance();

    @Test
    public void testGetAllBooks() {
        List<Book> bookList = instance.getALLBooks(1, 10);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    public void testGetCount() {
        Long countBook = instance.countBook();
        System.out.println(countBook);
    }

    @Test
    public void testGetBookByName() {
        Book book = instance.getBookByName("fang");
        System.out.println(book);
    }

    @Test
    public void testDelBookById() {
        int i = instance.deleteBookById("8");
        System.out.println(i);
    }

   @Test
    public void testInsertBook() {
       Book book = new Book(102, "test", "test", "test", "test", "test", 23.5, "fe", 28);
       instance.insertBook(book);
   }

    @Test
    public void testUpdateBook() {
        Book book = new Book(15, "修改", "修改", "test", "test", "test", 20.5, "fe", 28);
        int i = instance.updateBook(book);
        System.out.println(i);
    }
}
