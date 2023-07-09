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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getProducts")
public class GetProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	Connection con;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		con=(Connection)config.getServletContext().getAttribute("jdbc");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
	//	RequestDispatcher rd= request.getRequestDispatcher("/header");
	//	rd.include(request, response);
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String cid=request.getParameter("cid");
		int cid1=Integer.parseInt(cid);
		
		try {
			ps=con.prepareStatement("select * from product where cat_id=?");
			ps.setInt(1, cid1);
			rs=ps.executeQuery();
			
			
			out.print("<form action='cart' method='get' >");
			out.print("Select product : ");
			out.print("<select name='selectedP'>");			
			while(rs.next())
			{
				out.print("<option value='"+rs.getInt(1)+"'>"+ rs.getString(2)+"</option>");
			}
			out.print("</select>");
			out.print("<br/> <input type='submit' value='Add To Cart' />");
			out.print("</form>");
		}
			
		
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try
			{
				rs.close();
				ps.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}	
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
