package jee7afondo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jee7afondo.data.DataAccess;
import jee7afondo.dto.InscripcionDTO;

public class InscripcionDAO {

	public int insertar(InscripcionDTO dto) {

		// variables
		String sql = "";
		Connection con = null;
		PreparedStatement ps = null;
		int newId;

		try {

			// escribo la sentencia SQL
			sql = "INSERT INTO cursos.inscripcion(id_inscripcion, nombre, telefono, id_curso, id_forma_pago) VALUES (? ,?, ?, ?, ?);";

			// obtengo la conexion
			con = DataAccess.getConnection();

			newId = getNewId(con, ps);

			// preparo la sentencia
			ps = con.prepareStatement(sql);

			// cargo los parametros a la sentencia
			ps.setInt(1, newId);
			ps.setString(2, dto.getNombre());
			ps.setString(3, dto.getTelefono());
			ps.setInt(4, dto.getIdCurso());
			ps.setInt(5, dto.getIdFormaPago());

			// Si el Update salio ok NO devuelve 1
			if (ps.executeUpdate() != PreparedStatement.RETURN_GENERATED_KEYS) {

				System.out.println("Error.");

				throw new RuntimeException();

			}

		} catch (Exception e) {

			e.printStackTrace();

			throw new RuntimeException(e);

		}

		return newId;

	}

	private int getNewId(Connection con, PreparedStatement ps) {

		// variables
		String sql;
		ResultSet rs = null;
		int newId = 0;

		try {

			// busco la clave maxima
			sql = "SELECT MAX(id_inscripcion) as 'max_id_inscripcion' FROM inscripcion;";

			// preparo la sentencia SQL
			ps = con.prepareStatement(sql);

			// ejecuto la Query
			rs = ps.executeQuery();

			// itero los resultados
			while (rs.next()) {
				newId = rs.getInt("max_id_inscripcion");
			}

			rs.close();

			// devuelvo el max + 1
			return newId + 1;

		} catch (Exception e) {

			e.printStackTrace();

			return 0;

		}

	}

}
