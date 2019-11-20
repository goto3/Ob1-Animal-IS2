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
    public void agendarActividadNingunaAEsaHora() throws AnimalException {
        Animal unPerro = new Animal("Rasta", "Perro", 1, 2, "Es rubio");
        Animal unGato = new Animal("Joaco", "Gato", 1, 2, "Es siames");
        LocalDateTime fecha1 = LocalDateTime.of(2019, Month.MARCH, 2, 17, 0);
        LocalDateTime fecha2 = LocalDateTime.of(2019, Month.MARCH, 2, 16, 0);
        Responsable personaResponsable = new Responsable("Pedro", "Rodriguez", 
                "pr@gmail.com");
        VisitaVeterinaria visitaVet = new VisitaVeterinaria("Chequeo perro", unPerro, 
                personaResponsable, fecha1, 30, vet,"Chequeo anual");
        vet.getActividadesAgendadas().add(visitaVet);
        VisitaVeterinaria visitaVet2 = new VisitaVeterinaria("Chequeo gato", unGato, 
                personaResponsable, fecha2, 30, vet,"Chequeo anual");
        vet.agendarActividad(visitaVet2);
        assertEquals(true , vet.getActividadesAgendadas().contains(visitaVet2));
    }
    
    @Test(expected = excepciones.AnimalException.class)  
    public void agendarActividadExisteUnaAEsaHora() throws AnimalException {
        Animal unPerro = new Animal("Rasta", "Perro", 1, 2, "Es rubio");
        Animal unGato = new Animal("Joaco", "Gato", 1, 2, "Es siames");
        LocalDateTime fecha1 = LocalDateTime.of(2019, Month.MARCH, 2, 17, 0);
        LocalDateTime fecha2 = LocalDateTime.of(2019, Month.MARCH, 2, 17, 0);
        Responsable personaResponsable = new Responsable("Pedro", "Rodriguez", 
                "pr@gmail.com");
        VisitaVeterinaria visitaVet = new VisitaVeterinaria("Chequeo perro", unPerro, 
                personaResponsable, fecha1, 60, vet,"Chequeo anual");
        vet.getActividadesAgendadas().add(visitaVet);
        VisitaVeterinaria visitaVet2 = new VisitaVeterinaria("Chequeo gato", unGato, 
                personaResponsable, fecha2, 30, vet,"Chequeo anual");
        vet.agendarActividad(visitaVet2);
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
        assertEquals("Veterinaria{" + "nombre = " + nombre +
                ", actividadesAgendadas = " + actividadesAgendadas + 
                ", horaInicial = " + horaInicial + 
                ", horaFinal = " + horaFinal + '}', resToString);
    }
}
