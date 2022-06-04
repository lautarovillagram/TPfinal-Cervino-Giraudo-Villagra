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

	public List<Muestra> muestrasEnviadasLosUltimos30Dias() {
		return this.getObservable().getMuestrasEnviadas().stream().filter(m -> m.tieneMenosDe30Dias()).toList();
	}

	public List<Opinion> opinionesEnviadasLosUltimos30Dias() {
		return this.getObservable().getMuestrasOpinadas().stream().filter(m -> m.tieneMenosDe30Dias()).toList();
	}

	public void actualizar() {

		if (this.muestrasEnviadasLosUltimos30Dias().size() > 10
				&& this.opinionesEnviadasLosUltimos30Dias().size() > 20) {
			this.getObservable().setSubioAExperto(true);

		} else {
			this.getObservable().setSubioAExperto(false);
		}
	}

}
