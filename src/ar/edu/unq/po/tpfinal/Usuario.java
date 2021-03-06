package ar.edu.unq.po.tpfinal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Usuario {

	private List<Muestra> muestrasEnviadas = new ArrayList<Muestra>();
	private List<Opinion> opinionesEnviadas = new ArrayList<Opinion>();

	public List<Muestra> getMuestrasEnviadas() {
		return muestrasEnviadas;
	}

	public void agregarMuestraEnviada(Muestra muestra) {
		this.muestrasEnviadas.add(muestra);
	}

	public List<Opinion> getOpinionesEnviadas() {
		return opinionesEnviadas.stream().filter(o -> o.getMuestraOpinada().getUsuarioRecolectador() != this)
				.collect(Collectors.toList());
	}

	public void agregarOpinionEnviada(Opinion opinion) {
		this.opinionesEnviadas.add(opinion);
	}

	/*
	 * verifica que la especie ingresada es una categoria valida, seguramente haya
	 * una manera mas eficiente de hacer esto pero ahora lo unico que se me ocurre
	 * es asi agrega la muestra cargada a una lista donde estan todas las muestras
	 * que envi?
	 */

	/*
	 * public void cargarMuestra(String especie, Foto foto, Ubicacion
	 * ubicacionActual) { Especies especies = new Especies(); if
	 * (especies.esUnaCategoria(especie)) { this.enviarMuestra(new Muestra(especie,
	 * foto, ubicacionActual, this, LocalDateTime.now())); } else {
	 * System.out.println("la categoria no es valida"); }
	 * 
	 * }
	 * 
	 * public void enviarMuestra(Muestra muestraAEnviar) {
	 * this.agregarMuestraEnviada(muestraAEnviar); }
	 * 
	 * 
	 * 
	 * 
	 * Permite opinar en una muestra siempre y cuando esta no haya sido verificada,
	 * no sea propia del usuario y todavia no haya opinado. tambien se asegura de
	 * que la especie existe
	 */

	/*
	 * 
	 * public void opinarMuestra(Muestra muestraAOpinar, String especie) { Especies
	 * especies = new Especies(); if (this.puedeOpinarEn(muestraAOpinar) &&
	 * especies.esUnaCategoria(especie)) { this.opinar(muestraAOpinar, especie); }
	 * else {
	 * System.out.println("El usuario no puede opinar o la categoria es invalida");
	 * }
	 * 
	 * }
	 * 
	 * 
	 * public void agregarOpinionAMuestraPropia(Muestra muestraAOpinar, String
	 * especie) { Especies especies = new Especies(); if
	 * (especies.getCategorias().contains(especie)) { this.opinar(muestraAOpinar,
	 * especie); } else { System.out.println("la categoria es invalida"); } }
	 */

	public abstract boolean puedeOpinarEn(Muestra muestra);

	public boolean esPropia(Muestra muestra) {
		return this.getMuestrasEnviadas().contains(muestra);
	}

	/*
	 * Verifica que el usuario no este opinando dos veces en la misma muestra
	 */
	public boolean yaOpino(Muestra muestra) {
		return this.getOpinionesEnviadas().stream().anyMatch(o -> o.getMuestraOpinada() == muestra);
	}

	public abstract void setSubioAExperto(boolean subioAExperto);

	public abstract boolean isExperto();

}