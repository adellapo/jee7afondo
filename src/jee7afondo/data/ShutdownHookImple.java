package jee7afondo.data;

import java.sql.Connection;

public class ShutdownHookImple extends Thread{

	@Override
	public void run() {
		
		try {
			
			Connection con = DataAccess.getConnection();
			
			con.close();
			
			System.out.println("Bye");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			throw new RuntimeException(e);
			
		}
		
	}
	
}
