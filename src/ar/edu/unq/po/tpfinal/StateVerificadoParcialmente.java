package ar.edu.unq.po.tpfinal;

import java.util.List;

public class StateVerificadoParcialmente extends StateVerificacion {

	public StateVerificadoParcialmente() {
		this.setState("Verificado parcialmente");
	}

	@Override
	public String resultadoActual(Muestra muestra) {
		List<Opinion> opiniones = muestra.opinionesDeExpertos();
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
		if (muestra.getVerificador().coincidenDosExpertos(muestra)) {
			muestra.setVerificador(new StateVerificado(this.resultadoActual(muestra)));
		}
		
	}

	@Override
	public boolean hayEmpate(Muestra muestra) {
		// TODO Auto-generated method stub
		return false;
	}
}
