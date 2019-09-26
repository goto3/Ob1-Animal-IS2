/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.time.LocalTime;
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
public class VeterinariaTest {

    private Veterinaria vet;

    public VeterinariaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        vet = new Veterinaria();
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
        Veterinaria unVet = new Veterinaria();
        assertEquals("Sin-Nombre", unVet.getNombre());
        assertEquals(-1, unVet.getHoraInicial());
        assertEquals(-1, unVet.getHoraFinal());
        assertEquals(new ArrayList<>(), unVet.getActividadesAgendadas());
    }

    @Test
    public void testConstructorPorParametros() {
        Veterinaria unaVet = new Veterinaria("Nombre", new ArrayList<>(), 8, 16);
        assertEquals("Nombre", unaVet.getNombre());
        assertEquals(new ArrayList<>(), unaVet.getActividadesAgendadas());
        assertEquals(8, unaVet.getHoraInicial());
        assertEquals(16, unaVet.getHoraFinal());
    }

    @Test
    public void testConstructorPorParametrosNombreVaci0() {
        Veterinaria unaVet = new Veterinaria("", new ArrayList<>(), 8, 16);
        assertEquals("Sin-Nombre", unaVet.getNombre());
        assertEquals(new ArrayList<>(), unaVet.getActividadesAgendadas());
        assertEquals(8, unaVet.getHoraInicial());
        assertEquals(16, unaVet.getHoraFinal());
    }

    @Test
    public void testConstructorPorParametrosHorasNegativas() {
        Veterinaria unaVet = new Veterinaria("Nombre", new ArrayList<>(), -8, -16);
        assertEquals("Nombre", unaVet.getNombre());
        assertEquals(new ArrayList<>(), unaVet.getActividadesAgendadas());
        assertEquals(0, unaVet.getHoraInicial());
        assertEquals(0, unaVet.getHoraFinal());
    }

    @Test
    public void testConstructorPorParametrosHorasMayoresA23() {
        Veterinaria unaVet = new Veterinaria("Nombre", new ArrayList<>(), 25, 24);
        assertEquals("Nombre", unaVet.getNombre());
        assertEquals(new ArrayList<>(), unaVet.getActividadesAgendadas());
        assertEquals(23, unaVet.getHoraInicial());
        assertEquals(23, unaVet.getHoraFinal());
    }

    @Test
    public void testSetNombre() {
        vet.setNombre("Nombre");
        assertEquals("Nombre", vet.getNombre());
    }

    @Test
    public void testSetNombreVacio() {
        vet.setNombre("");
        assertEquals("Sin-Nombre", vet.getNombre());
    }

    @Test
    public void testSetActividadesAgendadas() {
        VisitaVeterinaria visita = new VisitaVeterinaria();
        ArrayList<Actividad> lista = new ArrayList<>();
        lista.add(visita);
        vet.setActividadesAgendadas(lista);
        assertEquals(lista, vet.getActividadesAgendadas());
        assertTrue(vet.getActividadesAgendadas().contains(visita));
    }

    @Test
    public void testActividadesAgendadas() {
        vet.setHoraInicial(8);
        vet.setHoraFinal(16);
        VisitaVeterinaria act = new VisitaVeterinaria("Visita", LocalTime.of(10, 20), new Usuario(), new Perro(), false, new Fecha(10, 10, 2018), new Veterinaria(), "Medico");
        vet.AgendarActividad(act);
        assertTrue(vet.getActividadesAgendadas().contains(act));
    }

    @Test
    public void testActividadesAgendadasFueraDeHorarioTemprano() {
        vet.setHoraInicial(8);
        vet.setHoraFinal(16);
        VisitaVeterinaria act = new VisitaVeterinaria("Visita", LocalTime.of(3, 20), new Usuario(), new Perro(), false, new Fecha(10, 10, 2018), new Veterinaria(), "Medico");
        vet.AgendarActividad(act);
        assertTrue(!vet.getActividadesAgendadas().contains(act));
    }

    @Test
    public void testActividadesAgendadasFueraDeHorarioTarde() {
        vet.setHoraInicial(8);
        vet.setHoraFinal(16);
        VisitaVeterinaria act = new VisitaVeterinaria("Visita", LocalTime.of(20, 20), new Usuario(), new Perro(), false, new Fecha(10, 10, 2018), new Veterinaria(), "Medico");
        vet.AgendarActividad(act);
        assertTrue(!vet.getActividadesAgendadas().contains(act));
    }

    @Test
    public void testActividadesAgendadasMismaFechaDistintaHora() {
        vet.setHoraInicial(8);
        vet.setHoraFinal(16);
        VisitaVeterinaria act2 = new VisitaVeterinaria("Visita2", LocalTime.of(11, 20), new Usuario(), new Perro(), false, new Fecha(10, 10, 2018), new Veterinaria(), "Medico");
        VisitaVeterinaria act = new VisitaVeterinaria("Visita", LocalTime.of(10, 20), new Usuario(), new Perro(), false, new Fecha(10, 10, 2018), new Veterinaria(), "Medico");
        vet.AgendarActividad(act);
        vet.AgendarActividad(act2);
        assertTrue(vet.getActividadesAgendadas().contains(act));
        assertTrue(vet.getActividadesAgendadas().contains(act2));
    }

    @Test
    public void testActividadesAgendadasMismaFechaMismaHora() {
        vet.setHoraInicial(8);
        vet.setHoraFinal(16);
        VisitaVeterinaria act2 = new VisitaVeterinaria("Visita2", LocalTime.of(10, 20), new Usuario(), new Perro(), false, new Fecha(10, 10, 2018), new Veterinaria(), "Medico");
        VisitaVeterinaria act = new VisitaVeterinaria("Visita", LocalTime.of(10, 20), new Usuario(), new Perro(), false, new Fecha(10, 10, 2018), new Veterinaria(), "Medico");
        vet.AgendarActividad(act);
        vet.AgendarActividad(act2);
        assertTrue(vet.getActividadesAgendadas().contains(act));
        assertTrue(!vet.getActividadesAgendadas().contains(act2));
    }

    @Test
    public void testActividadesAgendadasDistintosDias() {
        vet.setHoraInicial(8);
        vet.setHoraFinal(16);
        VisitaVeterinaria act2 = new VisitaVeterinaria("Visita2", LocalTime.of(10, 20), new Usuario(), new Perro(), false, new Fecha(11, 10, 2018), new Veterinaria(), "Medico");
        VisitaVeterinaria act = new VisitaVeterinaria("Visita", LocalTime.of(10, 20), new Usuario(), new Perro(), false, new Fecha(10, 10, 2018), new Veterinaria(), "Medico");
        vet.AgendarActividad(act);
        vet.AgendarActividad(act2);
        assertTrue(vet.getActividadesAgendadas().contains(act));
        assertTrue(vet.getActividadesAgendadas().contains(act2));
    }

    @Test
    public void testActividadesAgendadasDistintosMes() {
        vet.setHoraInicial(8);
        vet.setHoraFinal(16);
        VisitaVeterinaria act2 = new VisitaVeterinaria("Visita2", LocalTime.of(10, 20), new Usuario(), new Perro(), false, new Fecha(10, 11, 2018), new Veterinaria(), "Medico");
        VisitaVeterinaria act = new VisitaVeterinaria("Visita", LocalTime.of(10, 20), new Usuario(), new Perro(), false, new Fecha(10, 10, 2018), new Veterinaria(), "Medico");
        vet.AgendarActividad(act);
        vet.AgendarActividad(act2);
        assertTrue(vet.getActividadesAgendadas().contains(act));
        assertTrue(vet.getActividadesAgendadas().contains(act2));
    }

    @Test
    public void testActividadesAgendadasDistintoAno() {
        vet.setHoraInicial(8);
        vet.setHoraFinal(16);
        VisitaVeterinaria act2 = new VisitaVeterinaria("Visita2", LocalTime.of(10, 20), new Usuario(), new Perro(), false, new Fecha(10, 10, 2019), new Veterinaria(), "Medico");
        VisitaVeterinaria act = new VisitaVeterinaria("Visita", LocalTime.of(10, 20), new Usuario(), new Perro(), false, new Fecha(10, 10, 2018), new Veterinaria(), "Medico");
        vet.AgendarActividad(act);
        vet.AgendarActividad(act2);
        assertTrue(vet.getActividadesAgendadas().contains(act));
        assertTrue(vet.getActividadesAgendadas().contains(act2));
    }

    @Test
    public void testEliminarActividadAgendadaNoEsta() {
        VisitaVeterinaria act = new VisitaVeterinaria();
        assertTrue(!vet.getActividadesAgendadas().contains(act));
        vet.EliminarActividadAgendada(act);
        assertTrue(!vet.getActividadesAgendadas().contains(act));
    }

    @Test
    public void testEliminarActividadAgendadaEsta() {
        VisitaVeterinaria act = new VisitaVeterinaria();
        vet.setHoraInicial(0);
        vet.setHoraFinal(23);
        vet.AgendarActividad(act);
        assertTrue(vet.getActividadesAgendadas().contains(act));
        vet.EliminarActividadAgendada(act);
        assertTrue(!vet.getActividadesAgendadas().contains(act));
    }

    @Test
    public void testSetHoraInicial() {
        vet.setHoraInicial(2);
        assertEquals(2, vet.getHoraInicial());
    }

    @Test
    public void testSetHoraInicialNegativa() {
        vet.setHoraInicial(-2);
        assertEquals(0, vet.getHoraInicial());
    }

    @Test
    public void testSetHoraInicialMayorA23() {
        vet.setHoraInicial(24);
        assertEquals(23, vet.getHoraInicial());
    }

    @Test
    public void testSetHoraFinal() {
        vet.setHoraFinal(2);
        assertEquals(2, vet.getHoraFinal());
    }

    @Test
    public void testSetHoraFinalNegativa() {
        vet.setHoraFinal(-2);
        assertEquals(0, vet.getHoraFinal());
    }

    @Test
    public void testSetHoraFinalMayorA23() {
        vet.setHoraFinal(24);
        assertEquals(23, vet.getHoraFinal());
    }

    @Test
    public void testToString() {
        String nombre = vet.getNombre();
        ArrayList<Actividad> actividadesAgendadas = vet.getActividadesAgendadas();
        int horaInicial = vet.getHoraInicial();
        int horaFinal = vet.getHoraFinal();
        String resToString = vet.toString();
        assertEquals("Veterinaria{" + "nombre=" + nombre + ", actividadesAgendadas=" + actividadesAgendadas + ", horaInicial=" + horaInicial + ", horaFinal=" + horaFinal + '}', resToString);
    }
}
