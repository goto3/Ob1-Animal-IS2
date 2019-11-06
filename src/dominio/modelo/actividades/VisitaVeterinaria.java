package dominio.modelo.actividades;

import dominio.modelo.Actividad;
import dominio.modelo.Animal;
import dominio.modelo.Veterinaria;
import dominio.modelo.usuarios.Responsable;
import java.time.LocalDateTime;

public class VisitaVeterinaria extends Actividad {

    private Veterinaria veterinaria;
    private String motivo;

    public VisitaVeterinaria() {
        super();
        this.veterinaria = new Veterinaria();
        this.motivo = "Sin-motivo";
    }

    public VisitaVeterinaria(String nombre, Animal animal,
            Responsable responsable, boolean fueRealizado, LocalDateTime fecha,
            Veterinaria veterinaria, String motivo, int duracion) {
        super(nombre, animal, responsable, fueRealizado, fecha, duracion);
        this.veterinaria = veterinaria;
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        if (motivo.equals("")) {
            this.motivo = "Sin-Motivo";
        } else {
            this.motivo = motivo;
        }
    }

    public Veterinaria getVeterinaria() {
        return veterinaria;
    }

    public void setVeterinaria(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
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
        return "VisitaVeterinaria{" + "nombre=" + nombre + ", hora==" + this.responsable + ", perro=" + animal + ", fueRealizado=" + fueRealizado + ", fecherinaria=" + veterinaria + '}';
    }

}
