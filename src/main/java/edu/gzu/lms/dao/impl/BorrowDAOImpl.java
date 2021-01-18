package edu.gzu.lms.dao.impl;

import edu.gzu.lms.dao.BaseDAO;
import edu.gzu.lms.dao.BorrowDAO;
import edu.gzu.lms.entity.Borrow;
import java.util.List;


public class BorrowDAOImpl extends BaseDAO implements BorrowDAO {
    private static BorrowDAOImpl instance;

    public static final BorrowDAOImpl getInstance() {
        if (instance == null) {
            instance = new BorrowDAOImpl();
        }
        return instance;
    }


    @Override
    public List<Borrow> getAllBorrow(int page, int limit) {
        String sql = " SELECT * FROM borrow limit ?, ?";
        return getForList(Borrow.class, sql, page, limit);
    }

    @Override
    public Borrow getBorrowById(int id) {
        String sql = "select * from borrow where borrowId = ?";
        return getInstanceById(Borrow.class, sql, id);
    }

    @Override
    public int deleteBorrowById(String id) {
        String sql = "delete from borrow where borrowId = ?";
        return update(sql, id);
    }

    @Override
    public int insertBorrow(Borrow borrow) {
        String sql = "insert into borrow(bookId, readerId, lendDate, backDate) values(?,?,?,?)";
        return update(sql, borrow.getBookId(),borrow.getReaderId(),borrow.getLendDate(),borrow.getBackDate());
    }

    @Override
    public int updateBorrow(Borrow borrow) {
        String sql = "update borrow set bookId = ?,readerId = ?,lendDate = ?,backDate = ? where borrowId = ?";
        return update(sql, borrow.getBookId(),borrow.getReaderId(),borrow.getLendDate(),borrow.getBackDate(),borrow.getBorrowId());
    }

    @Override
    public Long countBorrow() {
        String sql = "select count(*) from borrow";
        return getValue(sql);
    }
}
