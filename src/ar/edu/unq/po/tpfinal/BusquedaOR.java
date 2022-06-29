package ar.edu.unq.po.tpfinal;

import java.util.List;

public class BusquedaOR extends Busqueda {
	private Busqueda operando1;
	private Busqueda operando2;
	
	public BusquedaOR(Busqueda op1, Busqueda op2, List<Muestra> muestras) {
		super(muestras);
		this.setOperando1(op1);
		this.setOperando2(op2);
	}

	@Override
	public List<Muestra> buscar() {
		// Si es un OR tengo que combinar ambas listas sin repetidos
		List<Muestra> resultado = this.operando1.buscar();
		List<Muestra> filtro2 = this.operando2.buscar();
		
		for(Muestra m: filtro2) {
			if (! resultado.contains(m)) { 
				resultado.add(m);
			}
		}
		return resultado;
	}

	
	// Getters y Setters
	public void setOperando1(Busqueda operando1) {
		this.operando1 = operando1;
	}
	
	public void setOperando2(Busqueda operando2) {
		this.operando2 = operando2;
	}

}
