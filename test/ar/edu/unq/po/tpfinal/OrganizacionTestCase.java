package ar.edu.unq.po.tpfinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrganizacionTestCase {
	Organizacion o;
	
	@BeforeEach
	public void setUp() {
		Ubicacion ubicacion = mock(Ubicacion.class);
		o = new Organizacion(ubicacion, TipoDeOrganizacion.EDUCATIVA, 25);
		
	}
	@Test
	public void testTipoOrganizacion() {
		TipoDeOrganizacion resultado = TipoDeOrganizacion.EDUCATIVA;
		assertEquals(resultado, o.getTipoOrganizacion());
	}
}
