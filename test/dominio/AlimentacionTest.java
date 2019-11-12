/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.modelo.Persona;
import dominio.modelo.Animal;
import dominio.modelo.actividades.Alimentacion;
import dominio.modelo.usuarios.Responsable;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
public class AlimentacionTest {

    private Alimentacion alimentacion;

    public AlimentacionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        alimentacion = new Alimentacion();
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
        Alimentacion unaAlim = new Alimentacion();
        assertEquals("Sin-Nombre", unaAlim.getNombre());
        assertEquals("Sin-Tipo", unaAlim.getTipoAlimento());
        assertEquals(false, unaAlim.getFueRealizado());

    }

    @Test
    public void testConstructorPorParametros() {
        Persona responsable = new Responsable();
        Animal perro = new Animal();
        LocalTime time = LocalTime.now();
        LocalDateTime fecha = LocalDateTime.of(2019, 12, 29, 18, 30);
        Alimentacion unaAlim = new Alimentacion("Nombre", responsable, perro, "Comida", true, time, fecha, 1);
        assertEquals(fecha, unaAlim.getFechaHora());
        assertEquals(time, unaAlim.getHora());
        assertEquals("Nombre", unaAlim.getNombre());
        assertEquals(usuario, unaAlim.getUsuario());
        assertEquals(perro, unaAlim.getMascota());
        assertEquals("Comida", unaAlim.getTipoAlimento());
        assertEquals(true, unaAlim.getFueRealizado());
    }

    @Test
    public void testConstructorPorParametrosVacios() {
        Persona usuario = new Persona();
        Animal perro = new Animal();
        LocalTime time = LocalTime.now();
        Fecha fecha = new Fecha();
        Alimentacion unaAlim = new Alimentacion("", usuario, perro, "", true, time, fecha);
        assertEquals(fecha, unaAlim.getFechaHora());
        assertEquals(time, unaAlim.getHora());
        assertEquals("Sin-Nombre", unaAlim.getNombre());
        assertEquals(usuario, unaAlim.getUsuario());
        assertEquals(perro, unaAlim.getMascota());
        assertEquals("Sin-Tipo", unaAlim.getTipoAlimento());
        assertEquals(true, unaAlim.getFueRealizado());
    }

    @Test
    public void testSetResponsable() {
        Persona usuario = new Persona();
        alimentacion.setUsuario(usuario);
        assertEquals(usuario, alimentacion.getUsuario());
    }

    @Test
    public void testSetHora() {
        LocalTime time = LocalTime.now();
        alimentacion.setHora(time);
        assertEquals(time, alimentacion.getHora());
    }

    @Test
    public void testSetTipoAlimento() {
        alimentacion.setTipoAlimento("comida");
        assertEquals("comida", alimentacion.getTipoAlimento());
    }

    @Test
    public void testSetTipoAlimentoVacio() {
        alimentacion.setTipoAlimento("");
        assertEquals("Sin-Tipo", alimentacion.getTipoAlimento());
    }

    @Test
    public void testSetMascota() {
        Animal perro = new Animal();
        alimentacion.setMascota(perro);
        assertEquals(perro, alimentacion.getMascota());
    }

    @Test
    public void testSetFueRealizadoTrue() {
        alimentacion.setFueRealizado(true);
        assertTrue(alimentacion.getFueRealizado());
    }

    @Test
    public void testSetFueRealizadoFalse() {
        alimentacion.setFueRealizado(false);
        assertTrue(!alimentacion.getFueRealizado());
    }

    @Test
    public void testSetFecha() {
        Fecha fecha = new Fecha();
        alimentacion.setFecha(fecha);
        assertEquals(fecha, alimentacion.getFechaHora());
    }

    @Test
    public void testToString() {
        Persona responsable = alimentacion.getUsuario();
        Animal mascota = alimentacion.getMascota();
        String tipoAlimento = alimentacion.getTipoAlimento();
        boolean fueRealizado = alimentacion.getFueRealizado();
        LocalTime hora = alimentacion.getHora();
        Fecha fecha = alimentacion.getFechaHora();
        String nombre = alimentacion.getNombre();
        String resToString = alimentacion.toString();
        assertEquals("Alimentacion{" + "responsable=" + responsable + ", mascota=" + mascota + ", tipoAlimento=" + tipoAlimento + ", fueRealizado=" + fueRealizado + ", hora=" + hora + ", fecha=" + fecha + ", nombre=" + nombre + '}', resToString);
    }

    @Test
    public void testSetNombre() {
        alimentacion.setNombre("Nombre");
        assertEquals("Nombre", alimentacion.getNombre());
    }

    @Test
    public void testSetNombreVacio() {
        alimentacion.setNombre("");
        assertEquals("Sin-Nombre", alimentacion.getNombre());
    }

}
