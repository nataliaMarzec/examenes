package ar.edu.unq.cpi.examenes;

import java.util.Set;
import java.util.stream.Collectors;

public class ExamenConCondicionEspecial extends Examen {

	public Set<Pregunta> preguntasAMirar;
	public int cantidadQueDebeEstarBien;
	
	@Override
	public boolean estaAprobada(ResolucionDeExamen resolucion) {
		return super.estaAprobada(resolucion) 
				&& this.tieneSuficienteDeLasQueHayQueMirar(resolucion);
	}
	
	/*
	 * True si la resolucion cumple la condicion adicional
	 * que define este examen.
	 */
	public boolean tieneSuficienteDeLasQueHayQueMirar(ResolucionDeExamen resolucion) {
		Set<RespuestaAPregunta<?>> respuestasCorrectas = 
				this.preguntasAMirar.stream()
				.map(preg -> resolucion.getRespuesta(preg))
				.filter(resp -> resp.esCorrecta())
				.collect(Collectors.toSet());
		return respuestasCorrectas.size() >= cantidadQueDebeEstarBien;
	}

	// ¡¡ esto es un chiche !!
	public boolean tieneSuficienteDeLasQueHayQueMirarChiche(ResolucionDeExamen resolucion) {
		long cantidadDeRespuestasCorrectas = 
				this.preguntasAMirar.stream()
				.map(preg -> resolucion.getRespuesta(preg))
				.filter(resp -> resp.esCorrecta())
				.count();
		return cantidadDeRespuestasCorrectas >= cantidadQueDebeEstarBien;
	}


}
