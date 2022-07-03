package ar.edu.unq.po.tpfinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StateVerificadoParcialmente extends StateVerificacion {
	
	public StateVerificadoParcialmente(Muestra context) {
		this.setContext(context);
	}

	@Override
	public void agregarOpinion(Opinion o) {
		if (o.getUsuarioOpinador().isExperto() && coincideConAlguna(o.getEspecie())) {
			this.getContext().getOpiniones().add(o);
			this.getContext().agregarOcurrenciaEspecieExpertos(o.getEspecie());
			this.getContext().setVerificador(new StateVerificado(o.getEspecie()));
		}
		else if (o.getUsuarioOpinador().isExperto() ) {
			this.getContext().getOpiniones().add(o);
			this.getContext().agregarOcurrenciaEspecieExpertos(o.getEspecie());
		}
		else {
			//No se agrega la opinion si no es de experto
			System.out.println("Solo pueden opinar usuarios expertos");
		}
	}
	
	// Indica si alguna de las opiniones de expertos de la muestra coincide con la especie dada por parametro
	private boolean coincideConAlguna(String especie) {
		List<String> especiesOpinionesExpertos = new ArrayList<>();
		for (Opinion o: this.getContext().opinionesDeExpertos()) {
			especiesOpinionesExpertos.add(o.getEspecie());
		}
		return especiesOpinionesExpertos.stream().anyMatch(e -> e.equals(especie));
	}
	
	@Override
	public String resultadoActual() {
		if (this.hayEmpate(this.getContext().getEspeciesXCantExpertos())) {
			return "No definido";
		} else {
			// Obtengo la entrada del map con el numero mas grande de votos
			Map.Entry<String, Integer> me = Collections.max(this.getContext().getEspeciesXCantExpertos().entrySet(), Map.Entry.comparingByValue());
			return me.getKey();
		}
	}
}
