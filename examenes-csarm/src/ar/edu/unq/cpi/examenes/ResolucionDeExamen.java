package ar.edu.unq.cpi.examenes;

import java.util.List;

public class ResolucionDeExamen {

	private Examen examen;
	private List<RespuestaAPregunta<?>> respuestas;
	
	public Examen getExamen() { return this.examen; }
	public List<RespuestaAPregunta<?>> getRespuestas() { return this.respuestas; }
	public RespuestaAPregunta<?> getRespuesta(Pregunta preg) {
		return this.getRespuestas().stream()
				.filter(respuesta -> respuesta.getPregunta().equals(preg))
				.findAny().get();
	}

	public int getPuntaje() {
		return this.getRespuestas().stream()
				.mapToInt(preg -> preg.getPuntaje()).sum();
	}
	
	public boolean estaAprobado() {
		// asi era cuando lo podia resolver la resolucion
		// boolean apruebo = this.getPuntaje() >= this.getExamen().getPuntajeMinimoAprobacion();
		
		// "la del if" que ya nos sabiamos
//		if (this.getExamen().esEspecial()) {
//			apruebo = apruebo && <<<otra condicion>>>
//		}
//		return apruebo;
		
		// los curiosos pueden chusmear el pattern Façade
		return this.examen.estaAprobada(this);
	}
	
	// seteo de cosas
	public void setExamen(Examen examen) {
		this.examen = examen;		
	}
	public void agregarRespuesta(RespuestaAPregunta<?> resp) {
		this.respuestas.add(resp);
	}

	// solucion "negra" que no gusto
//	public int getPuntaje() {
//		int puntaje = 0;
//		for (int i = 0; i < this.getExamen().getPreguntas().size(); i++) {
//			Pregunta pregunta = this.getExamen().getPreguntas().get(i);
//			String respuesta = this.getRespuestas().get(i);
//			if (respuesta.equals(pregunta.getRespuestaCorrecta())) {
//				puntaje = puntaje + pregunta.getPuntajeMaximo();
//			}
//		}
//		return puntaje;
//	}
	
}
