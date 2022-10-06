/**
* Universidad del Valle de Guatemala
* Facultad de Ingenieria
* Programacion orientada a objetos
* Prof. Lynette Garcia Perez
* Seccion 100
* Autor: Eunice Anahi Mata Ixcayau
*/
import java.sql.*;
import java.util.*;

public class conexion {
	
	//metodos
	/**
	 * Metodo que consigue la lista que requierea el programa , y realiza la conexion a la base de datos
	 * @param query string con la instruccion que envia el controlador a la base de datos
	 * @param columnas cantidad de columnas de informacion
	 * @return matriz L, con los datos extraidos de la base de datos
	 */
	public ArrayList<ArrayList<String>> consulta(String query, int columnas) {
		ArrayList<ArrayList<String>> L = new ArrayList<>(); //crea una matriz llamada L
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/platillos","root",""); //coneccion con la base de datos
			Statement stm = con.createStatement();
			 rs = stm.executeQuery(query);
			while(rs.next()) {
				ArrayList<String> auxiliar = new ArrayList<String>(); //arraylist auxiliar para agregar informacion a la matriz final
				
				for(int i=1; i<=columnas;i++) { //se agrega informacion al array list
					auxiliar.add(rs.getString(i));
				}
				L.add(auxiliar); // se agrega inf del arraylist auxiliar a la matriz final
			}
			con.close(); //se cierra la coneccion
			return L; //se regresa la matriz
		}catch(Exception e){ 
			System.out.println(e);
			return L;
		}
	}
	/**
	 * Metodo para verificar que la instruccion enviada por el programa haya resultado
	 * @param query string con la instruccion que se quiere enviar a la base de datos
	 * @return boolean de resultado, true si no hay errores, false si hay errores.
	 */
	public boolean consulta(String query) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/platillos","root",""); //conexion con la base de datos
			Statement stm = con.createStatement();
			stm.executeQuery(query);
			
			con.close(); // cierre de la conexion
			return true;
		}catch(Exception e){ 
			System.out.println(e);
			return false;
		}
	}
	
}
