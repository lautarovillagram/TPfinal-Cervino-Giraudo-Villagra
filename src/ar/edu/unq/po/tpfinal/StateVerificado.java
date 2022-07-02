package ar.edu.unq.po.tpfinal;

public class StateVerificado extends StateVerificacion {

	private String especieDefinitiva;

	public StateVerificado(String especie) {
		this.especieDefinitiva = especie;
	}

	@Override
	public void agregarOpinion(Opinion o) {
		System.out.println("Ningun usuario puede opinar sobre muestras verificadas");
	}

	@Override
	public String resultadoActual() {
		return especieDefinitiva;
	}
	
	@Override
	public boolean estaVerificada() {
		return true;
	}
}
