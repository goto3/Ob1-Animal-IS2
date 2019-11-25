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

    /* GETTERS */
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

    /* SETTERS */
    public final void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public final void setHoraInicio(LocalTime time) {
        this.horaInicio = time;
    }

    public final void setHoraFin(LocalTime time) {
        this.horaFin = time;
    }

//    private boolean existeActividadHora(LocalDateTime fechaHora) {        
//        for (Actividad actividad : actividades) {
//            LocalDateTime inicioActividad = actividad.getFechaHora();
//            LocalDateTime finActividad = actividad.getFechaHora().plusMinutes(actividad.duracion);
//            if(fechaHora.isAfter(inicioActividad) && fechaHora.isBefore(finActividad)){
//                return true;
//            }            
//        }
//
//        return false;
//    }
//
//    public void agendarActividad(VisitaVeterinaria act) throws AnimalException {
//        if (!existeActividadHora(act.getFechaHora())) {
//            actividades.add(act);
//            act.setVeterinaria(this);
//        } else{
//            throw new AnimalException("fecha ocupada por otra actividad");
//        }
//    }

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
