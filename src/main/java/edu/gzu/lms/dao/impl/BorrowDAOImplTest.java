//package edu.gzu.lms.dao.impl;
//
//import edu.gzu.lms.dao.BaseDAO;
//import edu.gzu.lms.dao.BorrowDAO;
//import edu.gzu.lms.entity.Borrow;
//import edu.gzu.lms.util.DBUtil;
//
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class BorrowDAOImplTest extends BaseDAO implements BorrowDAO {
//    private static BorrowDAOImpl instance;
//
//    public static final BorrowDAOImpl getInstance() {
//        if (instance == null) {
//            instance = new BorrowDAOImpl();
//        }
//        return instance;
//    }
//
//
//    @Override
//    public Borrow getBorrow(ResultSet resultSet) throws SQLException {
//        int borrowId = resultSet.getInt("borrowId");
//        String bookName = resultSet.getString("bookName");
//        String readerName = resultSet.getString("readerName");
//        Date lendDate = resultSet.getDate("lendDate");
//        Date backDate = resultSet.getDate("backDate");
//        Borrow borrow = new Borrow();
//        borrow.setBorrowId(borrowId);
//        borrow.setBookName(bookName);
//        borrow.setReaderName(readerName);
//        borrow.setLendDate(lendDate);
//        borrow.setBackDate(backDate);
//        return borrow;
//    }
//
//    @Override
//    public List<Borrow> getAllBorrow(int page, int limit) {
//        String sql = " SELECT borrowId,bookName,readerName,lendDate,backDate" +
//                "FROM borrow,book,reader WHERE" +
//                "borrow.readerId = reader.readerId AND borrow.bookId = book.bookId limit ?, ?";
//        List<Borrow> borrows = new ArrayList<Borrow>();
//        Connection connection = DBUtil.getConnection();
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        try {
//            statement = connection.prepareCall(sql);
//            statement.setInt(1, (page - 1) * limit);
//            statement.setInt(2, limit);
//            resultSet = statement.executeQuery();
//            while (resultSet.next())
//            {
//                Borrow borrow = getBorrow(resultSet);
//                borrows.add(borrow);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }finally {
//            DBUtil.closeConnection();
//            DBUtil.close(resultSet, statement);
//        }
//
//        return borrows;
//    }
//
//    @Override
//    public int deleteBorrowById(String id) {
//        String sql = "delete from book where borrowId = ?";
//        return update(sql, id);
//    }
//
//    @Override
//    public int insertBorrow(Borrow borrow) {
//        String sql = "insert into borrow(bookId, readerId, lendDate, backDate) values(?,?,?,?)";
//        return update(sql, borrow.getBookName(),borrow.getReaderName(),borrow.getLendDate(),borrow.getBackDate());
//    }
//
//    @Override
//    public int updateBorrow(Borrow borrow) {
//        String sql = "update borrow set bookId = ?,readerId = ?,lendDate = ?,backDate = ? where borrowId = ?";
//        return update(sql, borrow.getBookName(),borrow.getReaderName(),borrow.getLendDate(),borrow.getBackDate(),borrow.getBorrowId());
//    }
//
//    @Override
//    public Long countBorrow() {
//        String sql = "select count(*) from borrow";
//        return getValue(sql);
//    }
//}
