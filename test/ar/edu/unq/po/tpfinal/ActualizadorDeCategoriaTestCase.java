package ar.edu.unq.po.tpfinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

public class ActualizadorDeCategoriaTestCase {
	private Muestra muestra;
	private Muestra muestra2;
	private Muestra muestra3;
	private Muestra muestra4;
	private Muestra muestra5;
	private Muestra muestra6;
	private Muestra muestra7;
	private Muestra muestra8;
	private Muestra muestra9;
	private Muestra muestra10;
	private Muestra muestra11;

	private Opinion opinion;
	private Opinion opinion2;
	private Opinion opinion3;
	private Opinion opinion4;
	private Opinion opinion5;
	private Opinion opinion6;
	private Opinion opinion7;
	private Opinion opinion8;
	private Opinion opinion9;
	private Opinion opinion10;
	private Opinion opinion11;
	private Opinion opinion12;
	private Opinion opinion13;
	private Opinion opinion14;
	private Opinion opinion15;
	private Opinion opinion16;
	private Opinion opinion17;
	private Opinion opinion18;
	private Opinion opinion19;
	private Opinion opinion20;
	private Opinion opinion21;
	private ActualizadorDeCategoria actualizador;
	private Buscador buscador;
	private UsuarioRegular u;

	private Sistema sistema;

