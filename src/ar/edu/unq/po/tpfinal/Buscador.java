package ar.edu.unq.po.tpfinal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Buscador {
	private List<Muestra> muestras = new ArrayList<>();
	
	// Ejecuta la busqueda que recibe por parametro
	public List<Muestra> buscar(Busqueda b) {
		return b.buscar();
	}
	
	// Permite agregar una muestra al buscador, el sistema es responsable de llamar
	// a este metodo cada vez que se agregue una muestra nueva
	public void agregarMuestra(Muestra m) {
		this.getMuestras().add(m);
	}
	
	// Crea una instancia de busqueda AND con las busquedas dadas por parametro
	public Busqueda buscarPor_Y_(Busqueda b1, Busqueda b2) {
		return new BusquedaAND(b1, b2, this.getMuestras());
	}
	
	// Crea una instancia de busqueda AND con las busquedas dadas por parametro
	public Busqueda buscarPor_O_(Busqueda b1, Busqueda b2) {
		return new BusquedaOR(b1, b2, this.getMuestras());
	}
	
	// Crea una instancia de busqueda con el criterio dado por parametro
	public Busqueda buscarPorFechaDeCreacion(LocalDateTime fecha) {
		return new BusquedaPorFechaDeCreacion(fecha, this.getMuestras());
	}
	
	// Crea una instancia de busqueda con el criterio dado por parametro
	public Busqueda buscarPorFechaDeUltimaVotacion(LocalDateTime fecha) {
		return new BusquedaPorFechaUltimaVotacion(fecha, this.getMuestras());
	}
	
	// Crea una instancia de busqueda con el criterio dado por parametro
	public Busqueda buscarPorTipoDeInsecto(String especie) {
		return new BusquedaPorTipoDeInsecto(especie, this.getMuestras());
	}
	
	// Crea una instancia de busqueda con el criterio dado por parametro
	public Busqueda buscarPorNivelDeVerificacion(String nivel) {
		return new BusquedaPorNivelDeVerificacion(nivel, this.getMuestras());
	}
	
	// Getter y Setters
	public List<Muestra> getMuestras() {
		return muestras;
	}
}
