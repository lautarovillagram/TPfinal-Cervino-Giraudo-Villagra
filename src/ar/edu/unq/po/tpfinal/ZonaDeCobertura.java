package ar.edu.unq.po.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeCobertura extends ZonaObservable {
	private String nombre;
	private Ubicacion epicentro;
	private double radioEnKm;
	private List<Muestra> muestras;
	private List<Muestra> muestrasVerificadas;
	
	public ZonaDeCobertura(String nombre, Ubicacion epicentro, double radio) {
		this.setNombre(nombre);
		this.setEpicentro(epicentro);
		this.setRadioEnKm(radio);
		this.muestras = new ArrayList<Muestra>();
		this.muestrasVerificadas = new ArrayList<Muestra>();
	}
	
	// Indica si la zona se solapa con la recibida por parametro
	public boolean seSolapaCon(ZonaDeCobertura zona) {
		//La distancia entre sus centros debe ser menor que la suma de sus radios y mayor que su diferencia.
		double distanciaEntreCentros = this.getEpicentro().distanciaHasta(zona.getEpicentro());
		double sumaDeRadios = this.getRadioEnKm() + zona.getRadioEnKm();
		double diferenciaRadios = Math.max(zona.getRadioEnKm(), this.getRadioEnKm()) - Math.min(zona.getRadioEnKm(), this.getRadioEnKm());
		
		return distanciaEntreCentros < sumaDeRadios && distanciaEntreCentros > diferenciaRadios;
	}
	
	// Agrega la muestra a la zona
	// Falta ver que clase es la encargada de llamar a este metodo??
	public void agregarMuestra(Muestra muestra) {
		if (this.perteneceALaZona(muestra)) {
			this.getMuestras().add(muestra);
			// Utilizo un string para indicar que tipo de notificacion se envia
			this.notify(this, muestra, "Nueva Muestra");
		}
		else {
			System.out.println("Esta muestra no fue tomada dentro de esta zona de cobertura");
		}
	}
	
	// Si la muestra esta verificada la agrego a la lista de muestras verificadas y notifico a la organizacion
	// Falta ver que clase es la encargada de llamar a este metodo??
	public void agregarMuestraVerificada(Muestra muestra) {
		if (muestra.estaVerificada()) {
			this.getMuestrasVerificadas().add(muestra);
			this.notify(this, muestra, "Muestra verificada");
		}
	}
	
	// Indica si una muestra pertenece a esta zona
	public boolean perteneceALaZona(Muestra muestra) {
		// Para determinar si la muestra pertenece a la zona, la distancia desde la ubicacion de la muestra 
		// hasta el epicentro debe ser menor o igual que el radio de la zona
		return muestra.getUbicacion().distanciaHasta(this.getEpicentro()) <= this.getRadioEnKm();
	}
	
	// Getters y Setters
	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Ubicacion getEpicentro() {
		return epicentro;
	}

	private void setEpicentro(Ubicacion epicentro) {
		this.epicentro = epicentro;
	}
	
	public double getRadioEnKm() {
		return radioEnKm;
	}
	private void setRadioEnKm(double radioEnKm) {
		this.radioEnKm = radioEnKm;
	}
	
	public List<Muestra> getMuestras() {
		return muestras;
	}
	
	public List<Muestra> getMuestrasVerificadas() {
		return muestrasVerificadas;
	}
}
