package dominio;

import java.time.LocalTime;

public class Alimentacion extends Actividad {

    private Usuario responsable;
    private Perro mascota;
    private String tipoAlimento;
    private boolean fueRealizado;
    private LocalTime hora;
    private Fecha fecha;
    private String nombre;

    public Alimentacion(String nombre, Usuario responasble, Perro mascota, String tipoAlimento, boolean fueRealizado, LocalTime hora, Fecha fecha) {
        this.responsable = responasble;
        this.mascota = mascota;
        setTipoAlimento(tipoAlimento);
        this.fueRealizado = fueRealizado;
        this.hora = hora;
        this.fecha = fecha;
        setNombre(nombre);
    }

    public Alimentacion(){
        this.responsable = new Usuario();
        this.mascota = new Perro();
        this.tipoAlimento = "Sin-Tipo";
        this.fueRealizado = false;
        this.hora = LocalTime.now();
        this.fecha = new Fecha();
        this.nombre = "Sin-Nombre";
    }

    
    @Override
    public LocalTime getHora() {
        return hora;
    }

    @Override
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }

    public final void setTipoAlimento(String tipoAlimento) {
        if(tipoAlimento.equals("")){
            this.tipoAlimento = "Sin-Tipo";
        }else{
            this.tipoAlimento = tipoAlimento;
        }
    }

    @Override
    public Usuario getUsuario() {
        return responsable;
    }

    @Override
    public void setUsuario(Usuario responasble) {
        this.responsable = responasble;
    }

    @Override
    public Perro getMascota() {
        return mascota;
    }

    @Override
    public void setMascota(Perro mascota) {
        this.mascota = mascota;
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
        return "Alimentacion{" + "responsable=" + responsable + ", mascota=" + mascota + ", tipoAlimento=" + tipoAlimento + ", fueRealizado=" + fueRealizado + ", hora=" + hora + ", fecha=" + fecha + ", nombre=" + nombre + '}';
    }

    

    @Override
    public String getNombre() {
        return this.nombre;
    }

    public final void setNombre(String nombre) {
        if(nombre.equals("")){
            this.nombre = "Sin-Nombre";
        }else{
            this.nombre = nombre;
        }
    }

}
