/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package dominio;

import dominio.modelo.Animal;
import dominio.modelo.personas.Padrino;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import dominio.tools.Moneda;
import dominio.tools.Pago;
import dominio.tools.Periodo;
import java.util.ArrayList;

/**
 *
 * @author sebaban99
 */
public class PadrinoTest {
    
    private Padrino padrino;
    
    public PadrinoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         padrino = new Padrino("Pedro","González", "pedro12@gmail.com",
                 "098 775 234", "Montevideo", "Uruguay", Pago.TARJETA_CREDITO, 
                Periodo.MENSUAL, Moneda.DOLARES,300);
    }
    
    @After
    public void tearDown() {
        
    }
    
    
    @Test
    public void constructorConParametros() {
        assertEquals("Pedro", padrino.getNombre());
        assertEquals("González", padrino.getApellido());
        assertEquals("pedro12@gmail.com", padrino.getEmail());
        assertEquals("098 775 234", padrino.getTelefono());
        assertEquals("Montevideo", padrino.getCiudad());
        assertEquals("Uruguay", padrino.getPais());
        assertEquals(Moneda.DOLARES, padrino.getMoneda());
        assertEquals(Periodo.MENSUAL, padrino.getPeriodoPago());
        assertEquals(Pago.TARJETA_CREDITO, padrino.getTipoPago());
        assertEquals(300, padrino.getValor());
        assertEquals(0, padrino.getListaAnimales().size()); 
    }
    
    @Test
    public void agregarAnimalTest() {
        Animal juanjo = new Animal();
        padrino.agregarAnimal(juanjo);
        assertEquals(1, padrino.getListaAnimales().size());
        assertTrue(padrino.getListaAnimales().contains(juanjo));
    }
    
    @Test
    public void setNombrePersona() {
        padrino.setNombre("Pilar");
        assertEquals("Pilar", padrino.getNombre());
    }
    
    @Test
    public void setApellidoPersona() {
        padrino.setApellido("Rodriguez");
        assertEquals("Rodriguez", padrino.getApellido());
    }
    
    @Test
    public void setEmailPersona() {
        padrino.setEmail("mail@mail.com");
        assertEquals("mail@mail.com", padrino.getEmail());
    }
    
    @Test
    public void imprimirListaAnimalesVacia() {
        assertEquals("", padrino.imprimirListaAnimales());
    }
    
    @Test
    public void imprimirListaAnimalesNoVacia() {
        Animal ramiro = new Animal("Ramiro","Gato", 15, 2, "Blanco");
        padrino.agregarAnimal(ramiro);
        String impresion = "Gato - Ramiro" + "\n";
        assertEquals(impresion, padrino.imprimirListaAnimales());
    }
    
     @Test
    public void setListaAnimalesTest() {
        ArrayList<Animal> lista = new ArrayList<>();
        padrino.setListaAnimales(lista);
        assertEquals(lista, padrino.getListaAnimales());
    }
    
    @Test
    public void setTelefono() {
        padrino.setTelefono("099 123 456");
        assertEquals("099 123 456", padrino.getTelefono());
    }
    
    @Test
    public void setCiudad() {
        padrino.setCiudad("Montevideo");
        assertEquals("Montevideo", padrino.getCiudad());
    }
    
    @Test
    public void setPais() {
        padrino.setPais("Uruguay");
        assertEquals("Uruguay", padrino.getPais());
    }
    
    @Test
    public void setValor() {
        padrino.setValor(20);
        assertEquals(20, padrino.getValor());
    }
    
    @Test
    public void setMoneda() {
        padrino.setMoneda(Moneda.DOLARES);
        assertEquals(Moneda.DOLARES, padrino.getMoneda());
    }
    
    @Test
    public void setTipoPago() {
        padrino.setTipoPago(Pago.TARJETA_CREDITO);
        assertEquals(Pago.TARJETA_CREDITO, padrino.getTipoPago());
    }
    
    @Test
    public void setPeriodoPago() {
        padrino.setPeriodoPago(Periodo.ANUAL);
        assertEquals(Periodo.ANUAL, padrino.getPeriodoPago());
    }
}
