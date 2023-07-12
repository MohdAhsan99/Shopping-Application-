package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Comment;


@WebServlet("/getComment")
public class GetComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con=(Connection)config.getServletContext().getAttribute("jdbccon");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Statement st=null;
		ResultSet rs=null;
		
		try
		{
			st=con.createStatement();
			rs=st.executeQuery("select * from comments");
			
			List<Comment> Comments = new ArrayList();
			while(rs.next())
			{
				Comment c = new Comment(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
				Comments.add(c);
			}
			getServletContext().setAttribute("Comment", Comments);
			RequestDispatcher rd= request.getRequestDispatcher("/Comment.jsp");
			rd.forward(request, response);
					
		}
		catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace()	;	}
		finally {
			 try {
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getStackTrace();
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
