package dominio.modelo.actividades;

import dominio.modelo.Actividad;
import dominio.Fecha;
import dominio.modelo.Animal;
import dominio.modelo.Persona;
import java.time.LocalTime;

public class Alimentacion extends Actividad {
    
    private String tipoAlimento;

    public Alimentacion(String nombre, Persona responasble, Animal mascota, String tipoAlimento, boolean fueRealizado, LocalTime hora, Fecha fecha) {
        super();
    }

    public Alimentacion(){
        super();
        this.tipoAlimento = "Sin tipo de alimento.";
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
        return "Alimentacion{" + "responsable=" + this.responsable + ", mascota=" + animal + ", tipoAlimento=" + tipoAlimento + ", fueRealizado=" + fueRealizado + ", hora=" + hora + ", fecha=" + fecha + ", nombre=" + nombre + '}';
    }

    

}
