package ar.edu.unq.po.tpfinal;

import java.util.Arrays;
import java.util.List;

public class Especies {

	private List<String> categorias = Arrays.asList("Vinchuca Infestans", "Vinchuca Sordida", "Vinchuca Guasayana", "chinche foliada",
			"phtia-chinche", "ninguna", "imagen poco clara");

	public List<String> getCategorias() {
		return categorias;
	}

	public boolean esUnaCategoria(String categoria) {
		return this.getCategorias().contains(categoria);
	}

}
