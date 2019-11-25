package dominio;

import dominio.modelo.personas.Usuario;
import dominio.tools.EstadoAnimal;
import dominio.tools.Moneda;
import dominio.tools.Pago;
import dominio.tools.Periodo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        usuario = new Usuario("Juan", "Perez", "jP@gmail.com", "Contra");
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

    @Test
    public void testToString() {
        assertEquals("Nombre=Juan, mail=jP@gmail.com}", usuario.toString());
    }

    @Test
    public void testEnumMoneda() {
        assertEquals(Moneda.valueOf("PESOS"), Moneda.PESOS);
        assertEquals(Moneda.valueOf("DOLARES"), Moneda.DOLARES);
        assertEquals(Moneda.valueOf("SIN_MONEDA"), Moneda.SIN_MONEDA);
    }

    @Test
    public void testEnumPago() {
        assertEquals(Pago.valueOf("EFECTIVO"), Pago.EFECTIVO);
        assertEquals(Pago.valueOf("TARJETA_CREDITO"), Pago.TARJETA_CREDITO);
        assertEquals(Pago.valueOf("TRANSFERENCIA_BANCARIA"), Pago.TRANSFERENCIA_BANCARIA);
        assertEquals(Pago.valueOf("NO_ESPECIFICADO"), Pago.NO_ESPECIFICADO);
    }

    @Test
    public void testEnumPeriodo() {
        assertEquals(Periodo.valueOf("MENSUAL"), Periodo.MENSUAL);
        assertEquals(Periodo.valueOf("TRIMESTRAL"), Periodo.TRIMESTRAL);
        assertEquals(Periodo.valueOf("ANUAL"), Periodo.ANUAL);
        assertEquals(Periodo.valueOf("UNICA_VEZ"), Periodo.UNICA_VEZ);
        assertEquals(Periodo.valueOf("NO_ESPECIFICADO"), Periodo.NO_ESPECIFICADO);
    }

}
