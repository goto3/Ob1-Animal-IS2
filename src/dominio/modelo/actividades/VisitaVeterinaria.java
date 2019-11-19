package dominio.modelo.actividades;

import dominio.modelo.Actividad;
import dominio.modelo.Animal;
import dominio.modelo.Veterinaria;
import dominio.modelo.personas.Responsable;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;

public class VisitaVeterinaria extends Actividad {

    private Veterinaria veterinaria;
    private String motivo;

    public VisitaVeterinaria(String nombre, Animal mascota, Responsable responsable,
            boolean fueRealizado, LocalDateTime fecha, int duracion,
            Veterinaria vet, String motivo) {
        super(nombre, mascota, responsable, fueRealizado, fecha, duracion);
        this.veterinaria = vet;
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
