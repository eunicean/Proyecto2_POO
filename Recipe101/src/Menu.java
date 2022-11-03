import java.util.Scanner;

import modelos.Ingredientes;
import modelos.Receta;
import modelos.Usuarios;

public class Menu {
	Scanner sn = new Scanner(System.in);
	
	public void menu() {
		while(true) {
			System.out.println("\n==========Bienvenido a MyMeal==========");
			System.out.println("1) Log In");
			System.out.println("2) Registrarse");
			System.out.println("3) Salir");
			String key = sn.nextLine();
			System.out.println(key);
			
			switch (key) {
			case "1":
				String user = pedir_valor("User");
				String contr = pedir_valor("Contrasenia");
				
				if(Controlador.Controlador_user.existe_users(new Usuarios(user, contr))) {
					if(Controlador.Controlador_user.obt_rol_users(new Usuarios(user, contr)).equals("0")) {
						System.out.println("Bienvenido Administrador " + user);
						menu2();
					}
					else {
						System.out.println("Bienvenido Visitante " + user);
						menu3();
					}
				}
				
				else {
					System.out.println("Su usuario o contrasena so incorrectos");
				}
				break;
			case "2":
				String userr = pedir_valor("Usuario");
				String contrr = pedir_valor("Contrasenia");
				String rol = pedir_valor("Rol * 0 = Admin , 1 = Visitante*");

				Controlador.Controlador_user.create_users(new Usuarios(userr, contrr,rol));
				//Controlador.Controlador_user.get_users();
				System.out.println("Usuario " + userr + " registrado exitosamente");
				//menu2();
				break;
			case "3":
				System.exit(0);
				break;

			default:
				System.out.println("Solo valores desde 1 a 3");
				break;
			}
			
			esperar();
		}
	}
	
	
	public void menu2() { //menu al cual el administrador tiene acceso
		while(true) {
			System.out.println("\n=====Menu MyMeal=====");
			System.out.println("1) Ingresar receta");
			System.out.println("2) Eliminar receta");
			System.out.println("3) Listar recetas");
			System.out.println("4) Mostrar receta con pasos");
			System.out.println("5) Buscar por ingrediente");
			System.out.println("6) Cerrar sesion");
			String key = sn.nextLine();
			switch (key) {
			case "1":
				System.out.println("=====Agregar receta=====");
				String nmb_r = pedir_valor("Nombre de la receta");
				String igdt1 = pedir_valor("Primer ingrediente").toLowerCase();
				String cigd1 = pedir_valor("Cantidades del primer ingrediente");
				String igdt2 = pedir_valor("Segundo ingrediente").toLowerCase();
				String cigd2 = pedir_valor("Cantidades del segundo ingrediente");
				String igdt3 = pedir_valor("Tercer ingrediente").toLowerCase();
				String cigd3 = pedir_valor("Cantidades del tercer ingrediente");
				String pasos = pedir_valor("Pasos de la receta");
				
				Receta n_receta = new Receta(nmb_r,"0",pasos);
				n_receta.add_ingrediente(new Ingredientes(igdt1,cigd1));
				n_receta.add_ingrediente(new Ingredientes(igdt2,cigd2));
				n_receta.add_ingrediente(new Ingredientes(igdt3,cigd3));
				
				Controlador.Controlador_recetas.create_receta(n_receta);
				n_receta.imprimir();
				break;	
			case "2":
				Controlador.Controlador_recetas.get_recetas_pasos().imprimir_recetas();
				
				String drop = pedir_valor("Id de la receta que se eliminara");
				Controlador.Controlador_recetas.delete_receta(drop);

				Controlador.Controlador_recetas.get_recetas_pasos().imprimir_recetas();
				System.out.println("Receta eliminada");
				break;
			case "3":
				Controlador.Controlador_recetas.get_recetas_pasos().imprimir_recetas();
				
				break;
			case "4":
				Controlador.Controlador_recetas.get_recetas_pasos().imprimir_recetas();
				
				String recetea = pedir_valor("Id de la receta para mostrar pasos");
				Controlador.Controlador_recetas.pasos_receta(recetea);

				Controlador.Controlador_recetas.pasos_receta(recetea).imprimir_recetas_pasos();
				break;
			case "5":
				String n_ingr = pedir_valor("Nombre del ingrediente");
				
				Controlador.Controlador_recetas.get_recetas_pasos().imprimir_recetas_c_ingrdiente(n_ingr);
				break;
			case "6":
				System.out.println("Regresando al menu principal ...");
				return;

			default:
				break;
			}
			esperar();
		}
	}
	
	public void menu3() {//visitantes
		while(true) {
			System.out.println("\n=====Menu MyMeal=====");
			System.out.println("1) Listar recetas");
			System.out.println("2) Buscar por ingrediente");
			System.out.println("3) Mostrar receta con pasos");
			System.out.println("4) Cerrar sesion");
			String key = sn.nextLine();
			switch (key) {
			case "1":
				Controlador.Controlador_recetas.get_recetas_pasos().imprimir_recetas();
				break;
			case "2":
				String n_ingr = pedir_valor("Nombre del ingrediente");
				
				Controlador.Controlador_recetas.get_recetas_pasos().imprimir_recetas_c_ingrdiente(n_ingr);
				break;
			case "3":
				Controlador.Controlador_recetas.get_recetas_pasos().imprimir_recetas();
				
				String recetea = pedir_valor("Id de la receta para mostrar pasos");
				Controlador.Controlador_recetas.pasos_receta(recetea);

				Controlador.Controlador_recetas.pasos_receta(recetea).imprimir_recetas_pasos();
				break;
			case "4":
				System.out.println("Regresando al menu principal ...");
				return;

			default:
				break;
			}
			esperar();
		}
	}
	
	public void esperar() {
		System.out.println("");	
		System.out.println("Presione una tecla para continuar ...");
		sn.nextLine();
	}
	
	public String pedir_valor(String valor) {
		System.out.println("Ingrese el " + valor);
		return sn.nextLine();
	}
}
