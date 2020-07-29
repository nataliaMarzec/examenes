package ar.edu.unq.cpi.examenes;

public class PreguntaMultipleChoice extends Pregunta {
	private String respuestaCorrecta;

	public String getRespuestaCorrecta() { return this.respuestaCorrecta; }

	@Override
	public RespuestaAPregunta<?> crearRespuesta() {
		return new RespuestaMultipleChoice(this);
	} 
}
