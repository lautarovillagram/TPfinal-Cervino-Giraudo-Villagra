package ar.edu.unq.po.tpfinal;

import java.util.List;

public class ActualizadorDeCategoria implements Observer {
	private UsuarioRegular observable;

	public UsuarioRegular getObservable() {
		return observable;
	}

	public void setObservable(UsuarioRegular observable) {
		this.observable = observable;
	}

	/*
	 * verifica la cantidad de muestras enviadas y opiniones enviadas, si 10
	 * muestras y 20 opiniones fueron enviadas en menos de 30 dias, cambia la
	 * categoria de usuario regular a experto
	 */

	public void actualizar() {
		List<Muestra> muestrasEnviadasLosUltimos30Dias = this.getObservable().getMuestrasEnviadas().stream()
				.filter(s -> s.tieneMenosDe30Dias()).toList();
		List<Opinion> opinionesEnviadasLosUltimos30Dias = this.getObservable().getMuestrasOpinadas().stream()
				.filter(s -> s.tieneMenosDe30Dias()).toList();
		if (muestrasEnviadasLosUltimos30Dias.size() > 10 && opinionesEnviadasLosUltimos30Dias.size() > 20) {
			this.getObservable().setSubioAExperto(true);

		} else {
			this.getObservable().setSubioAExperto(false);
		}
	}

}
