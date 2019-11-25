package dominio;

import dominio.modelo.Animal;
import dominio.modelo.personas.Adoptante;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
    
    @Test
    public void setListaAnimalesTest() {
        ArrayList<Animal> lista = new ArrayList<>();
        adoptante.setAnimales(lista);
        assertEquals(lista, adoptante.getAnimales());
    }
    
    @Test
    public void setTelefono() {
        adoptante.setTelefono("099 123 456");
        assertEquals("099 123 456", adoptante.getTelefono());
    }
}
