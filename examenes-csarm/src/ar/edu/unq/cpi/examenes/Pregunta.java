package ar.edu.unq.cpi.examenes;

public abstract class Pregunta {

	private int puntajeMaximo;

	public int getPuntajeMaximo() { return this.puntajeMaximo; }
	
	public abstract Object getRespuestaCorrecta();

	public abstract RespuestaAPregunta<?> crearRespuesta(); 
}
