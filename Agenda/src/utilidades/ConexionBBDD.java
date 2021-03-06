package utilidades;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class ConexionBBDD {

	private static String driver;
	private static String cadenaConexion;
	private static String user;
	private static String password;
	private static String FILE = "config.json";
	
	static {
		
		try {
			cargarPropiedades();
			Class.forName(driver);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (JsonIOException e) {	
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(cadenaConexion, user, password);
	}
	
	private static void cargarPropiedades() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		
		JsonObject conn = JsonParser.parseReader(new FileReader(FILE)).getAsJsonObject();
		
		driver = conn.get("driver").getAsString();
		cadenaConexion = conn.get("cadenaConexion").getAsString();
		user = conn.get("user").getAsString();
		password = conn.get("password").getAsString();
	}
	
}
