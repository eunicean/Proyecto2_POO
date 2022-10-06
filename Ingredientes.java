/**
* Universidad del Valle de Guatemala
* Facultad de Ingenieria
* Programacion orientada a objetos
* Prof. Lynette Garcia Perez
* Seccion 100
* Autor: Eunice Anahi Mata Ixcayau
*/
public class Ingredientes {
	private String Nombre;
	private String Cantidades;
	
    //construtor
	/**
	 * Constructor que simula un ingrediente
	 * @param nombre del ingrediente
	 * @param cantidades cantidad y medicion del ingrediente (ej: 5lb)
	 */
	public Ingredientes(String nombre, String cantidades) {
		this.Nombre = nombre;
		this.Cantidades = cantidades;
	} 
	//getters setter
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	public String getCantidades() {
		return Cantidades;
	}
	public void setCantidades(String cantidades) {
		this.Cantidades = cantidades;
	}
	
	//Metodos
	/**
	 * Imprime el ingrediente
	 */
	public void imprimir() {
		System.out.println("* " + this.Nombre + ", " +this.Cantidades);
	}
	 public String imprimir_p_query() {
		 return "'" +this.Nombre + "', '" +this.Cantidades+"'";
		
	}
}
