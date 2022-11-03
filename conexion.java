package Controlador;
import java.sql.*;
import java.util.*;

public class conexion {
	
	public ArrayList<ArrayList<String>> consulta(String query, int columnas) {
		ArrayList<ArrayList<String>> L = new ArrayList<>();
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/platillos","root","");
			Statement stm = con.createStatement();
			 rs = stm.executeQuery(query);
			while(rs.next()) {
				ArrayList<String> auxiliar = new ArrayList<String>();
				
				for(int i=1; i<=columnas;i++) {
					auxiliar.add(rs.getString(i));
				}
				L.add(auxiliar);
			}
			con.close();
			return L;
		}catch(Exception e){ 
			System.out.println(e);
			return L;
		}
	}

	public boolean consulta(String query) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/platillos","root","");
			Statement stm = con.createStatement();
			stm.executeQuery(query);
			
			con.close();
			return true;
		}catch(Exception e){ 
			System.out.println(e);
			return false;
		}
	}
	
}
