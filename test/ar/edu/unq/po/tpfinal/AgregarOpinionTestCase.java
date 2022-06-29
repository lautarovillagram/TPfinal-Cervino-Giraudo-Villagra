package ar.edu.unq.po.tpfinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

public class AgregarOpinionTestCase {
	private UsuarioRegular u1;
	private UsuarioRegular u2;
	private UsuarioExperto u3;
	private UsuarioExperto u4;
	
	private Muestra muestra1;
	private Muestra muestra2;
	
	private Opinion opinion1;
	private Opinion opinion2;
	private Sistema sistema;
	private ActualizadorDeCategoria recategorizador;
	private Ubicacion ubicacion;
	
	@BeforeEach
	public void SetUp() {
		u1 = new UsuarioRegular();
		u2 = new UsuarioRegular();
		u3 = new UsuarioExperto();
		u4 = new UsuarioExperto();
		Ubicacion ubicacion = mock(Ubicacion.class);
		Foto foto = mock(Foto.class);
		recategorizador = new ActualizadorDeCategoria();
		sistema = new Sistema();
		sistema.setRecategorizador(recategorizador);
		
		muestra1 = new Muestra("Vinchuca Infestans", foto, ubicacion, u1, LocalDateTime.now());
		muestra2 = new Muestra("Vinchuca Sordida", foto, ubicacion, u3, LocalDateTime.now());
		
		opinion1 = new Opinion(muestra1, u2, LocalDateTime.now(), "ninguna");
		opinion2 = new Opinion(muestra1, u1, LocalDateTime.now(), " Vinchuca Infestans");
		
		
		
	}
	
	public void TestAgregarOpinionAMuestraPropia() {
		assertEquals(sistema.getMuestras().size(), 0);
		sistema.agregarOpinion(opinion2);
		assertEquals(sistema.getMuestras().size(), 0);
	}
}
