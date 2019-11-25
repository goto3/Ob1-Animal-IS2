/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.modelo.Animal;
import dominio.modelo.Veterinaria;
import dominio.modelo.actividades.VisitaVeterinaria;
import dominio.modelo.personas.Responsable;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
public class VisitaVeterinariaTest {

    private VisitaVeterinaria visita;

    public VisitaVeterinariaTest() {
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
        LocalTime inicio = LocalTime.of(9, 30);
        LocalTime fin = LocalTime.of(17, 30);
        Veterinaria vet = new Veterinaria("ANIMALS", inicio, fin);
        LocalDateTime fecha1 = LocalDateTime.of(2019, Month.MARCH, 2, 17, 0);
        visita = new VisitaVeterinaria("Chequeo perro", unPerro, 
                personaResponsable, fecha1, 30, vet,"Chequeo anual");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstructorPorParametros() {
        Animal unPerro = new Animal("Joaco", "perro", 1, 2, "Es marron");
        Responsable personaResponsable = new Responsable("Pedro", "Rodriguez", 
                "pr@gmail.com");
        LocalTime inicio = LocalTime.of(9, 30);
        LocalTime fin = LocalTime.of(17, 30);
        Veterinaria vet = new Veterinaria("ANIMALS", inicio, fin);
        LocalDateTime fecha1 = LocalDateTime.of(2019, Month.MARCH, 2, 17, 0);
        
        assertEquals("Chequeo perro", visita.getNombre());
        assertEquals(unPerro.getNombre(), visita.getMascota().getNombre());
        assertEquals(unPerro.getTipo(), visita.getMascota().getTipo());
        assertEquals(unPerro.getComentarios(), 
                visita.getMascota().getComentarios());
        assertEquals(personaResponsable.getEmail(), 
                visita.getUsuario().getEmail());
        assertEquals(fecha1, visita.getFechaHora());
        assertEquals(30, visita.getDuracion());
        assertEquals(vet.getNombre(), visita.getVeterinaria().getNombre());
        assertEquals("Chequeo anual", visita.getMotivo());
    }

    @Test
    public void testToString() {
        assertEquals("VisitaVeterinaria{" + "nombre=" + visita.getNombre() +
                ", responsable=" + visita.getUsuario() + ", mascota=" + 
                visita.getMascota() + ", fueRealizado=" + visita.getFueRealizado() +
                ", fecha = " + visita.getFechaHora() + "veterinaria=" +
                visita.getVeterinaria() + '}', visita.toString());
    }
    
    @Test
    public void setFueRealizadoTrue() {
       visita.setFueRealizado(true);
       assertEquals(true, visita.getFueRealizado());
       assertFalse(visita.getVeterinaria().getActividadesAgendadas().contains(this));
    }
}
