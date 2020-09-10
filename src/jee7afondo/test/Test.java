package jee7afondo.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jee7afondo.data.DataAccess;

public class Test {

	public static void main(String[] args) {
		
		
		try {

			Connection con = DataAccess.getConnection();
			
			String sql = "SELECT * FROM cursos.curso";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("id_curso"));
				System.out.println(rs.getString("descripcion"));
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("ERROR");
		}finally {
			
		}
		
	}
}
