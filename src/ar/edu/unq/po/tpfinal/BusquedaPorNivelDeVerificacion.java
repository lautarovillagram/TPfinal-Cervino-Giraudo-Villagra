package ar.edu.unq.po.tpfinal;

import java.util.List;
import java.util.stream.Collectors;

public class BusquedaPorNivelDeVerificacion extends Busqueda{
	private String criterioDeBusqueda;
	
	public BusquedaPorNivelDeVerificacion(String criterio, List<Muestra> muestras) {
		super(muestras);
		this.setCriterioDeBusqueda(criterio);
	}
	
	@Override
	public List<Muestra> buscar() {
		switch(this.getCriterioDeBusqueda()) {
		case "verificada": 
			return this.getMuestras().stream().filter(m -> m.estaVerificada()).collect(Collectors.toList());
		case "votada": 
			return this.getMuestras().stream().filter(m -> !m.estaVerificada()).collect(Collectors.toList());
		}
		System.out.println("No es un nivel valido");
		return this.getMuestras();
	}
	
	// Getters y setters
	public String getCriterioDeBusqueda() {
		return criterioDeBusqueda;
	}
	public void setCriterioDeBusqueda(String criterioDeBusqueda) {
		this.criterioDeBusqueda = criterioDeBusqueda;
	}
}
