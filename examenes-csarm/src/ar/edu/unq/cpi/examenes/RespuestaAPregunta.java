package ar.edu.unq.cpi.examenes;

public abstract class RespuestaAPregunta<P extends Pregunta> {
	private P pregunta;

	public RespuestaAPregunta(P laPregunta) {
		this.pregunta = laPregunta;
	}
	
	public P getPregunta() { return this.pregunta; }
	
	public int getPuntaje() {
		return this.esCorrecta() 
			? this.getPregunta().getPuntajeMaximo() 
			: 0
		;
	}

	public abstract boolean esCorrecta();
	
	// seteos
	public abstract void setValueFromString(String valorString);

//	public int getPuntajeSiSeEncargaraLaPregunta() {
//		return this.getPregunta().getPuntajePara(this);
		/* este método sería abstracto en Pregunta
		 * y lo resolvería cada subclase.
		 */
//		}
		
//	public int getPuntajePrimeraVersion() {
//		return this.getPregunta().getRespuestaCorrecta().equals(this.valor) 
//				? this.getPregunta().getPuntajeMaximo() 
//				: 0
//				;
//	}
}
