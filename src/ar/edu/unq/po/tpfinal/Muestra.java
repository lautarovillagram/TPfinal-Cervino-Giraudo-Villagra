package ar.edu.unq.po.tpfinal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Muestra {
	private String especie;
	private Foto foto;
	private Ubicacion ubicacion;
	private Usuario usuarioRecolectador;
	private LocalDateTime fecha;
	private List<Opinion> opiniones = new ArrayList<Opinion>();
	// private List<String> opinionesExpertas = new ArrayList<String>();
	private boolean verificada;
	// Contiene a todas las especies y la cantidad de votos que posee cada una
	private HashMap<String, Integer> especiesXcant = new HashMap<>();
	
	
	public Usuario getUsuarioRecolectador() {
		return usuarioRecolectador;
	}

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
		this.agregarOcurrenciaEspecie(opinion.getEspecie());
	}
	
	// Agrego una ocurrencia de la especie al map
	private void agregarOcurrenciaEspecie(String especie) {
		this.getEspeciesXCant().putIfAbsent(especie, 0);
		this.getEspeciesXCant().put(especie, this.getEspeciesXCant().get(especie) + 1);
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
		this.fecha = fecha;
		this.verificada = false;

		// La opinion del usuario recolectador tambien debe tenerse en cuenta
		this.getUsuarioRecolectador().agregarOpinionAMuestraPropia(this, this.especie);
		// this.agregarOpinion(new Opinion(this, this.usuarioRecolectador, this.fecha,
		// this.especie, this.usuarioRecolectador.esExperto()));
	}

	// Indica si al menos 2 usuarios expertos tienen la misma opinion
	public boolean estaVerificada() {
		return verificada;
	}
	
	// Permite cambiar el estado de verificacion de la muestra
	public void setVerificada(Boolean verificada) {
		this.verificada = verificada;
	}

	public boolean opinoUnExperto() {
		return this.opinionesDeExpertos().size() >= 1;

	}

	public List<Opinion> opinionesDeExpertos() {
		return this.getOpiniones().stream().filter(o -> o.esOpinionExperta()).collect(Collectors.toList());
	}

	public String resultadoActual() {
		if (hayEmpate(this.getEspeciesXCant())) {
			return "No definido";
		}
		else {
			//Obtengo la entrada del map con el numero mas grande de votos
			Map.Entry<String, Integer> me = Collections.max(especiesXcant.entrySet(), Map.Entry.comparingByValue());
			return me.getKey();
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
	
	public LocalDateTime getFechaUltimaVotacion() {
		return this.getOpiniones().stream().max(Comparator.comparing(Opinion::getFecha)).get().getFecha(); 
	}
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	private Map<String, Integer> getEspeciesXCant() {
		return especiesXcant;
	}
}