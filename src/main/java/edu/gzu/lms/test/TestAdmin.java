package edu.gzu.lms.test;


import edu.gzu.lms.dao.impl.AdminDAOImpl;
import org.junit.Test;

public class TestAdmin {
    AdminDAOImpl instance = AdminDAOImpl.getInstance();
    @Test
    public void testCheckUsername() {
        boolean b = instance.checkUsername("admin");
        System.out.println(b);
    }

    @Test
    public void testCheckPassword() {
        boolean b = instance.checkPassword("13252");
        System.out.println(b);
    }

    @Test
    public void testCheckUsernameAndPassword() {
        boolean b = instance.checkUsernameAndPassword("admin", "1234");
        System.out.println(b);
    }
}
