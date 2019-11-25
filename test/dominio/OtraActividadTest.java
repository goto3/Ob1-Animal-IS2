package dominio;

import dominio.modelo.Animal;
import dominio.modelo.actividades.OtraActividad;
import dominio.modelo.personas.Responsable;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class OtraActividadTest {
    
    private OtraActividad act;
    public OtraActividadTest() {
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
        LocalDateTime fecha1 = LocalDateTime.of(2019, Month.MARCH, 2, 17, 0);
        act = new OtraActividad("Bañar perro", unPerro, personaResponsable, 
             fecha1, 20);
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
        assertEquals("Bañar perro", act.getNombre());
         assertEquals(unPerro.getNombre(), act.getMascota().getNombre());
        assertEquals(unPerro.getTipo(), act.getMascota().getTipo());
        assertEquals(unPerro.getComentarios(), 
                act.getMascota().getComentarios());
        assertEquals(personaResponsable.getEmail(), 
                act.getUsuario().getEmail());
        assertEquals(fecha1, act.getFechaHora());
        assertEquals(20, act.getDuracion());
    }
    
    @Test
    public void testToString() {
        assertEquals("ActividadCualquiera{" + "responsable = " + act.getUsuario() 
                + ", mascota = " + act.getMascota() + ", fueRealizado = " + 
                act.getFueRealizado() + 
                ", fecha = " + act.getFechaHora() + ", nombre = " + act.getNombre() + 
                '}', act.toString());
    }
    
    @Test
    public void setNombreActividad() {
        act.setNombre("Jugar");
        assertEquals(act.getNombre(), "Jugar");
    }
    
    @Test
    public void setDuracionActividad() {
        act.setDuracion(10);
        assertEquals(act.getDuracion(), 10);
    }
    
    @Test
    public void setFechaHoraActividad() {
        LocalDateTime fecha1 = LocalDateTime.of(2019, Month.MARCH, 2, 15, 0);
        act.setFechaHora(fecha1);
        assertEquals(act.getFechaHora(), fecha1);
    }
    
    @Test
    public void setFueRealizadoActividad() {
        act.setFueRealizado(true);
        assertEquals(act.getFueRealizado(), true);
    }
    
    @Test
    public void setMascotaActividad() {
        Animal perro = new Animal("Perro", "Rasta", 1, 2, "Es rubio");
        act.setMascota(perro);
        assertEquals(act.getMascota(), perro);
    }
    
    @Test
    public void setUsuarioActividad() {
        Responsable res = new Responsable("Pedro","Gonzalez", "pedro12@gmail.com");
        act.setUsuario(res);
        assertEquals(act.getUsuario(), res);
    }
}