	/*
	 * el setup agrega 10 muestras con menos de 30 dias de antiguedad y 1 con mas de
	 * 30 dias de antiguedad, tambien 20 opiniones con menos de 30 dias de
	 * antiguedad y 1 con mas de 30 dias de antiguedad
	 */
	@BeforeEach
	public void SetUp() {
		LocalDateTime fecha = LocalDateTime.now().minusDays(7);
		LocalDateTime fecha2 = LocalDateTime.now().minusDays(31);
		Ubicacion ubicacion = mock(Ubicacion.class);
		Foto foto = mock(Foto.class);
		Muestra muestraAjena = mock(Muestra.class);
		Muestra muestraAjena2 = mock(Muestra.class);
		Muestra muestraAjena3 = mock(Muestra.class);
		Muestra muestraAjena4 = mock(Muestra.class);
		Muestra muestraAjena5 = mock(Muestra.class);
		Muestra muestraAjena6 = mock(Muestra.class);
		Muestra muestraAjena7 = mock(Muestra.class);
		Muestra muestraAjena8 = mock(Muestra.class);
		Muestra muestraAjena9 = mock(Muestra.class);
		Muestra muestraAjena10 = mock(Muestra.class);
		Muestra muestraAjena11 = mock(Muestra.class);
		Muestra muestraAjena12 = mock(Muestra.class);
		Muestra muestraAjena13 = mock(Muestra.class);
		Muestra muestraAjena14 = mock(Muestra.class);
		Muestra muestraAjena15 = mock(Muestra.class);
		Muestra muestraAjena16 = mock(Muestra.class);
		Muestra muestraAjena17 = mock(Muestra.class);
		Muestra muestraAjena18 = mock(Muestra.class);
		Muestra muestraAjena19 = mock(Muestra.class);
		Muestra muestraAjena20 = mock(Muestra.class);
		Muestra muestraAjena21 = mock(Muestra.class);
		actualizador = new ActualizadorDeCategoria();
		u = new UsuarioRegular();
		UsuarioRegular u2 = mock(UsuarioRegular.class);
		sistema = new Sistema();
		buscador = new Buscador();
		sistema.setRecategorizador(actualizador);
		sistema.setBuscador(buscador);
		sistema.agregarUsuario(u);

		muestra = new Muestra("Vinchuca Infestans", foto, ubicacion, u2, fecha);
		muestra2 = new Muestra("Vinchuca Sordida", foto, ubicacion, u2, fecha);
		muestra3 = new Muestra("Vinchuca Guasayana", foto, ubicacion, u2, fecha);
		muestra4 = new Muestra("Vinchuca Infestans", foto, ubicacion, u2, fecha);
		muestra5 = new Muestra("Vinchuca Sordida", foto, ubicacion, u2, fecha);
		muestra6 = new Muestra("Vinchuca Infestans", foto, ubicacion, u2, fecha);
		muestra7 = new Muestra("Vinchuca Sordida", foto, ubicacion, u2, fecha);
		muestra8 = new Muestra("Vinchuca Sordida", foto, ubicacion, u2, fecha);
		muestra9 = new Muestra("Vinchuca Infestans", foto, ubicacion, u2, fecha);
		muestra10 = new Muestra("Vinchuca Guasayana", foto, ubicacion, u2, fecha);
		muestra11 = new Muestra("Vinchuca Guasayana", foto, ubicacion, u2, fecha2);
		opinion = new Opinion(muestraAjena, u, fecha, "Vinchuca Guasayana");
		opinion2 = new Opinion(muestraAjena2, u, fecha, "Vinchuca Infestans");
		opinion3 = new Opinion(muestraAjena3, u, fecha, "ninguna");
		opinion4 = new Opinion(muestraAjena4, u, fecha, "Vinchuca Guasayana");
		opinion5 = new Opinion(muestraAjena5, u, fecha, "Vinchuca Infestans");
		opinion6 = new Opinion(muestraAjena6, u, fecha, "Vinchuca Guasayana");
		opinion7 = new Opinion(muestraAjena7, u, fecha, "Vinchuca Guasayana");
		opinion8 = new Opinion(muestraAjena8, u, fecha, "Vinchuca Infestans");
		opinion9 = new Opinion(muestraAjena9, u, fecha, "Vinchuca Guasayana");
		opinion10 = new Opinion(muestraAjena10, u, fecha, "Vinchuca Guasayana");
		opinion11 = new Opinion(muestraAjena11, u, fecha, "ninguna");
		opinion12 = new Opinion(muestraAjena12, u, fecha, "Vinchuca Infestans");
		opinion13 = new Opinion(muestraAjena13, u, fecha, "Vinchuca Guasayana");
		opinion14 = new Opinion(muestraAjena14, u, fecha, "Chinche Foliada");
		opinion15 = new Opinion(muestraAjena15, u, fecha, "Vinchuca Guasayana");
		opinion16 = new Opinion(muestraAjena16, u, fecha, "Phtia-Chinche");
		opinion17 = new Opinion(muestraAjena17, u, fecha, "Vinchuca Infestans");
		opinion18 = new Opinion(muestraAjena18, u, fecha, "Vinchuca Guasayana");
		opinion19 = new Opinion(muestraAjena19, u, fecha, "imagen poco clara");
		opinion20 = new Opinion(muestraAjena20, u, fecha, "Chinche Foliada");
		opinion21 = new Opinion(muestraAjena21, u, fecha2, "imagen poco clara");

		sistema.agregarMuestra(muestra);
		sistema.agregarMuestra(muestra2);
		sistema.agregarMuestra(muestra3);
		sistema.agregarMuestra(muestra4);
		sistema.agregarMuestra(muestra5);
		sistema.agregarMuestra(muestra6);
		sistema.agregarMuestra(muestra7);
		sistema.agregarMuestra(muestra8);
		sistema.agregarMuestra(muestra9);
		sistema.agregarMuestra(muestra10);
		sistema.agregarMuestra(muestra11);

		sistema.agregarOpinion(opinion);
		sistema.agregarOpinion(opinion2);
		sistema.agregarOpinion(opinion3);
		sistema.agregarOpinion(opinion4);
		sistema.agregarOpinion(opinion5);
		sistema.agregarOpinion(opinion6);
		sistema.agregarOpinion(opinion7);
		sistema.agregarOpinion(opinion8);
		sistema.agregarOpinion(opinion9);
		sistema.agregarOpinion(opinion10);
		sistema.agregarOpinion(opinion11);
		sistema.agregarOpinion(opinion12);
		sistema.agregarOpinion(opinion13);
		sistema.agregarOpinion(opinion14);
		sistema.agregarOpinion(opinion15);
		sistema.agregarOpinion(opinion16);
		sistema.agregarOpinion(opinion17);
		sistema.agregarOpinion(opinion18);
		sistema.agregarOpinion(opinion19);
		sistema.agregarOpinion(opinion20);
		sistema.agregarOpinion(opinion21);

	}

	@Test
	public void testOpinionConAntiguedadMenorA30() {
		assertTrue(opinion.tieneMenosDe30Dias());
	}

	@Test
	public void testOpinionConAntiguedadMayorA30() {
		assertFalse(opinion21.tieneMenosDe30Dias());
	}

	@Test
	public void testMuestraConAntiguedadMenorA30() {
		assertTrue(muestra.tieneMenosDe30Dias());
	}

