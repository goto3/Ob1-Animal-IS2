/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.time.LocalTime;

/**
 *
 * @author marce
 */
public class VisitaVeterinaria extends Actividad {
    
    private Veterinaria veterinaria;
    private String motivo;

    public VisitaVeterinaria() {
        this.nombre = "Sin-Nombre";
        this.hora = LocalTime.now();
        this.usuarioResponsable = new Usuario();
        this.mascota = new Perro();
        this.fueRealizado = false;
        this.fecha = new Fecha();
        this.veterinaria = new Veterinaria();
        this.motivo = "Sin-Motivo";
    }

    public VisitaVeterinaria(String nombre, LocalTime hora, Usuario responsable, Perro perro, boolean fueRealizado, Fecha fecha, Veterinaria veterinaria, String motivo) {
        setNombre(nombre);
        this.hora = hora;
        this.usuarioResponsable = responsable;
        this.mascota = perro;
        this.fueRealizado = fueRealizado;
        this.fecha = fecha;
        this.veterinaria = veterinaria;
        setMotivo(motivo);
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        if(motivo.equals("")){
            this.motivo = "Sin-Motivo";
        }else{
            this.motivo = motivo;
        }
    }

    public Veterinaria getVeterinaria() {
        return veterinaria;
    }

    public void setVeterinaria(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }

    @Override
    public void setFueRealizado(boolean seCompleto) {
        this.fueRealizado = seCompleto;
        if(fueRealizado)
            veterinaria.EliminarActividadAgendada(this);
    }

    @Override
    public String toString() {
        return "VisitaVeterinaria{" + "nombre=" + nombre + ", hora=" + hora + ", responsable=" + usuarioResponsable + ", perro=" + mascota + ", fueRealizado=" + fueRealizado + ", fecha=" + fecha + ", veterinaria=" + veterinaria + '}';
    }

  

    
}
