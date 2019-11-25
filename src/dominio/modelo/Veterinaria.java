package dominio.modelo;

import dominio.modelo.actividades.VisitaVeterinaria;
import excepciones.AnimalException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Veterinaria {

    private String nombre;
    private ArrayList<Actividad> actividades;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Veterinaria(String nombre, LocalTime timeInicio, LocalTime timeFin) {
        setNombre(nombre);
        this.actividades = new ArrayList<>();
        setHoraInicio(timeInicio);
        setHoraFin(timeFin);
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<Actividad> getActividadesAgendadas() {
        return actividades;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public final void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public final void setHoraInicio(LocalTime time) {
        this.horaInicio = time;
    }

    public final void setHoraFin(LocalTime time) {
        this.horaFin = time;
    }
    
    public void EliminarActividadAgendada(Actividad act) {
        if (actividades.contains(act)) {
            actividades.remove(act);
        }
    }

    @Override
    public String toString() {
        return nombre;
    }

}
