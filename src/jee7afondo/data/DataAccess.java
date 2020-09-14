package jee7afondo.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import jee7afondo.util.PropertiesUtil;

public class DataAccess {

	static Properties properties = null;
	static Connection connection = null;
	static String driver = "";

	static {
		
		properties = PropertiesUtil.getProperties(DataAccess.class, true);

		try {

			// cargo el driver
			driver = properties.getProperty("jdbc.connection.driver");

			// levanto el driver
			Class.forName(driver);

			// agrego shutdown
			Thread t = new ShutdownHookImple();
			Runtime.getRuntime().addShutdownHook(t);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);

		}

	}

	public static Connection getConnection() {

		String url = "";
		String user = "";
		String password = "";

		try {

			if (connection == null || connection.isClosed()) {

				// obtengo los datos para hacer la conexion
				url = properties.getProperty("jdbc.connection.url");
				user = properties.getProperty("jdbc.connection.user");
				password = properties.getProperty("jdbc.connection.password");

				// establezco la conexion
				connection = DriverManager.getConnection(url, user, password);

			}

		} catch (Exception e) {

			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);

		}

		return connection;

	}

	@SuppressWarnings("unchecked")
	public static <T> T getObject(String objName) {

		try {

			String className = properties.getProperty(objName);

			Class<?> c = Class.forName(className);
			
			return (T) c.newInstance();

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);

		}

	}

}
