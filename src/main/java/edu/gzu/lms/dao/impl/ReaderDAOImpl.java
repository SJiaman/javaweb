package edu.gzu.lms.dao.impl;

import edu.gzu.lms.dao.BaseDAO;
import edu.gzu.lms.dao.ReaderDAO;
import edu.gzu.lms.entity.Reader;

import java.util.List;


public class ReaderDAOImpl extends BaseDAO implements ReaderDAO {
    private static ReaderDAOImpl instance;

    public static final ReaderDAOImpl getInstance() {
        if (instance == null) {
            instance = new ReaderDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Reader> getAllReader(int page, int limit) {
        String sql = "select * from reader limit ?, ?";
        return getForList(Reader.class, sql, page, limit);
    }

    @Override
    public Reader getReaderByName(String name) {
        String sql = "select * from reader where readerName = ?";
        return getInstanceByName(Reader.class, sql, name);
    }

    @Override
    public int deleteReaderById(String id) {
        String sql = "delete from reader where readerId = ?";
        return update(sql, id);
    }

    @Override
    public int insertReader(Reader reader) {
        String sql = "insert into reader(readerName, sex, birth, address, phone, password) values(?,?,?,?,?,?)";
        return update(sql, reader.getReaderName(),reader.getSex(),reader.getBirth(),reader.getAddress(),
                reader.getPhone(),reader.getPassword());
    }

    @Override
    public int updateReader(Reader reader) {
        String sql = "update reader set readerName = ?,sex = ?,birth = ?,address = ?, " +
                "phone = ?, password = ? where readerId = ?";
        return update(sql, reader.getReaderName(),reader.getSex(),reader.getBirth(),
                reader.getAddress(),reader.getPhone(), reader.getPassword(), reader.getReaderId());
    }

    @Override
    public Long countReader() {
        String sql = "select count(*) from reader";
        return getValue(sql);
    }
}
