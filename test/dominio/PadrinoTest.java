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
        padrino = new Padrino();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void constructorVacio() {
        assertEquals("Sin-Nombre", padrino.getNombre());
        assertEquals("Sin-Apellido", padrino.getApellido());
        assertEquals("Sin-Email", padrino.getEmail());
        assertEquals("Sin-Telefono", padrino.getTelefono());
        assertEquals("Sin-Ciudad", padrino.getCiudad());
        assertEquals("Sin-Pais", padrino.getPais());
        assertEquals(Moneda.SIN_MONEDA, padrino.getMoneda());
        assertEquals(Periodo.NO_ESPECIFICADO, padrino.getPeriodoPago());
        assertEquals(Pago.NO_ESPECIFICADO, padrino.getTipoPago());
        assertEquals(0, padrino.getValor());
        assertEquals(0, padrino.getListaAnimales().size());
    }
    
    @Test
    public void constructorConParametros() {
        ArrayList<Animal> animalesApadrinados = new ArrayList<>();
        Animal juanjo = new Animal();
        Animal ramiro = new Animal();
        animalesApadrinados.add(ramiro);
        animalesApadrinados.add(juanjo);
        padrino = new Padrino("Pedro","pedro12@gmail.com", "098 775 234",
                "González", "Montevideo", "Uruguay", Pago.TARJETA_CREDITO, 
                Periodo.MENSUAL, Moneda.DOLARES, animalesApadrinados, 
                300);
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
        assertEquals(2, padrino.getListaAnimales().size());
        assertTrue(padrino.getListaAnimales().contains(juanjo));
        assertTrue(padrino.getListaAnimales().contains(ramiro));   
    }
    
    @Test
    public void agregarAnimalListaAnimalesVacia() {
        Animal juanjo = new Animal();
        padrino.agregarAnimal(juanjo);
        assertEquals(1, padrino.getListaAnimales().size());
        assertTrue(padrino.getListaAnimales().contains(juanjo));
    }
    
    @Test
    public void agregarAnimalListaAnimalesNoVacia() {
        ArrayList<Animal> animalesApadrinados = new ArrayList<>();
        Animal ramiro = new Animal();
        animalesApadrinados.add(ramiro);
        padrino = new Padrino("Pedro","pedro12@gmail.com", "098 775 234",
                "González", "Montevideo", "Uruguay", Pago.TARJETA_CREDITO, 
                Periodo.MENSUAL, Moneda.DOLARES, animalesApadrinados, 
                300);
        Animal juanjo = new Animal();
        padrino.agregarAnimal(juanjo);
        assertEquals(2, padrino.getListaAnimales().size());
        assertTrue(padrino.getListaAnimales().contains(juanjo));
    }
    
    @Test
    public void imprimirListaAnimalesVacia() {
        assertEquals("", padrino.imprimirListaAnimales());
    }
    
    @Test
    public void imprimirListaAnimalesNoVacia() {
        Animal ramiro = new Animal("Ramiro","Gato", 15, 2, "Blanco");
        Animal juanjo = new Animal("Juanjo", "Perro", 30, 3, "Marron");
        padrino.agregarAnimal(ramiro);
        padrino.agregarAnimal(juanjo);
        String impresion = "Gato {"
                + "\n  nombre = Ramiro"
                + "\n  altura = 15.0"
                + "\n  peso = 2.0" 
                + "\n  comentarios = Blanco"
                + "\n" + '}' + "\n"
                +"Perro {"
                + "\n  nombre = Juanjo"
                + "\n  altura = 30.0"
                + "\n  peso = 3.0" 
                + "\n  comentarios = Marron"
                + "\n" +'}' + "\n";
        assertEquals(impresion, padrino.imprimirListaAnimales());
    }
    
    @Test
    public void toStringPadrino() {
        ArrayList<Animal> animalesApadrinados = new ArrayList<>();
        Animal ramiro = new Animal("Ramiro","Gato", 15, 2, "Blanco");
        Animal juanjo = new Animal("Juanjo", "Perro", 30, 3, "Marron");
        animalesApadrinados.add(ramiro);
        animalesApadrinados.add(juanjo);
        padrino = new Padrino("Pedro","pedro12@gmail.com", "098 775 234",
                "González", "Montevideo", "Uruguay", Pago.TARJETA_CREDITO, 
                Periodo.MENSUAL, Moneda.DOLARES, animalesApadrinados, 
                300);
        String impresion = "Persona => Padrino \nNombre = "
                + "Pedro" + "\nApellido = " +  "González"
                + "\nEmail = " + "pedro12@gmail.com" + "\nCiudad = " + 
                "Montevideo" + "\nPais = " + "Uruguay" + "\nValor = " + 300
                + "\nTelefono = " + "098 775 234"
                + "\nMoneda = " + "DOLAR_AMERICANO"
                +"\nPeriodo de pago = " + "MENSUAL" +
                "\nTipo de pago = " + "TARJETA_CREDITO" +
                "\nAnimales que apadrina:\n"
                + padrino.imprimirListaAnimales();
        System.out.println(impresion);
        assertEquals(impresion, padrino.toString());
    }
   
}
