/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.modelo.Persona;
import dominio.modelo.Animal;
import dominio.modelo.actividades.Alimentacion;
import dominio.modelo.personas.Responsable;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marce
 */
public class AlimentacionTest {

    private Alimentacion alimentacion;

    public AlimentacionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Animal unGato = new Animal("Joaco", "Gato", 1, 2, "Es siames");
        Responsable personaResponsable = new Responsable("Pedro", "Rodriguez", 
                "pr@gmail.com");
        LocalDateTime fecha1 = LocalDateTime.of(2019, Month.MARCH, 2, 17, 0);
        alimentacion = new Alimentacion("Alimentar gato", unGato, personaResponsable,
                fecha1, 40, "Comida gato");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstructorConParametros() {
        Animal unGato = new Animal("Joaco", "Gato", 1, 2, "Es siames");
        Responsable personaResponsable = new Responsable("Pedro", "Rodriguez", 
                "pr@gmail.com");
        LocalDateTime fecha1 = LocalDateTime.of(2019, Month.MARCH, 2, 17, 0);
        assertEquals("Alimentar gato", alimentacion.getNombre());
        assertEquals(unGato.getNombre(), alimentacion.getMascota().getNombre());
        assertEquals(unGato.getTipo(), alimentacion.getMascota().getTipo());
        assertEquals(unGato.getComentarios(), 
                alimentacion.getMascota().getComentarios());
        assertEquals(personaResponsable.getEmail(), 
                alimentacion.getUsuario().getEmail());
        assertEquals(fecha1, alimentacion.getFechaHora());
        assertEquals(40, alimentacion.getDuracion());
    }

    @Test
    public void testToString() {
        Persona responsable = alimentacion.getUsuario();
        Animal mascota = alimentacion.getMascota();
        String tipoAlimento = alimentacion.getTipoAlimento();
        boolean fueRealizado = alimentacion.getFueRealizado();
        String nombre = alimentacion.getNombre();
        assertEquals("Alimentacion{" + "responsable = " + responsable +
                ", mascota = " + mascota + ", tipoAlimento = " + tipoAlimento +
                ", fueRealizado = " + fueRealizado + ", nombre = " + nombre + '}'
                , alimentacion.toString());
    }
}
