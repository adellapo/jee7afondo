package jee7afondo.util;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * <span class="muyImportante"> Importante </span> Pensado para guardar
 * cualquier tipo de archivo mientras tenga pares Key-Value Se le puede pasar
 * una clase como NombreDeLaClase.class y te devuelve una instancia de
 * Properties configurada. Para que esto funcione deben estar en
 * directorioRaizProyecto/util/nombreclase.properties Los archivos deben estar
 * en minuscula, si la clase es Cliente entonces el nombre del archivo sera
 * cliente.properties.
 * 
 * @author Andres Della Porta
 *
 */
public class PropertiesUtil {

	public static Properties getProperties(Class<?> c, boolean enUtil) {

		Properties prop = new Properties();

		String nombreArchivo = "C:\\tools\\Projects\\jee7afondo\\util\\DataAccess";
		
		try {

			prop.load(new FileInputStream(nombreArchivo + ".properties"));
			return prop;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return null;

		}

	}

	public static Properties getProperties(FileInputStream fis) {

		Properties prop = new Properties();

		try {

			prop.load(fis);
			return prop;

		} catch (Exception e) {

			System.out.println();
			return null;

		}

	}

}
