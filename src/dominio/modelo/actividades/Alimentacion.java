package dominio.modelo.actividades;

import dominio.modelo.Actividad;
import dominio.modelo.Animal;
import dominio.modelo.personas.Responsable;
import java.time.LocalDateTime;

public class Alimentacion extends Actividad {
    
    private String tipoAlimento;

    public Alimentacion(String nombre, Animal mascota, Responsable responsable,
            LocalDateTime fecha, int duracion, 
            String tipoAlimento) {
        super(nombre, mascota, responsable, fecha, duracion);
        this.tipoAlimento = tipoAlimento;
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }

    @Override
    public String toString() {
        return "Alimentacion{" + "responsable = " + this.responsable +
                ", mascota = " + animal + ", tipoAlimento = " + tipoAlimento +
                ", fueRealizado = " + fueRealizado + ", nombre = " + nombre + '}';
    }

    

}
