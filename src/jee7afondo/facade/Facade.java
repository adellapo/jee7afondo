package jee7afondo.facade;

import java.util.List;

import jee7afondo.dao.CursoDAO;
import jee7afondo.dao.FormaPagoDAO;
import jee7afondo.dao.InscripcionDAO;
import jee7afondo.dto.CursoDTO;
import jee7afondo.dto.FormaPagoDTO;
import jee7afondo.dto.InscripcionDTO;

public class Facade {

	public int registrarInscripcion(InscripcionDTO dto) {

		InscripcionDAO dao = new InscripcionDAO();

		return dao.insertar(dto);

	}

	public List<CursoDTO> obtenerCursos() {

		CursoDAO dao = new CursoDAO();

		return dao.getCursos();

	}

	public List<FormaPagoDTO> obtenerFormasPago() {

		FormaPagoDAO dao = new FormaPagoDAO();

		return dao.getFormasPago();

	}

}
