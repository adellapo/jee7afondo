package jee7afondo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jee7afondo.dto.CursoDTO;
import jee7afondo.dto.FormaPagoDTO;
import jee7afondo.facade.Facade;

@WebServlet("/preInscripcion")
public class PreInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PreInscripcion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// variables
		Facade f;
		List<CursoDTO>cursos;
		List<FormaPagoDTO>formasPago;
		RequestDispatcher rd;
		
		// obtengo instancia del Facade
		f = new Facade();
		
		// lleno la lista de cursos
		cursos = f.obtenerCursos();
		
		// lleno la lista de formas de pago
		formasPago = f.obtenerFormasPago();
		
		// le paso las listas al modelo
		request.setAttribute("cursos", cursos);
		request.setAttribute("formasPago", formasPago);
		
		// obtengo el RequestDispatcher
		rd = request.getRequestDispatcher("inscripcion.jsp");
		
		// le paso el request y response del Servlet
		rd.forward(request, response);

	}

}
