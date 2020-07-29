package ar.edu.unq.cpi.examenes;

public class RespuestaMultipleChoice extends RespuestaAPregunta<PreguntaMultipleChoice> {
	private String valor;
	
	public RespuestaMultipleChoice(PreguntaMultipleChoice pregunta) {
		super(pregunta);
	}

	public String getValor() { return this.valor; }

	@Override
	public boolean esCorrecta() {
		return this.getPregunta().getRespuestaCorrecta()
				.equals(this.getValor());

	}
	
	@Override
	public void setValueFromString(String valorString) {
		this.valor = valorString;
	}

}
