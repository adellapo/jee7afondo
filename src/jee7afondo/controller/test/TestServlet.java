package jee7afondo.controller.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test/Test")
public class TestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
    
    	super();
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<html><body>");
		pw.println("<h1>- Hola Mundo -</h1>");
		pw.println("<p>............</p>");
		pw.println("</body></html>");
		
		pw.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);
	
		PrintWriter pw = response.getWriter();
		String user = request.getParameter("usr");
		String password = request.getParameter("pwd");

		pw.println("BIENVENIDO " + user.toUpperCase());
		pw.println("Password: " + password);
	
	}

}
