package dominio.modelo;

import dominio.Fecha;
import dominio.modelo.usuarios.Responsable;
import java.time.LocalTime;

public abstract class Actividad {

    protected Animal animal;
    protected Responsable responsable;
    protected boolean fueRealizado;
    protected Fecha fecha;
    protected LocalTime hora;
    protected String nombre;

    public Actividad() {
        this.responsable = new Responsable();
        this.animal = new Animal();
        this.nombre = "Sin-Nombre";
        this.fueRealizado = false;
        this.hora = LocalTime.now();
        this.fecha = new Fecha();
    }

    public Actividad(String nombre, Animal animal, Responsable responsable,
            boolean fueRealizado, Fecha fecha, LocalTime hora) {
        this.nombre = nombre;
        this.responsable = responsable;
        this.animal = animal;
        this.fueRealizado = fueRealizado;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.equals("")) {
            this.nombre = "Sin-Nombre";
        } else {
            this.nombre = nombre;
        }
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Responsable getUsuario() {
        return responsable;
    }

    public void setUsuario(Responsable responasble) {
        this.responsable = responasble;
    }

    public Animal getMascota() {
        return animal;
    }

    public void setMascota(Animal mascotas) {
        this.animal = mascotas;
    }

    public boolean getFueRealizado() {
        return fueRealizado;
    }

    public void setFueRealizado(boolean seCompleto) {
        fueRealizado = seCompleto;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
}
