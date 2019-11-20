package dominio.modelo.actividades;

import dominio.modelo.Actividad;
import dominio.modelo.Animal;
import dominio.modelo.personas.Responsable;
import java.time.LocalDateTime;

public class OtraActividad extends Actividad {

    public OtraActividad(String nombre, Animal mascota, Responsable responsable,
            LocalDateTime fecha, int duracion) {
        super(nombre, mascota, responsable, fecha, duracion);
    }

    @Override
    public String toString() {
        return "ActividadCualquiera{" + "responsable = " + this.responsable + 
                ", mascota = " + animal + ", fueRealizado = " + fueRealizado
                + ", fecha = " + fechaHora + ", nombre = " + nombre + '}';
    }
}
