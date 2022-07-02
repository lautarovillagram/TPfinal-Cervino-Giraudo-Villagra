package ar.edu.unq.po.tpfinal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Muestra {
	private String especie;
	private Foto foto;
	private Ubicacion ubicacion;
	private Usuario usuarioRecolectador;
	private LocalDateTime fecha;
	private List<Opinion> opiniones = new ArrayList<Opinion>();
	// private List<String> opinionesExpertas = new ArrayList<String>();
	private StateVerificacion verificador;

	public Usuario getUsuarioRecolectador() {
		return usuarioRecolectador;
	}

	public String getEspecie() {
		return especie;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public List<Opinion> getOpiniones() {
		return opiniones;
	}

	public void agregarOpinion(Opinion opinion) {
		this.getVerificador().agregarOpinion(opinion);
	}

	/*
	 * public List<String> getOpinionesExpertas() { return opinionesExpertas; }
	 * 
	 * public void AgregarOpinionExperta(String opinion) {
	 * this.opinionesExpertas.add(opinion); }
	 * 
	 */

	public Muestra(String especie, Foto foto, Ubicacion ubicacion, Usuario usuarioRecolectador, LocalDateTime fecha) {

		super();
		this.especie = especie;
		this.foto = foto;
		this.ubicacion = ubicacion;
		this.usuarioRecolectador = usuarioRecolectador;
		this.fecha = fecha;
		if (usuarioRecolectador.isExperto()) {
			this.setVerificador(new StateVerificadoParcialmente(this));

		} else {
			this.setVerificador(new StateNoVerificado(this));

		}

		// La opinion del usuario recolectador tambien debe tenerse en cuenta
		// this.getUsuarioRecolectador().agregarOpinionAMuestraPropia(this,
		// this.especie);
		// this.agregarOpinion(new Opinion(this, this.usuarioRecolectador, this.fecha,
		// this.especie));

	}

	// Indica si al menos 2 usuarios expertos tienen la misma opinion
	public boolean estaVerificada() {
		return getVerificador().estaVerificada();
	}

	public StateVerificacion getVerificador() {
		return this.verificador;
	}

	public void setVerificador(StateVerificacion nuevoEstadoDeVerificacion) {
		this.verificador = nuevoEstadoDeVerificacion;
	}

	public boolean opinoUnExperto() {
		return this.opinionesDeExpertos().size() >= 1;

	}

	public List<Opinion> opinionesDeExpertos() {
		return this.getOpiniones().stream().filter(o -> o.esOpinionExperta()).collect(Collectors.toList());
	}

	public String resultadoActual() {
		return this.getVerificador().resultadoActual();
	}

	public boolean tieneMenosDe30Dias() {
		return this.getFecha().isAfter(LocalDateTime.now().minusDays(30));
	}

	public LocalDateTime getFechaUltimaVotacion() {
		return this.getOpiniones().stream().max(Comparator.comparing(Opinion::getFecha)).get().getFecha();
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}
}