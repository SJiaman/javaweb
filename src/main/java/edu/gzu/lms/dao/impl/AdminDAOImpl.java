package edu.gzu.lms.dao.impl;

import edu.gzu.lms.dao.AdminDAO;
import edu.gzu.lms.dao.BaseDAO;
import edu.gzu.lms.entity.Admin;

public class AdminDAOImpl extends BaseDAO implements AdminDAO {
    private static AdminDAOImpl instance;

    public static final AdminDAOImpl getInstance() {
        if (instance == null) {
            instance = new AdminDAOImpl();
        }
        return instance;
    }

    @Override
    public boolean checkUsername(String username) {
        String sql = "select * from admin where username = ?";
        return check(sql, username);
    }

    @Override
    public boolean checkPassword(String password) {
        String sql = "select * from admin where username = ?";
        return check(sql, password);
    }

    @Override
    public boolean checkUsernameAndPassword(String username, String password) {
        String sql = "select * from admin where username = ? and password = ?";
        return check(sql, username, password);
    }
}
