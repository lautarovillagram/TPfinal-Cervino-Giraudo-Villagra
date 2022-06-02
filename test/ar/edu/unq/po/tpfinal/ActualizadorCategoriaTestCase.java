package ar.edu.unq.po.tpfinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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

	private Usuario u;

	@BeforeEach
	public void SetUp() {
		LocalDateTime fecha = LocalDateTime.now();
		Ubicacion ubicacion = mock(Ubicacion.class);
		Foto foto = mock(Foto.class);

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
		
		
		

	}

}
