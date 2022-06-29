package ar.edu.unq.po.tpfinal;

import java.util.List;
import java.util.stream.Collectors;

public class ActualizadorDeCategoria {

	/*
	 * verifica la cantidad de muestras enviadas y opiniones enviadas, si 10
	 * muestras y 20 opiniones fueron enviadas en menos de 30 dias, cambia la
	 * categoria de usuario regular a experto
	 */

	public List<Muestra> muestrasEnviadasLosUltimos30Dias(Usuario usuario) {
		return usuario.getMuestrasEnviadas().stream().filter(m -> m.tieneMenosDe30Dias()).collect(Collectors.toList());
	}

	public List<Opinion> opinionesEnviadasLosUltimos30Dias(Usuario usuario) {
		return usuario.getOpinionesEnviadas().stream().filter(o -> o.tieneMenosDe30Dias()).collect(Collectors.toList());
	}

	public void actualizarCategoria(Usuario usuario) {

		if (this.muestrasEnviadasLosUltimos30Dias(usuario).size() > 10
				&& this.opinionesEnviadasLosUltimos30Dias(usuario).size() > 20) {
			usuario.setSubioAExperto(true);

		} else {
			usuario.setSubioAExperto(false);
		}
	}

}