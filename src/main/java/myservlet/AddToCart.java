package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/cart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd=request.getRequestDispatcher("/header");
		rd.include(request, response);
		int pid=Integer.parseInt(request.getParameter("selectedP"));
		
		HttpSession session = request.getSession();
	
		List<Integer> products =(List<Integer>)session.getAttribute("cart");
		
		if(products == null)
		{
			products=new ArrayList<>();
		}
		products.add(pid);
		session.setAttribute("cart", products);
		
		out.print("<br/>selected product "+pid+" is added in the cart");
		out.print("<br/>There are "+ products.size()+" item(s) in the cart");
		
		out.print("<br/> <a href='viewcart'> View Cart <a/>");
		out.print("<br/> <a href='home'> Go back to Categories <a/>");
	}

}
