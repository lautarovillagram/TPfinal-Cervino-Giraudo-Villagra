package ar.edu.unq.po.tpfinal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Buscador {
	private List<Muestra> muestras;

	public Buscador(List<Muestra> muestras) {
		this.setMuestras(muestras);
	}
	
	// Recibe por parametros 2 listas que son el resultado de aplicar algun filtro de busqueda
	// y devuelve las que cumplan con ambos criterios
	public List<Muestra> buscarPor_Y_(List<Muestra> filtro1, List<Muestra> filtro2) {
		// Si es un AND tengo que crear una lista con solo los elementos que se repitan en ambas listas
		List<Muestra> resultado = new ArrayList<>();
		for(Muestra m: filtro1) {
			if (filtro2.contains(m)) {
				resultado.add(m);
			}
		}
		return resultado;
	}
	
	// Recibe por parametros 2 listas que son el resultado de aplicar algun filtro de busqueda
	// y devuelve las que cumplan con alguno de los 2 criterios
	public List<Muestra> buscarPor_O_(List<Muestra> filtro1, List<Muestra> filtro2) {
		// Si es un OR tengo que combinar ambas listas
		List<Muestra> resultado = filtro1;
		for(Muestra m: filtro2) {
			if (! resultado.contains(m)) { 
				resultado.add(m);
			}
		}
		return resultado;
	}
	
	public List<Muestra> buscarPorFechaDeCreacion(LocalDateTime fecha) {
		return this.getMuestras().stream().filter(m -> m.getFecha().equals(fecha)).collect(Collectors.toList());
	}
	
	public List<Muestra> buscarPorFechaDeUltimaVotacion(LocalDateTime fecha) {
		return this.getMuestras().stream().filter(m -> m.getFechaUltimaVotacion().equals(fecha)).collect(Collectors.toList());
	}
	
	public List<Muestra> buscarPorTipoDeInsecto(String especie) {
		return this.getMuestras().stream().filter(m -> m.resultadoActual().equals(especie)).collect(Collectors.toList());
	}
	
	public List<Muestra> buscarPorNivelDeVerificacion(String nivel) {
		switch(nivel) {
		case "verificada": 
			return this.getMuestras().stream().filter(m -> m.estaVerificada()).collect(Collectors.toList());
		case "votada": 
			return this.getMuestras().stream().filter(m -> !m.estaVerificada()).collect(Collectors.toList());
		}
		System.out.println("No es un nivel valido");
		return muestras;
	}
	
	// Getter y Setters
	public List<Muestra> getMuestras() {
		return muestras;
	}

	public void setMuestras(List<Muestra> muestras) {
		this.muestras = muestras;
	}
}
