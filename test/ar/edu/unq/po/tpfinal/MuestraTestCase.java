package ar.edu.unq.po.tpfinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.time.LocalDateTime;

public class MuestraTestCase {
	private Muestra muestra;
	private UsuarioRegular u;
	private UsuarioRegular u2;
	private Usuario u3;
	private Usuario u4;
	private UsuarioRegular u5;
	private ActualizadorDeCategoria observer;
	private ActualizadorDeCategoria observer2;

	
	@BeforeEach
	public void setUp() {
		LocalDateTime fecha = LocalDateTime.now();
		Ubicacion ubicacion = mock(Ubicacion.class);
		Foto foto = mock(Foto.class);
		ActualizadorDeCategoria observer3 = mock(ActualizadorDeCategoria.class);
		u5 = new UsuarioRegular();
		u5.setObservador(observer3);
		observer3.setObservable(u5);
		
		
		muestra = new Muestra("Vinchuca Infestans", foto, ubicacion, u5, fecha);
		observer = new ActualizadorDeCategoria();
		observer2 = new ActualizadorDeCategoria();
		
		u  = new UsuarioRegular();
		u2 = new UsuarioRegular();
		u.setObservador(observer);
		u2.setObservador(observer2);
		observer.setObservable(u);
		observer2.setObservable(u2);
		
		
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
