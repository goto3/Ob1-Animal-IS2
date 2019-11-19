package dominio.modelo.actividades;

import dominio.modelo.Actividad;
import dominio.modelo.Animal;
import dominio.modelo.personas.Responsable;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;

public class Paseo extends Actividad {

    private int distancia;
    private ImageIcon ruta;

    public Paseo(String nombre, Animal mascota, Responsable responsable,
            boolean fueRealizado, LocalDateTime fecha, int duracion,
            int distancia, ImageIcon ruta) {
        super(nombre, mascota, responsable, fueRealizado, fecha, duracion);
        this.distancia = distancia;
        this.ruta = ruta;
    }

    public ImageIcon getRuta() {
        return ruta;
    }

    public void setRuta(ImageIcon ruta) {
        this.ruta = ruta;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        if (distancia < 0) {
            this.distancia = 0;
        } else {
            this.distancia = distancia;
        }
    }

    @Override
    public String toString() {
        return "Paseo{" + "responsable=" + this.responsable + ", perro=" + animal + ", distancia=" + distancia + ", fueRealizado=" + fueRealizado + ", hora=, nombre=" + nombre + '}';
    }
}
