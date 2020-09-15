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

@WebServlet("/test/posInscripcion")
public class PosInscripcionTest extends HttpServlet {
	
	// atributos
	String nombre;
	String tel;
	String curso;
	String formaPago;
	
	private static final long serialVersionUID = 1L;

	public PosInscripcionTest() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// obtengo el PrintWriter
		PrintWriter pw = response.getWriter();

		// obtengo los atributos nombre, tel, curso y formaPago
		nombre = request.getParameter("nomIns");
		tel = request.getParameter("telIns");
		curso = request.getParameter("curIns");
		formaPago = request.getParameter("forPagIns");

		// pagina para confirmar
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

		// cierro
		pw.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int newId;

		Facade f = new Facade();

		// creo la nueva inscripcion
		InscripcionDTO inscripcion = new InscripcionDTO();
		
		// le establezco las propiedades
		inscripcion.setNombre(nombre);
		inscripcion.setTelefono(tel);
		inscripcion.setIdCurso(Integer.parseInt(curso));
		inscripcion.setIdFormaPago(Integer.parseInt(formaPago));
		
		// obtengo el nuevo ID de inscripcion
		newId = f.registrarInscripcion(inscripcion);
		
		// obtengo PrintWriter
		PrintWriter pw = response.getWriter();
		
		// pagina
		pw.println("<html><body>");
		pw.println("<h2>Inscripción recibida.</h2>");
		pw.println("<br>");
		pw.println("<hr>");
		pw.println("<p>ID Inscripción: " + newId + "</p>");
		pw.println("</body></html>");

		// cierro
		pw.close();
		
	}

}
