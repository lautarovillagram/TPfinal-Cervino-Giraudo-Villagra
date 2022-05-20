package ar.edu.unq.po.tpfinal;

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
		if (this.isSubioAExperto()) {
			muestra.AgregarOpinionExperta(especie); 
		} else {
			muestra.agregarOpinionRegular(especie);
		}
	}

}
