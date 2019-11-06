package dominio.modelo.actividades;

import dominio.modelo.Actividad;
import dominio.Fecha;
import dominio.modelo.Animal;
import dominio.modelo.usuarios.Responsable;
import java.time.LocalTime;
import javax.swing.ImageIcon;

public class Paseo extends Actividad {
    
    private double distancia;
    private ImageIcon ruta;
    
    public Paseo(){
        super();
        this.distancia = 0;
        this.ruta = null;
    }

    public Paseo(String nombre, Animal animal, Responsable responsable,
                boolean fueRealizado, Fecha fecha, LocalTime hora,
                double distancia, ImageIcon ruta) {
        super(nombre, animal, responsable, fueRealizado, fecha, hora);
        this.distancia = distancia;
        this.ruta = ruta;
    }
    
    public ImageIcon getRuta() {
        return ruta;
    }

    public void setRuta(ImageIcon ruta) {
        this.ruta = ruta;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
       if(distancia < 0){
           this.distancia = 0.0;
       }else{
           this.distancia = distancia;
       }
    }

    @Override
    public String toString() {
        return "Paseo{" + "responsable=" + this.responsable + ", perro=" + animal + ", distancia=" + distancia + ", fueRealizado=" + fueRealizado + ", hora=" + hora + ", fecha=" + fecha + ", nombre=" + nombre + '}';
    }
}
