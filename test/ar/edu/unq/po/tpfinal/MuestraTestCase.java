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
	private Usuario u3;
	private Usuario u4;
	
	@BeforeEach
	public void setUp() {
		LocalDateTime fecha = LocalDateTime.now();
		Ubicacion ubicacion = mock(Ubicacion.class);
		Foto foto = mock(Foto.class);
		
		muestra = new Muestra("Vinchuca Infestans", foto, ubicacion, new UsuarioRegular(), fecha);
		
		u  = new UsuarioRegular();
		u2 = new UsuarioRegular();
		
		u3 = new UsuarioExperto();
		u4 = new UsuarioExperto();
	}
	
	@Test
	public void testSiUnaMuestraNoTieneOpinionesSuResultadoActualEsIgualAlDadoPorSuUsuarioRecolectador() {
		assertEquals("Vinchuca Infestans", muestra.resultadoActual());
	}
	
	@Test
	public void testSiHayEmpateEnLasOpinionesDeUnaMuestraElResultadoEsNoDefinido() {
		u.opinarMuestra(muestra, "Chinche Foliada");
		u2.opinarMuestra(muestra, "Phtia-Chinche");
		
		assertEquals("No definido", muestra.resultadoActual());
	}
	
	@Test
	public void testResultadoActualDevuelveLaEspecieMasVotada() {
		u.opinarMuestra(muestra, "Chinche Foliada");
		u2.opinarMuestra(muestra, "Vinchuca Infestans");
		
		assertEquals("Vinchuca Infestans", muestra.resultadoActual());
	}
	
	@Test
	public void testUnaMuestraSinOpinionesDeExpertosNoEstaVerificada() {
		u.opinarMuestra(muestra, "Chinche Foliada");
		
		assertFalse(muestra.estaVerificada());
	}
	
	@Test
	public void testUnaMuestraConOpinionesDeExpertosQueNoCoincidenNoEstaVerificada() {
		u3.opinarMuestra(muestra, "Chinche Foliada");
		u4.opinarMuestra(muestra, "Vinchuca Infestans");
		
		assertFalse(muestra.estaVerificada());
	}
	
	@Test
	public void testUnaMuestraConOpinionesDeExpertosQueCoincidenEstaVerificada() {
		u3.opinarMuestra(muestra, "Chinche Foliada");
		u4.opinarMuestra(muestra, "Chinche Foliada");
		
		assertTrue(muestra.estaVerificada());
	}
}
