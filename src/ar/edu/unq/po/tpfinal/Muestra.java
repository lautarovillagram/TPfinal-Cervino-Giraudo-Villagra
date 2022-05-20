package ar.edu.unq.po.tpfinal;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Muestra {
	private String especie;
	private Foto foto;
	private Ubicacion ubicacion;
	private Usuario usuarioRecolectador;
	private List<String> opinionesRegulares = new ArrayList<String>();
	private List<String> opinionesExpertas = new ArrayList<String>();
	private LocalDateTime fecha;

	public List<String> getOpinionesRegulares() {
		return opinionesRegulares;
	}

	public void setOpinionesRegulares(List<String> opinionesRegulares) {
		this.opinionesRegulares = opinionesRegulares;
	}

	public List<String> getOpinionesExpertas() {
		return opinionesExpertas;
	}

	public void setOpinionesExpertas(List<String> opinionesExpertas) {
		this.opinionesExpertas = opinionesExpertas;
	}

	public Muestra(String especie, Foto foto, Ubicacion ubicacion, Usuario usuarioRecolectador, Time fecha) {
		super();
		this.especie = especie;
		this.foto = foto;
		this.ubicacion = ubicacion;
		this.usuarioRecolectador = usuarioRecolectador;
		this.fecha = LocalDateTime.now();

	}

	public boolean estaVerificada() {
		return this.getOpinionesExpertas().size() >= 2;
	}

}
