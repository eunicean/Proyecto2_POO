package modelos;
import java.util.*;

public class Receta {
	private String nombre;
	private ArrayList<Ingredientes> ListaIngredientes;
	private ArrayList<tags> ListaTags;
	private String id_receta ="0";
	private String pasos;
	
	//Constructores
	public Receta(String nombre, String id) {
		this.nombre = nombre;
		this.ListaIngredientes = new ArrayList<Ingredientes>();
		this.ListaTags = new ArrayList<tags>();
		this.id_receta = id;
	}
	
	public Receta(String nombre,String id_receta , String pasos) {
		this.nombre = nombre;
		this.ListaIngredientes = new ArrayList<Ingredientes>();
		this.ListaTags = new ArrayList<tags>();
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
	
	public ArrayList<tags> getListaTags() {
		return ListaTags;
	}

	public void setListaTags(ArrayList<tags> listaTags) {
		ListaTags = listaTags;
	}

	//Metodos
	public void add_ingrediente(Ingredientes n_ingrd) {
		ListaIngredientes.add(n_ingrd);
	}
	
	public void add_tag(tags n_tgs) {
		ListaTags.add(n_tgs);
	}
	
	public void imprimir() {
		System.out.println("");
		System.out.println("======= "+ this.id_receta +" - "+this.nombre+" =======");
		for(tags TAGS : ListaTags) {
			TAGS.imprimir();
		}
		for (Ingredientes ingrediente : ListaIngredientes) {
			ingrediente.imprimir();
		}
		System.out.println(this.pasos);
	}
		
	public String imprimir_p_query() {
		return "'" 	+ this.nombre+"'," 
					+ ListaIngredientes.get(0).imprimir_p_query() + "," 
					+ ListaIngredientes.get(1).imprimir_p_query() + "," 
					+ ListaIngredientes.get(2).imprimir_p_query()+ ",'" 
					+ this.pasos + "'," 
					+ ListaTags.get(0).imprimir_p_query() + "," 
					+ ListaTags.get(1).imprimir_p_query() + "," 
					+ ListaTags.get(2).imprimir_p_query();
		
	}
	
	public boolean tieneingrediente(String ingred) {
		for (Ingredientes ingredientes : ListaIngredientes) {			
			if(ingredientes.getNombre().toLowerCase().contains(ingred.trim().toLowerCase())) { //verifica que haya ingredientes parecidos al ingrediente ingresado
				return true;
			}
		}
		return false;
	}
	
	public boolean tienetag(String t) {
		for (tags tagg : ListaTags) {			
			if(tagg.getNombre_tag().toLowerCase().contains(t.trim().toLowerCase())) { //verifica que haya ingredientes parecidos al ingrediente ingresado
				return true;
			}
		}
		return false;
	}
	
	public void nombreparecido(String rnombre) {
		if(this.nombre.toLowerCase().contains(rnombre.trim().toLowerCase())) {
			this.imprimir();
		}
	}
	
	public void imprimir_c_ingrediente(String nombre_ingrediente) {
		if(tieneingrediente(nombre_ingrediente)) {
			this.imprimir();
		}
	}
	public void imprimir_c_tag(String nombre_tag) {
		System.out.println(tienetag(nombre_tag));
		if(tienetag(nombre_tag)) {
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