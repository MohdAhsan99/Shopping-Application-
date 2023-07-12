package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;

/**
 * Servlet implementation class AddCD
 */
@WebServlet("/addC")
public class AddCD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		con=(Connection)config.getServletContext().getAttribute("jdbccon");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String comm=request.getParameter("comm"); 
		System.out.println(comm);
		 int tid=Integer.parseInt(request.getParameter("topicid"));
		 User u=(User)getServletContext().getAttribute("user");
		 String uid =u.getUid();
		 
	     PreparedStatement ps=null;
	     try {
			ps= con.prepareStatement("insert into comments (text,topicid,uid)values (?,?,?)");
			ps.setString(1,comm );
			ps.setInt(2, tid);
			ps.setString(3, uid);
			int n=ps.executeUpdate();
			
			
			if(n==0) {
				System.out.println("comment Added");
			}
			else
			{
				response.sendRedirect("/BloggingDB/Index.jsp");
			}
	     }
	     catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			try {
				ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
