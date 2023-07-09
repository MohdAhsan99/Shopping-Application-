package listener;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class listener
 *
 */
@WebListener
public class listener implements ServletContextListener {

    
   Connection con;
    public void contextDestroyed(ServletContextEvent sce)  { 
    	try {
    		con.close();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
		}
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	 String driver=sce.getServletContext().getInitParameter("Driverclass");
         String url=sce.getServletContext().getInitParameter("jdbcurl");
         String user=sce.getServletContext().getInitParameter("user");
         String pwd=sce.getServletContext().getInitParameter("password");
         
         try {
        	 Class.forName(driver);
        	 con=DriverManager.getConnection(url,user,pwd);
        	 sce.getServletContext().setAttribute("jdbc", con);
        	 System.out.println("Connection Established");
        	 
         }
         catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
