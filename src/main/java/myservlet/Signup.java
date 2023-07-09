package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		con=(Connection)config.getServletContext().getAttribute("jdbc");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("pwd");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String contact=request.getParameter("cnt");
		PreparedStatement ps=null;
		ResultSet rs=null;
	
		
		try
		{
			ps=con.prepareStatement("insert into users values (?,?,?,?,?,?)");
			ps.setString(1, uid);
			ps.setString(2, pwd);
			ps.setString(3, fname);
			ps.setString(4,lname);
			ps.setString(5, email);
			ps.setString(6, contact);
			
			 int n=ps.executeUpdate();
			
			if(n<1)
			{
			out.print("1 record Updated");
			}
			else
			{
				out.print("Not Updated");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				
				ps.close();
			
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}

}
