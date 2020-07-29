package ar.edu.unq.cpi.examenes;

import java.util.List;

public class PreguntaSecuencia extends Pregunta {

	private List<String> respuestaCorrecta;
	
	@Override
	public Object getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	@Override
	public RespuestaAPregunta<?> crearRespuesta() {
		return new RespuestaSecuencia(this);
	}

}
