package ar.edu.unq.po.tpfinal;

import java.util.Collections;
import java.util.Map;

public class StateNoVerificado extends StateVerificacion {
	public StateNoVerificado(Muestra context) {
		this.setContext(context);
	}

	@Override
	public void agregarOpinion(Opinion o) {
		if(o.getUsuarioOpinador().isExperto()) {
			this.getContext().getOpiniones().add(o);
			this.getContext().agregarOcurrenciaEspecieExpertos(o.getEspecie());
			this.getContext().setVerificador(new StateVerificadoParcialmente(this.getContext()));	
		}
		else {
			this.getContext().getOpiniones().add(o);
			this.getContext().agregarOcurrenciaEspecie(o.getEspecie());
		}
	}

	@Override
	public String resultadoActual() {
		if (this.hayEmpate(this.getContext().getEspeciesXCant())) {
			return "No definido";
		} else {
			// Obtengo la entrada del map con el numero mas grande de votos
			Map.Entry<String, Integer> me = Collections.max(this.getContext().getEspeciesXCant().entrySet(), Map.Entry.comparingByValue());
			return me.getKey();
		}
	}
}