package jee7afondo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jee7afondo.dto.InscripcionDTO;
import jee7afondo.facade.Facade;

@WebServlet("/posInscripcion")
public class PosInscripcion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public PosInscripcion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// variables
		String nombre;
		String tel;
		int idCurso;
		int idFormaPago;
		InscripcionDTO inscripcion;
		Facade f;
		int idInscripcion;
		RequestDispatcher rd;
		
		// obtengo los datos mandados de la vista al controlador
		nombre = request.getParameter("nombre");
		tel = request.getParameter("telefono");
		idCurso = Integer.parseInt(request.getParameter("idCurso"));
		idFormaPago = Integer.parseInt(request.getParameter("idFormaPago"));
		
		// instancio el DTO 
		inscripcion = new InscripcionDTO();
		
		// le asigno los datos que llegaron de la vista
		inscripcion.setNombre(nombre);
		inscripcion.setTelefono(tel);
		inscripcion.setIdCurso(idCurso);
		inscripcion.setIdFormaPago(idFormaPago);
		
		// instancio el Facade que funciona de Modelo
		f = new Facade();
		
		// le paso la nueva inscripcion y obtengo el nuevo ID
		idInscripcion = f.registrarInscripcion(inscripcion);
		
		// obtengo el RequestDispatcher para redireccionar el request
		rd = request.getRequestDispatcher("preConfirmacion");
		
		// antes de redireccionar el request le agrego el nuevo ID
		request.setAttribute("idInscripcion", idInscripcion);
		
		// redirecciono
		rd.forward(request, response);
		
	}

}
