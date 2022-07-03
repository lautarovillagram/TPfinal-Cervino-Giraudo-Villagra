package ar.edu.unq.po.tpfinal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class StateVerificacion {
	private Muestra context;
	
	public abstract void agregarOpinion(Opinion o);
	
	public abstract String resultadoActual();
	
	public boolean estaVerificada() {
		return false;
	}
	
	public boolean hayEmpate(Map<String, Integer> opiniones) {
		// Obtengo el mayor numero de votos del map
		int maxNumeroVotos = Collections.max(opiniones.values());
		// Si hay mas de 1 opinion con la mayor cantidad de votos hay empate
		return opiniones.entrySet().stream().filter(me -> me.getValue() == maxNumeroVotos).count() > 1;
	}
	
	// Getters y Setters
	public Muestra getContext() {
		return context;
	}
	
	public void setContext(Muestra context) {
		this.context = context;
	}
}
