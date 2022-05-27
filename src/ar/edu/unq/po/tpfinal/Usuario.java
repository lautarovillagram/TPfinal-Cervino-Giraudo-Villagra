package ar.edu.unq.po.tpfinal;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {

	private List<Muestra> muestrasEnviadas = new ArrayList<Muestra>();
	private List<Opinion> opinionesEnviadas = new ArrayList<Opinion>();

	public List<Muestra> getMuestrasEnviadas() {
		return muestrasEnviadas;
	}

	public void agregarMuestraEnviada(Muestra muestra) {
		this.muestrasEnviadas.add(muestra);
	}

	public List<Opinion> getMuestrasOpinadas() {
		return opinionesEnviadas;
	}

	public void agregarOpinionEnviada(Opinion opinion) {
		this.opinionesEnviadas.add(opinion);
	}

	//creo que esto no va a servir para nada pero por las dudas lo dejamos aca
	public void enviarMuestra(Muestra muestraAEnviar) {
		// TODO
	}

	/*
	 * Permite opinar en una muestra siempre y cuando esta no haya sido verificada,
	 * no sea propia del usuario y todavia no haya opinado
	 */

	public void opinarMuestra(Muestra muestraAOpinar, String especie) {
		if (this.puedeOpinarEn(muestraAOpinar)) {
			this.opinar(muestraAOpinar, especie);
		}

	}

	
	public abstract void opinar(Muestra muestra, String especie);

	public abstract boolean puedeOpinarEn(Muestra muestra);

	public boolean esPropia(Muestra muestra) {
		return this.getMuestrasEnviadas().contains(muestra);
	}

	/*
	 * Verifica que el usuario no este opinando dos veces en la misma muestra
	 */
	public boolean yaOpino(Muestra muestra) {
		return this.getMuestrasOpinadas().stream().anyMatch(o -> o.getMuestraOpinada() == muestra);
	}

}
