/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.modelo.Persona;
import dominio.modelo.Animal;
import dominio.modelo.Veterinaria;
import dominio.modelo.Actividad;
import dominio.modelo.actividades.VisitaVeterinaria;
import dominio.modelo.actividades.OtraActividad;
import dominio.modelo.actividades.Paseo;
import dominio.modelo.actividades.Alimentacion;
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
public class SistemaTest {

    private Sistema sis;

    public SistemaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        sis = new Sistema();
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
    public void testConstructorSinParametros(){
        Sistema unSistema = new Sistema();
        assertEquals(new ArrayList<>(), unSistema.getActividades());
        assertEquals(new ArrayList<>(), unSistema.getActsCualquieras());
        assertEquals(new ArrayList<>(), unSistema.getAlimentaciones());
        assertEquals(new ArrayList<>(), unSistema.getFechas());
        assertEquals(new ArrayList<>(), unSistema.getPaseos());
        assertEquals(new ArrayList<>(), unSistema.getAnimales());
        assertEquals(new ArrayList<>(), unSistema.getResponsables());
        assertEquals(new ArrayList<>(), unSistema.getVeterinarias());
        assertEquals(new ArrayList<>(), unSistema.getVisitas());
    }
    
    @Test
    public void testAñadirActividadDosElementos() {
        Actividad act1 = new OtraActividad();
        Actividad act2 = new Alimentacion();
        sis.addActividad(act1);
        sis.addActividad(act2);
        assertTrue(sis.getActividades().contains(act1));
        assertTrue(sis.getActividades().contains(act2));
    }

