package ar.edu.unq.po.tpfinal;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Buscador {
	private List<Muestra> muestras;

	public Buscador(List<Muestra> muestras) {
		this.setMuestras(muestras);
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
