package edu.gzu.lms.listener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("webService start!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("webService stop!");
        try {
            while (DriverManager.getDrivers().hasMoreElements()) {
                DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
            }
            System.out.println("jdbc Driver close!");
            AbandonedConnectionCleanupThread.checkedShutdown();
            System.out.println("clean thread success!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
