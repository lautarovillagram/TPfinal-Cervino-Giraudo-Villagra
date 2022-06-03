package ar.edu.unq.po.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeCobertura {
	private String nombre;
	private Ubicacion epicentro;
	private double radioEnKm;
	private List<Muestra> muestras;
	
	public ZonaDeCobertura(String nombre, Ubicacion epicentro, double radio) {
		this.setNombre(nombre);
		this.setEpicentro(epicentro);
		this.setRadioEnKm(radio);
		this.muestras = new ArrayList<Muestra>();
	}
	
	// Indica si la zona se solapa con la recibida por parametro
	public boolean seSolapaCon(ZonaDeCobertura zona) {
		//La distancia entre sus centros debe ser menor que la suma de sus radios y mayor que su diferencia.
		double distanciaEntreCentros = this.getEpicentro().distanciaHasta(zona.getEpicentro());
		double sumaDeRadios = this.getRadioEnKm() + zona.getRadioEnKm();
		double diferenciaRadios = Math.max(zona.getRadioEnKm(), this.getRadioEnKm()) - Math.min(zona.getRadioEnKm(), this.getRadioEnKm());
		
		return distanciaEntreCentros < sumaDeRadios && distanciaEntreCentros > diferenciaRadios;
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
}
