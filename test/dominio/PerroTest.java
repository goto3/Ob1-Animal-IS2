/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

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
public class PerroTest {
    private Perro perro;
    public PerroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        perro = new Perro();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testConstructorSinParametros() {
        Perro unPerro = new Perro();
        assertEquals("Sin-Nombre", unPerro.getNombre());
        assertEquals(0, unPerro.getPeso(),0);
        assertEquals(0, unPerro.getAltura(),0);
        assertNull(unPerro.getFoto());
        assertEquals("Sin-Comentarios", unPerro.getComentarios());
    }
    
     @Test
    public void testConstructorPorParametros() {
        Perro unPerro = new Perro("Rasta", 1.1, 2.3, "Es rubio");
        assertEquals("Rasta", unPerro.getNombre());
        assertEquals(1.1, unPerro.getAltura(), 0);
        assertEquals(2.3, unPerro.getPeso(), 0);
        assertEquals("Es rubio", unPerro.getComentarios());
        assertEquals(null, unPerro.getFoto());
    }
     @Test
    public void testConstructorPorParametrosConPesoYAlturaMenoresQue0() {
        Perro unPerro = new Perro("Rasta", -1.1, -2.3, "Es rubio");
        assertEquals("Rasta", unPerro.getNombre());
        assertEquals(0.0, unPerro.getAltura(), 0);
        assertEquals(0.0, unPerro.getPeso(), 0);
        assertEquals("Es rubio", unPerro.getComentarios());
        assertEquals(null, unPerro.getFoto());
    }
    
     @Test
    public void testConstructorPorParametrosConNombreYComentariosVacios() {
        Perro unPerro = new Perro("", -1.1, -2.3, "");
        assertEquals("Sin-Nombre", unPerro.getNombre());
        assertEquals(0.0, unPerro.getAltura(), 0);
        assertEquals(0.0, unPerro.getPeso(), 0);
        assertEquals("Sin-Comentarios", unPerro.getComentarios());
        assertEquals(null, unPerro.getFoto());
    }
    
    @Test
    public void testSetNombre(){
        perro.setNombre("Rasta");
        assertEquals("Rasta", perro.getNombre());
    }
    
    @Test
    public void testSetNombreVacio(){
        perro.setNombre("");
        assertEquals("Sin-Nombre", perro.getNombre());
    }
    
     @Test
    public void testSetComentarios(){
        perro.setComentarios("Es rubio");
        assertEquals("Es rubio", perro.getComentarios());
    }
    
    @Test
    public void testSetComentariosVacio(){
        perro.setComentarios("");
        assertEquals("Sin-Comentarios", perro.getComentarios());
    }
    @Test
    public void testSetRutaFoto(){
        ImageIcon imagen = new ImageIcon("/interfaz.images/perro.png");
        perro.setFoto(imagen);
        assertEquals(imagen, perro.getFoto());
    }
    
    @Test
    public void testSetRutaFotoVacia(){
        perro.setFoto(null);
        assertEquals(null, perro.getFoto());
    }
    
    @Test
    public void testToString(){
        String resToString = perro.toString();
        String nombre = perro.getNombre();
        double altura = perro.getAltura();
        double peso = perro.getPeso();
        String comentarios = perro.getComentarios();
        assertEquals("Perro{" + "nombre=" + nombre + ", altura=" + altura + ", peso=" + peso + ", comentarios=" + comentarios + '}', resToString);
    }
}
