package dominio;

import dominio.modelo.Animal;
import dominio.tools.EstadoAnimal;
import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalTest {

    private Animal animal;

    public AnimalTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        animal = new Animal("Perro", "Rasta", 1, 2, "Es rubio");
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testEnumEstadoAnimal() {
        assertEquals(EstadoAnimal.valueOf("NO_ADOPTABLE"), EstadoAnimal.NO_ADOPTABLE);
        assertEquals(EstadoAnimal.valueOf("SIN_ADOPTAR"), EstadoAnimal.SIN_ADOPTAR);
        assertEquals(EstadoAnimal.valueOf("ADOPTADO"), EstadoAnimal.ADOPTADO);
    }

    @Test
    public void testConstructorPorParametros() {
        Animal unPerro = new Animal("Rasta", "Perro", 1, 2, "Es rubio");
        assertEquals("Rasta", unPerro.getNombre());
        assertEquals("Perro", unPerro.getTipo());
        assertEquals(1, unPerro.getAltura());
        assertEquals(2, unPerro.getPeso());
        assertEquals("Es rubio", unPerro.getComentarios());
        assertEquals(null, unPerro.getFoto());
        assertEquals(EstadoAnimal.NO_ADOPTABLE, unPerro.getEstado());
    }

    @Test
    public void testSetEstado() {
        animal.setEstado(EstadoAnimal.SIN_ADOPTAR);
        assertEquals(EstadoAnimal.SIN_ADOPTAR, animal.getEstado());
    }

    @Test
    public void testSetRutaFoto() {
        ImageIcon imagen = new ImageIcon("/interfaz.images/perroFoto.png");
        animal.setFoto(imagen);
        assertEquals(imagen, animal.getFoto());
    }

    @Test
    public void testSetRutaFotoVacia() {
        animal.setFoto(null);
        assertEquals(null, animal.getFoto());
    }

    @Test
    public void testToString() {
        assertEquals(animal.getTipo() + " - " + animal.getNombre(),
                 animal.toString());
    }

    @Test
    public void setNombre() {
        animal.setNombre("Juanjo");
        assertEquals(animal.getNombre(), "Juanjo");
    }

    @Test
    public void setComentario() {
        animal.setComentarios("Es marron");
        assertEquals(animal.getComentarios(), "Es marron");
    }

    @Test
    public void setTipo() {
        animal.setTipo("Gato");
        assertEquals(animal.getTipo(), "Gato");
    }

    @Test
    public void setAltura() {
        animal.setAltura(15);
        assertEquals(animal.getAltura(), 15);
    }

    @Test
    public void setPeso() {
        animal.setPeso(15);
        assertEquals(animal.getPeso(), 15);
    }

}
