package ar.edu.unq.cpi.busquedas;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import ar.edu.unq.cpi.examenes.Examen;

public class Busqueda {
	private Set<Aspirante> aspirantes = new HashSet<>();
	private Set<Examen> examenes = new HashSet<>();
	
	public void agregarExamen(Examen ex) {
		examenes.add(ex);
	}
	
	/*
	 * Segunda parte, requerimiento 1
	 */
	public void registrarAspirante(Aspirante aspi) {
		aspirantes.add(aspi);
	}
	
	/*
	 * Para hacerlo asi, la resolucion tiene que conocer al aspirante
	 * Pero el project leader esta caprichoso y no me deja
	 * tocar la resolucion.
	 * En principio, esto es una alternativa valida.
	 */
//	public void registrarResolucion(ResolucionDeExamen reso) {
//		
//	}
	
	/*
	 * Segunda parte, requerimiento 3 
	 */
	public Set<Aspirante> losQueNoSePuedenEvaluar() {
		return this.aspirantes.stream()
				.filter(aspirante -> !aspirante.examenesFaltantes().isEmpty())
				.collect(Collectors.toSet());
	}

	public Set<Examen> getExamenes() {
		// TODO Auto-generated method stub
		return null;
	}
	
}




