package ar.edu.unq.po.tpfinal;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Muestra {
	private String especie;
	private Foto foto;
	private Ubicacion ubicacion;
	private Usuario usuarioRecolectador;
	private List<Opinion> opiniones = new ArrayList<Opinion>();
	// private List<String> opinionesExpertas = new ArrayList<String>();
	private LocalDateTime fecha;

	public List<Opinion> getOpiniones() {
		return opiniones;
	}

	public void agregarOpinion(Opinion opinion) {
		this.opiniones.add(opinion);
	}

	/*
	 * public List<String> getOpinionesExpertas() { return opinionesExpertas; }
	 * 
	 * public void AgregarOpinionExperta(String opinion) {
	 * this.opinionesExpertas.add(opinion); }
	 * 
	 */

	public Muestra(String especie, Foto foto, Ubicacion ubicacion, Usuario usuarioRecolectador, Time fecha) {
		super();
		this.especie = especie;
		this.foto = foto;
		this.ubicacion = ubicacion;
		this.usuarioRecolectador = usuarioRecolectador;
		this.fecha = LocalDateTime.now();

	}

	public boolean estaVerificada() {
		// TODO
		return false;
	}

	public boolean opinoUnExperto() {
		return this.opinionesDeExpertos().size() >= 1;

	}

	public List<Opinion> opinionesDeExpertos() {
		return this.getOpiniones().stream().filter(o -> o.esOpinionExperta()).toList();
	}

}
