/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.modelo.Actividad;
import dominio.modelo.Animal;
import dominio.modelo.actividades.OtraActividad;
import dominio.modelo.personas.Responsable;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ResponsableTest {
    
    private Responsable res;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         res = new Responsable("Pedro","Gonzalez", "pedro12@gmail.com");
    }
    
    @After
    public void tearDown() {
        
    }
    
    @Test
    public void constructorConParametrosTest(){
        assertEquals("Pedro", res.getNombre());
        assertEquals("Gonzalez", res.getApellido());
        assertEquals("pedro12@gmail.com", res.getEmail());
    }
    
    @Test
    public void agregarActividadTest(){
        Animal unPerro = new Animal("Joaco", "perro", 1, 2, "Es marron");
        LocalDateTime fecha1 = LocalDateTime.of(2019, Month.MARCH, 2, 17, 0);
        Actividad act = new OtraActividad("Bañar perro", unPerro, res, 
             fecha1, 20);
        res.agregarActividad(act);
        assertEquals(true, res.getActividades().contains(act));
        assertEquals(1, res.getActividades().size());
    }
    
    @Test
    public void toStringTest(){
        assertEquals("Persona => Responsable: Nombre = "
                + res.getNombre() + ", apellido = " + res.getApellido() +
                ", mail = " + res.getEmail(), res.toString());
    }
}
