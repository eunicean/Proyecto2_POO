package Controlador;

import java.util.*;
import modelos.Usuarios;

public class Controlador_user {
	private static conexion Conec = new conexion();
	
	public static void get_users() {
		try {
			String query = "CALL get_users()";
			ArrayList<ArrayList<String>> rs = Conec.consulta(query,3); 
			for (ArrayList<String> arrayList : rs) {
				System.out.println(String.join(",", arrayList));
			}
		}catch(Exception e){ System.out.println(e);}
	}
	
	public static void create_users(Usuarios user_n) {
		try {
			String query = "CALL create_users('"+ user_n.getUsuario()+ "','"+user_n.getContrasenia()+"',"+user_n.getRol()+")";
			Conec.consulta(query); 
			
		}catch(Exception e){ System.out.println(e);}
	}
	
	public static boolean existe_users(Usuarios v_user) {
		try {
			String query = "CALL verf_users('"+ v_user.getUsuario()+ "','"+v_user.getContrasenia()+"')";
			ArrayList<ArrayList<String>> rs = Conec.consulta(query,1); 
			String valor = rs.get(0).get(0);
			if (valor.equals("0")) {
				return false;
			}
			else {
				return true;
			}
			
		}catch(Exception e){ 
			System.out.println(e); 
			return false;}
	}
	
	public static String obt_rol_users(Usuarios v_user) {
		try {
			String query = "CALL obt_rol_users('"+ v_user.getUsuario()+ "','"+v_user.getContrasenia()+"')";
			ArrayList<ArrayList<String>> rs = Conec.consulta(query,1); 
			String valor = rs.get(0).get(0);
			return valor;
			
		}catch(Exception e){ 
			System.out.println(e); 
			return null;}
	}
}