	@Test
	public void testMuestraConAntiguedadMayorA30() {
		assertFalse(muestra11.tieneMenosDe30Dias());
	}

	/*
	 * se agrega dos muestras y 2 opiniones con antiguedad menor a 30 dias, se
	 * espera que el usuario haya subido de categoria
	 */

	@Test
	public void testAgregarMuestraYOpinionDentroDeLos30Dias() {
		Foto foto = mock(Foto.class);
		Ubicacion ubicacion = mock(Ubicacion.class);
		Muestra muestraAjena = mock(Muestra.class);
		Muestra muestraPropia = new Muestra("Vinchuca Infestans", foto, ubicacion, u, LocalDateTime.now());
		Opinion opinionPropia = new Opinion(muestraAjena, u, LocalDateTime.now(), "ninguna");
		sistema.recategorizar();
		assertFalse(u.isExperto());
		sistema.agregarMuestra(muestraPropia);
		sistema.agregarOpinion(opinionPropia);
		sistema.recategorizar();
		assertTrue(u.isExperto());
	}

	@Test
	public void testAgregarMuestrasYOpinionesDentroDeLos30Dias() {
		Foto foto = mock(Foto.class);
		Ubicacion ubicacion = mock(Ubicacion.class);
		Muestra muestraAjena = mock(Muestra.class);
		Muestra muestraAjena2 = mock(Muestra.class);
		Opinion opinionPropia = new Opinion(muestraAjena, u, LocalDateTime.now(), "ninguna");
		Opinion opinionPropia2 = new Opinion(muestraAjena2, u, LocalDateTime.now(), "ninguna");
		Muestra muestraPropia = new Muestra("Vinchuca Infestans", foto, ubicacion, u, LocalDateTime.now());
		Muestra muestraPropia2 = new Muestra("Vinchuca Infestans", foto, ubicacion, u, LocalDateTime.now());
		assertFalse(u.isExperto());

		sistema.agregarMuestra(muestraPropia);
		sistema.agregarMuestra(muestraPropia2);

		sistema.agregarOpinion(opinionPropia);
		sistema.agregarOpinion(opinionPropia2);
		sistema.recategorizar();
		assertTrue(u.isExperto());
	}

	/*
	 * se agrega una muestra con menos de 30 dias, se espera que no haya subido a
	 * experto ya que tiene menos de 20 opiniones y con menor antiguedad de 30 dias
	 * y
	 */

	@Test
	public void testSoloAgregarMuestraConMenosDe30Dias() {
		Foto foto = mock(Foto.class);
		Ubicacion ubicacion = mock(Ubicacion.class);
		Muestra muestraPropia = new Muestra("Vinchuca Infestans", foto, ubicacion, u, LocalDateTime.now());
		assertFalse(u.isExperto());
		sistema.agregarMuestra(muestraPropia);
		sistema.recategorizar();
		assertFalse(u.isExperto());

	}

	@Test
	public void test11MuestrasConMenosDe30Dias() {
		Foto foto = mock(Foto.class);
		Ubicacion ubicacion = mock(Ubicacion.class);
		Muestra muestraPropia = new Muestra("Vinchuca Infestans", foto, ubicacion, u, LocalDateTime.now());
		assertEquals(sistema.getRecategorizador().muestrasEnviadasLosUltimos30Dias(u).size(), 10);
		sistema.agregarMuestra(muestraPropia);
		assertEquals(sistema.getRecategorizador().muestrasEnviadasLosUltimos30Dias(u).size(), 10);

	}

	@Test
	public void test21OpinionesConMenosDe30Dias() {
		Muestra muestraAjena = mock(Muestra.class);
		Opinion opinionPropia = new Opinion(muestraAjena, u, LocalDateTime.now(), "ninguna");
		assertEquals(sistema.getRecategorizador().opinionesEnviadasLosUltimos30Dias(u).size(), 20);
		sistema.agregarOpinion(opinionPropia);
		assertEquals(sistema.getRecategorizador().opinionesEnviadasLosUltimos30Dias(u).size(), 21);

	}

	@Test
	public void testSoloAgregarOpinionConMenosDe30Dias() {
		Muestra muestraAjena = mock(Muestra.class);
		Opinion opinionPropia = new Opinion(muestraAjena, u, LocalDateTime.now(), "ninguna");
		assertFalse(u.isExperto());
		sistema.agregarOpinion(opinionPropia);
		sistema.recategorizar();
		assertFalse(u.isExperto());
	}

}