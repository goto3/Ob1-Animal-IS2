/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.modelo.Animal;
import dominio.modelo.Actividad;
import dominio.modelo.actividades.OtraActividad;
import dominio.modelo.actividades.Alimentacion;
import dominio.modelo.personas.Adoptante;
import dominio.modelo.personas.Responsable;
import dominio.modelo.personas.Usuario;
import dominio.tools.EstadoAnimal;
import excepciones.AnimalException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
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
public class SistemaTest {

    private Sistema sis;

    public SistemaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        sis = Sistema.getInstance();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstructorSinParametros(){
        assertEquals(new ArrayList<>(), sis.getActividades());
        assertEquals(new ArrayList<>(), sis.getPadrinos());
        assertEquals(new ArrayList<>(), sis.getAnimales());
        assertEquals(new ArrayList<>(), sis.getResponsables());
        assertEquals(new ArrayList<>(), sis.getVeterinarias());
    }
    
    @Test
    public void loadUsersTest() throws AnimalException{
        sis.loadUsers();
        Usuario usuario1 = new Usuario("nombre1", "apellido1", 
                "email1@mail.com", "password1");
        Usuario usuario2 = new Usuario("nombre2", "apellido2", 
                "email2@mail.com", "password2");
        assertTrue(sis.getUsuarios().contains(usuario1));
        assertTrue(sis.getUsuarios().contains(usuario2));
        assertEquals(2, sis.getUsuarios().size());
    }
    
    @Test
    public void logInTestExistentUser() throws AnimalException{
        Usuario usuario1 = new Usuario("nombre1", "apellido1", 
                "email1@mail.com", "password1");
        sis.getUsuarios().add(usuario1);
        assertTrue(sis.logIn(usuario1));
    }
    
    @Test
    public void logInTestInexistentUser() throws AnimalException{
        Usuario usuario1 = new Usuario("nombre1", "apellido1", 
                "email1@mail.com", "password1");
        assertFalse(sis.logIn(usuario1));
    }
    
    @Test(expected = excepciones.AnimalException.class) 
    public void adoptarAnimalTestAnimalNulo() throws AnimalException{
        Adoptante a = new Adoptante("Pedro", "Gonzalez", "pg@gmail.com", 
                "099123456");
        sis.adoptarAnimal(a, null);
    }
    
    @Test(expected = excepciones.AnimalException.class) 
    public void adoptarAnimalTestAdoptanteNulo() throws AnimalException{
        Animal unPerro = new Animal("Rasta", "Perro", 1, 2, "Es rubio");
        sis.adoptarAnimal(null, unPerro);
    }
    
    @Test(expected = excepciones.AnimalException.class) 
    public void adoptarAnimalNoAdoptableTest() throws AnimalException{
        Animal unPerro = new Animal("Rasta", "Perro", 1, 2, "Es rubio");
        Adoptante a = new Adoptante("Pedro", "Gonzalez", "pg@gmail.com", 
                "099123456");
        sis.adoptarAnimal(a, unPerro);
    }
    
    @Test(expected = excepciones.AnimalException.class) 
    public void adoptarAnimalAdoptadoTest() throws AnimalException{
        Animal unPerro = new Animal("Rasta", "Perro", 1, 2, "Es rubio");
        unPerro.setEstado(EstadoAnimal.ADOPTADO);
        Adoptante a = new Adoptante("Pedro", "Gonzalez", "pg@gmail.com", 
                "099123456");
        sis.adoptarAnimal(a, unPerro);
    }
    
    @Test
    public void adoptarAnimalSinAdoptarTest() throws AnimalException{
        Animal unPerro = new Animal("Rasta", "Perro", 1, 2, "Es rubio");
        unPerro.setEstado(EstadoAnimal.SIN_ADOPTAR);
        Adoptante a = new Adoptante("Pedro", "Gonzalez", "pg@gmail.com", 
                "099123456");
        sis.adoptarAnimal(a, unPerro);
        assertTrue(a.getAnimales().contains(unPerro));
        assertEquals(EstadoAnimal.ADOPTADO ,unPerro.getEstado());
        assertTrue(sis.getAdoptantes().contains(a));
    }
    
    @Test
    public void listaActividadesPorFechaExisten() {
       Animal unGato = new Animal("Joaco", "Gato", 1, 2, "Es siames");
        Responsable personaResponsable = new Responsable("Pedro", "Rodriguez", 
                "pr@gmail.com");
        LocalDateTime fecha1 = LocalDateTime.of(2019, Month.MARCH, 2, 17, 0);
        Alimentacion alim = new Alimentacion("Alimentar gato", unGato, personaResponsable,
                fecha1, 40, "Comida gato");
        Animal unPerro = new Animal("Joaco", "perro", 1, 2, "Es marron");
        LocalDateTime fecha2 = LocalDateTime.of(2019, Month.MARCH, 2, 19, 0);
        OtraActividad act = new OtraActividad("Bañar perro", unPerro, personaResponsable, 
             fecha1, 20);
        sis.getActividades().add(act);
        sis.getActividades().add(alim);
        LocalDate date = LocalDate.of(2019, Month.MARCH, 2);
        List<Actividad> activsPorFecha = sis.listaActividadesPorFecha(date);
        assertTrue(activsPorFecha.contains(act));
        assertTrue(activsPorFecha.contains(alim));
        assertEquals(2, activsPorFecha.size());
    }
    
    @Test
    public void listaActividadesPorFechaVacia() {
       Animal unGato = new Animal("Joaco", "Gato", 1, 2, "Es siames");
        Responsable personaResponsable = new Responsable("Pedro", "Rodriguez", 
                "pr@gmail.com");
        LocalDateTime fecha1 = LocalDateTime.of(2019, Month.MARCH, 2, 17, 0);
        Alimentacion alim = new Alimentacion("Alimentar gato", unGato, personaResponsable,
                fecha1, 40, "Comida gato");
        Animal unPerro = new Animal("Joaco", "perro", 1, 2, "Es marron");
        LocalDateTime fecha2 = LocalDateTime.of(2019, Month.MARCH, 2, 19, 0);
        OtraActividad act = new OtraActividad("Bañar perro", unPerro, personaResponsable, 
             fecha1, 20);
        sis.getActividades().add(act);
        sis.getActividades().add(alim);
        LocalDate date = LocalDate.of(2019, Month.MARCH, 3);
        List<Actividad> activsPorFecha = sis.listaActividadesPorFecha(date);
        assertEquals(0, activsPorFecha.size());
    }
}
