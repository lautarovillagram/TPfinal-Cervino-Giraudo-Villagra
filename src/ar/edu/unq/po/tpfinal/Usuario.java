package ar.edu.unq.po.tpfinal;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private List<Muestra> muestrasEnviadas = new ArrayList<Muestra>();
	private List<Muestra> muestrasOpinadas = new ArrayList<Muestra>();

	public List<Muestra> getMuestrasEnviadas() {
		return muestrasEnviadas;
	}

	public void setMuestrasEnviadas(List<Muestra> muestrasEnviadas) {
		this.muestrasEnviadas = muestrasEnviadas;
	}

	public List<Muestra> getMuestrasOpinadas() {
		return muestrasOpinadas;
	}

	public void setMuestrasOpinadas(List<Muestra> muestrasOpinadas) {
		this.muestrasOpinadas = muestrasOpinadas;
	}

	public void enviarMuestra(Muestra muestraAEnviar) {
		// TODO
	}

	/*
	 * Permite opinar en una muestra siempre y cuando esta no haya sido verificada,
	 * no sea propia del usuario y todavia no haya opinado
	 */

	public void opinarMuestra(Muestra muestraAOpinar, String especie) {
		if (!muestraAOpinar.estaVerificada() && !this.esPropia(muestraAOpinar) && !this.yaOpino(muestraAOpinar)) {

		} else {

		}

	}

	public boolean esPropia(Muestra muestra) {
		return this.getMuestrasEnviadas().contains(muestra);
	}

	public boolean yaOpino(Muestra muestra) {
		return this.getMuestrasOpinadas().contains(muestra);
	}
}
