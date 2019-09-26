/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.time.LocalTime;
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
public class PaseoTest {

    private Paseo paseo;

    public PaseoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        paseo = new Paseo();
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
        Paseo unPaseo = new Paseo();
        assertEquals("Sin-Nombre", unPaseo.getNombre());
        assertEquals(0, unPaseo.getDistancia(), 0);
        assertEquals(false, unPaseo.getFueRealizado());
        assertNull(unPaseo.getRuta());
    }

    @Test
    public void testConstructorPorParametros() {
        Usuario usuario = new Usuario();
        Perro perro = new Perro();
        LocalTime time = LocalTime.now();
        Fecha fecha = new Fecha();
        Paseo unPaseo = new Paseo("Nombre", usuario, perro, 0, true, time, fecha);
        assertEquals(fecha, unPaseo.getFecha());
        assertEquals(time, unPaseo.getHora());
        assertEquals("Nombre", unPaseo.getNombre());
        assertEquals(usuario, unPaseo.getUsuario());
        assertEquals(perro, unPaseo.getMascota());
        assertEquals(true, unPaseo.getFueRealizado());
        assertEquals(0, unPaseo.getDistancia(), 0.0);
    }

    @Test
    public void testConstructorPorParametrosVacio() {
        Usuario usuario = new Usuario();
        Perro perro = new Perro();
        LocalTime time = LocalTime.now();
        Fecha fecha = new Fecha();
        Paseo unPaseo = new Paseo("", usuario, perro, 0, true, time, fecha);
        assertEquals(fecha, unPaseo.getFecha());
        assertEquals(time, unPaseo.getHora());
        assertEquals("Sin-Nombre", unPaseo.getNombre());
        assertEquals(usuario, unPaseo.getUsuario());
        assertEquals(perro, unPaseo.getMascota());
        assertEquals(true, unPaseo.getFueRealizado());
        assertEquals(0, unPaseo.getDistancia(), 0.0);
    }

    @Test
    public void testSetRuta() {
        ImageIcon imagen = new ImageIcon("/interfaz.images/perro.png");
        paseo.setRuta(imagen);
        assertEquals(imagen, paseo.getRuta());
    }

    @Test
    public void testSetHora() {
        LocalTime time = LocalTime.now();
        paseo.setHora(time);
        assertEquals(time, paseo.getHora());
    }

    @Test
    public void testSetDistanciaPositiva() {
        paseo.setDistancia(2.3);
        assertEquals(2.3, paseo.getDistancia(), 0.0);
    }

    @Test
    public void testSetDistanciaCero() {
        paseo.setDistancia(0);
        assertEquals(0, paseo.getDistancia(), 0.0);
    }

    @Test
    public void testSetDistanciaNegativa() {
        paseo.setDistancia(-2.3);
        assertEquals(0.0, paseo.getDistancia(), 0.0);
    }

    @Test
    public void testSetReesponsable() {
        Usuario usuario = new Usuario();
        paseo.setUsuario(usuario);
        assertEquals(usuario, paseo.getUsuario());
    }

    @Test
    public void testSetMascota() {
        Perro perro = new Perro();
        paseo.setMascota(perro);
        assertEquals(perro, paseo.getMascota());
    }

    @Test
    public void testSetFueRealizadoTrue() {
        paseo.setFueRealizado(true);
        assertTrue(paseo.getFueRealizado());
    }

    @Test
    public void testSetFueRealizadoFalse() {
        paseo.setFueRealizado(false);
        assertTrue(!paseo.getFueRealizado());
    }

    @Test
    public void testSetFecha() {
        Fecha fecha = new Fecha();
        paseo.setFecha(fecha);
        assertEquals(fecha, paseo.getFecha());
    }

    @Test
    public void testSetNombre() {
        paseo.setNombre("Nombre");
        assertEquals("Nombre", paseo.getNombre());
    }

    @Test
    public void testSetNombreVacio() {
        paseo.setNombre("");
        assertEquals("Sin-Nombre", paseo.getNombre());
    }

    @Test
    public void testToString() {
        Usuario responsable = paseo.getUsuario();
        Perro perro = paseo.getMascota();
        double distancia = paseo.getDistancia();
        boolean fueRealizado = paseo.getFueRealizado();
        LocalTime hora = paseo.getHora();
        Fecha fecha = paseo.getFecha();
        String nombre = paseo.getNombre();
        String resString = paseo.toString();
        assertEquals("Paseo{" + "responsable=" + responsable + ", perro=" + perro + ", distancia=" + distancia + ", fueRealizado=" + fueRealizado + ", hora=" + hora + ", fecha=" + fecha + ", nombre=" + nombre + '}', resString);
    }
}
