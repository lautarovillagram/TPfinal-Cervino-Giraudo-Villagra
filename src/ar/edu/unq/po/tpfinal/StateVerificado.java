package ar.edu.unq.po.tpfinal;

public class StateVerificado extends StateVerificacion {

	private String especieDefinitiva;

	public StateVerificado(String especie) {
		this.state = "Verificada";
		this.especieDefinitiva = especie;
	}

	public String getState() {
		return this.state;
	}

	@Override
	public String resultadoActual(Muestra muestra) {
		return especieDefinitiva;
	}

	@Override
	public boolean hayEmpate(Muestra muestra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void actualizarVerificacion(Muestra muestra) {
		// TODO Auto-generated method stub

	}

}
