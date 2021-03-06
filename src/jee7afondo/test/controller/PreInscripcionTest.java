package jee7afondo.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jee7afondo.dto.CursoDTO;
import jee7afondo.dto.FormaPagoDTO;
import jee7afondo.facade.Facade;

@WebServlet("/test/preInscripcion")
public class PreInscripcionTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public PreInscripcionTest() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// obtengo el PrintWriter
		PrintWriter pw = response.getWriter();
		
		// obtengo el punto de acceso al modelo
		Facade f = new Facade();
		
		// le pido la listas necesarias al modelo
		List<CursoDTO> cursos = f.obtenerCursos();
		
		List<FormaPagoDTO>formasPago = f.obtenerFormasPago();
		
		// pagina
		pw.println("<html><body>");

		// formulario
		pw.println("<form action='posInscripcion' method='get' >");
		
		// nombre
		pw.println("<label for='txtNomIns'>Nombre:</label>");
		pw.println("<input id='txtNomIns' type='text' name='nomIns' >");

		// telefono
		pw.println("<label for='txtTelIns'>Tel::</label>");
		pw.println("<input type='tel' name='telIns' >");
		
		// cursos
		pw.println("<label for='cboCurso'>Curso:</label>");
		pw.println("<select id='cboCurso' name='curIns'>");
		for (CursoDTO curso : cursos) {
			pw.println("<option value='" + curso.getIdCurso() + "'>" + curso.getIdCurso() + " - "
					+ curso.getDescripcion() + " - " + curso.getPrecio() + "</option>");
		}
		pw.println("</select>");
		
		// formas de pago
		pw.println("<label for='cboFormaPago'>Formas de Pago:</label>");
		pw.println("<select id='cboFormaPago' name='forPagIns'>");
		for (FormaPagoDTO formaPago : formasPago) {
			pw.println("<option value='" + formaPago.getIdFormaPago() + "'>" + formaPago.getIdFormaPago() + " - "
					+ formaPago.getDescripcion() + " - " + formaPago.getRecargo() + "</option>");
		}
		pw.println("</select>");
		
		// confirmar inscripcion
		pw.println("<input type='submit' value='Confirmar Inscripción'>");
		
		pw.println("</form>");

		// tabla de Cursos - TEST
		pw.println("<table>");

		// encabezado de la tabla
		pw.println("<thead>");
		pw.println("<th>ID</th><th>Descripcion</th><th>Precio</th>");
		pw.println("</thead>");

		// cuerpo de la tabla
		pw.println("<tbody>");
		for (CursoDTO curso : cursos) {
			pw.println("<tr>");
			pw.println("<td>" + curso.getIdCurso() + "</td>");
			pw.println("<td>" + curso.getDescripcion() + "</td>");
			pw.println("<td>" + curso.getPrecio() + "</td>");
			pw.println("</tr>");
		}
		pw.println("</tbody>");

		pw.println("</table>");

		pw.println("</body></html>");
		
		// cierro
		pw.close();
		
	}

}
