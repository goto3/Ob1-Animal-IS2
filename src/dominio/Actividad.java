package dominio;

import java.time.LocalTime;

public abstract class Actividad {
    
    protected Perro mascota;
    protected Usuario usuarioResponsable;
    protected boolean fueRealizado;
    protected Fecha fecha;
    protected LocalTime hora;
    protected String nombre;

    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre) {
        if(nombre.equals("")){
            this.nombre = "Sin-Nombre";
        }else{
            this.nombre = nombre;
        }
    }

    public LocalTime getHora(){
        return hora;   
    }

    public void setHora(LocalTime hora){
         this.hora = hora;
    }

    public Usuario getUsuario() {
        return usuarioResponsable;
    }

    public void setUsuario(Usuario responasble) {
        this.usuarioResponsable = responasble;
    }

    public Perro getMascota(){
        return mascota;
    }

    public void setMascota(Perro mascotas) {
        this.mascota = mascotas;
    }

    public boolean getFueRealizado() {
        return fueRealizado;
    }

    public void setFueRealizado(boolean seCompleto){
        fueRealizado = seCompleto;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
}
