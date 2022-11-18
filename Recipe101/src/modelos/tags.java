package modelos;

public class tags {
	private String nombre_tag;

	public tags(String nombre_tag) {
		this.nombre_tag = nombre_tag;
	}
	//setters y getters
	public String getNombre_tag() {
		return nombre_tag;
	}

	public void setNombre_tag(String nombre_tag) {
		this.nombre_tag = nombre_tag;
	}
	
	//metodos
	public void imprimir() {
		System.out.println("* | " + this.nombre_tag );
	}
	
	public String imprimir_p_query() {
		return "'" + this.nombre_tag +"'";
	}
	
}
