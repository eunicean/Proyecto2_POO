import java.util.ArrayList;

/*Universidad del Valle de Guatemala
/*Proyecto POO
* 
* 
*Esta es una clase para generar las recetas
*/


public class Recetas {
    private String nombre;
    private ArrayList<ingrediente> listaingredientes;
    private String procedimiento;
    private String id;
    
      //construtor
	/**
	 * Constructor que simula una receta
	 * @param nombre nombre de la receta
	 * @param procedimiento procedimiento como se realiza esta receta
     * @param id como se puede identificar
	 */
    
    public Recetas(){
        nombre = "";
        listaingredientes = new ArrayList<ingrediente>();
        procedimiento = "";
        id = "";


    }

    public Recetas(String nombre, ArrayList<ingrediente> listaingredientes, String procedimiento, String id){
        this.nombre = nombre;
        this.listaingredientes = listaingredientes;
        this.procedimiento = procedimiento;
        this.id = id;
    }


    /*
     * Get y sets de los atributos
     */
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<ingrediente> getListaingredientes() {
        return this.listaingredientes;
    }

    public void setListaingredientes(ArrayList<ingrediente> listaingredientes) {
        this.listaingredientes = listaingredientes;
    }

    public String getProcedimiento() {
        return this.procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


    /*
     * Implrime la receta con sus respectivos atributos
     */
    @Override
    public String toString() {
        
        String estring =  "{" +
            " nombre: '" + getNombre() + "'" +
            ", procedimiento: '" + getProcedimiento() + "'" +
            ", id: '" + getId() + "'" +
            "}";

        return estring;
    }

        
        
    
}
