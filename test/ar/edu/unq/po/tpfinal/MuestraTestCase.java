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
	private Ubicacion ubicacion;
	private Opinion opinion1;
	private Opinion opinion2;
	private Opinion opinion3;
	private Opinion opinion4;
	private Opinion opinion5;
	private Opinion opinion6;
	private Opinion opinion7;
	private Sistema sistema;

	@BeforeEach
	public void setUp() {
		LocalDateTime fecha = LocalDateTime.now();
		ubicacion = mock(Ubicacion.class);
		Foto foto = mock(Foto.class);
		u5 = new UsuarioRegular();
		sistema = new Sistema();

		muestra = new Muestra("Vinchuca Infestans", foto, ubicacion, u5, fecha);

		u = new UsuarioRegular();
		u2 = new UsuarioRegular();

		u3 = new UsuarioExperto();
		u4 = new UsuarioExperto();

		opinion1 = new Opinion(muestra, u, LocalDateTime.now(), "Chinche Foliada");
		opinion2 = new Opinion(muestra, u2, LocalDateTime.now(), "Phtia-Chinche");
		opinion3 = new Opinion(muestra, u2, LocalDateTime.now(), "Vinchuca Infestans");
		opinion4 = new Opinion(muestra, u3, LocalDateTime.now(), "Chinche Foliada");
		opinion5 = new Opinion(muestra, u4, LocalDateTime.now(), "Vinchuca Infestans");
		opinion6 = new Opinion(muestra, u4, LocalDateTime.now(), "Chinche Foliada");
		opinion7 = new Opinion(muestra, u4, LocalDateTime.now(), "Phtia-Chinche");
		sistema.agregarMuestra(muestra);
	}

	@Test
	public void testLaMuestraEsNoVerificada() {
		assertFalse(muestra.estaVerificada());
	}

	@Test
	public void testSiUnaMuestraNoTieneOpinionesSuResultadoActualEsIgualAlDadoPorSuUsuarioRecolectador() {
		assertEquals("Vinchuca Infestans", muestra.resultadoActual());
	}

	@Test
	public void testSiHayEmpateEnLasOpinionesDeUnaMuestraElResultadoEsNoDefinido() {
		sistema.agregarOpinion(opinion1);
		sistema.agregarOpinion(opinion2);

		assertEquals("No definido", muestra.resultadoActual());
	}

	@Test
	public void testResultadoActualDevuelveLaEspecieMasVotada() {
		sistema.agregarOpinion(opinion1);
		sistema.agregarOpinion(opinion3);
		
		assertEquals("Vinchuca Infestans", muestra.resultadoActual());
	}

	@Test
	public void testUnaMuestraSinOpinionesDeExpertosNoEstaVerificada() {
		sistema.agregarOpinion(opinion1);

		assertFalse(muestra.estaVerificada());
	}

	@Test
	public void testUnaMuestraConOpinionesDeExpertosQueNoCoincidenNoEstaVerificada() {

		sistema.agregarOpinion(opinion4);
		sistema.agregarOpinion(opinion5);

		assertFalse(muestra.estaVerificada());
	}

	@Test
	public void testUnaMuestraConOpinionesDeExpertosQueCoincidenEstaVerificada() {

		sistema.agregarOpinion(opinion4);
		sistema.agregarOpinion(opinion6);
		assertTrue(muestra.estaVerificada());
	}

	@Test
	public void testLaEspecieOriginalComoResultadoActual() {
		assertEquals(muestra.getEspecie(), muestra.resultadoActual());
	}
	
	@Test
	public void testUnaMuestraPuedeSaberLaFechaDeSuUltimaVotacion() {
		LocalDateTime fecha = LocalDateTime.of(2023, 05, 15, 15, 55);
		LocalDateTime fecha2 = LocalDateTime.of(2023, 05, 30, 15, 58);

		Opinion o = mock(Opinion.class);
		when(o.getFecha()).thenReturn(fecha);
		when(o.getUsuarioOpinador()).thenReturn(u);

		Opinion o2 = mock(Opinion.class);
		when(o2.getFecha()).thenReturn(fecha2);
		when(o2.getUsuarioOpinador()).thenReturn(u2);

		muestra.agregarOpinion(o);
		muestra.agregarOpinion(o2);

		assertEquals(fecha2, muestra.getFechaUltimaVotacion());
	}
	

	@Test
	public void testUnaMuestraPuedeConocerSuUbicacion() {
		assertEquals(ubicacion, muestra.getUbicacion());
	}
	
	@Test
	public void testUnaMuestraParcialmenteVerificadaNoRecibeOpinionesDeUsuariosRegulares() {
		muestra.agregarOpinion(opinion4);
		muestra.agregarOpinion(opinion1);
		
		assertTrue(muestra.getOpiniones().contains(opinion4));
		assertFalse(muestra.getOpiniones().contains(opinion1));
	}
	
	@Test
	public void testUnaMuestraParcialmenteVerificadaSoloTieneEnCuentaOpinionesExpertasParaSuResultadoActual() {
		muestra.agregarOpinion(opinion1); // UsuarioRegular Chinche Foliada
		muestra.agregarOpinion(opinion3); // UsuarioRegular Vinchuca Infestans
		
		muestra.agregarOpinion(opinion7); // UsuarioExperto Phtia-Chinche
		
		assertTrue(muestra.resultadoActual().equals("Phtia-Chinche"));
	}
	
	@Test
	public void testUnaMuestraYaVerificadaNoRecibeOpinionesDeNingunTipo() {
		muestra.agregarOpinion(opinion4); // UsuarioExperto "Chinche Foliada"
		muestra.agregarOpinion(opinion6); // UsuarioExperto "Chinche Foliada"
	
		muestra.agregarOpinion(opinion3); // UsuarioRegular Vinchuca Infestans
		muestra.agregarOpinion(opinion7); // UsuarioExperto Phtia-Chinche
		
		assertFalse(muestra.getOpiniones().contains(opinion3));
		assertFalse(muestra.getOpiniones().contains(opinion7));
	}
}