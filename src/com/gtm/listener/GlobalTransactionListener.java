package com.gtm.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.gtm.util.HibernateUtilForMySQL;
import com.gtm.util.HibernateUtilForOracle;

/**
 * Application Lifecycle Listener implementation class GlobalTransactionListener
 *
 */
@WebListener
public class GlobalTransactionListener implements ServletContextListener {


	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent se) {
    	HibernateUtilForMySQL.closeSessionFactory();
    	HibernateUtilForOracle.closeSessionFactory();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent se) {
    	
    	System.out.println("MYSQL SessionFactory"+HibernateUtilForMySQL.getSessionFactory());
       	System.out.println("Oracle SessionFactory"+HibernateUtilForOracle
       			.getSessionFactory());
        
    }
	
}
