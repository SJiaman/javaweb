package edu.gzu.lms.dao;

import edu.gzu.lms.entity.Admin;


public interface AdminDAO {

    /**
     * 用于判断用户名是否存在正确
     * @param username
     * @return
     */
    boolean checkUsername(String username);

    /**
     * 用于检查密码正确与否
     * @param password
     * @return
     */
    boolean checkPassword(String password);


    /**
     *检查用户是否存在
     * @param admin
     * @return
     */
    boolean checkUsernameAndPassword(String username, String password);

}
