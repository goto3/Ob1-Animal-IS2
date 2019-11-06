package dominio.modelo.actividades;

import dominio.modelo.Actividad;
import dominio.modelo.Animal;
import dominio.modelo.Persona;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OtraActividad extends Actividad {

    public OtraActividad() {
        super();
    }

    public OtraActividad(String nombre, Persona responasble, Animal mascota,
            boolean fueRealizado, LocalTime hora, LocalDateTime fecha,
            int duracion) {
        super();
    }

    @Override
    public String toString() {
        return "ActividadCualquiera{" + "responsable=" + this.responsable + ", mascota=" + animal + ", fueRealizado=" + fueRealizado + ", hora=bre=" + nombre + '}';
    }

}
