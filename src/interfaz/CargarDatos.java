package interfaz;

import dominio.Sistema;
import dominio.modelo.Animal;
import dominio.modelo.Veterinaria;
import dominio.modelo.actividades.Alimentacion;
import dominio.modelo.personas.Adoptante;
import dominio.modelo.personas.Padrino;
import dominio.modelo.personas.Responsable;
import dominio.tools.Moneda;
import dominio.tools.Pago;
import dominio.tools.Periodo;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CargarDatos {

    Sistema sistema = Sistema.getInstance();

    public void Cargar() {
        Animal a1 = new Animal("Nombre1", "tipo1", 120, 5000, "Comentario1");
        Animal a2 = new Animal("Nombre2", "tipo2", 120, 5000, "Comentario2");
        Animal a3 = new Animal("Nombre3", "tipo3", 120, 5000, "Comentario3");
        Animal a4 = new Animal("Nombre4", "tipo4", 120, 5000, "Comentario4");
        Animal a5 = new Animal("Nombre5", "tipo5", 120, 5000, "Comentario5");
        Animal a6 = new Animal("Nombre6", "tipo6", 120, 5000, "Comentario6");
        Animal a7 = new Animal("Nombre7", "tipo7", 120, 5000, "Comentario7");
        Animal a8 = new Animal("Nombre8", "tipo8", 120, 5000, "Comentario8");
        Animal a9 = new Animal("Nombre9", "tipo9", 120, 5000, "Comentario9");
        Animal a10 = new Animal("Nombre10", "tipo10", 120, 5000, "Comentario10");

        sistema.addAnimal(a1);
        sistema.addAnimal(a2);
        sistema.addAnimal(a3);
        sistema.addAnimal(a4);
        sistema.addAnimal(a5);
        sistema.addAnimal(a6);
        sistema.addAnimal(a7);
        sistema.addAnimal(a8);
        sistema.addAnimal(a9);
        sistema.addAnimal(a10);

        Responsable r1 = new Responsable("Nombre1", "Apellido1", "email1");
        Responsable r2 = new Responsable("Nombre2", "Apellido2", "email2");
        Responsable r3 = new Responsable("Nombre3", "Apellido3", "email3");

        Adoptante ad1 = new Adoptante("Nombre4", "Apellido4", "email4", "tel4");
        Adoptante ad2 = new Adoptante("Nombre5", "Apellido5", "email5", "tel5");
        Adoptante ad3 = new Adoptante("Nombre6", "Apellido6", "email6", "tel6");

        Padrino p1 = new Padrino("Nombre7", "Apellido7", "email7", "telefono7", "Ciudad7", "Pais7", Pago.NO_ESPECIFICADO, Periodo.NO_ESPECIFICADO, Moneda.SIN_MONEDA, 7);
        Padrino p2 = new Padrino("Nombre8", "Apellido8", "email8", "telefono8", "Ciudad8", "Pais8", Pago.NO_ESPECIFICADO, Periodo.NO_ESPECIFICADO, Moneda.SIN_MONEDA, 8);
        Padrino p3 = new Padrino("Nombre9", "Apellido9", "email9", "telefono9", "Ciudad9", "Pais9", Pago.NO_ESPECIFICADO, Periodo.NO_ESPECIFICADO, Moneda.SIN_MONEDA, 9);
        try {
            sistema.getResponsables().add(r1);
            sistema.getResponsables().add(r2);
            sistema.getResponsables().add(r3);

            sistema.getAdoptantes().add(ad1);
            sistema.getAdoptantes().add(ad2);
            sistema.getAdoptantes().add(ad3);

            sistema.getPadrinos().add(p1);
            sistema.getPadrinos().add(p2);
            sistema.getPadrinos().add(p3);
        } catch (Exception ex) {
        }
        LocalTime lt1 = LocalTime.of(0, 0);
        LocalTime lt2 = LocalTime.of(23, 59);
        Veterinaria v1 = new Veterinaria("NombreVet1", lt1, lt2);
        Veterinaria v2 = new Veterinaria("NombreVet2", lt1, lt2);
        Veterinaria v3 = new Veterinaria("NombreVet3", lt1, lt2);
        sistema.addVeterinaria(v1);
        sistema.addVeterinaria(v2);
        sistema.addVeterinaria(v3);
        
        LocalDateTime ldt = LocalDateTime.now();
        Alimentacion al1 = new Alimentacion("Alimentacion1", a1, r1, ldt, 11, "Alimento1");
        Alimentacion al2 = new Alimentacion("Alimentacion2", a2, r2, ldt, 12, "Alimento2");
        Alimentacion al3 = new Alimentacion("Alimentacion3", a3, r3, ldt, 13, "Alimento3");

        sistema.addActividad(al1);
        sistema.addActividad(al2);
        sistema.addActividad(al3);

    }

}
