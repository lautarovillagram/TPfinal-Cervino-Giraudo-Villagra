package ar.edu.unq.po.tpfinal;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Opinion implements Comparable<Opinion> {
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

	@Override
	public int compareTo(Opinion o) {

		int compareInt = this.getEspecie().compareTo(o.getEspecie());
		if (compareInt < 0)
			return -1;
		if (compareInt > 0)
			return 1;
		return 0;

	}

	public int compareTo(Opinion o, Muestra m) {
		List<Opinion> cantidad = m.getOpiniones().stream().filter(op -> op.getEspecie() == this.getEspecie())
				.collect(Collectors.toList());
		List<Opinion> cantidad2 = m.getOpiniones().stream().filter(op -> op.getEspecie() == o.getEspecie())
				.collect(Collectors.toList());
		if (cantidad.size() < cantidad2.size() && this.getEspecie() != o.getEspecie())
			return -1;

		if (cantidad.size() > cantidad2.size() && this.getEspecie() != o.getEspecie())
			return 1;

		return 0;
	}

	public String toString() {
		return this.getEspecie();
	}

}
