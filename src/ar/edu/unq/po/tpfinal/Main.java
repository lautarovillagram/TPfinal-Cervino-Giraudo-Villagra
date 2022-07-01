package ar.edu.unq.po.tpfinal;

import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		UsuarioRegular u = new UsuarioRegular();
		UsuarioExperto u2 = new UsuarioExperto();
		UsuarioExperto u3 = new UsuarioExperto();
		Foto foto = mock(Foto.class);
		Ubicacion ubicacion = mock(Ubicacion.class);
		Sistema sistema = new Sistema();
		Muestra muestra = new Muestra("Vinchuca Infestans", foto, ubicacion, u, LocalDateTime.now());
		sistema.agregarMuestra(muestra);
		System.out.println(sistema.getMuestras());
		System.out.println(muestra.estadoDeVerificacion());
		Opinion opinion = new Opinion(muestra, u2, LocalDateTime.now(), "ninguna");
		sistema.agregarOpinion(opinion);
		System.out.println(muestra.estadoDeVerificacion());
		Opinion opinion2 = new Opinion(muestra, u3, LocalDateTime.now(), "ninguna");
		sistema.agregarOpinion(opinion2);
		System.out.println(muestra.estadoDeVerificacion());
	}

}
