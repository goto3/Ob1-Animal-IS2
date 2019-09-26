/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

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
public class FechaTest {

    private Fecha fecha;

    public FechaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fecha = new Fecha();
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
        Fecha unaFecha = new Fecha();
        assertEquals(1, unaFecha.getDia());
        assertEquals(1, unaFecha.getMes());
        assertEquals(2018, unaFecha.getAno());
        assertEquals(new ArrayList<>(), unaFecha.getActividades());
    }
    
    @Test
    public void testSetDiaPositivo() {
        fecha.setDia(3);
        int res = fecha.getDia();
        assertEquals(3, res);
    }

    @Test
    public void testSetDiaMayorA31() {
        fecha.setDia(32);
        int res = fecha.getDia();
        assertEquals(31, res);
    }

    @Test
    public void testSetDiaFebreroMayorA29() {
        fecha.setMes(2);
        fecha.setDia(30);
        int res = fecha.getDia();
        assertEquals(29, res);
    }

    @Test
    public void testSetDiaCero() {
        fecha.setDia(0);
        int res = fecha.getDia();
        assertEquals(1, res);
    }

    @Test
    public void testSetDiaNegativo() {
        fecha.setDia(-1);
        int res = fecha.getDia();
        assertEquals(1, res);
    }

    //Pruebas de setAño
    @Test
    public void testSetAnoPositivo() {
        fecha.setAno(2019);
        int res = fecha.getAno();
        assertEquals(2019, res);
    }

    @Test
    public void testSetAnoCero() {
        fecha.setAno(0);
        int res = fecha.getAno();
        assertEquals(2018, res);
    }

    @Test
    public void testSetAnoNegativo() {
        fecha.setAno(-1);
        int res = fecha.getAno();
        assertEquals(2018, res);
    }

    //Pruebas de setMes
    @Test
    public void testSetMesPositivo() {
        fecha.setMes(3);
        int res = fecha.getMes();
        assertEquals(3, res);
    }

    @Test
    public void testSetMesMayorA12() {
        fecha.setMes(13);
        int res = fecha.getMes();
        assertEquals(12, res);
    }

    @Test
    public void testSetMesFebreroConDiaMayorA29() {
        fecha.setDia(30);
        fecha.setMes(2);
        int res = fecha.getMes();
        assertEquals(2, res);
        assertEquals(29, fecha.getDia());
    }

    @Test
    public void testSetMesCero() {
        fecha.setMes(0);
        int res = fecha.getMes();
        assertEquals(1, res);
    }

    @Test
    public void testSetMesNegativo() {
        fecha.setMes(-1);
        int res = fecha.getMes();
        assertEquals(1, res);
    }

    //Pruebas de Actividades
    @Test
    public void testAgregarActividad() {
        Actividad act = new ActividadCualquiera();
        fecha.agregarActividad(act);
        assertTrue(fecha.getActividades().contains(act));
    }

    @Test
    public void testBorrarActividadAgregada() {
        Actividad act = new ActividadCualquiera();
        fecha.agregarActividad(act);
        fecha.borrarActividad(act);
        assertTrue(!fecha.getActividades().contains(act));
    }

    @Test
    public void testBorrarActividadNoAgregada() {
        Actividad act = new ActividadCualquiera();
        ArrayList<Actividad> aux = fecha.getActividades();
        fecha.borrarActividad(act);
        assertEquals(aux, fecha.getActividades());
    }

    @Test
    public void testToString() {
        String res = fecha.toString();
        assertEquals("Fecha{dia=1, mes=1, año=2018, actividades=[]}", res);
    }

    @Test
    public void testConstructorPorParametros() {
        Fecha unaFecha = new Fecha(1, 1, 2018);
        int resAño = unaFecha.getAno();
        int resMes = unaFecha.getMes();
        int resDia = unaFecha.getDia();
        assertEquals(2018, resAño);
        assertEquals(1, resMes);
        assertEquals(1, resDia);
    }
    
    @Test
    public void testConstructorPorParametrosFebreroMayor29() {
        Fecha unaFecha = new Fecha(31, 2, 2018);
        int resAño = unaFecha.getAno();
        int resMes = unaFecha.getMes();
        int resDia = unaFecha.getDia();
        assertEquals(2018, resAño);
        assertEquals(2, resMes);
        assertEquals(29, resDia);
    }
    @Test
    public void testConstructorPorParametrosAñoNegativo() {
        Fecha unaFecha = new Fecha(31, 2, -3);
        int resAño = unaFecha.getAno();
        int resMes = unaFecha.getMes();
        int resDia = unaFecha.getDia();
        assertEquals(2018, resAño);
        assertEquals(2, resMes);
        assertEquals(29, resDia);
    }
    @Test
    public void testConstructorPorParametrosDiaMesAñoNegativo() {
        Fecha unaFecha = new Fecha(-1, -1, -3);
        int resAño = unaFecha.getAno();
        int resMes = unaFecha.getMes();
        int resDia = unaFecha.getDia();
        assertEquals(2018, resAño);
        assertEquals(1, resMes);
        assertEquals(1, resDia);
    }
    
    @Test
    public void testConstructorPorParametrosMesMayorA12() {
        Fecha unaFecha = new Fecha(-1, 13, -3);
        int resAño = unaFecha.getAno();
        int resMes = unaFecha.getMes();
        int resDia = unaFecha.getDia();
        assertEquals(2018, resAño);
        assertEquals(12, resMes);
        assertEquals(1, resDia);
    }
    
    @Test
    public void testConstructorPorParametrosDiaMayor31() {
        Fecha unaFecha = new Fecha(32, 4, -3);
        int resAño = unaFecha.getAno();
        int resMes = unaFecha.getMes();
        int resDia = unaFecha.getDia();
        assertEquals(2018, resAño);
        assertEquals(4, resMes);
        assertEquals(31, resDia);
    }
    
    @Test
    public void testConstructorPorParametrosFebreroMenor29() {
        Fecha unaFecha = new Fecha(25, 2, -3);
        int resAño = unaFecha.getAno();
        int resMes = unaFecha.getMes();
        int resDia = unaFecha.getDia();
        assertEquals(2018, resAño);
        assertEquals(2, resMes);
        assertEquals(25, resDia);
    }
    
    
    
}
