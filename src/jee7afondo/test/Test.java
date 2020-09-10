package jee7afondo.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import jee7afondo.dao.CursoDAO;
import jee7afondo.dao.FormaPagoDAO;
import jee7afondo.dao.InscripcionDAO;
import jee7afondo.data.DataAccess;
import jee7afondo.dto.CursoDTO;
import jee7afondo.dto.FormaPagoDTO;
import jee7afondo.dto.InscripcionDTO;

public class Test {

	public static void main(String[] args) {

		// Cursos
		CursoDAO daoCurso = new CursoDAO();
		
		List<CursoDTO> lstCurso = daoCurso.getCursos();

		for (CursoDTO dtoCurso : lstCurso) {
			System.out.println("Curso ID: " + dtoCurso.getIdCurso());
			System.out.println("Curso Descripcion: " + dtoCurso.getDescripcion());
			System.out.println("Curso Precio: " + dtoCurso.getPrecio());
		}

		// Formas Pago
		FormaPagoDAO daoFormaPago = new FormaPagoDAO();
		
		List<FormaPagoDTO> lstFormaPago = daoFormaPago.getFormasPago();

		for (FormaPagoDTO dtoFormaPago : lstFormaPago) {
			System.out.println("FormaPago ID: " + dtoFormaPago.getIdFormaPago());
			System.out.println("FormaPago Descripcion: " + dtoFormaPago.getDescripcion());
			System.out.println("FormaPago Recargo: " + dtoFormaPago.getRecargo());
		}
		
		// Inscripcion
		InscripcionDTO dtoInscripcion = new InscripcionDTO();
		dtoInscripcion.setNombre("Andres");
		dtoInscripcion.setTelefono("1155853411");
		dtoInscripcion.setIdCurso(1);
		dtoInscripcion.setIdFormaPago(2);
		
		InscripcionDAO daoInscripcion = new InscripcionDAO();
		daoInscripcion.insertar(dtoInscripcion);
	
		// Fin
		System.out.println("FIN.");
		
	}

	public void testearConexion() {

		String sql;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			sql = "SELECT * FROM cursos.curso";

			con = DataAccess.getConnection();

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("id_curso"));
				System.out.println(rs.getString("descripcion"));
			}

		} catch (Exception e) {

			e.printStackTrace();

			throw new RuntimeException(e);

		} finally {

			try {

				rs.close();
				ps.close();
				con.close();

			} catch (Exception e2) {

				e2.printStackTrace();

				throw new RuntimeException(e2);

			}

		}

	}

}
