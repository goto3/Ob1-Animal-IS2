/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.modelo.Animal;
import dominio.modelo.personas.Adoptante;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sebaban99
 */
public class AdoptanteTest {
    private Adoptante adoptante;
    
     public AdoptanteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        adoptante = new Adoptante("Pedro", "Gonzalez", "pg@gmail.com", 
                "099123456");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorConParametrosTest(){
        assertEquals("Pedro", adoptante.getNombre());
        assertEquals("Gonzalez", adoptante.getApellido());
        assertEquals("pg@gmail.com", adoptante.getEmail());
        assertEquals("099123456", adoptante.getTelefono());
    }
    
    @Test
    public void agregarAnimalTest() {
        Animal unGato = new Animal("Joaco", "Gato", 1, 2, "Es siames");
        adoptante.addAnimal(unGato);
        assertEquals(true, adoptante.getAnimales().contains(unGato));
        assertEquals(1, adoptante.getAnimales().size());
    }
}
