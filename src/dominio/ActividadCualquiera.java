package dominio;

import java.time.LocalTime;

public class ActividadCualquiera extends Actividad {

    private Usuario responasble;
    private Perro mascotas;
    private boolean fueRealizado;
    private LocalTime hora;
    private Fecha fecha;
    private String nombre;

    public ActividadCualquiera(String nombre, Usuario responasble, Perro mascota, boolean fueRealizado, LocalTime hora, Fecha fecha) {
        this.responasble = responasble;
        this.mascotas = mascota;
        this.fueRealizado = fueRealizado;
        this.hora = hora;
        this.fecha = fecha;
        setNombre(nombre);
    }

    public ActividadCualquiera() {
        this.responasble = new Usuario();
        this.mascotas = new Perro();
        this.nombre = "Sin-Nombre";
        this.fueRealizado = false;
        this.hora = LocalTime.now();
        this.fecha = new Fecha();
    }

    @Override
    public LocalTime getHora() {
        return hora;
    }

    @Override
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }


    public final void setNombre(String nombre) {
        if(nombre.equals("")){
            this.nombre = "Sin-Nombre";
        }else{
            this.nombre = nombre;
        }
    }

    @Override
    public Usuario getUsuario() {
        return responasble;
    }

    @Override
    public void setUsuario(Usuario responasble) {
        this.responasble = responasble;
    }

    @Override
    public Perro getMascota() {
        return mascotas;
    }

    @Override
    public void setMascota(Perro mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public boolean getFueRealizado() {
        return fueRealizado;
    }

    @Override
    public void setFueRealizado(boolean seCompleto) {
        this.fueRealizado = seCompleto;
    }

    @Override
    public Fecha getFecha() {
        return fecha;
    }

    @Override
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ActividadCualquiera{" + "responsable=" + responasble + ", mascota=" + mascotas + ", fueRealizado=" + fueRealizado + ", hora=" + hora + ", fecha=" + fecha + ", nombre=" + nombre + '}';
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

}
