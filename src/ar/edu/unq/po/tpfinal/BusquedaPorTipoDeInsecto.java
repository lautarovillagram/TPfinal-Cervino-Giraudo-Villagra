package ar.edu.unq.po.tpfinal;

import java.util.List;
import java.util.stream.Collectors;

public class BusquedaPorTipoDeInsecto extends Busqueda{
	private String criterioDeBusqueda;
	
	public BusquedaPorTipoDeInsecto(String criterio, List<Muestra> muestras) {
		super(muestras);
		this.setCriterioDeBusqueda(criterio);
	}
	
	@Override
	public List<Muestra> buscar() {
		return this.getMuestras().stream().filter(m -> m.resultadoActual().equals(this.getCriterioDeBusqueda())).collect(Collectors.toList());
	}
	
	// Getters y setters
	public String getCriterioDeBusqueda() {
		return criterioDeBusqueda;
	}
	public void setCriterioDeBusqueda(String c) {
		this.criterioDeBusqueda = c;
	}
}
