/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.modelo.Animal;
import dominio.modelo.Veterinaria;
import dominio.modelo.Actividad;
import dominio.modelo.actividades.VisitaVeterinaria;
import dominio.modelo.personas.Responsable;
import excepciones.AnimalException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VeterinariaTest {

    private Veterinaria vet;

    public VeterinariaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        LocalTime inicio = LocalTime.of(9, 30);
        LocalTime fin = LocalTime.of(17, 30);
        vet = new Veterinaria("ANIMALS", inicio, fin);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorConParametrosTest() {
        LocalTime inicio = LocalTime.of(9, 30);
        LocalTime fin = LocalTime.of(17, 30);
        assertEquals("ANIMALS", vet.getNombre());
        assertEquals(new ArrayList<>(), vet.getActividadesAgendadas());
        assertEquals(inicio, vet.getHoraInicio());
        assertEquals(fin, vet.getHoraFin());
    }

    @Test
    public void eliminarActividadAgendada() throws AnimalException {
        Animal unPerro = new Animal("Rasta", "Perro", 1, 2, "Es rubio");
        LocalDateTime fecha1 = LocalDateTime.of(2019, Month.MARCH, 2, 17, 0);
        Responsable personaResponsable = new Responsable("Pedro", "Rodriguez", 
                "pr@gmail.com");
        VisitaVeterinaria visitaVet = new VisitaVeterinaria("Chequeo perro", unPerro, 
                personaResponsable,fecha1, 30, vet,"Chequeo anual");
        vet.getActividadesAgendadas().add(visitaVet);
        vet.EliminarActividadAgendada(visitaVet);
        assertEquals(false , vet.getActividadesAgendadas().contains(visitaVet));
    }

    @Test
    public void testToString() {
        String nombre = vet.getNombre();
        ArrayList<Actividad> actividadesAgendadas = vet.getActividadesAgendadas();
        LocalTime horaInicial = vet.getHoraInicio();
        LocalTime horaFinal = vet.getHoraFin();
        String resToString = vet.toString();
        assertEquals(vet.getNombre(), "ANIMALS");
    }
}
