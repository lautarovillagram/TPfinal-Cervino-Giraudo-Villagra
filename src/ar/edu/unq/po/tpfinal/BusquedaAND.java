package ar.edu.unq.po.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class BusquedaAND extends Busqueda {
	private Busqueda operando1;
	private Busqueda operando2;
	
	public BusquedaAND(Busqueda op1, Busqueda op2, List<Muestra> muestras) {
		super(muestras);
		this.setOperando1(op1);
		this.setOperando2(op2);
	}
	
	@Override
	public List<Muestra> buscar() {
		// Si es un AND tengo que crear una lista con solo los elementos que se repitan en ambas listas
		List<Muestra> resultado = new ArrayList<>();
		
		List<Muestra> filtro1 = this.operando1.buscar();
		List<Muestra> filtro2 = this.operando2.buscar();
		
		for(Muestra m: filtro1) {
			if (filtro2.contains(m)) {
				resultado.add(m);
			}
		}
		return resultado;
	}
	
	// Getters y Setters
	public void setOperando1(Busqueda op1) {
		this.operando1 = op1;
	}
	
	public void setOperando2(Busqueda op2) {
		this.operando2 = op2;
	}
}
