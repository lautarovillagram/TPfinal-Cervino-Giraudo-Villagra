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
			this.agregarOcurrenciaEspecieExpertos(o.getEspecie());
			this.getContext().setVerificador(new StateVerificadoParcialmente(this.getContext()));	
		}
		else {
			this.getContext().getOpiniones().add(o);
			this.agregarOcurrenciaEspecie(o.getEspecie());
		}
	}

	@Override
	public String resultadoActual() {
		if (this.hayEmpate(this.getEspeciesXCant())) {
			return "No definido";
		} else {
			// Obtengo la entrada del map con el numero mas grande de votos
			Map.Entry<String, Integer> me = Collections.max(this.getEspeciesXCant().entrySet(), Map.Entry.comparingByValue());
			return me.getKey();
		}
	}
}