package dominio.modelo.actividades;

import dominio.Fecha;
import dominio.modelo.Actividad;
import dominio.modelo.Animal;
import dominio.modelo.Persona;
import java.time.LocalTime;

public class OtraActividad extends Actividad {

    public OtraActividad() {
        super();
    }

    public OtraActividad(String nombre, Persona responasble,
            Animal mascota, boolean fueRealizado, LocalTime hora, Fecha fecha) {
        super();
    }

    @Override
    public String toString() {
        return "ActividadCualquiera{" + "responsable=" + this.responsable + ", mascota=" + animal + ", fueRealizado=" + fueRealizado + ", hora=" + hora + ", fecha=" + fecha + ", nombre=" + nombre + '}';
    }

}
