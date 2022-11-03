package modelos;

import java.util.ArrayList;

public class Lista_recetas {

	public ArrayList<Receta> Listad_recetas = new ArrayList<Receta>();
	
	public Receta agregar_recetas(Receta auxiliar) {
		for (Receta receta : Listad_recetas) {
			if(receta.getNombre().equals(auxiliar.getNombre())) {
				return receta;
			}
		}
		Listad_recetas.add(auxiliar);
		return auxiliar;
	}
	
	public void imprimir_recetas() {
		for (Receta receta : Listad_recetas) {
			receta.imprimir();
		}
		
	}
	
	public Receta obtener_recetas(String n_receta) {
		for (Receta receta : Listad_recetas) {
			if(receta.getNombre().equals(n_receta)) {
				return receta;
			}
		}
		return null;
	}
	
	public void imprimir_recetas_c_ingrdiente(String n_ingrediente) {
		for (Receta receta : Listad_recetas) {
			receta.imprimir_c_ingrediente(n_ingrediente);;
		}
		
	}
	
	public void imprimir_recetas_c_tags(String n_t) {
		for (Receta receta : Listad_recetas) {
			receta.imprimir_c_tag(n_t);;
		}
		
	}
	
	public void imprimir_recetas_c_nombre(String rnmb) {
		for (Receta receta : Listad_recetas) {
			receta.nombreparecido(rnmb);
		}
	}
	//
	public void imprimir_recetas_pasos() {
		for (Receta receta : Listad_recetas) {
			receta.imprimir_c_ingrediente_pasos();
		}
		
	}
}
