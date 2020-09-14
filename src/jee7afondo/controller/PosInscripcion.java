package jee7afondo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jee7afondo.dto.InscripcionDTO;
import jee7afondo.facade.Facade;

/**
 * Servlet implementation class PosInscripcion
 */
@WebServlet("/posInscripcion")
public class PosInscripcion extends HttpServlet {
	
	String nombre;
	String tel;
	String curso;
	String formaPago;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PosInscripcion() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		nombre = request.getParameter("nomIns");
		tel = request.getParameter("telIns");
		curso = request.getParameter("curIns");
		formaPago = request.getParameter("forPagIns");

		pw.println("<html><body>");
		pw.println("<h4>--- Datos Inscripción ---</h4>");
		pw.println("<p>Nombre: " + nombre + "</p>");
		pw.println("<p>Tel: " + tel + "</p>");
		pw.println("<p>Curso: " + curso + "</p>");
		pw.println("<p>Forma Pago: " + formaPago + "</p>");
		pw.println("<br>");
		pw.println("<hr>");
		pw.println("<form action='posInscripcion' method='post'>");
		pw.println("<input type='submit' value='Confirmar'>");
		pw.println("</form");
		pw.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int newId;
		
		Facade f = new Facade();
		
		InscripcionDTO inscripcion = new InscripcionDTO();
		inscripcion.setNombre(nombre);
		inscripcion.setTelefono(tel);
		inscripcion.setIdCurso(Integer.parseInt(curso));
		inscripcion.setIdFormaPago(Integer.parseInt(formaPago));

		newId = f.registrarInscripcion(inscripcion);
		
		PrintWriter pw = response.getWriter();
		pw.println("<html><body><h2>INSCRIPCINO OK : " +newId + "</h2></body></html>");
		pw.close();
		
	}

}
