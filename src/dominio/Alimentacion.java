package dominio;

import java.time.LocalTime;

public class Alimentacion extends Actividad {
    
    private String tipoAlimento;

    public Alimentacion(String nombre, Usuario responasble, Perro mascota, String tipoAlimento, boolean fueRealizado, LocalTime hora, Fecha fecha) {
        this.usuarioResponsable = responasble;
        this.mascota = mascota;
        setTipoAlimento(tipoAlimento);
        this.fueRealizado = fueRealizado;
        this.hora = hora;
        this.fecha = fecha;
        setNombre(nombre);
    }

    public Alimentacion(){
        this.usuarioResponsable = new Usuario();
        this.mascota = new Perro();
        this.tipoAlimento = "Sin-Tipo";
        this.fueRealizado = false;
        this.hora = LocalTime.now();
        this.fecha = new Fecha();
        this.nombre = "Sin-Nombre";
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(String tipoAlimento) {
        if(tipoAlimento.equals("")){
            this.tipoAlimento = "Sin-Tipo";
        }else{
            this.tipoAlimento = tipoAlimento;
        }
    }

    @Override
    public String toString() {
        return "Alimentacion{" + "responsable=" + usuarioResponsable + ", mascota=" + mascota + ", tipoAlimento=" + tipoAlimento + ", fueRealizado=" + fueRealizado + ", hora=" + hora + ", fecha=" + fecha + ", nombre=" + nombre + '}';
    }

    

}
