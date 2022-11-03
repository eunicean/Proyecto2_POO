package modelos;
import java.util.*;

public class Receta {
	private String nombre;
	private ArrayList<Ingredientes> ListaIngredientes;
	private String id_receta ="0";
	private String pasos;
	
	//Constructores
	public Receta(String nombre, String id) {
		this.nombre = nombre;
		this.ListaIngredientes = new ArrayList<Ingredientes>();
		this.id_receta = id;
	}
	
	public Receta(String nombre,String id_receta , String pasos) {
		this.nombre = nombre;
		this.ListaIngredientes = new ArrayList<Ingredientes>();
		this.id_receta = id_receta;
		this.pasos = pasos;
	}
	

	//getters setters
	public ArrayList<Ingredientes> getListaIngredientes() {
		return ListaIngredientes;
	}

	public void setListaIngredientes(ArrayList<Ingredientes> listaIngredientes) {
		ListaIngredientes = listaIngredientes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//Metodos
	public void add_ingrediente(Ingredientes n_ingrd) {
		ListaIngredientes.add(n_ingrd);
	}
	
	public void imprimir() {
		System.out.println("");
		System.out.println("======= "+ this.id_receta +" - "+this.nombre+" =======");
		for (Ingredientes ingrediente : ListaIngredientes) {
			ingrediente.imprimir();
		}
		System.out.println(this.pasos);
	}
		
	public String imprimir_p_query() {
		return "'" + this.nombre+"'," + ListaIngredientes.get(0).imprimir_p_query() + "," + ListaIngredientes.get(1).imprimir_p_query() + "," + ListaIngredientes.get(2).imprimir_p_query()+ ",'" +this.pasos+"'";
		
	}
	
	public boolean tieneingrediente(String ingred) {
		for (Ingredientes ingredientes : ListaIngredientes) {
			if(ingredientes.getNombre().equalsIgnoreCase(ingred.trim())) {
				return true;
			}
		}
		return false;
	}
	
	public void imprimir_c_ingrediente(String nombre_ingrediente) {
		if(tieneingrediente(nombre_ingrediente)) {
			this.imprimir();
		}
	}
	//
	public void imprimir_c_ingrediente_pasos() {
		this.imprimir();
		System.out.println("----------------*PASOS*----------------");
		System.out.println(this.pasos);
		System.out.println("----------------*PASOS*----------------");
	}
}
