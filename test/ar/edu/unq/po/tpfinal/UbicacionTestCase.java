package ar.edu.unq.po.tpfinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class UbicacionTestCase {
	private Ubicacion buenosAires;
	private Ubicacion moscu;
	private Ubicacion montevideo;
	private Ubicacion santiago;
	
	@BeforeEach
	public void setUp() {
		// Buenos Aires
		buenosAires = new Ubicacion(-34.6083, -58.3712);
		// Moscu
		moscu = new Ubicacion(55.7508, 37.6172);
		// Montevideo
		montevideo = new Ubicacion(-34.8833, -56.1667);
		// Santiago
		santiago = new Ubicacion(-33.4513, -70.6653);
	}
	
	@Test
	public void testDistanciaEntreBuenosAiresYMoscu() {
		double resultado = Math.round(buenosAires.distanciaHasta(moscu));
		assertEquals(13475,resultado);
	}
	
	@Test
	public void testUbicacionesAMenosDe1500Km() {
		ArrayList<Ubicacion> ubicaciones= new ArrayList<>();
		ubicaciones.add(moscu);
		ubicaciones.add(montevideo);
		ubicaciones.add(santiago);
		List<Ubicacion> resultado = buenosAires.ubicacionesAMenosDeX(ubicaciones, 1500);
		
		assertTrue(resultado.contains(montevideo));
		assertTrue(resultado.contains(santiago));
		assertFalse(resultado.contains(moscu));
	}
}