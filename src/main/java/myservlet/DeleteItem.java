package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteItem
 */
@WebServlet("/delete")
public class DeleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd=request.getRequestDispatcher("/header");
		rd.include(request, response);
		int pid=Integer.parseInt(request.getParameter("pid"));
		HttpSession session = request.getSession();
		List<Integer> products =(List<Integer>)session.getAttribute("cart");
		
		if(products == null)
		{
			products=new ArrayList<>();
		}
		products.remove(pid-1);
		session.setAttribute("cart", products);
		out.print("<h1>item removed from cart</h1>");
		out.print("<br/> <br/> <a href='viewcart'> Go back to Cart <a/>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
