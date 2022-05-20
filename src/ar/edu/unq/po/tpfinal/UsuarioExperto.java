package ar.edu.unq.po.tpfinal;

public class UsuarioExperto extends Usuario {

	@Override
	public void opinar(Muestra muestra, String especie) {
		muestra.AgregarOpinionExperta(especie);
	}

	@Override
	public boolean puedeOpinarEn(Muestra muestra) {
		return !muestra.estaVerificada();
	}

}
