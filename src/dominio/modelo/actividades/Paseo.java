package dominio.modelo.actividades;

import dominio.modelo.Actividad;
import dominio.modelo.Animal;
import dominio.modelo.personas.Responsable;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;

public class Paseo extends Actividad {

    private int distancia;
    private ImageIcon ruta;

    public Paseo(String nombre, Animal mascota, Responsable responsable
             , LocalDateTime fecha, int duracion,
            int distancia, ImageIcon ruta) {
        super(nombre, mascota, responsable, fecha, duracion);
        this.distancia = distancia;
        this.ruta = ruta;
    }

    public ImageIcon getRuta() {
        return ruta;
    }

    public int getDistancia() {
        return distancia;
    }

    @Override
    public String toString() {
        return "Paseo{" + "responsable=" + responsable + 
                ", mascota = " + animal + ", distancia=" + distancia +
                ", fueRealizado=" + fueRealizado + ", fecha=" + fechaHora +
                ", nombre=" + nombre + '}';
    }
}
