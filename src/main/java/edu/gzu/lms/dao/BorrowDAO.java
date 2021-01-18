package edu.gzu.lms.dao;

import edu.gzu.lms.entity.Borrow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public interface BorrowDAO {

//    Borrow getBorrow(ResultSet resultSet) throws SQLException;

    /**
     * 获取借书的全部信息
     * @return
     */
    List<Borrow> getAllBorrow(int page, int limit);


    Borrow getBorrowById(int id);
    /**
     * 通过id删除类型
     * @param id
     * @return
     */
    int deleteBorrowById(String id);

    /**
     * 插入类型
     * @param borrow
     * @return
     */
    int insertBorrow(Borrow borrow);

    /**
     * 更新类型
     * @param borrow
     * @return
     */
    int updateBorrow(Borrow borrow);


    /**
     * 获取书籍类型的数量
     * @return
     */
    Long countBorrow();

}
