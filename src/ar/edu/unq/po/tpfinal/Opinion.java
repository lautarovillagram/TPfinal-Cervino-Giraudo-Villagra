package ar.edu.unq.po.tpfinal;

import java.time.LocalDateTime;

public class Opinion {
	private Muestra muestraOpinada;

	public Muestra getMuestraOpinada() {
		return muestraOpinada;
	}

	private Usuario usuarioOpinador;
	private LocalDateTime fecha;

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	private String especie;
	private boolean esOpinionExperta;

	public Opinion(Muestra muestraAOpinar, Usuario usuarioOpinador, LocalDateTime fecha, String especie,
			boolean esOpinionExperta) {
		this.muestraOpinada = muestraAOpinar;
		this.usuarioOpinador = usuarioOpinador;
		this.fecha = fecha;
		this.especie = especie;
		this.esOpinionExperta = esOpinionExperta;
	}

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
		return this.getFecha().isAfter(this.getFecha().minusDays(30));
	}
}
