package dominio;

import dominio.tools.EstadoAnimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Enums {

    public Enums() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
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
}
