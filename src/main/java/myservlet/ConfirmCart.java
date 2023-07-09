package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;

/**
 * Servlet implementation class ConfirmCart
 */
@WebServlet("/confirmcart")
public class ConfirmCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		con=(Connection)config.getServletContext().getAttribute("jdbc");
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		RequestDispatcher rd=request.getRequestDispatcher("/header");
		PreparedStatement ps=null;
		int n;
		HttpSession session = request.getSession();
		User u=(User)session.getAttribute("loggedinuser");
		
		String uid=u.getUid();
		out.print(uid);
		java.sql.Timestamp ts=new java.sql.Timestamp(new java.util.Date().getTime());
		float tprice=(Float)session.getAttribute("tprice");
		
		try {
		 ps=con.prepareStatement("insert into shopping(user_id,shoppingDate,totalprice) values (?,?,?)");
		 ps.setString(1, uid);
		 ps.setTimestamp(2, ts);
		 ps.setFloat(3, tprice);
		 
		 n=ps.executeUpdate();
		 out.print(n);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try
			{
				ps.close();
			}
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		out.print("<p> Order is confirmed </p>");
		out.print("<p> You bill will be emailed at "+ u.getEmail()+"</p>");
		out.print("<p> You will receive message on"+ u.getContact() +" before order delivery </p>");
		
		out.print("<br/> <br/> <a href='logout'> Logout <a/>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
