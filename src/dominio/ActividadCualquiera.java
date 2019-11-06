package dominio;

import java.time.LocalTime;

public class ActividadCualquiera extends Actividad {


    public ActividadCualquiera(String nombre, Usuario responasble, Perro mascota, boolean fueRealizado, LocalTime hora, Fecha fecha) {
        this.usuarioResponsable = responasble;
        this.mascota = mascota;
        this.fueRealizado = fueRealizado;
        this.hora = hora;
        this.fecha = fecha;
        setNombre(nombre);
    }

    public ActividadCualquiera() {
        this.usuarioResponsable = new Usuario();
        this.mascota = new Perro();
        this.nombre = "Sin-Nombre";
        this.fueRealizado = false;
        this.hora = LocalTime.now();
        this.fecha = new Fecha();
    }

    @Override
    public String toString() {
        return "ActividadCualquiera{" + "responsable=" + usuarioResponsable + ", mascota=" + mascota + ", fueRealizado=" + fueRealizado + ", hora=" + hora + ", fecha=" + fecha + ", nombre=" + nombre + '}';
    }

}
