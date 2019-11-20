/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author marce
 */
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
}
