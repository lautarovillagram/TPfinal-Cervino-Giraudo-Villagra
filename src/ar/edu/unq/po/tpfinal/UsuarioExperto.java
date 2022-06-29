package ar.edu.unq.po.tpfinal;

import java.time.LocalDateTime;

public class UsuarioExperto extends Usuario {

	/*
	 * 
	 * @Override public void opinar(Muestra muestra, String especie) { // Busco si
	 * hay opiniones de expertos iguales a la mia en la muestra antes de // opinar
	 * if (muestra.opinionesDeExpertos().stream().filter(o ->
	 * o.getEspecie().equals(especie)).count() > 0) { // En caso de que haya, la
	 * muestra queda verificada muestra.setVerificada(true); } // Agrego la nueva
	 * opinion a la muestra y a la lista de opiniones del usuario Opinion opinion =
	 * new Opinion(muestra, this, LocalDateTime.now(), especie);
	 * this.agregarOpinionEnviada(opinion); muestra.agregarOpinion(opinion); }
	 * 
	 */

	@Override
	public boolean puedeOpinarEn(Muestra muestra) {
		return !muestra.estaVerificada() && !this.yaOpino(muestra) && !this.esPropia(muestra);
	}

	@Override
	public void setSubioAExperto(boolean subioAExperto) {
	}

	@Override
	public boolean isExperto() {
		return true;
	}

}
