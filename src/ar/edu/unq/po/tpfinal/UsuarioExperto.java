package ar.edu.unq.po.tpfinal;

import java.time.LocalDateTime;

public class UsuarioExperto extends Usuario {

	@Override
	public void opinar(Muestra muestra, String especie) {

		Opinion opinion = new Opinion(muestra, this, LocalDateTime.now(), especie, true);
		this.agregarOpinionEnviada(opinion);
		muestra.agregarOpinion(opinion);

	}

	@Override
	public boolean puedeOpinarEn(Muestra muestra) {
		return !muestra.estaVerificada() && !this.yaOpino(muestra) && !this.esPropia(muestra);
	}
}
