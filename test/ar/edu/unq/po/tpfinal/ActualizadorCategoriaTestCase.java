package ar.edu.unq.po.tpfinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

public class ActualizadorCategoriaTestCase {
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
	private ActualizadorDeCategoria observer;

	private UsuarioRegular u;
	private UsuarioRegular u2;

	@BeforeEach
	public void SetUp() {
		LocalDateTime fecha = LocalDateTime.now().minusDays(7);
		LocalDateTime fecha2 = LocalDateTime.now().minusDays(60);
		Ubicacion ubicacion = mock(Ubicacion.class);
		Foto foto = mock(Foto.class);
		UsuarioRegular u2 = mock(UsuarioRegular.class);
		Muestra muestraAjena = mock(Muestra.class);
		Muestra muestraAjena2 = mock(Muestra.class);
		ActualizadorDeCategoria observador = new ActualizadorDeCategoria();
		u = new UsuarioRegular();
		u.setObservador(observador);
		observador.setObservable(u);

		muestra = new Muestra("Vinchuca Infestans", foto, ubicacion, u, fecha);
		muestra2 = new Muestra("Vinchuca Sordida", foto, ubicacion, u, fecha);
		muestra3 = new Muestra("Vinchuca Guasayana", foto, ubicacion, u, fecha);
		muestra4 = new Muestra("Vinchuca Infestans", foto, ubicacion, u, fecha);
		muestra5 = new Muestra("Vinchuca Sordida", foto, ubicacion, u, fecha);
		muestra6 = new Muestra("Vinchuca Infestans", foto, ubicacion, u, fecha);
		muestra7 = new Muestra("Vinchuca Sordida", foto, ubicacion, u, fecha);
		muestra8 = new Muestra("Vinchuca Sordida", foto, ubicacion, u, fecha);
		muestra9 = new Muestra("Vinchuca Infestans", foto, ubicacion, u, fecha);
		muestra10 = new Muestra("Vinchuca Guasayana", foto, ubicacion, u, fecha);
		muestra11 = new Muestra("Vinchuca Guasayana", foto, ubicacion, u, fecha2);
		opinion = new Opinion(muestraAjena, u, fecha, "Vinchuca Guasayana", false);
		opinion2 = new Opinion(muestraAjena, u, fecha, "Vinchuca Infestans", false);
		opinion3 = new Opinion(muestraAjena, u, fecha, "ninguna", false);
		opinion4 = new Opinion(muestraAjena, u, fecha, "Vinchuca Guasayana", false);
		opinion5 = new Opinion(muestraAjena, u, fecha, "Vinchuca Infestans", false);
		opinion6 = new Opinion(muestraAjena, u, fecha, "Vinchuca Guasayana", false);
		opinion7 = new Opinion(muestraAjena, u, fecha, "Vinchuca Guasayana", false);
		opinion8 = new Opinion(muestraAjena, u, fecha, "Vinchuca Infestans", false);
		opinion9 = new Opinion(muestraAjena, u, fecha, "Vinchuca Guasayana", false);
		opinion10 = new Opinion(muestraAjena, u, fecha, "Vinchuca Guasayana", false);
		opinion11 = new Opinion(muestraAjena, u, fecha, "ninguna", false);
		opinion12 = new Opinion(muestraAjena, u, fecha, "Vinchuca Infestans", false);
		opinion13 = new Opinion(muestraAjena, u, fecha, "Vinchuca Guasayana", false);
		opinion14 = new Opinion(muestraAjena, u, fecha, "chinche foliada", false);
		opinion15 = new Opinion(muestraAjena, u, fecha, "Vinchuca Guasayana", false);
		opinion16 = new Opinion(muestraAjena, u, fecha, "phtia-chinche", false);
		opinion17 = new Opinion(muestraAjena, u, fecha, "Vinchuca Infestans", false);
		opinion18 = new Opinion(muestraAjena, u, fecha, "Vinchuca Guasayana", false);
		opinion19 = new Opinion(muestraAjena, u, fecha, "imagen poco clara", false);

		u.agregarMuestraEnviada(muestra);
		u.agregarMuestraEnviada(muestra2);
		u.agregarMuestraEnviada(muestra3);
		u.agregarMuestraEnviada(muestra4);
		u.agregarMuestraEnviada(muestra5);
		u.agregarMuestraEnviada(muestra6);
		u.agregarMuestraEnviada(muestra7);
		u.agregarMuestraEnviada(muestra8);
		u.agregarMuestraEnviada(muestra9);
		u.agregarMuestraEnviada(muestra10);

		/*
		 * se agregan las opiniones omitiendo el opinarMuestra, ya que al ser todas
		 * sobre el mismo mock la logica de opinarMuestra no permitiria agregarlas
		 */
		u.agregarOpinionEnviada(opinion);
		u.agregarOpinionEnviada(opinion2);
		u.agregarOpinionEnviada(opinion3);
		u.agregarOpinionEnviada(opinion4);
		u.agregarOpinionEnviada(opinion5);
		u.agregarOpinionEnviada(opinion6);
		u.agregarOpinionEnviada(opinion7);
		u.agregarOpinionEnviada(opinion8);
		u.agregarOpinionEnviada(opinion9);
		u.agregarOpinionEnviada(opinion10);
		u.agregarOpinionEnviada(opinion11);
		u.agregarOpinionEnviada(opinion12);
		u.agregarOpinionEnviada(opinion13);
		u.agregarOpinionEnviada(opinion14);
		u.agregarOpinionEnviada(opinion15);
		u.agregarOpinionEnviada(opinion16);
		u.agregarOpinionEnviada(opinion17);
		u.agregarOpinionEnviada(opinion18);
		u.agregarOpinionEnviada(opinion19);

	}

	/*
	 * se agrega una muestra y 2 opiniones con antiguedad menor a 30 dias, se espera
	 * que el usuario haya subido de categoria
	 */
	@Test
	public void testMuestrasYOpinionesDentroDeLos30Dias() {
		Foto foto = mock(Foto.class);
		Ubicacion ubicacion = mock(Ubicacion.class);
		Muestra muestraAjena = mock(Muestra.class);
		Muestra muestraAjena2 = mock(Muestra.class);
		assertFalse(u.isSubioAExperto());
		u.cargarMuestra("Vinchuca Infestans", foto, ubicacion);

		u.opinarMuestra(muestraAjena, "ninguna");
		u.opinarMuestra(muestraAjena2, "Vinchuca Sordida");
		assertTrue(u.isSubioAExperto());
	}

	@Test
	public void testUnaMuestraConMasDe30Dias() {

		Muestra muestraAjena = mock(Muestra.class);
		Muestra muestraAjena2 = mock(Muestra.class);
		assertFalse(u.isSubioAExperto());
		u.agregarMuestraEnviada(muestra11);
		u.opinarMuestra(muestraAjena, "ninguna");
		u.opinarMuestra(muestraAjena2, "Vinchuca Sordida");
		assertFalse(u.isSubioAExperto());

	}

}
