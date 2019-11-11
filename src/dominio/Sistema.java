package dominio;

import dominio.modelo.Animal;
import dominio.modelo.Veterinaria;
import dominio.modelo.Actividad;
import dominio.modelo.actividades.VisitaVeterinaria;
import dominio.modelo.actividades.OtraActividad;
import dominio.modelo.actividades.Paseo;
import dominio.modelo.actividades.Alimentacion;
import dominio.modelo.usuarios.Responsable;
import dominio.modelo.usuarios.Usuario;
import excepciones.AnimalException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sistema {

    private ArrayList<Usuario> usuarios;
    private final ArrayList<Responsable> responsables;
    private final ArrayList<Animal> animales;
    private final ArrayList<Actividad> actividades;
    private final List<Veterinaria> veterinarias;

    private Usuario usuarioLogeado;

    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.responsables = new ArrayList<>();
        this.animales = new ArrayList<>();
        this.actividades = new ArrayList<>();
        this.veterinarias = new ArrayList<>();
        usuarioLogeado = null;
    }

    public void loadUsers() throws AnimalException {
        LogInController lc = new LogInController();
        usuarios = lc.LoadUsers();
    }

    public boolean logIn(Usuario user) throws AnimalException {
        if (user == null) {
            throw new AnimalException("Usuario vacío");
        } else {
            Iterator<Usuario> itUsers = usuarios.iterator();
            while (itUsers.hasNext()) {
                Usuario usuarioList = itUsers.next();
                if (usuarioList.getEmail().equals(user.getEmail())
                        && usuarioList.getPassword().equals(user.getPassword())) {
                    usuarioLogeado = usuarioList;
                    return true;
                }
            }
        }
        return false;
    }

    public List<Actividad> listaActividadesPorFecha(LocalDate date) {
        ArrayList<Actividad> activs = new ArrayList<>();
        for (Actividad actividad : actividades) {
            LocalDate ld = actividad.getFechaHora().toLocalDate();
            if (ld.equals(date)) {
                activs.add(actividad);
            }
        }
        return activs;
    }

    private boolean existeResponsable(Responsable responsable) {
        for (Responsable res : responsables) {
            if (res.getNombre().equals(responsable.getNombre())
                    && res.getEmail().equals(responsable.getEmail())) {
                return true;
            }
        }
        return false;
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

    /* ADDERS */
    public void addResponsable(Responsable resp) throws AnimalException {
        if (existeResponsable(resp)) {
            throw new AnimalException("ya existe un responsable con estos datos");
        } else {
            responsables.add(resp);
        }
    }

    public void addAnimal(Animal perroAnadir) {
        animales.add(perroAnadir);
    }

    public void addActividad(Actividad act) {
        actividades.add(act);
        act.getUsuario().agregarActividad(act);
    }

    /* DELETERS */
    public void deleteActividad(Actividad act) throws AnimalException {
        if (actividades.contains(act)) {
            actividades.remove(act);
        } else {
            throw new AnimalException("no existe esa actividad");
        }
    }

}
