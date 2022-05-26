package ar.edu.unq.po.tpfinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.time.LocalDateTime;

public class MuestraTestCase {
	private Muestra muestra;
	private Usuario u;
	private Usuario u2;
	
	@BeforeEach
	public void setUp() {
		LocalDateTime fecha = LocalDateTime.now();
		Ubicacion ubicacion = mock(Ubicacion.class);
		Foto foto = mock(Foto.class);
		
		muestra = new Muestra("Vinchuca Infestans", foto, ubicacion, new UsuarioRegular(), fecha);
		
		u  = new UsuarioRegular();
		u2 = new UsuarioRegular();
	}
	
	@Test
	public void testSiUnaMuestraNoTieneOpinionesSuResultadoActualEsIgualAlDadoPorSuUsuarioRecolectador() {
		assertEquals("Vinchuca Infestans", muestra.resultadoActual());
	}
	
	@Test
	public void testSiHayEmpateEnLasOpinionesDeUnaMuestraElResultadoEsNoDefinido() {
		u.opinar(muestra, "Chinche Foliada");
		u2.opinar(muestra, "Phtia-Chinche");
		
		assertEquals("No definido", muestra.resultadoActual());
	}
	
	@Test
	public void testResultadoActualDevuelveLaEspecieMasVotada() {
		u.opinarMuestra(muestra, "Chinche Foliada");
		u2.opinarMuestra(muestra, "Vinchuca Infestans");
		
		assertEquals("Vinchuca Infestans", muestra.resultadoActual());
	}
	
}
