package ar.edu.unq.cpi.examenes;

import java.util.ArrayList;
import java.util.List;

public class Examen {
	private List<Pregunta> preguntas = new ArrayList<>();
	private int puntajeMinimoAprobacion;
	
	public int getPuntajeMaximo() { 
		return this.getPreguntas().stream()
				.mapToInt(preg -> preg.getPuntajeMaximo()).sum();
	}
	
	public List<Pregunta> getPreguntas() { return this.preguntas; }

	public int getPuntajeMinimoAprobacion() {
		return this.puntajeMinimoAprobacion;
	}
	
	public boolean estaAprobada(ResolucionDeExamen resolucion) {
		return resolucion.getPuntaje() >= this.getPuntajeMinimoAprobacion();
	}
	
	public ResolucionDeExamen crearResolucion(Examen examen) {
		// este proceso es un caso sencillo de Builder
		ResolucionDeExamen resolucion = new ResolucionDeExamen();
		resolucion.setExamen(this);
		this.getPreguntas().forEach(preg -> 
			// el crearPregunta() es un FactoryMethod
			resolucion.agregarRespuesta(preg.crearRespuesta())
		);
		return resolucion;
	}

}
