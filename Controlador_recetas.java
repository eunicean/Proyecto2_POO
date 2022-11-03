package Controlador;
import java.util.ArrayList;

import modelos.Ingredientes;
import modelos.Lista_recetas;
import modelos.Receta;

public class Controlador_recetas {

	private static conexion Conec = new conexion();
	
	public static Lista_recetas get_recetas() { //listado de recetas sin pasos
		Lista_recetas Lista_recetas = new Lista_recetas();
		
		try {
			String query = "CALL get_recetas()";
			ArrayList<ArrayList<String>> rs = Conec.consulta(query,5); //se env�a el query a la base de datos
			for (ArrayList<String> arrayList : rs) {

				Lista_recetas.agregar_recetas(new Receta(arrayList.get(3),arrayList.get(4)));
			}
			for (ArrayList<String> arrayList : rs) {
				Receta receta_temp =Lista_recetas.obtener_recetas(arrayList.get(3));
				receta_temp.add_ingrediente(new Ingredientes(arrayList.get(2),arrayList.get(1)));
			}
			return Lista_recetas;
		}catch(Exception e){ System.out.println(e); return null;}
	}
	//------------------------------------------------------------------------------------------------------------
	public static Lista_recetas get_recetas_pasos() { //con pasos
		Lista_recetas Lista_recetas = new Lista_recetas();
		
		try {
			String query = "CALL get_recetas_pasos()";
			ArrayList<ArrayList<String>> rs = Conec.consulta(query,6); //se env�a el query a la base de datos
			for (ArrayList<String> arrayList : rs) {

				Lista_recetas.agregar_recetas(new Receta(arrayList.get(3),arrayList.get(4),arrayList.get(5)));
			}
			for (ArrayList<String> arrayList : rs) {
				Receta receta_temp =Lista_recetas.obtener_recetas(arrayList.get(3));
				receta_temp.add_ingrediente(new Ingredientes(arrayList.get(2),arrayList.get(1)));
			}
			return Lista_recetas;
		}catch(Exception e){ System.out.println(e); return null;}
	}
	//-------------------------------------------------------------------------------
	public static void create_receta(Receta recepy_n) {
		try {
			String query = "CALL add_receta("+recepy_n.imprimir_p_query()+")";
			Conec.consulta(query); //se env�a el query a la base de datos
			
		}catch(Exception e){ System.out.println(e);}
	}
	//-------------------------------------------------------------------------------
	public static void delete_receta(String id_receta) {
		try {
			String query = "CALL drop_receta("+id_receta+")";
			Conec.consulta(query); //se env�a el query a la base de datos
			
		}catch(Exception e){ System.out.println(e);}
	}
	//-------------------------------------------------------------------------------
	public static Lista_recetas pasos_receta(String id_receta) {
		Lista_recetas Lista_recetas = new Lista_recetas();
		try {
			String query = "CALL get_recetas_pasos("+id_receta+")";
			ArrayList<ArrayList<String>> rs = Conec.consulta(query,6); //se env�a el query a la base de datos
			for (ArrayList<String> arrayList : rs) {

				Lista_recetas.agregar_recetas(new Receta(arrayList.get(3),arrayList.get(4),arrayList.get(5)));
			}
			for (ArrayList<String> arrayList : rs) {
				Receta receta_temp =Lista_recetas.obtener_recetas(arrayList.get(3));
				receta_temp.add_ingrediente(new Ingredientes(arrayList.get(2),arrayList.get(1)));
			}
			return Lista_recetas;
		}catch(Exception e){ System.out.println(e); return null;}
	}
}
