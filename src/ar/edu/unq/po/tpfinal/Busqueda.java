package ar.edu.unq.po.tpfinal;

import java.util.List;

public abstract class Busqueda {
	private List<Muestra> muestras;
	
	public Busqueda(List<Muestra> muestras) {
		this.setMuestras(muestras);
	}
	
	public abstract List<Muestra> buscar();
	
	// Getter y Setters
	public List<Muestra> getMuestras() {
		return muestras;
	}

	public void setMuestras(List<Muestra> muestras) {
		this.muestras = muestras;
	}
}