    @Test
    public void testListaActicidadesPorFecha() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new OtraActividad();
        act1.setFecha(fecha);
        Actividad act2 = new OtraActividad();
        act2.setFecha(fecha);
        sis.addActividad(act1);
        sis.addActividad(act2);
        ArrayList<Actividad> lista = (ArrayList)sis.listaActividadesPorFecha(10, 2, 2018);
        assertTrue(lista.contains(act1));
        assertTrue(lista.contains(act2));
    }

    @Test
    public void testListaActividadesPorFechaDistinta() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new OtraActividad();
        act1.setFecha(fecha);
        Actividad act2 = new OtraActividad();
        act2.setFecha(fecha);
        sis.addActividad(act1);
        sis.addActividad(act2);
        ArrayList<Actividad> lista = (ArrayList)sis.listaActividadesPorFecha(10, 1, 2018);
        assertTrue(!lista.contains(act1));
        assertTrue(!lista.contains(act2));
    }

    @Test
    public void testListaActividadesPorFechaDiaNegativo() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new OtraActividad();
        act1.setFecha(fecha);
        Actividad act2 = new OtraActividad();
        act2.setFecha(fecha);
        sis.addActividad(act1);
        sis.addActividad(act2);
        ArrayList<Actividad> lista = (ArrayList)sis.listaActividadesPorFecha(-10, 2, 2018);
        assertTrue(!lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaMesNegativo() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new OtraActividad();
        act1.setFecha(fecha);
        Actividad act2 = new OtraActividad();
        act2.setFecha(fecha);
        sis.addActividad(act1);
        sis.addActividad(act2);
        ArrayList<Actividad> lista = (ArrayList)sis.listaActividadesPorFecha(10, -2, 2018);
        assertTrue(!lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaAnoNegativo() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new OtraActividad();
        act1.setFecha(fecha);
        Actividad act2 = new OtraActividad();
        act2.setFecha(fecha);
        sis.addActividad(act1);
        sis.addActividad(act2);
        ArrayList<Actividad> lista = (ArrayList)sis.listaActividadesPorFecha(10, 2, -2018);
        assertTrue(!lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaDiaMayorA31() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new OtraActividad();
        act1.setFecha(fecha);
        Actividad act2 = new OtraActividad();
        act2.setFecha(fecha);
        sis.addActividad(act1);
        sis.addActividad(act2);
        ArrayList<Actividad> lista = (ArrayList)sis.listaActividadesPorFecha(32, 2, 2018);
        assertTrue(!lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaMesMayorA12() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new OtraActividad();
        act1.setFecha(fecha);
        Actividad act2 = new OtraActividad();
        act2.setFecha(fecha);
        sis.addActividad(act1);
        sis.addActividad(act2);
        ArrayList<Actividad> lista =(ArrayList) sis.listaActividadesPorFecha(10, 13, 2018);
        assertTrue(!lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaAnoMenorA1() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new OtraActividad();
        act1.setFecha(fecha);
        Actividad act2 = new OtraActividad();
        act2.setFecha(fecha);
        sis.addActividad(act1);
        sis.addActividad(act2);
        ArrayList<Actividad> lista = (ArrayList)sis.listaActividadesPorFecha(31, 2, 0);
        assertTrue(!lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaDiaMesAnoMal() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new OtraActividad();
        act1.setFecha(fecha);
        Actividad act2 = new OtraActividad();
        act2.setFecha(fecha);
        sis.addActividad(act1);
        sis.addActividad(act2);
        ArrayList<Actividad> lista = (ArrayList)sis.listaActividadesPorFecha(32, -2, 0);
        assertTrue(!lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaDiaDistintos() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Fecha fecha2 = new Fecha(11, 2, 2018);
        Actividad act1 = new OtraActividad();
        act1.setFecha(fecha);
        Actividad act2 = new OtraActividad();
        act2.setFecha(fecha2);
        sis.addActividad(act1);
        sis.addActividad(act2);
        ArrayList<Actividad> lista = (ArrayList)sis.listaActividadesPorFecha(10, 2, 2018);
        assertTrue(lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaMesDistintos() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Fecha fecha2 = new Fecha(10, 3, 2018);
        Actividad act1 = new OtraActividad();
        act1.setFecha(fecha);
        Actividad act2 = new OtraActividad();
        act2.setFecha(fecha2);
        sis.addActividad(act1);
        sis.addActividad(act2);
        ArrayList<Actividad> lista = (ArrayList)sis.listaActividadesPorFecha(10, 2, 2018);
        assertTrue(lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaAnoDistintos() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Fecha fecha2 = new Fecha(10, 2, 2019);
        Actividad act1 = new OtraActividad();
        act1.setFecha(fecha);
        Actividad act2 = new OtraActividad();
        act2.setFecha(fecha2);
        sis.addActividad(act1);
        sis.addActividad(act2);
        ArrayList<Actividad> lista = (ArrayList)sis.listaActividadesPorFecha(10, 2, 2018);
        assertTrue(lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaTodaDistinta() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Fecha fecha2 = new Fecha(11, 3, 2019);
        Actividad act1 = new OtraActividad();
        act1.setFecha(fecha);
        Actividad act2 = new OtraActividad();
        act2.setFecha(fecha2);
        sis.addActividad(act1);
        sis.addActividad(act2);
        ArrayList<Actividad> lista = (ArrayList)sis.listaActividadesPorFecha(10, 2, 2018);
        assertTrue(lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testSetUsuarios() {
        ArrayList<Persona> lstUsuarios = new ArrayList<>();
        Persona usuario = new Persona();
        lstUsuarios.add(usuario);
        sis.setUsuarios(lstUsuarios);
        assertTrue(sis.getResponsables().contains(usuario));
    }

    @Test
    public void testSetUsuariosVacio() {
        ArrayList<Persona> lstUsuarios = new ArrayList<>();
        sis.setUsuarios(lstUsuarios);
        assertTrue(sis.getResponsables().isEmpty());
    }

    @Test
    public void testSetPerros() {
        ArrayList<Animal> lstPerros = new ArrayList<>();
        Animal perro = new Animal();
        lstPerros.add(perro);
        sis.setPerros(lstPerros);
        assertTrue(sis.getAnimales().contains(perro));
    }

    @Test
    public void testSetPerrosVacio() {
        ArrayList<Animal> lstPerros = new ArrayList<>();
        sis.setPerros(lstPerros);
        assertTrue(sis.getAnimales().isEmpty());
    }

    @Test
    public void testanadirPerro() {
        Animal perro = new Animal();
        sis.addAnimal(perro);
        assertTrue(sis.getAnimales().contains(perro));
    }

    @Test
    public void testeliminarPerro() {
        Animal perro = new Animal();
        sis.getAnimales().add(perro);
        sis.eliminarPerro(perro);
        assertFalse(sis.getAnimales().contains(perro));
    }

    @Test
    public void testeliminarPerroQueNoEsta() {
        Animal perro = new Animal();
        Animal perro2 = new Animal();
        sis.addAnimal(perro2);
        sis.eliminarPerro(perro);
        assertFalse(sis.getAnimales().contains(perro));
        assertTrue(sis.getAnimales().contains(perro2));
    }

    @Test
    public void testanadirUsuario() {
        Persona usuario = new Persona();
        sis.anadirUsuario(usuario);
        assertTrue(sis.getResponsables().contains(usuario));
    }

    @Test
    public void testeliminarUsuario() {
        Persona usuario = new Persona();
        sis.getResponsables().add(usuario);
        sis.eliminarUsuario(usuario);
        assertFalse(sis.getResponsables().contains(usuario));
    }

    @Test
    public void testeliminarUsuarioQueNoEsta() {
        Persona usuario = new Persona();
        Persona usuario2 = new Persona();
        sis.anadirUsuario(usuario2);
        sis.eliminarUsuario(usuario);
        assertFalse(sis.getResponsables().contains(usuario));
        assertTrue(sis.getResponsables().contains(usuario2));
    }

    @Test
    public void testanadirActividad() {
        Actividad act = new OtraActividad();
        sis.addActividad(act);
        assertTrue(sis.getActividades().contains(act));
    }

    @Test
    public void testeliminarActividad() {
        Actividad act = new OtraActividad();
        sis.getActividades().add(act);
        sis.deleteActividad(act);
        assertFalse(sis.getActividades().contains(act));
    }

    @Test
    public void testeliminarActividadQueNoEsta() {
        Actividad act = new OtraActividad();
        Actividad act2 = new Alimentacion();
        sis.addActividad(act2);
        sis.deleteActividad(act);
        assertFalse(sis.getActividades().contains(act));
        assertTrue(sis.getActividades().contains(act2));
    }

    @Test
    public void testanadirFecha() {
        Fecha fecha = new Fecha();
        sis.anadirFecha(fecha);
        assertTrue(sis.getFechas().contains(fecha));
    }

    @Test
    public void testeliminarFecha() {
        Fecha fecha = new Fecha();
        sis.getFechas().add(fecha);
        sis.eliminarFecha(fecha);
        assertFalse(sis.getFechas().contains(fecha));
    }

    @Test
    public void testeliminarFechaQueNoEsta() {
        Fecha fecha = new Fecha();
        Fecha fecha2 = new Fecha();
        sis.anadirFecha(fecha2);
        sis.eliminarFecha(fecha);
        assertFalse(sis.getFechas().contains(fecha));
        assertTrue(sis.getFechas().contains(fecha2));
    }

    @Test
    public void testSetFechas() {
        ArrayList<Fecha> lstFechas = new ArrayList<>();
        Fecha fecha = new Fecha();
        lstFechas.add(fecha);
        sis.setFechas(lstFechas);
        assertTrue(sis.getFechas().contains(fecha));
    }

    @Test
    public void testSetFechasVacio() {
        ArrayList<Fecha> lstFechas = new ArrayList<>();
        sis.setFechas(lstFechas);
        assertTrue(sis.getFechas().isEmpty());
    }

    @Test
    public void testBuscarUsuarioPorNombre() {
        Persona usuario = new Persona();
        usuario.setNombre("Marcel");
        sis.anadirUsuario(usuario);
        assertEquals(usuario, sis.getResponsable("Marcel"));
    }
    
    @Test
    public void testBuscarUsuarioPorNombreDistintos() {
        Persona usuario = new Persona();
        usuario.setNombre("Marcel");
        sis.anadirUsuario(usuario);
        assertEquals(null, sis.getResponsable("Alejandro"));
    }
    
    @Test
    public void testBuscarPerroPorNombre() {
        Animal perro = new Animal();
        perro.setNombre("Marcel");
        sis.addAnimal(perro);
        assertEquals(perro, sis.getAnimal("Marcel"));
    }
    
    @Test
    public void testBuscarPerroPorNombreDistintos() {
        Animal perro = new Animal();
        perro.setNombre("Marcel");
        sis.addAnimal(perro);
        assertEquals(null, sis.getAnimal("Alejandro"));
    }
    
    @Test
    public void testBuscarVeterinariaPorNombre() {
        Veterinaria vet = new Veterinaria();
        vet.setNombre("Marcel");
        sis.getVeterinarias().add(vet);
        assertEquals(vet, sis.getVeterinaria("Marcel"));
    }
    
    @Test
    public void testBuscarVeterinariaPorNombreDistintos() {
        Veterinaria vet = new Veterinaria();
        vet.setNombre("Marcel");
        sis.getVeterinarias().add(vet);
        assertEquals(null, sis.getVeterinaria("Alejandro"));
    }
    
    @Test
    public void testBuscarPaseoPorNombre() {
        Paseo paseo = new Paseo();
        paseo.setNombre("Marcel");
        sis.getPaseos().add(paseo);
        assertEquals(paseo, sis.getPaseo("Marcel"));
    }
    
    @Test
    public void testBuscarPaseoPorNombreDistintos() {
        Paseo paseo = new Paseo();
        paseo.setNombre("Marcel");
        sis.getPaseos().add(paseo);
        assertEquals(null, sis.getPaseo("Alejandro"));
    }
    
    @Test
    public void testBuscarVisitaPorNombre() {
        VisitaVeterinaria visita = new VisitaVeterinaria();
        visita.setNombre("Marcel");
        sis.getVisitas().add(visita);
        assertEquals(visita, sis.getVisita("Marcel"));
    }
    
    @Test
    public void testBuscarVisitaPorNombreDistintos() {
        VisitaVeterinaria visita = new VisitaVeterinaria();
        visita.setNombre("Marcel");
        sis.getVisitas().add(visita);
        assertEquals(null, sis.getVisita("Alejandro"));
    }
    
    @Test
    public void testBuscarAlimentacionPorNombre() {
        Alimentacion alim = new Alimentacion();
        alim.setNombre("Marcel");
        sis.getAlimentaciones().add(alim);
        assertEquals(alim, sis.getAlimentacion("Marcel"));
    }
    
    @Test
    public void testBuscarAlimentacionPorNombreDistintos() {
        Alimentacion alim = new Alimentacion();
        alim.setNombre("Marcel");
        sis.getAlimentaciones().add(alim);
        assertEquals(null, sis.getAlimentacion("Alejandro"));
    }
    
    @Test
    public void testBuscarActsPorNombre() {
        OtraActividad act = new OtraActividad();
        act.setNombre("Marcel");
        sis.getActsCualquieras().add(act);
        assertEquals(act, sis.getOtraActividad("Marcel"));
    }
    
    @Test
    public void testBuscarActsPorNombreDistintos() {
        OtraActividad act = new OtraActividad();
        act.setNombre("Marcel");
        sis.getActsCualquieras().add(act);
        assertEquals(null, sis.getOtraActividad("Alejandro"));
    }
    
    @Test
    public void testSetVets() {
        ArrayList<Veterinaria> lstVets = new ArrayList<>();
        Veterinaria vet = new Veterinaria();
        lstVets.add(vet);
        sis.setVeterinarias(lstVets);
        assertTrue(sis.getVeterinarias().contains(vet));
    }

    @Test
    public void testSetVetsVacio() {
        ArrayList<Veterinaria> lstVets = new ArrayList<>();
        sis.setVeterinarias(lstVets);
        assertTrue(sis.getVeterinarias().isEmpty());
    }
    
   @Test
    public void testSetActs() {
        ArrayList<OtraActividad> lstActs = new ArrayList<>();
        OtraActividad act = new OtraActividad();
        lstActs.add(act);
        sis.setActsCualquieras(lstActs);
        assertTrue(sis.getActsCualquieras().contains(act));
    }

    @Test
    public void testSetActsVacio() {
        ArrayList<OtraActividad> lstActs = new ArrayList<>();
        sis.setActsCualquieras(lstActs);
        assertTrue(sis.getActsCualquieras().isEmpty());
    }
    
    @Test
    public void testSetPaseos() {
        ArrayList<Paseo> lstPaseos = new ArrayList<>();
        Paseo paseo = new Paseo();
        lstPaseos.add(paseo);
        sis.setPaseos(lstPaseos);
        assertTrue(sis.getPaseos().contains(paseo));
    }

    @Test
    public void testSetPaseoVacio() {
        ArrayList<Paseo> lstPaseos = new ArrayList<>();
        sis.setPaseos(lstPaseos);
        assertTrue(sis.getPaseos().isEmpty());
    }
    
    @Test
    public void testSetAlimentaciones() {
        ArrayList<Alimentacion> lstAlims = new ArrayList<>();
        Alimentacion alim = new Alimentacion();
        lstAlims.add(alim);
        sis.setAlimentaciones(lstAlims);
        assertTrue(sis.getAlimentaciones().contains(alim));
    }

    @Test
    public void testSetAlimentacionesVacio() {
        ArrayList<Alimentacion> lstAlims = new ArrayList<>();
        sis.setAlimentaciones(lstAlims);
        assertTrue(sis.getAlimentaciones().isEmpty());
    }
    
    @Test
    public void testSetVisitas() {
        ArrayList<VisitaVeterinaria> lstVisitas = new ArrayList<>();
        VisitaVeterinaria visita = new VisitaVeterinaria();
        lstVisitas.add(visita);
        sis.setVisitas(lstVisitas);
        assertTrue(sis.getVisitas().contains(visita));
    }

    @Test
    public void testSetVisitasVacio() {
        ArrayList<VisitaVeterinaria> lstVisitas = new ArrayList<>();
        sis.setVisitas(lstVisitas);
        assertTrue(sis.getVisitas().isEmpty());
    }
}
