package ar.edu.unq.po.tpfinal;

import java.util.List;
import java.util.stream.Collectors;

public class Ubicacion {
	private double latitud;
	private double longitud;
	
	public Ubicacion(double latitud, double longitud) {
		this.setLatitud(latitud);
		this.setLongitud(longitud);
	}
	
	// Devuelve la distancia hasta otra ubicacion
	public double distanciaHasta(Ubicacion u) {
		// Radio de la tierra en kilometros
		final double radio = 6371;
		
		double x = Math.toRadians(this.getLatitud());
		double y = Math.toRadians(this.getLongitud());
		
		double x2 = Math.toRadians(u.getLatitud());
		double y2 = Math.toRadians(u.getLongitud());
		
		//Formula de distancia
		double distancia = radio * Math.acos(Math.sin(x) * Math.sin(x2) + Math.cos(x) * Math.cos(x2) * Math.cos(y - y2));
		return distancia;
	}
	
	// Devuelve las ubicaciones que se encuentren a menos de x kilometros
	public List<Ubicacion> ubicacionesAMenosDeX(List<Ubicacion> u, double kilometros) {
		return u.stream().filter(ubicacion -> ubicacion.distanciaHasta(this) < kilometros).collect(Collectors.toList());
	}
	
	// Getters y Setters
	public double getLatitud() {
		return latitud;
	}
	
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	
	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
}
