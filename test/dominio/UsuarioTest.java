/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.modelo.Persona;
import dominio.modelo.Actividad;
import dominio.modelo.actividades.OtraActividad;
import java.util.ArrayList;
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
public class UsuarioTest {

    private Persona usuario;

    public UsuarioTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        usuario = new Persona("Nombre", "mail@gmail.com");
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
        Persona unUsuario = new Persona();
        assertEquals("Sin-Nombre", unUsuario.getNombre());
        assertEquals("Sin-Mail", unUsuario.getMail());
        assertEquals(new ArrayList<>(), unUsuario.getActividades());
    }

    @Test
    public void testCosntructorPorParametros() {
        Persona unUsuario = new Persona("nombre", "email@email.com");
        String resNom = unUsuario.getNombre();
        String resMail = unUsuario.getMail();
        ArrayList<Actividad> resActividades = (ArrayList)unUsuario.getActividades();
        assertEquals("nombre", resNom);
        assertEquals("email@email.com", resMail);
        assertEquals(new ArrayList<>(), resActividades);
    }

    @Test
    public void testSetNombre() {
        usuario.setNombre("Marcel");
        String resNom = usuario.getNombre();
        assertEquals("Marcel", resNom);
    }

    @Test
    public void testSetNombreVacio() {
        usuario.setNombre("");
        String resNom = usuario.getNombre();
        assertEquals("Sin-Nombre", resNom);
    }

    @Test
    public void testSetMail() {
        usuario.setMail("marcel@gmail.com");
        String resMail = usuario.getMail();
        assertEquals("marcel@gmail.com", resMail);
    }

    @Test
    public void testSetMailVacio() {
        usuario.setMail("");
        String resMail = usuario.getMail();
        assertEquals("Sin-Mail", resMail);
    }

    @Test
    public void testGetActividadesElementoAgregado() {
        Actividad act = new OtraActividad();
        usuario.getActividades().add(act);
        assertEquals(act, usuario.getActividades().get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetActividadesSinElementos() {
        assertEquals(null, usuario.getActividades().get(0));
    }

}
