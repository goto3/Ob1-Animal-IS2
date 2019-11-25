package dominio;

import dominio.modelo.Animal;
import dominio.modelo.actividades.Paseo;
import dominio.modelo.personas.Responsable;
import java.time.LocalDateTime;
import java.time.Month;
import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaseoTest {

    private Paseo paseo;

    public PaseoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Animal unPerro = new Animal("Joaco", "perro", 1, 2, "Es marron");
        Responsable personaResponsable = new Responsable("Pedro", "Rodriguez", 
                "pr@gmail.com");
        ImageIcon imagen = new ImageIcon("/interfaz.images/rutaPorDefecto.png");
        LocalDateTime fecha1 = LocalDateTime.of(2019, Month.MARCH, 2, 17, 0);
        paseo = new Paseo("Paseo perro", unPerro, personaResponsable, 
             fecha1, 20, 3, imagen);
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testConstructorConParametros() {
        Animal unPerro = new Animal("Joaco", "perro", 1, 2, "Es marron");
        Responsable personaResponsable = new Responsable("Pedro", "Rodriguez", 
                "pr@gmail.com");
        LocalDateTime fecha1 = LocalDateTime.of(2019, Month.MARCH, 2, 17, 0);
        assertEquals("Paseo perro", paseo.getNombre());
        assertEquals(unPerro.getNombre(), paseo.getMascota().getNombre());
        assertEquals(unPerro.getTipo(), paseo.getMascota().getTipo());
        assertEquals(unPerro.getComentarios(), 
                paseo.getMascota().getComentarios());
        assertEquals(personaResponsable.getEmail(), 
                paseo.getUsuario().getEmail());
        assertEquals(fecha1, paseo.getFechaHora());
        assertEquals(20, paseo.getDuracion());
        assertEquals(3, paseo.getDistancia());
    }

    @Test
    public void testToString() {
        assertEquals("Paseo{" + "responsable=" + paseo.getUsuario() + 
                ", mascota = " + paseo.getMascota() + ", distancia=" + 
                paseo.getDistancia() + ", fueRealizado=" +
                paseo.getFueRealizado() +
                ", fecha=" + paseo.getFechaHora() + 
                ", nombre=" + paseo.getNombre() + '}', 
                paseo.toString());
    }
}
