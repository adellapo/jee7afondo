package jee7afondo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jee7afondo.data.DataAccess;
import jee7afondo.dto.CursoDTO;

public class CursoDAO {

	public List<CursoDTO> getCursos() {

		// variables
		ArrayList<CursoDTO> lst = new ArrayList<CursoDTO>();
		String sql;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			// escribo la sentencia SQL
			sql = "SELECT * FROM cursos.curso;";

			// obtengo la conexion
			con = DataAccess.getConnection();

			// preparo el Statement
			ps = con.prepareStatement(sql);

			// obtengo el ResultSet
			rs = ps.executeQuery();

			// itero los resultados y los guardo en una lista
			while (rs.next()) {
				CursoDTO curso = new CursoDTO();
				curso.setIdCurso(rs.getInt("id_curso"));
				curso.setDescripcion(rs.getString("descripcion"));
				curso.setPrecio(rs.getDouble("precio"));
				lst.add(curso);
			}

			// devuelvo la lista con los cursos
			return lst;

		} catch (Exception e) {

			e.printStackTrace();

			throw new RuntimeException(e);

		}

	}

}
