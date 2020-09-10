package jee7afondo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jee7afondo.data.DataAccess;
import jee7afondo.dto.FormaPagoDTO;

public class FormaPagoDAO {
	
	public List<FormaPagoDTO> getFormasPago() {

		// variables
		ArrayList<FormaPagoDTO> lst = new ArrayList<FormaPagoDTO>();
		String sql;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			// escribo la sentencia SQL
			sql = "SELECT * FROM cursos.forma_pago;";

			// obtengo la conexion
			con = DataAccess.getConnection();

			// preparo el Statement
			ps = con.prepareStatement(sql);

			// obtengo el ResultSet
			rs = ps.executeQuery();

			// itero los resultados y los guardo en una lista
			while (rs.next()) {
				FormaPagoDTO formaPago = new FormaPagoDTO();
				formaPago.setIdFormaPago(rs.getInt("id_forma_pago"));
				formaPago.setDescripcion(rs.getString("descripcion"));
				formaPago.setRecargo(rs.getDouble("recargo"));
				lst.add(formaPago);
			}

			// devuelvo la lista con los cursos
			return lst;

		} catch (Exception e) {

			e.printStackTrace();

			throw new RuntimeException(e);

		}

	}
}
