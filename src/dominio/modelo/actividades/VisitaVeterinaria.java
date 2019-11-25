package dominio.modelo.actividades;

import dominio.modelo.Actividad;
import dominio.modelo.Animal;
import dominio.modelo.Veterinaria;
import dominio.modelo.personas.Responsable;
import java.time.LocalDateTime;

public class VisitaVeterinaria extends Actividad {

    private Veterinaria veterinaria;
    private String motivo;

    public VisitaVeterinaria(String nombre, Animal mascota, Responsable responsable,
            LocalDateTime fecha, int duracion,
            Veterinaria vet, String motivo) {
        super(nombre, mascota, responsable, fecha, duracion);
        this.veterinaria = vet;
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }
    
    public Veterinaria getVeterinaria() {
        return veterinaria;
    }

    @Override
    public void setFueRealizado(boolean seCompleto) {
        this.fueRealizado = seCompleto;
        if (fueRealizado) {
            veterinaria.EliminarActividadAgendada(this);
        }
    }

    @Override
    public String toString() {
        return "VisitaVeterinaria{" + "nombre=" + nombre + ", responsable=" + 
                responsable + ", mascota=" + animal + ", fueRealizado=" + 
                fueRealizado + ", fecha = " + fechaHora + "veterinaria=" +
                veterinaria + '}';
    }

}
