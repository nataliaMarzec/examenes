package ar.edu.unq.cpi.examenes;

public class RespuestaNumerica extends RespuestaAPregunta<PreguntaNumerica> {
	
	private int respuestaElegida;

	public RespuestaNumerica(PreguntaNumerica pregunta) {
		super(pregunta);
	}

	@Override
	public boolean esCorrecta() {
		return this.getPregunta().getRespuestaCorrecta().equals(this.respuestaElegida);
	}

	public int getPuntaje() {
		this.getPregunta().getPuntajeMaximo();
		if (!this.esCorrecta() && this.estaEnRangoAproximado()) {
			return this.getPregunta().getPuntajeAproximado();
		} else {
			return super.getPuntaje();
		}
	}

	private boolean estaEnRangoAproximado() {
		return this.respuestaElegida >= this.getPregunta().getMinimoAproximado() &&
				this.respuestaElegida <= this.getPregunta().getMaximoAproximado();
	}

	@Override
	public void setValueFromString(String valorString) {
		this.respuestaElegida =  Integer.parseInt(valorString);
	}

}
