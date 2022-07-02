package ar.edu.unq.po.tpfinal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class StateVerificacion {
	// Contiene a todas las especies y la cantidad de votos que posee cada una
	private HashMap<String, Integer> especiesXcant = new HashMap<>();
		
	// Contiene a todas las especies y la cantidad de votos que posee cada una pero solo se utiliza cuando votan expertos
	private HashMap<String, Integer> especiesXcantExpertos = new HashMap<>();
	
	private Muestra context;
	
	public abstract void agregarOpinion(Opinion o);
	
	public abstract String resultadoActual();
	
	public boolean estaVerificada() {
		return false;
	}
	// Agrego una ocurrencia de la especie al map
	public void agregarOcurrenciaEspecie(String especie) {
		this.getEspeciesXCant().putIfAbsent(especie, 0);
		this.getEspeciesXCant().put(especie, this.getEspeciesXCant().get(especie) + 1);
	}
		
	// Agrego una ocurrencia de la especie al map de opiniones de expertos
	public void agregarOcurrenciaEspecieExpertos(String especie) {
		this.getEspeciesXCantExpertos().putIfAbsent(especie, 0);
		this.getEspeciesXCantExpertos().put(especie, this.getEspeciesXCantExpertos().get(especie) + 1);
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
	
	public Map<String, Integer> getEspeciesXCant() {
		return especiesXcant;
	}
	
	public Map<String, Integer> getEspeciesXCantExpertos() {
		return especiesXcantExpertos;
	}
}
