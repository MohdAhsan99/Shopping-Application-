package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Comment;


@WebServlet("/getText")
public class GetText extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	con=(Connection)config.getServletContext().getAttribute("jdbccon");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement ps=null;
		ResultSet rs=null;
		int topid=Integer.parseInt(request.getParameter("tid"));
		
		
		
		try
		{
			ps=con.prepareStatement("select * from comments where topicid=?");
			ps.setInt(1, topid);
			rs=ps.executeQuery();
			
			List<Comment> cmp= new ArrayList<>();
			
			
			while(rs.next())
			{
				Comment c = new Comment(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
				cmp.add(c);
			}
			getServletContext().setAttribute("Comment1", cmp);
			  
			RequestDispatcher rd= request.getRequestDispatcher("/topic.jsp");
			rd.forward(request, response);
		     
					
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		finally {
			try {
				rs.close();
				ps.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
