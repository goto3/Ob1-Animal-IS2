/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.modelo.Persona;
import dominio.modelo.Animal;
import dominio.modelo.actividades.OtraActividad;
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
public class ActividadCualquieraTest {
    
    private OtraActividad actividad;
    public ActividadCualquieraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        actividad = new OtraActividad();
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
        OtraActividad unaAct = new OtraActividad();
        assertEquals("Sin-Nombre", unaAct.getNombre());
        assertEquals(false, unaAct.getFueRealizado());
    }
    
    @Test
    public void testConstructorPorParametros() {
        Fecha fecha = new Fecha();
        LocalTime time = LocalTime.now();
        Persona usuario = new Persona();
        Animal perro = new Animal();
        OtraActividad unaAct = new OtraActividad("Nombre", usuario, perro, false, time, fecha);
        Persona resResponsable = unaAct.getUsuario();
        Animal resMascota = unaAct.getMascota();
        String resNombreAct = unaAct.getNombre();
        boolean resFueRealizada = unaAct.getFueRealizado();
        Fecha resFecha = unaAct.getFecha();
        LocalTime resHora = unaAct.getHora();
        assertEquals(usuario, resResponsable);
        assertEquals(perro, resMascota);
        assertEquals("Nombre", resNombreAct);
        assertEquals(false, resFueRealizada);
        assertEquals(fecha, resFecha);
        assertEquals(time, resHora);
    }
    
    @Test
    public void testConstructorPorParametrosVacio() {
        Fecha fecha = new Fecha();
        LocalTime time = LocalTime.now();
        Persona usuario = new Persona();
        Animal perro = new Animal();
        OtraActividad unaAct = new OtraActividad("", usuario, perro, false, time, fecha);
        Persona resResponsable = unaAct.getUsuario();
        Animal resMascota = unaAct.getMascota();
        String resNombreAct = unaAct.getNombre();
        boolean resFueRealizada = unaAct.getFueRealizado();
        Fecha resFecha = unaAct.getFecha();
        LocalTime resHora = unaAct.getHora();
        assertEquals(usuario, resResponsable);
        assertEquals(perro, resMascota);
        assertEquals("Sin-Nombre", resNombreAct);
        assertEquals(false, resFueRealizada);
        assertEquals(fecha, resFecha);
        assertEquals(time, resHora);
    }
    
     @Test
    public void testSetNombreActiidad() {
        actividad.setNombre("Nombre");
        String resNombre = actividad.getNombre();
        assertEquals("Nombre", resNombre);
    }
    
    @Test
    public void testSetNombreVacio() {
        actividad.setNombre("");
        String resNombre = actividad.getNombre();
        assertEquals("Sin-Nombre", resNombre);
    }
    
     @Test
    public void testSetHora() {
        LocalTime time = LocalTime.now();
        actividad.setHora(time);
        LocalTime resHora = actividad.getHora();
        assertEquals(time, resHora);
    }
    
     @Test
    public void testToString() {
        LocalTime time = LocalTime.now();
        Fecha fecha = new Fecha();
        actividad.setHora(time);
        actividad.setFecha(fecha);
        Persona usuario = actividad.getUsuario();
        Animal perro = actividad.getMascota();
        String resToString = actividad.toString();
        assertEquals("ActividadCualquiera{" + "responsable=" + usuario + ", mascota=" + perro + ", fueRealizado=" + actividad.getFueRealizado() + ", hora=" + time + ", fecha=" + fecha + ", nombre=" + actividad.getNombre() + '}', resToString);
    }
    
      @Test
    public void testSetFueRealizadoTrue() {
        actividad.setFueRealizado(true);
        boolean resFueRealizado = actividad.getFueRealizado();
        assertEquals(true, resFueRealizado);
    }
    
      @Test
    public void testSetFueRealizadoFalse() {
        actividad.setFueRealizado(false);
        boolean resFueRealizado = actividad.getFueRealizado();
        assertEquals(false, resFueRealizado);
    }
    
    @Test
    public void testSetMascota() {
        Animal mascota;
        mascota = new Animal();
       actividad.setMascota(mascota);
        assertEquals(mascota, actividad.getMascota());
    }
    
     @Test
    public void testSetResponsable() {
        Persona responsable;
        responsable = new Persona();
        actividad.setUsuario(responsable);
         assertEquals(responsable, actividad.getUsuario());
    }
}
