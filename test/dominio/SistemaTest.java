/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.modelo.personas.Usuario;
import excepciones.AnimalException;
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
        assertTrue(sis.getActividades().isEmpty());
        assertTrue(sis.getPadrinos().isEmpty());
        assertTrue(sis.getAnimales().isEmpty());
        assertTrue(sis.getResponsables().isEmpty());
        assertTrue(sis.getVeterinarias().isEmpty());
    }
    
    @Test
    public void loadUsersTest() throws AnimalException{
        sis.loadUsers();
        assertEquals(2, sis.getUsuarios().size());
    }
    
    @Test
    public void logInTestExistentUser(){
        Usuario usuario1 = new Usuario("nombre1", "apellido1", 
                "email1@mail.com", "password1");
        sis.getUsuarios().add(usuario1);
        assertTrue(sis.logIn(usuario1));
    }
    
    @Test
    public void logInTestInexistentUser(){
        Usuario usuario1 = new Usuario("Pedro", "apellido1", 
                "pedro@mail.com", "password1");
        assertFalse(sis.logIn(usuario1));
    }
    
//    @Test
//    public void listaActividadesPorFechaExisten() {
//       Animal unGato = new Animal("Joaco", "Gato", 1, 2, "Es siames");
//        Responsable personaResponsable = new Responsable("Pedro", "Rodriguez", 
//                "pr@gmail.com");
//        LocalDateTime fecha1 = LocalDateTime.of(2019, Month.MARCH, 2, 17, 0);
//        Alimentacion alim = new Alimentacion("Alimentar gato", unGato, personaResponsable,
//                fecha1, 40, "Comida gato");
//        Animal unPerro = new Animal("Joaco", "perro", 1, 2, "Es marron");
//        LocalDateTime fecha2 = LocalDateTime.of(2019, Month.MARCH, 2, 19, 0);
//        OtraActividad act = new OtraActividad("Bañar perro", unPerro, personaResponsable, 
//             fecha1, 20);
//        sis.getActividades().add(act);
//        sis.getActividades().add(alim);
//        LocalDate date = LocalDate.of(2019, Month.MARCH, 2);
//        List<Actividad> activsPorFecha = sis.listaActividadesPorFecha(date);
//        assertTrue(activsPorFecha.contains(act));
//        assertTrue(activsPorFecha.contains(alim));
//        assertEquals(2, activsPorFecha.size());
//    }
//    
//    @Test
//    public void listaActividadesPorFechaVacia() {
//       Animal unGato = new Animal("Joaco", "Gato", 1, 2, "Es siames");
//        Responsable personaResponsable = new Responsable("Pedro", "Rodriguez", 
//                "pr@gmail.com");
//        LocalDateTime fecha1 = LocalDateTime.of(2019, Month.MARCH, 2, 17, 0);
//        Alimentacion alim = new Alimentacion("Alimentar gato", unGato, personaResponsable,
//                fecha1, 40, "Comida gato");
//        Animal unPerro = new Animal("Joaco", "perro", 1, 2, "Es marron");
//        LocalDateTime fecha2 = LocalDateTime.of(2019, Month.MARCH, 2, 19, 0);
//        OtraActividad act = new OtraActividad("Bañar perro", unPerro, personaResponsable, 
//             fecha1, 20);
//        sis.getActividades().add(act);
//        sis.getActividades().add(alim);
//        LocalDate date = LocalDate.of(2019, Month.MARCH, 3);
//        List<Actividad> activsPorFecha = sis.listaActividadesPorFecha(date);
//        assertEquals(0, activsPorFecha.size());
//    }
}
