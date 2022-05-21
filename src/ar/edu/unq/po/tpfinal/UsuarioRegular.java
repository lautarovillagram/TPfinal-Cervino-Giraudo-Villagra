package ar.edu.unq.po.tpfinal;

import java.time.LocalDateTime;

public class UsuarioRegular extends Usuario {

	private boolean subioAExperto = false;

	public boolean isSubioAExperto() {
		return subioAExperto;
	}

	public void setSubioAExperto(boolean subioAExperto) {
		this.subioAExperto = subioAExperto;
	}

	@Override
	public void opinar(Muestra muestra, String especie) {
		Opinion opinion = new Opinion(muestra, this, LocalDateTime.now(), especie, this.isSubioAExperto());
		if (this.puedeOpinarEn(muestra)) {
			this.agregarOpinionEnviada(opinion);
			muestra.agregarOpinion(opinion);
		} else {

		}
	}

	@Override
	public boolean puedeOpinarEn(Muestra muestra) {
		if (this.subioAExperto) {
			return !muestra.estaVerificada();
		} else {
			return !(this.esPropia(muestra) || this.yaOpino(muestra));
		}
	}

}
