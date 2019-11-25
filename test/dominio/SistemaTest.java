/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.modelo.Animal;
import dominio.modelo.Veterinaria;
import dominio.modelo.actividades.OtraActividad;
import dominio.modelo.Actividad;
import dominio.modelo.personas.Adoptante;
import dominio.modelo.personas.Padrino;
import dominio.modelo.personas.Responsable;
import dominio.modelo.personas.Usuario;
import dominio.tools.Moneda;
import dominio.tools.Pago;
import dominio.tools.Periodo;
import excepciones.AnimalException;
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
        sis.returnEmptyLists();
        assertTrue(sis.getActividades().isEmpty());
        assertTrue(sis.getPadrinos().isEmpty());
        assertTrue(sis.getAnimales().isEmpty());
        assertTrue(sis.getResponsables().isEmpty());
        assertTrue(sis.getVeterinarias().isEmpty());
        assertTrue(sis.getAdoptantes().isEmpty());
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
    
    @Test
    public void addPersonaAdoptante(){
        Adoptante adoptante = new Adoptante("Pedro", "Gonzalez", "pg@gmail.com", 
                "099123456");
         sis.addPersona(adoptante);
        assertEquals(sis.getPersona(adoptante.getId(), "Adoptante"), adoptante);
    }
    
    @Test
    public void addPersonaResponsable(){
        Responsable res = new Responsable("Pedro","Gonzalez", "pedro12@gmail.com");
        sis.addPersona(res);
        assertEquals(sis.getPersona(res.getId(), "Responsable"), res);
    }
    
    @Test
    public void addPersonaPadrino(){
         Padrino padrino = new Padrino("Pedro","González", "pedro12@gmail.com",
                 "098 775 234", "Montevideo", "Uruguay", Pago.TARJETA_CREDITO, 
                Periodo.MENSUAL, Moneda.DOLARES,300);
        sis.addPersona(padrino);
        assertEquals(sis.getPersona(padrino.getId(), "Padrino"), padrino);
    }
    
    @Test
    public void addAnimal(){
        Animal unPerro = new Animal("Rasta", "Perro", 1, 2, "Es rubio");
        sis.addAnimal(unPerro);
        assertEquals(1 ,sis.getAnimales().size());
    }
    
    @Test
    public void addActividad(){
       Animal unPerro = new Animal("Joaco", "perro", 1, 2, "Es marron");
       Responsable personaResponsable = new Responsable("Pedro", "Rodriguez", 
                "pr@gmail.com");
       LocalDateTime fecha1 = LocalDateTime.of(2019, Month.MARCH, 2, 17, 0);
       Actividad act = new OtraActividad("Bañar perro", unPerro, personaResponsable, 
            fecha1, 20);
       sis.addActividad(act);
       assertEquals(1, sis.getActividades().size());
    }
    
    @Test
    public void addVeterinaria(){
        LocalTime inicio = LocalTime.of(9, 30);
        LocalTime fin = LocalTime.of(17, 30);
        Veterinaria vet = new Veterinaria("ANIMALS", inicio, fin);
        sis.addVeterinaria(vet);
        assertEquals(1, sis.getVeterinarias().size());
    }
    
    @Test
    public void getAnimalPorId(){
        Animal unPerro = new Animal("Rasta", "Perro", 1, 2, "Es rubio");
        sis.addAnimal(unPerro);
        Animal animalRetornado = sis.getAnimal(unPerro.getId());
        assertEquals(animalRetornado,unPerro);
    }
    
    @Test
    public void getVeterinariadPorNombre(){
        LocalTime inicio = LocalTime.of(9, 30);
        LocalTime fin = LocalTime.of(17, 30);
        Veterinaria vet = new Veterinaria("ANIMALES SANOS", inicio, fin);
        sis.addVeterinaria(vet);
        Veterinaria vetRetornada = sis.getVeterinaria("ANIMALES SANOS");
        assertEquals(vet, vetRetornada);
    }
    
    @Test
    public void getResponsablePorId(){
        Responsable personaResponsable = new Responsable("Pedro", "Rodriguez", 
                "pr@gmail.com");
        sis.addPersona(personaResponsable);
        Responsable resRetornado = sis.getResponsable(personaResponsable.getId());
        assertEquals(personaResponsable, resRetornado);
    }
    
    
    
}
