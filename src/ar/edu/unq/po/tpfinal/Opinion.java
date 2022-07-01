package ar.edu.unq.po.tpfinal;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Opinion {
	private Muestra muestraOpinada;

	private Usuario usuarioOpinador;
	private LocalDateTime fecha;
	private String especie;
	private boolean esOpinionExperta;

	public Muestra getMuestraOpinada() {
		return muestraOpinada;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuarioOpinador() {
		return usuarioOpinador;
	}

	/*
	 * constructor para la opinion de los usuarios regulares
	 */
	public Opinion(Muestra muestraAOpinar, Usuario usuarioOpinador, LocalDateTime fecha, String tipo) {
		this.muestraOpinada = muestraAOpinar;
		this.usuarioOpinador = usuarioOpinador;
		this.setFecha(fecha);
		this.especie = tipo;
		this.setEsOpinionExperta(usuarioOpinador.isExperto());
	}

	/*
	 * constructor para la opinion de los usuarios expertos
	 */

	/*
	 * public Opinion(Muestra muestraAOpinar, Usuario usuarioOpinador, LocalDateTime
	 * fecha, String tipo) { this.muestraOpinada = muestraAOpinar;
	 * this.usuarioOpinador = usuarioOpinador; this.fecha = fecha; this.especie =
	 * tipo; this.setEsOpinionExperta(true); }
	 */

	public boolean esOpinionExperta() {
		return esOpinionExperta;
	}

	public void setEsOpinionExperta(boolean esOpinionExperta) {
		this.esOpinionExperta = esOpinionExperta;
	}

	public String getEspecie() {
		return this.especie;
	}

	public boolean tieneMenosDe30Dias() {
		return this.getFecha().isAfter(LocalDateTime.now().minusDays(30));
	}

	public boolean esOpinionValida() {
		return !(this.getUsuarioOpinador().puedeOpinarEn(muestraOpinada));
	}

	public String toString() {
		return this.getEspecie();
	}

}
