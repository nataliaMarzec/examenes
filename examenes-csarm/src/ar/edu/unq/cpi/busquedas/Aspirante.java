package ar.edu.unq.cpi.busquedas;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import ar.edu.unq.cpi.examenes.Examen;
import ar.edu.unq.cpi.examenes.ResolucionDeExamen;

public class Aspirante {
	private Set<ResolucionDeExamen> resoluciones = new HashSet<>();
	private Busqueda busqueda;
	
	public void setBusqueda(Busqueda busq) { this.busqueda = busq; }
	/*
	 * Segunda parte, requerimiento 2
	 */
	public void registrarResolucion(ResolucionDeExamen reso) {
		this.resoluciones.add(reso);
	}

	/*
	 * Segunda parte, requerimiento 4
	 */
	public Set<Examen> examenesFaltantes() {
		// de los examenes de la busqueda, los que no resolvi
		return this.busqueda.getExamenes().stream()
				.filter(examen -> this.resolvioExamen(examen))
				.collect(Collectors.toSet());
	}
	
	private boolean resolvioExamen(Examen examen) {
		return this.resoluciones.stream()
				.anyMatch(reso -> reso.getExamen().equals(examen));
	}	
}







