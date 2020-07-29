package ar.edu.unq.cpi.examenes;

public class PreguntaNumerica extends Pregunta {

	private int respuestaCorrecta;
	private int minimoAproximado;
	private int maximoAproximado;
	private int puntajeAproximado;

	
	@Override
	public Object getRespuestaCorrecta() {
		return this.respuestaCorrecta;
	}
	
	public int getPuntajeAproximado() { return this.puntajeAproximado; }

	public int getMinimoAproximado() { return this.minimoAproximado; }
	public int getMaximoAproximado() { return this.maximoAproximado; }

	@Override
	public RespuestaAPregunta<?> crearRespuesta() {
		return new RespuestaNumerica(this);
	}

}
