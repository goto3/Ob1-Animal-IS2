/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.modelo.Persona;
import dominio.modelo.Actividad;
import dominio.modelo.actividades.OtraActividad;
import dominio.modelo.personas.Usuario;
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

    private Usuario usuario;

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
        usuario = new Usuario("Juan", "Perez","jP@gmail.com", "Contra");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCosntructorConParametros() {
        assertEquals("Juan", usuario.getNombre());
        assertEquals("jP@gmail.com", usuario.getEmail());
        assertEquals("Perez", usuario.getApellido());
    }
}
