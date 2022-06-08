package ar.edu.unq.po.tpfinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrganizacionTestCase {
	Organizacion o;
	ZonaDeCobertura z1;
	ZonaDeCobertura z2 ;
	Muestra m;
	
	FuncionalidadExterna f1;
	FuncionalidadExterna f2;
	
	@BeforeEach
	public void setUp() {
		Ubicacion ubicacion = mock(Ubicacion.class);
		f1 = mock(FuncionalidadExterna.class);
		f2 = mock(FuncionalidadExterna.class);
		
		z1 = mock(ZonaDeCobertura.class);
		z2 = mock(ZonaDeCobertura.class);
		
		o = new Organizacion(ubicacion, TipoDeOrganizacion.EDUCATIVA, 25, f1, f2);
	}
	
	@Test
	public void testTipoOrganizacion() {
		TipoDeOrganizacion resultado = TipoDeOrganizacion.EDUCATIVA;
		assertEquals(resultado, o.getTipoOrganizacion());
	}
	
	@Test
	public void testCantEmpleados() {
		int resultado = 25;
		assertEquals(resultado, o.getCantEmpleados());
	}
	
	@Test
	public void testSuscribirNuevoObservable() {
		o.suscribirse(z1);
		assertEquals(1, o.getObservados().size());
	}
	
	@Test
	public void testDesuscribirNuevoObservable() {
		o.suscribirse(z1);
		o.desuscribirse(z1);
		assertEquals(0, o.getObservados().size());
	}
	
	@Test
	public void testAlRealizarUnUpdateDeNuevaMuestraLaFuncionalidadExternaRealizaLaAccionEsperada() {
		o.updateNuevaMuestra(z1, m);
		
		verify(f1).nuevoEvento(o, z1, m);
		verifyNoInteractions(f2);
	}
	
	@Test
	public void testAlRealizarUnUpdateDeVerificacionLaFuncionalidadExternaRealizaLaAccionEsperada() {
		o.updateMuestraVerificada(z1, m);
		
		verify(f2).nuevoEvento(o, z1, m);
		verifyNoInteractions(f1);
	}
	
	
	
}
