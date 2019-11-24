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
    
//    String nombre, String apellido, String mail, String telefono,
//            String ciudad, String pais, Pago tipoPago,
//            Periodo tipoPeriodo, Moneda tipoMoneda, int valor
    
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
    public void toStringPadrino() {
        Animal ramiro = new Animal("Ramiro","Gato", 15, 2, "Blanco");
        Animal juanjo = new Animal("Juanjo", "Perro", 30, 3, "Marron");
        padrino.agregarAnimal(ramiro);
        padrino.agregarAnimal(juanjo);
        String impresion = "Persona => Padrino \nNombre = "
                + "Pedro" + "\nApellido = " +  "González"
                + "\nEmail = " + "pedro12@gmail.com" + "\nCiudad = " + 
                "Montevideo" + "\nPais = " + "Uruguay" + "\nValor = " + 300
                + "\nTelefono = " + "098 775 234"
                + "\nMoneda = " + "DOLARES"
                +"\nPeriodo de pago = " + "MENSUAL" +
                "\nTipo de pago = " + "TARJETA_CREDITO" +
                "\nAnimales que apadrina:\n"
                + padrino.imprimirListaAnimales();
        assertEquals(impresion, padrino.toString());
    }
   
}
