package ar.edu.unq.po.tpfinal;

public class UsuarioRegular extends Usuario {

	private boolean subioAExperto = false;

	public boolean isExperto() {
		return subioAExperto;
	}

	@Override
	public void setSubioAExperto(boolean subioAExperto) {
		this.subioAExperto = subioAExperto;
	}

	/*
	 * @Override public void enviarMuestra(Muestra muestraAEnviar) {
	 * this.agregarMuestraEnviada(muestraAEnviar);
	 * 
	 * }
	 * 
	 */

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