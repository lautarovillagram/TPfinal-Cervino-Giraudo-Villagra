package ar.edu.unq.po.tpfinal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTestCase {
	private Sistema sistema;
	private Muestra m1;
	private Muestra m2;
	private Muestra m3;
	private Usuario u;
	private ZonaDeCobertura z;
	private Foto foto;
	private Ubicacion ubicacion;
	
	
	@BeforeEach
	public void setUp() {
		foto = mock(Foto.class);
		ubicacion = mock(Ubicacion.class);
		u = mock(UsuarioRegular.class);
			
		m1 = mock(Muestra.class);
		m2 = mock(Muestra.class);
		m3 = mock(Muestra.class);
		
		z = mock(ZonaDeCobertura.class);
		
		
		sistema = new Sistema();
	}
	
	@Test
	public void testAgregarUsuario() {
		sistema.agregarUsuario(u);
		assertTrue(sistema.getUsuarios().contains(u));
	}
	
	@Test
	public void testAgregarZonaDeCobertura() {
		sistema.agregarZonaDeCobertura(z);
		assertTrue(sistema.getZonasDeCobertura().contains(z));
	}
	
	@Test
	public void testAgregarMuestra() {
		m1 = new Muestra("Vinchuca Infestans", foto, ubicacion, u, LocalDateTime.now());
		m2 = new Muestra("Vinchuca Infestans", foto, ubicacion, u, LocalDateTime.now());
		m3 = new Muestra("Vinchuca Infestans", foto, ubicacion, u, LocalDateTime.now());
		
		sistema.agregarZonaDeCobertura(z);
				
		sistema.agregarMuestra(m1);
		sistema.agregarMuestra(m2);	
		
		// Verifico que la zona reciba el mensaje agregarMuestra
		verify(z).agregarMuestra(m1);
		verify(z).agregarMuestra(m2);
		
		assertTrue(sistema.getMuestras().contains(m1));
		assertTrue(sistema.getMuestras().contains(m2));
	}
	
	// Test Busquedas
	@Test
	public void testBuscarPorFechaDeCreacion() {
		LocalDateTime fechaABuscar = LocalDateTime.of(2022, 05, 15, 15, 55);
		// Se espera que la busqueda devuelva solo las muestras m1 y m2
		m1 = new Muestra("Vinchuca Infestans", foto, ubicacion, u, fechaABuscar);
		m2 = new Muestra("Vinchuca Infestans", foto, ubicacion, u, fechaABuscar);
		m3 = new Muestra("Vinchuca Infestans", foto, ubicacion, u, LocalDateTime.of(2021, 04, 25, 14, 30));
		
		
		sistema.agregarMuestra(m1);
		sistema.agregarMuestra(m2);
		sistema.agregarMuestra(m3);
		
		Busqueda b = sistema.getBuscador().buscarPorFechaDeCreacion(fechaABuscar);
		List<Muestra> resultado = sistema.buscar(b);

		assertTrue(resultado.contains(m1));
		assertTrue(resultado.contains(m2));
		assertFalse(resultado.contains(m3));
	}
	
	@Test
	public void testBuscarPorFechaDeUltimaVotacion() {
		LocalDateTime fechaABuscar = LocalDateTime.of(2022, 05, 15, 15, 55);
		// Se espera que la busqueda devuelva solo las muestras m1 y m2
		m1 = new Muestra("Vinchuca Infestans", foto, ubicacion, u, fechaABuscar);
		m2 = new Muestra("Vinchuca Infestans", foto, ubicacion, u, fechaABuscar);
		m3 = new Muestra("Vinchuca Infestans", foto, ubicacion, u, LocalDateTime.of(2021, 04, 25, 14, 30));
		
		sistema.agregarMuestra(m1);
		sistema.agregarMuestra(m2);
		sistema.agregarMuestra(m3);
		
		Busqueda b = sistema.getBuscador().buscarPorFechaDeUltimaVotacion(fechaABuscar);
		List<Muestra> resultado = sistema.buscar(b);

		assertTrue(resultado.contains(m1));
		assertTrue(resultado.contains(m2));
		assertFalse(resultado.contains(m3));
	}
	
	@Test
	public void testBuscarPorTipoDeInsecto() {
		m1 = new Muestra("Vinchuca Infestans", foto, ubicacion, u, LocalDateTime.now());
		m2 = new Muestra("Chinche Foliada", foto, ubicacion, u, LocalDateTime.now());
		m3 = new Muestra("imagen poco clara", foto, ubicacion, u, LocalDateTime.now());
		
		sistema.agregarMuestra(m1);
		sistema.agregarMuestra(m2);
		sistema.agregarMuestra(m3);
		List<Muestra> resultado = sistema.buscar(sistema.getBuscador().buscarPorTipoDeInsecto("Vinchuca Infestans"));

		assertTrue(resultado.contains(m1));
		assertFalse(resultado.contains(m2));
		assertFalse(resultado.contains(m3));
	}
	
	@Test
	public void testBuscarPorNivelDeVerificacionVerificada() {
		when(m1.getEspecie()).thenReturn("Vinchuca Infestans");
		when(m2.getEspecie()).thenReturn("Vinchuca Infestans");
		when(m3.getEspecie()).thenReturn("Vinchuca Infestans");
		
		when(m1.getUsuarioRecolectador()).thenReturn(u);
		when(m2.getUsuarioRecolectador()).thenReturn(u);
		when(m3.getUsuarioRecolectador()).thenReturn(u);	
		
		sistema.agregarMuestra(m1);
		sistema.agregarMuestra(m2);
		sistema.agregarMuestra(m3);
		
		// Se espera que el resultado solo devuelva las muestras m1 y m3
		when(m1.estaVerificada()).thenReturn(true);
		when(m2.estaVerificada()).thenReturn(false);
		when(m3.estaVerificada()).thenReturn(true);
		
		List<Muestra> resultado = sistema.buscar(sistema.getBuscador().buscarPorNivelDeVerificacion("verificada"));
		
		assertTrue(resultado.contains(m1));
		assertFalse(resultado.contains(m2));
		assertTrue(resultado.contains(m3));
	}
	
	@Test
	public void testBuscarPorNivelDeVerificacionVotada() {	
		when(m1.getEspecie()).thenReturn("Vinchuca Infestans");
		when(m2.getEspecie()).thenReturn("Vinchuca Infestans");
		when(m3.getEspecie()).thenReturn("Vinchuca Infestans");
		
		when(m1.getUsuarioRecolectador()).thenReturn(u);
		when(m2.getUsuarioRecolectador()).thenReturn(u);
		when(m3.getUsuarioRecolectador()).thenReturn(u);
		
		sistema.agregarMuestra(m1);
		sistema.agregarMuestra(m2);
		sistema.agregarMuestra(m3);
		// Se espera que el resultado solo devuelva la muestra m2
		when(m1.estaVerificada()).thenReturn(true);
		when(m2.estaVerificada()).thenReturn(false);
		when(m3.estaVerificada()).thenReturn(true);
		
		List<Muestra> resultado = sistema.buscar(sistema.getBuscador().buscarPorNivelDeVerificacion("votada"));
		
		assertFalse(resultado.contains(m1));
		assertTrue(resultado.contains(m2));
		assertFalse(resultado.contains(m3));
	}
	
	@Test
	public void testCombinarCriteriosDeBusquedaOR() {
		when(m1.getEspecie()).thenReturn("Vinchuca Infestans");
		when(m1.resultadoActual()).thenReturn("Vinchuca Infestans");
		when(m1.estaVerificada()).thenReturn(true);
		when(m1.getUsuarioRecolectador()).thenReturn(u);
		
		when(m2.getEspecie()).thenReturn("Vinchuca Infestans");
		when(m2.resultadoActual()).thenReturn("Vinchuca Infestans");
		when(m2.estaVerificada()).thenReturn(false);
		when(m2.getUsuarioRecolectador()).thenReturn(u);
		
		when(m3.getEspecie()).thenReturn("Vinchuca Infestans");
		when(m3.resultadoActual()).thenReturn("Chinche Foliada");
		when(m3.estaVerificada()).thenReturn(false);
		when(m3.getUsuarioRecolectador()).thenReturn(u);
		
		sistema.agregarMuestra(m1);
		sistema.agregarMuestra(m2);
		sistema.agregarMuestra(m3);
		
		Busqueda b1 = sistema.getBuscador().buscarPorNivelDeVerificacion("verificada");
		Busqueda b2 = sistema.getBuscador().buscarPorTipoDeInsecto("Vinchuca Infestans");
		
		Busqueda or = sistema.getBuscador().buscarPor_O_(b1, b2);
		
		// Se espera que el resultado contenga a m1 y m2
		List<Muestra> resultado = sistema.buscar(or);
		
		assertTrue(resultado.contains(m1));
		assertTrue(resultado.contains(m2));
		assertFalse(resultado.contains(m3));
	}
	
	@Test
	public void testCombinar2CriteriosDeBusquedaAND() {
		when(m1.getEspecie()).thenReturn("Vinchuca Infestans");
		when(m1.resultadoActual()).thenReturn("Vinchuca Infestans");
		when(m1.estaVerificada()).thenReturn(true);
		when(m1.getUsuarioRecolectador()).thenReturn(u);
		
		when(m2.getEspecie()).thenReturn("Vinchuca Infestans");
		when(m2.resultadoActual()).thenReturn("Vinchuca Infestans");
		when(m2.estaVerificada()).thenReturn(false);
		when(m2.getUsuarioRecolectador()).thenReturn(u);
		
		when(m3.getEspecie()).thenReturn("Vinchuca Infestans");
		when(m3.resultadoActual()).thenReturn("Chinche Foliada");
		when(m3.estaVerificada()).thenReturn(false);
		when(m3.getUsuarioRecolectador()).thenReturn(u);
		
		sistema.agregarMuestra(m1);
		sistema.agregarMuestra(m2);
		sistema.agregarMuestra(m3);
		
		Busqueda b1 = sistema.getBuscador().buscarPorNivelDeVerificacion("verificada");
		Busqueda b2 = sistema.getBuscador().buscarPorTipoDeInsecto("Vinchuca Infestans"); 
		Busqueda and = sistema.getBuscador().buscarPor_Y_(b1,b2);
		
		// Se espera que el resultado solo contenga a m1
		List<Muestra> resultado = sistema.buscar(and);
		
		assertTrue(resultado.contains(m1));
		assertFalse(resultado.contains(m2));
		assertFalse(resultado.contains(m3));
	}
}
