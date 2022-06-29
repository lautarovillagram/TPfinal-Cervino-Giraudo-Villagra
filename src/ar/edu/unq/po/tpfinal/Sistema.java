package ar.edu.unq.po.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Usuario> usuarios = new ArrayList<>();
	private List<Muestra> muestras = new ArrayList<>();
	private List<Opinion> opiniones = new ArrayList<>();
	private List<ZonaDeCobertura> zonasDeCobertura = new ArrayList<>();
	private ActualizadorDeCategoria recategorizador = new ActualizadorDeCategoria();
	private Buscador buscador = new Buscador();

	// Agrega un usuario al Sistema
	public void agregarUsuario(Usuario u) {
		this.getUsuarios().add(u);
	}

	// Agrega una nueva zona de cobertura al sistema
	public void agregarZonaDeCobertura(ZonaDeCobertura z) {
		this.getZonasDeCobertura().add(z);
	}

	// Agrega una muestra al sistema, al buscador y a las zonas que pertenezca
	public void agregarMuestra(Muestra m) {
		this.getMuestras().add(m);
		this.getBuscador().agregarMuestra(m);
		for (ZonaDeCobertura z : this.getZonasDeCobertura()) {
			z.agregarMuestra(m); // agregarMuestra se encarga de comprobar si la muestra pertenece antes de
									// agregarla
		}
	}

	public void agregarOpinion(Opinion o) {
		if (o.getUsuarioOpinador().puedeOpinarEn(o.getMuestraOpinada())) {

			this.getOpiniones().add(o);
		}
	}

	public void setRecategorizador(ActualizadorDeCategoria actualizador) {
		this.recategorizador = actualizador;
	}

	public void recategorizar() {
		this.getUsuarios().stream().forEach(u -> recategorizador.actualizarCategoria(u));
	}

	// Ejecuta la busqueda que recibe por parametro
	public List<Muestra> buscar(Busqueda b) {
		return this.getBuscador().buscar(b);
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

	public List<Opinion> getOpiniones() {
		return opiniones;
	}

	public Buscador getBuscador() {
		return buscador;
	}
}
