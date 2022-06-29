package ar.edu.unq.po.tpfinal;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BusquedaPorFechaDeCreacion extends Busqueda{
	private LocalDateTime criterioDeBusqueda;
	
	public BusquedaPorFechaDeCreacion(LocalDateTime criterio, List<Muestra> muestras) {
		super(muestras);
		this.setCriterioDeBusqueda(criterio);
	}
	
	@Override
	public List<Muestra> buscar() {
		return this.getMuestras().stream().filter(m -> m.getFecha().equals(this.getCriterioDeBusqueda())).collect(Collectors.toList());
	}
	
	// Getter y Setter
	public LocalDateTime getCriterioDeBusqueda() {
		return criterioDeBusqueda;
	}

	public void setCriterioDeBusqueda(LocalDateTime criterioDeBusqueda) {
		this.criterioDeBusqueda = criterioDeBusqueda;
	}
}
