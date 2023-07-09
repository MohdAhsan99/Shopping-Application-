package myservlet;

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

import entity.User;


@WebServlet("/logincheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    

	Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		con=(Connection)config.getServletContext().getAttribute("jdbc");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("pwd");
		
		PreparedStatement ps= null;
		ResultSet rs=null;
		try
		{
			ps=con.prepareStatement("select * from users where u_id=? and password=?");
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
			     User u= new User(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7));
			          HttpSession session= request.getSession();
			          session.setAttribute("loggedinuser", u);
				RequestDispatcher rd = request.getRequestDispatcher("/home");
				rd.forward(request, response);
				
			}
			else
			{   Cookie c = new Cookie("loginerror", "wrong_UID/pwd");
			     response.addCookie(c);
				response.sendRedirect("/ShoppingDB/Logincheck.jsp");
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

}
