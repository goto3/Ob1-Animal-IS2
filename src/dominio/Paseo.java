package dominio;

import java.time.LocalTime;
import javax.swing.ImageIcon;

public class Paseo extends Actividad {
    
    private double distancia;
    private ImageIcon ruta;

    public Paseo(String nombre, Usuario usuario, Perro perro, double distancia, boolean fueRealizado, LocalTime hora, Fecha fecha) {
        this.usuarioResponsable = usuario;
        this.mascota = perro;
        setDistancia(distancia);
        this.fueRealizado = fueRealizado;
        this.hora = hora;
        this.fecha = fecha;
        this.ruta=null;
        setNombre(nombre);
    }
    
    public Paseo(){
        this.usuarioResponsable = new Usuario();
        this.mascota = new Perro();
        this.distancia = 0;
        this.fueRealizado = false;
        this.hora = LocalTime.now();
        this.fecha = new Fecha();
        this.nombre = "Sin-Nombre";
        this.ruta=null;
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
        return "Paseo{" + "responsable=" + usuarioResponsable + ", perro=" + mascota + ", distancia=" + distancia + ", fueRealizado=" + fueRealizado + ", hora=" + hora + ", fecha=" + fecha + ", nombre=" + nombre + '}';
    }
}
