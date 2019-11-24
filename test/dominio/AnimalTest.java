/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author marce
 */
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
    public void testSetEstado(){
        animal.setEstado(EstadoAnimal.SIN_ADOPTAR);
        assertEquals(EstadoAnimal.SIN_ADOPTAR, animal.getEstado());
    }
    
    @Test
    public void testSetRutaFoto(){
        ImageIcon imagen = new ImageIcon("/interfaz.images/perroFoto.png");
        animal.setFoto(imagen);
        assertEquals(imagen, animal.getFoto());
    }
    
    @Test
    public void testSetRutaFotoVacia(){
        animal.setFoto(null);
        assertEquals(null, animal.getFoto());
    }
//    
    @Test
    public void testToString(){
        assertEquals(animal.getTipo()+ " - " + animal.getNombre() 
                , animal.toString());
    }
}
