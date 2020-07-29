package ar.edu.unq.cpi.examenes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RespuestaSecuencia extends RespuestaAPregunta<PreguntaSecuencia> {

	public RespuestaSecuencia(PreguntaSecuencia pregunta) {
		super(pregunta);
	}

	private PreguntaSecuencia pregunta;
	public List<String> secuenciaElegida;

	@Override
	public PreguntaSecuencia getPregunta() {
		return this.pregunta;
	}
	
	@Override
	public boolean esCorrecta() {
		return this.getSecuenciaElegida().equals(this.getPregunta().getRespuestaCorrecta())
				|| 
				this.getSecuenciaElegidaAlReves().equals(this.getPregunta().getRespuestaCorrecta());
	}


	public List<String> getSecuenciaElegida() {
		return this.secuenciaElegida; 
	}
	
	public List<String> getSecuenciaElegidaAlReves() { 
		List<String> nuevaSecuencia = new ArrayList<String>(this.secuenciaElegida);
		Collections.reverse(nuevaSecuencia);
		return nuevaSecuencia;
	}

	@Override
	// la codificacion es "xx-yy-zz", las opciones
	// se esperan separadas por guion
	public void setValueFromString(String valorString) {
		this.secuenciaElegida = Arrays.asList(valorString.split("-"));
	}

}
