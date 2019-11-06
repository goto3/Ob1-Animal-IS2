package dominio;

import dominio.modelo.Persona;
import dominio.modelo.Animal;
import dominio.modelo.Veterinaria;
import dominio.modelo.Actividad;
import dominio.modelo.actividades.VisitaVeterinaria;
import dominio.modelo.actividades.OtraActividad;
import dominio.modelo.actividades.Paseo;
import dominio.modelo.actividades.Alimentacion;
import dominio.modelo.usuarios.Responsable;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private final ArrayList<Responsable> responsables;
    private final ArrayList<Animal> animales;
    private final ArrayList<Actividad> actividades;
    private final List<Veterinaria> veterinarias;
    private List<Fecha> fechas;

    public Sistema() {
        this.responsables = new ArrayList<>();
        this.animales = new ArrayList<>();
        this.actividades = new ArrayList<>();
        this.fechas = new ArrayList<>();
        this.veterinarias = new ArrayList<>();
    }

    public List<Actividad> listaActividadesPorFecha(int dia, int mes, int ano) {
        ArrayList<Actividad> retLista = new ArrayList<>();
        if (dia >= 1 && dia <= 31 && mes >= 0 && mes <= 12 && ano >= 1) {
            for (int i = 0; i < actividades.size(); i++) {
                Actividad act = actividades.get(i);
                if (act.getFecha().getDia() == dia && act.getFecha().getMes() == mes && act.getFecha().getAno() == ano) {
                    retLista.add(act);
                }
            }
        }
        return retLista;
    }

    /* GETTERS */
    public List<Responsable> getResponsables() {
        return responsables;
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public List<Veterinaria> getVeterinarias() {
        return veterinarias;
    }

    public List<Fecha> getFechas() {
        return fechas;
    }

    public Responsable getResponsable(String nombreBuscar) {
        for (int i = 0; i < responsables.size(); i++) {
            if (nombreBuscar.equals(responsables.get(i).getNombre())) {
                return responsables.get(i);
            }
        }
        return null;
    }

    public Animal getAnimal(String nombreBuscar) {
        for (int i = 0; i < animales.size(); i++) {
            if (nombreBuscar.equals(animales.get(i).getNombre())) {
                return animales.get(i);
            }
        }
        return null;
    }

    public Veterinaria getVeterinaria(String nombreBuscar) {
        for (int i = 0; i < veterinarias.size(); i++) {
            if (nombreBuscar.equals(veterinarias.get(i).getNombre())) {
                return veterinarias.get(i);
            }
        }
        return null;
    }

    public Paseo getPaseo(String nombreBuscar) {
        for (int i = 0; i < actividades.size(); i++) {
            Actividad act = actividades.get(i);
            if (act.getNombre().equals(nombreBuscar)
                    && act.getClass().getSimpleName().equals("Paseo")) {
                return (Paseo) act;
            }
        }
        return null;
    }

    public VisitaVeterinaria getVisita(String nombreBuscar) {
        for (int i = 0; i < actividades.size(); i++) {
            Actividad act = actividades.get(i);
            if (act.getNombre().equals(nombreBuscar)
                    && act.getClass().getSimpleName().equals("VisitaVeterinaria")) {
                return (VisitaVeterinaria) act;
            }
        }
        return null;
    }

    public OtraActividad getOtraActividad(String nombreBuscar) {
        for (int i = 0; i < actividades.size(); i++) {
            Actividad act = actividades.get(i);
            if (act.getNombre().equals(nombreBuscar)
                    && act.getClass().getSimpleName().equals("ActividadCualquiera")) {
                return (OtraActividad) act;
            }
        }
        return null;
    }

    public Alimentacion getAlimentacion(String nombreBuscar) {
        for (int i = 0; i < actividades.size(); i++) {
            Actividad act = actividades.get(i);
            if (act.getNombre().equals(nombreBuscar)
                    && act.getClass().getSimpleName().equals("Alimentacion")) {
                return (Alimentacion) act;
            }
        }
        return null;
    }

    /* SETTERS */
    public void setFechas(ArrayList<Fecha> fechas) {
        this.fechas = fechas;
    }

    /* ADDERS */
    public void addResponsable(Responsable personaAnadir) {
        responsables.add(personaAnadir);
    }

    public void addAnimal(Animal perroAnadir) {
        animales.add(perroAnadir);
    }

    public void addActividad(Actividad act) {
        actividades.add(act);
        act.getUsuario().agregarActividad(act);
    }

    public void anadirFecha(Fecha fecha) {
        fechas.add(fecha);
    }

    /* DELETERS */
    public void eliminarPerro(Animal perro) {
        if (animales.contains(perro)) {
            animales.remove(perro);
        } else {
            System.out.println("No existe tal perro");
        }
    }

    public void eliminarUsuario(Persona persona) {
        if (responsables.contains(persona)) {
            responsables.remove(persona);
        } else {
            System.out.println("No existe tal persona");
        }
    }

    public void eliminarActividad(Actividad act) {
        if (actividades.contains(act)) {
            actividades.remove(act);
        } else {
            System.out.println("No existe tal actividad");
        }
    }

    public void eliminarFecha(Fecha fecha) {
        if (fechas.contains(fecha)) {
            fechas.remove(fecha);
        } else {
            System.out.println("No existe tal fecha");
        }
    }

}
