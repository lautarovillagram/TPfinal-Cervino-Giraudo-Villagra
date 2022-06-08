package ar.edu.unq.po.tpfinal;

import java.util.ArrayList;
import java.util.List;

public abstract class ZonaObservable {
	private List<OrganizacionObserver> observadores = new ArrayList<>();
	
	
	public void addObserver(OrganizacionObserver observer) {
		this.getObservadores().add(observer);
	}

	public void deleteObserver(OrganizacionObserver observer) {
		this.getObservadores().remove(observer);
	}
	
	// Notifica a todos los observadores segun el codigo que recibe por parametro
	public void notify(ZonaObservable z, Muestra muestra, String codigo) {
		switch(codigo) {
		case "Nueva Muestra":
			for(OrganizacionObserver o: this.getObservadores()) {
				o.updateNuevaMuestra(z, muestra);
			}
			break;
		case "Muestra verificada":
			for(OrganizacionObserver o: this.getObservadores()) {
				o.updateMuestraVerificada(z, muestra);
			}
			break;
		}
	}
	// Getters y Setters
	public List<OrganizacionObserver> getObservadores() {
		return observadores;
	}
}
