package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/logincheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		con=(Connection)config.getServletContext().getAttribute("jdbccon");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("pwd");
		
		PreparedStatement ps= null;
		ResultSet rs=null;
		try
		{
			ps=con.prepareStatement("select * from users where uid=? and password=?");
			ps.setString(1, uid);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			
			if(rs.next())   
			{    Cookie [] all = request.getCookies();
			     if(all != null)
			     {
			    	 for(Cookie e : all)
			    	 {
			    		 if(e.getName().equals("loginerror"))
			    		 {
			    			 e.setMaxAge(0);
			    			 response.addCookie(e);
			    		 }
			    	 }
			     }
			     entity.User u = new entity.User(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6));
			     getServletContext().setAttribute("user", u);
				RequestDispatcher rd = request.getRequestDispatcher("/addcomment.jsp");
				rd.forward(request, response);
				
			}
			else
			{   Cookie c = new Cookie("loginerror", "wrong_UID/pwd");
			     response.addCookie(c);
				response.sendRedirect("/BloggingDB/login.jsp");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				ps.close();
				} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
