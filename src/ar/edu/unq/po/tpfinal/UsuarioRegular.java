package ar.edu.unq.po.tpfinal;

import java.time.LocalDateTime;

public class UsuarioRegular extends Usuario implements Observable {
	private ActualizadorDeCategoria observador;
	private boolean subioAExperto = false;

	public ActualizadorDeCategoria getObservador() {
		return observador;
	}

	public void setObservador(ActualizadorDeCategoria observer) {
		this.observador = observer;
	}

	public boolean isSubioAExperto() {
		return subioAExperto;
	}

	public void setSubioAExperto(boolean subioAExperto) {
		this.subioAExperto = subioAExperto;
	}

	@Override
	public void opinar(Muestra muestra, String especie) {

		Opinion opinion = new Opinion(muestra, this, LocalDateTime.now(), especie, this.isSubioAExperto());
		this.agregarOpinionEnviada(opinion);
		muestra.agregarOpinion(opinion);
		this.notificar();

	}

	@Override
	public void enviarMuestra(Muestra muestraAEnviar) {
		this.agregarMuestraEnviada(muestraAEnviar);
		this.notificar();

	}

	public void notificar() {
		this.getObservador().actualizar();

	}

	/*
	 * verifica que, en caso de ser experto, la muestra no este verificada, el
	 * usuario no haya opinado sobre la misma, y que no sea propia en caso de no ser
	 * experto, verifica que la muestra no haya sido opinada por un experto, que no
	 * haya opinado sobre la misma, y que no sea propia
	 */
	@Override
	public boolean puedeOpinarEn(Muestra muestra) {
		if (this.subioAExperto) {
			return !muestra.estaVerificada() && !this.yaOpino(muestra) && !this.esPropia(muestra);
		} else {
			return !muestra.opinoUnExperto() && !this.yaOpino(muestra) && !this.esPropia(muestra);
		}
	}

}
