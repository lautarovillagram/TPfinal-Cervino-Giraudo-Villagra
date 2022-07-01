package ar.edu.unq.po.tpfinal;

import java.util.List;

public class StateNoVerificado extends StateVerificacion {

	public StateNoVerificado() {
		this.setState("No verificado");
	}

	/*
	 * 
	 * no sirve pero no lo borro por las dudas
	 * 
	 * public String resultadoActual2(Muestra muestra) { List<Opinion> opiniones =
	 * muestra.getOpiniones(); opiniones.sort((o1, o2) -> o1.compareTo(o2,
	 * muestra)); Opinion opinion1 = opiniones.get(0); Opinion opinion2; int
	 * cantidadOpinion1 = 0; int cantidadOpinion2 = 0;
	 * 
	 * for (Opinion opinion : opiniones) { if (opinion == opinion1) {
	 * cantidadOpinion1++; } } List<Opinion> opinionesSinOpinion1 =
	 * opiniones.stream().filter(o -> o.getEspecie() != opinion1.getEspecie())
	 * .toList();
	 * 
	 * if (opinionesSinOpinion1.size() == 0) { return opinion1.getEspecie(); } else
	 * { opinion2 = opinionesSinOpinion1.get(0); for (Opinion opinion :
	 * opinionesSinOpinion1) { if (opinion.getEspecie() == opinion2.getEspecie()) {
	 * cantidadOpinion2++; }
	 * 
	 * } } if (cantidadOpinion1 == cantidadOpinion2) { return "No definido"; } else
	 * { return opinion1.getEspecie(); }
	 * 
	 * }
	 * 
	 * /* resultado actual sin usar mapas
	 */

	public String resultadoActual(Muestra muestra) {
		List<Opinion> opiniones = muestra.getOpiniones();
		this.setOpinionMasRepetida(opiniones.get(0));
		for (Opinion opinion : opiniones) {
			if (this.cantidadDeVecesQueAparece(opinion, opiniones) > this
					.cantidadDeVecesQueAparece(this.getOpinionMasRepetida(), opiniones)) {
				this.setOpinionMasRepetida(opinion);
			}

		}

		List<Opinion> opinionesSinLaMasRepetida = opiniones.stream()
				.filter(o -> o.getEspecie() != this.getOpinionMasRepetida().getEspecie()).toList();
		if (!opinionesSinLaMasRepetida.isEmpty()) {

			this.setOpinionMasRepetida2(opinionesSinLaMasRepetida.get(0));
			for (Opinion opinion : opiniones) {
				if (this.cantidadDeVecesQueAparece(opinion, opinionesSinLaMasRepetida) > this
						.cantidadDeVecesQueAparece(this.getOpinionMasRepetida(), opinionesSinLaMasRepetida)) {
					this.setOpinionMasRepetida2(opinion);
				}

			}
			if (this.hayEmpate(muestra)) {
				return "No definido";
			} else {
				return this.getOpinionMasRepetida().toString();
			}
		} else {
			return this.getOpinionMasRepetida().toString();
		}

	}

	@Override
	public void actualizarVerificacion(Muestra muestra) {
		if (muestra.opinoUnExperto()) {
			muestra.setVerificador(new StateVerificadoParcialmente());
		}
	}

	public void CambiarAVerificadaParcialmente(Muestra muestra) {

		muestra.setVerificador(new StateVerificadoParcialmente());

	}

}
