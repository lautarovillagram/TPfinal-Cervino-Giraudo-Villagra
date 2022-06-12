package ar.edu.unq.po.tpfinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BuscadorTestCase {
	private Buscador buscador;
	private List<Muestra> muestras = new ArrayList<>();
	private Muestra m1;
	private Muestra m2;
	private Muestra m3;
	
	@BeforeEach
	public void setUp() {
		m1 = mock(Muestra.class);
		m2 = mock(Muestra.class);
		m3 = mock(Muestra.class);
		
		muestras.add(m1);
		muestras.add(m2);
		muestras.add(m3);
		
		buscador = new Buscador(muestras);
	}
	
	@Test
	public void testBuscarPorFechaDeCreacion() {
		LocalDateTime fechaABuscar = LocalDateTime.of(2022, 05, 15, 15,55);
		// Se espera que el buscador devuelva solo las muestras m1 y m2
		when(m1.getFecha()).thenReturn(fechaABuscar);
		when(m2.getFecha()).thenReturn(fechaABuscar);
		when(m3.getFecha()).thenReturn(LocalDateTime.of(2021, 04, 25, 14,30));
		
		List<Muestra> resultado = buscador.buscarPorFechaDeCreacion(fechaABuscar);
		
		assertTrue(resultado.contains(m1));
		assertTrue(resultado.contains(m2));
		assertFalse(resultado.contains(m3));
	}
	
	@Test
	public void testBuscarPorFechaDeUltimaVotacion() {
		LocalDateTime fechaABuscar = LocalDateTime.of(2022, 05, 15, 15,55);
		
		when(m1.getFechaUltimaVotacion()).thenReturn(fechaABuscar);
		when(m2.getFechaUltimaVotacion()).thenReturn(LocalDateTime.of(2019, 05, 15, 15,55));
		when(m3.getFechaUltimaVotacion()).thenReturn(LocalDateTime.of(2019, 05, 12, 15,25));
		
		List<Muestra> resultado = buscador.buscarPorFechaDeUltimaVotacion(fechaABuscar);
		
		assertTrue(resultado.contains(m1));
		assertFalse(resultado.contains(m2));
		assertFalse(resultado.contains(m3));
	}
	
	@Test
	public void testBuscarPorTipoDeInsecto() {
		when(m1.resultadoActual()).thenReturn("Vinchuca Infestans");
		when(m2.resultadoActual()).thenReturn("Chinche Foliada");
		when(m3.resultadoActual()).thenReturn("imagen poco clara");
		
		List<Muestra> resultado = buscador.buscarPorTipoDeInsecto("Vinchuca Infestans");
		
		assertTrue(resultado.contains(m1));
		assertFalse(resultado.contains(m2));
		assertFalse(resultado.contains(m3));
	}
	
	@Test
	public void testBuscarPorNivelDeVerificacionVerificada() {
		when(m1.estaVerificada()).thenReturn(true);
		when(m2.estaVerificada()).thenReturn(false);
		when(m3.estaVerificada()).thenReturn(true);
		
		List<Muestra> resultado = buscador.buscarPorNivelDeVerificacion("verificada");
		assertTrue(resultado.contains(m1));
		assertFalse(resultado.contains(m2));
		assertTrue(resultado.contains(m3));
	}
	
	@Test
	public void testBuscarPorNivelDeVerificacionVotada() {
		when(m1.estaVerificada()).thenReturn(true);
		when(m2.estaVerificada()).thenReturn(false);
		when(m3.estaVerificada()).thenReturn(true);
		
		List<Muestra> resultado = buscador.buscarPorNivelDeVerificacion("votada");
		assertFalse(resultado.contains(m1));
		assertTrue(resultado.contains(m2));
		assertFalse(resultado.contains(m3));
	}
	
	@Test
	public void testCombinar2CriteriosDeBusquedaOR() {
		when(m1.resultadoActual()).thenReturn("Vinchuca Infestans");
		when(m1.estaVerificada()).thenReturn(true);
		
		when(m2.resultadoActual()).thenReturn("Vinchuca Infestans");
		when(m2.estaVerificada()).thenReturn(false);
		
		when(m3.resultadoActual()).thenReturn("Chinche Foliada");
		when(m3.estaVerificada()).thenReturn(false);
		
		
		List<Muestra> resultado = buscador.buscarPor_O_(buscador.buscarPorNivelDeVerificacion("verificada"),
				                                        buscador.buscarPorTipoDeInsecto("Vinchuca Infestans"));
		assertTrue(resultado.contains(m1));
		assertTrue(resultado.contains(m2));
		assertFalse(resultado.contains(m3));
	}
	
	@Test
	public void testCombinar2CriteriosDeBusquedaAND() {
		when(m1.resultadoActual()).thenReturn("Vinchuca Infestans");
		when(m1.estaVerificada()).thenReturn(true);
		
		when(m2.resultadoActual()).thenReturn("Vinchuca Infestans");
		when(m2.estaVerificada()).thenReturn(false);
		
		when(m3.resultadoActual()).thenReturn("Chinche Foliada");
		when(m3.estaVerificada()).thenReturn(true);
		
		
		List<Muestra> resultado = buscador.buscarPor_Y_(buscador.buscarPorNivelDeVerificacion("verificada"),
				                                        buscador.buscarPorTipoDeInsecto("Vinchuca Infestans"));
		assertTrue(resultado.contains(m1));
		assertFalse(resultado.contains(m2));
		assertFalse(resultado.contains(m3));
	}
}
