package ar.edu.unq.po.tpfinal;

import java.util.List;

public abstract class StateVerificacion {

	/*
	 * el state sabe cuales son las dos opiniones con mas votos, ya que es todo lo
	 * que necesita para determinar si el resultado es no definido o es uno en
	 * particular
	 */
	private Opinion opinionMasRepetida;
	private Opinion opinionMasRepetida2;
	public String state;

	public Opinion getOpinionMasRepetida() {
		return this.opinionMasRepetida;
	}

	public Opinion getOpinionMasRepetida2() {
		return this.opinionMasRepetida2;
	}

	public void setOpinionMasRepetida(Opinion opinion) {
		this.opinionMasRepetida = opinion;
	}

	public void setOpinionMasRepetida2(Opinion opinion) {
		this.opinionMasRepetida2 = opinion;
	}

	public String getState() {
		return state;
	}

	public void setState(String estado) {
		this.state = estado;
	}

	/*
	 * retorna un String con el resultado actual de la muestra, cada state tiene un
	 * comportamiento diferente
	 */

	public abstract String resultadoActual(Muestra muestra);

	/*
	 * se utiliza para verificar la muestra cada vez que hay una opinion y cambia el
	 * state segun corresponda
	 */

	public abstract void actualizarVerificacion(Muestra muestra);

	/*
	 * retorna la cantidad de repeticiones que tiene cierta opinion en una lista
	 * dada
	 */

	public int cantidadDeVecesQueAparece(Opinion opinion, List<Opinion> list) {
		return list.stream().filter(o -> o.getEspecie() == opinion.getEspecie()).toList().size();
	}

	public boolean hayEmpate(Muestra muestra) {
		return muestra.getOpiniones().stream().filter(o -> this.getOpinionMasRepetida().getEspecie() == o.getEspecie())
				.toList().size() == muestra.getOpiniones().stream()
						.filter(o -> this.getOpinionMasRepetida2().getEspecie() == o.getEspecie()).toList().size();
	}

	/*
	 * retorna si dos expertos comparten una misma opinion en la muestra dada
	 */

	public boolean coincidenDosExpertos(Muestra muestra) {
		List<Opinion> opiniones = muestra.opinionesDeExpertos();
		if (!opiniones.isEmpty()) {
			this.setOpinionMasRepetida(opiniones.get(0));
			for (Opinion opinion : opiniones) {
				if (this.cantidadDeVecesQueAparece(opinion, opiniones) > this
						.cantidadDeVecesQueAparece(this.getOpinionMasRepetida(), opiniones)) {
					this.setOpinionMasRepetida(opinion);
				}

			}
			if (this.cantidadDeVecesQueAparece(this.getOpinionMasRepetida(), opiniones) == 2) {
				return true;

			} else {
				return false;
			}
		} else {
			return false;
		}

	}
}
