package ar.edu.unq.po.tpfinal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Muestra {
	private String especie;
	private Foto foto;
	private Ubicacion ubicacion;
	private Usuario usuarioRecolectador;
	public Usuario getUsuarioRecolectador() {
		return usuarioRecolectador;
	}

	private List<Opinion> opiniones = new ArrayList<Opinion>();
	// private List<String> opinionesExpertas = new ArrayList<String>();
	private LocalDateTime fecha;

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public List<Opinion> getOpiniones() {
		return opiniones;
	}

	public void agregarOpinion(Opinion opinion) {
		this.opiniones.add(opinion);
	}

	/*
	 * public List<String> getOpinionesExpertas() { return opinionesExpertas; }
	 * 
	 * public void AgregarOpinionExperta(String opinion) {
	 * this.opinionesExpertas.add(opinion); }
	 * 
	 */

	public Muestra(String especie, Foto foto, Ubicacion ubicacion, Usuario usuarioRecolectador, LocalDateTime fecha) {

		super();
		this.especie = especie;
		this.foto = foto;
		this.ubicacion = ubicacion;
		this.usuarioRecolectador = usuarioRecolectador;
		this.fecha = LocalDateTime.now();

		// La opinion del usuario recolectador tambien debe tenerse en cuenta
		this.getUsuarioRecolectador().agregarOpinionAMuestraPropia(this, especie);
		// this.agregarOpinion(new Opinion(this, this.usuarioRecolectador, this.fecha,
		// this.especie, this.usuarioRecolectador.esExperto()));
	}

	// Indica si al menos 2 usuarios expertos tienen la misma opinion
	public boolean estaVerificada() {
		List<String> especiesOpinionesExpertas = this.opinionesDeExpertos().stream().map(o -> o.getEspecie())
				.collect(Collectors.toList());

		HashSet<String> posiblesOpiniones = new HashSet<>(especiesOpinionesExpertas);

		for (String e : posiblesOpiniones) {
			if (Collections.frequency(especiesOpinionesExpertas, e) >= 2) {
				return true;
			}
			;
		}
		return false;
	}

	public boolean opinoUnExperto() {
		return this.opinionesDeExpertos().size() >= 1;

	}

	public List<Opinion> opinionesDeExpertos() {
		return this.getOpiniones().stream().filter(o -> o.esOpinionExperta()).collect(Collectors.toList());
	}

	public String resultadoActual() {
		// Agrego las especies de cada opinion a un arraylist
		List<String> especies = new ArrayList<>();
		this.getOpiniones().forEach(o -> {
			especies.add(o.getEspecie());
		});

		// Agrego las posibles opiniones distintas a un set para no tener repetidos
		HashSet<String> posiblesOpiniones = new HashSet<>(especies);

		// Creo un map con cada especie como clave y su cantidad de votos como valor
		Map<String, Integer> opinionesXcant = new HashMap<>();
		posiblesOpiniones.forEach(e -> {
			opinionesXcant.put(e, Collections.frequency(especies, e));
		});

		if (hayEmpate(opinionesXcant)) {
			return "No definido";
		} else {
			String resultado = "";
			int value = 0;
			for (Map.Entry<String, Integer> me : opinionesXcant.entrySet()) {
				if (me.getValue() > value) {
					value = me.getValue();
					resultado = me.getKey();
				}
			}
			return resultado;
		}
	}

	private boolean hayEmpate(Map<String, Integer> opiniones) {
		// Obtengo el mayor numero de votos del map
		int maxNumeroVotos = Collections.max(opiniones.values());
		// Si hay mas de 1 opinion con la mayor cantidad de votos hay empate
		return opiniones.entrySet().stream().filter(me -> me.getValue() == maxNumeroVotos).count() > 1;
	}

	public boolean tieneMenosDe30Dias() {
		return this.getFecha().isAfter(LocalDateTime.now().minusDays(30));
	}
}
