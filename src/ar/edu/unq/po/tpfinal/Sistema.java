package ar.edu.unq.po.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Usuario> usuarios = new ArrayList<>();
	private List<Muestra> muestras = new ArrayList<>();
	private List<ZonaDeCobertura> zonasDeCobertura = new ArrayList<>();
	private Buscador buscador;
	
	public Sistema() {
		this.setBuscador(new Buscador(this.getMuestras()));
	}
	
	// Agrega un usuario al Sistema
	public void agregarUsuario(Usuario u) {
		this.getUsuarios().add(u);
	}
	
	// Agrega una nueva zona de cobertura al sistema
	public void agregarZonaDeCobertura(ZonaDeCobertura z) {
		this.getZonasDeCobertura().add(z);
	}
	
	// Agrega una muestra al sistema y a las zonas que pertenezca
	public void agregarMuestra(Muestra m) {
		this.getMuestras().add(m);
		for(ZonaDeCobertura z: this.getZonasDeCobertura()) {
			z.agregarMuestra(m); // agregarMuestra se encarga de comprobar si la muestra pertenece antes de agregarla
		}
	}

	
	// Getters y Setters
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public List<Muestra> getMuestras() {
		return muestras;
	}
	
	public List<ZonaDeCobertura> getZonasDeCobertura() {
		return zonasDeCobertura;
	}

	public Buscador getBuscador() {
		return buscador;
	}
	private void setBuscador(Buscador b) {
		this.buscador = b;
	}
}
