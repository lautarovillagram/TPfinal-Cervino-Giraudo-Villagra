package ar.edu.unq.po.tpfinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ZonaDeCoberturaTestCase {
	ZonaDeCobertura florencioVarela;
	ZonaDeCobertura quilmes;
	Ubicacion epicentro1;
	Ubicacion epicentro2;
	
	Muestra m;
	
	@BeforeEach
	public void setUp() {
		epicentro1 = new Ubicacion(-34.7975, -58.2761);
		florencioVarela = new ZonaDeCobertura("Florencio Varela", epicentro1, 5d);
	}
	
	@Test
	public void testObtenerNombre() {
		String resultado = florencioVarela.getNombre();
		assertEquals(resultado, "Florencio Varela");
	}
	
	@Test
	public void testObtenerEpicentro() {
		Ubicacion resultado = florencioVarela.getEpicentro();
		assertEquals(resultado, epicentro1);
	}
	
	@Test
	public void testObtenerRadio() {
		Double resultado = florencioVarela.getRadioEnKm();
		assertEquals(resultado, 5d);
	}
	
	@Test
	public void testConocerSiUnaMuestraPerteneceALaZona() {
		// Le indico al mock de la muestra que devuelva una ubicacion que yo se que esta dentro de la zona
		// como su ubicacion
		Ubicacion u = new Ubicacion(-34.8039d, -58.2794d);
		Muestra muestra = mock(Muestra.class);
		when(muestra.getUbicacion()).thenReturn(u);
		
		assertTrue(florencioVarela.perteneceALaZona(muestra));
	}
	
	
	@Test
	public void testConocerSiUnaMuestraNoPerteneceALaZona() {
		// Le indico al mock de la muestra que devuelva una ubicacion que yo se que no esta dentro de la zona
		// como su ubicacion
		Ubicacion u = new Ubicacion(-34.7242d, -58.2608d);
		Muestra muestra = mock(Muestra.class);
		when(muestra.getUbicacion()).thenReturn(u);
		
		assertFalse(florencioVarela.perteneceALaZona(muestra));
	}
	
	@Test
	public void testConocerSiDosZonasSeSolapan() {
		epicentro2 = new Ubicacion(-34.7203, -58.2694);
		quilmes = new ZonaDeCobertura("Quilmes", epicentro2, 5d);
		assertTrue(florencioVarela.seSolapaCon(quilmes));
	}
	
	@Test
	public void testConocerSiDosZonasNoSeSolapan() {
		epicentro2 = new Ubicacion(-34.7203, -58.2694);
		quilmes = new ZonaDeCobertura("Quilmes", epicentro2, 1d);
		assertFalse(florencioVarela.seSolapaCon(quilmes));
	}
	
	
	@Test
	public void testAgregarMuestrasAUnaZona() {
		Ubicacion u = new Ubicacion(-34.8039d, -58.2794d);
		Muestra muestra = mock(Muestra.class);
		when(muestra.getUbicacion()).thenReturn(u);
		
		florencioVarela.agregarMuestra(muestra);
		assertEquals(1, florencioVarela.getMuestras().size());
	}
	
	@Test
	public void testSiUnaMuestraNoPerteneceALaZonaNoSeAgrega() {
		Ubicacion u = new Ubicacion(-34.7242d, -58.2608d);
		Muestra muestra = mock(Muestra.class);
		when(muestra.getUbicacion()).thenReturn(u);
		
		florencioVarela.agregarMuestra(muestra);
		assertEquals(0, florencioVarela.getMuestras().size());
	}
	
	@Test
	public void testSiUnaMuestraEstaVericadaSeAgregaAlLaLista() {
		Muestra muestra = mock(Muestra.class);
		when(muestra.estaVerificada()).thenReturn(true);
		
		florencioVarela.agregarMuestraVerificada(muestra);
		assertEquals(1, florencioVarela.getMuestrasVerificadas().size());
	}
	
	@Test
	public void testSiUnaMuestraNoEstaVericadaNoSeAgregaAlLaLista() {
		Muestra muestra = mock(Muestra.class);
		when(muestra.estaVerificada()).thenReturn(false);
		
		florencioVarela.agregarMuestraVerificada(muestra);
		assertEquals(0, florencioVarela.getMuestrasVerificadas().size());
	}
}
