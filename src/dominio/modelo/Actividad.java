package dominio.modelo;

import dominio.modelo.personas.Responsable;
import java.time.LocalDateTime;

public abstract class Actividad {

    protected String nombre;
    protected Animal animal;
    protected Responsable responsable;
    protected boolean fueRealizado;
    protected LocalDateTime fechaHora;
    protected int duracion;

    public Actividad(String nombre, Animal animal, Responsable responsable, 
            LocalDateTime fecha, int dur) {
        this.nombre = nombre;
        this.responsable = responsable;
        this.animal = animal;
        this.fechaHora = fecha;
        this.duracion = dur;
    }

    /* GETTERS */
    public String getNombre() {
        return nombre;
    }

    public Responsable getUsuario() {
        return responsable;
    }

    public Animal getMascota() {
        return animal;
    }

    public boolean getFueRealizado() {
        return fueRealizado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public int getDuracion() {
        return duracion;
    }

    /* SETTERS */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(Responsable responasble) {
        this.responsable = responasble;
    }

    public void setMascota(Animal mascotas) {
        this.animal = mascotas;
    }

    public void setFueRealizado(boolean seCompleto) {
        fueRealizado = seCompleto;
    }

    public void setFechaHora(LocalDateTime fecha) {
        this.fechaHora = fecha;
    }

    public void setDuracion(int dur) {
        this.duracion = dur;
    }
}
