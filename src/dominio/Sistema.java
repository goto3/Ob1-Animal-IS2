package dominio;

import dominio.modelo.Animal;
import dominio.modelo.Veterinaria;
import dominio.modelo.Actividad;
import dominio.modelo.Persona;
import dominio.modelo.personas.Adoptante;
import dominio.modelo.personas.Padrino;
import dominio.modelo.personas.Responsable;
import dominio.modelo.personas.Usuario;
import excepciones.AnimalException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sistema {

    private static Sistema Instance;

    private ArrayList<Usuario> usuarios;
    private ArrayList<Responsable> responsables;
    private ArrayList<Animal> animales;
    private ArrayList<Actividad> actividades;
    private List<Veterinaria> veterinarias;
    private List<Padrino> padrinos;
    private List<Adoptante> adoptantes;

    private Usuario usuarioLogeado;

    public static Sistema getInstance() {
        if (Instance == null) {
            Instance = new Sistema();
        }
        return Instance;
    }

    private Sistema() {
        this.usuarios = new ArrayList<>();
        this.responsables = new ArrayList<>();
        this.animales = new ArrayList<>();
        this.actividades = new ArrayList<>();
        this.veterinarias = new ArrayList<>();
        this.padrinos = new ArrayList<>();
        this.adoptantes = new ArrayList<>();
        usuarioLogeado = null;
    }

    public void loadUsers() throws AnimalException {
        LogInController lc = new LogInController();
        String filePath = new File("").getAbsolutePath();
        String csvFile = filePath + "/Usuarios.csv";
        usuarios = lc.LoadUsers(csvFile);
    }

    public boolean logIn(Usuario user) {
        Iterator<Usuario> itUsers = usuarios.iterator();
        while (itUsers.hasNext()) {
            Usuario usuarioList = itUsers.next();
            if (usuarioList.getEmail().equals(user.getEmail())
                    && usuarioList.getPassword().equals(user.getPassword())) {
                usuarioLogeado = usuarioList;
                return true;
            }
        }
        return false;
    }

    public void returnEmptyLists(){
        this.usuarios = new ArrayList<>();
        this.responsables = new ArrayList<>();
        this.animales = new ArrayList<>();
        this.actividades = new ArrayList<>();
        this.veterinarias = new ArrayList<>();
        this.padrinos = new ArrayList<>();
        this.adoptantes = new ArrayList<>();
    }
    
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
//    
//    public void adoptarAnimal(Adoptante adoptante, Animal animal) throws AnimalException {
//        if (adoptante == null || animal == null) {
//            throw new AnimalException("Parámetro nulo.");
//        }
//        if (animal.getEstado() == EstadoAnimal.NO_ADOPTABLE) {
//            throw new AnimalException("Animal no puede ser adoptado.");
//        }
//        if (animal.getEstado() == EstadoAnimal.ADOPTADO) {
//            throw new AnimalException("Animal ya fue adoptado.");
//        }
//        animal.setEstado(EstadoAnimal.ADOPTADO);
//        adoptante.addAnimal(animal);
//        adoptantes.add(adoptante);
//    }
//
//    public List<Actividad> listaActividadesPorFecha(LocalDate date) {
//        ArrayList<Actividad> activs = new ArrayList<>();
//        for (Actividad actividad : actividades) {
//            LocalDate ld = actividad.getFechaHora().toLocalDate();
//            if (ld.equals(date)) {
//                activs.add(actividad);
//            }
//        }
//        return activs;
//    }
//
//    private boolean existeResponsable(Responsable responsable) {
//        for (Responsable res : responsables) {
//            if (res.getNombre().equals(responsable.getNombre())
//                    && res.getEmail().equals(responsable.getEmail())) {
//                return true;
//            }
//        }
//        return false;
//    }

    /* GETTERS */
    public List<Responsable> getResponsables() {
        return responsables;
    }

    public List<Padrino> getPadrinos() {
        return padrinos;
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

    public List<Adoptante> getAdoptantes() {
        return adoptantes;
    }

    public Persona getPersona(String id, String tipo) {
        Persona p = null;
        switch (tipo) {
            case ("Adoptante"):
                for (Adoptante a : adoptantes) {
                    if (a.getId().equals(id)) {
                        p = a;
                    }
                }
                break;
            case ("Responsable"):
                for (Responsable r : responsables) {
                    if (r.getId().equals(id)) {
                        p = r;
                    }
                }
                break;
            case ("Padrino"):
                for (Padrino pa : padrinos) {
                    if (pa.getId().equals(id)) {
                        p = pa;
                    }
                }
                break;
        }
        return p;
    }

    public Responsable getResponsable(String idBuscar) {
        for (int i = 0; i < responsables.size(); i++) {
            if (idBuscar.equals(responsables.get(i).getId())) {
                return responsables.get(i);
            }
        }
        return null;
    }

    public Animal getAnimal(String idBuscar) {
        for (int i = 0; i < animales.size(); i++) {
            if (idBuscar.equals(animales.get(i).getId())) {
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
//
//    public Paseo getPaseo(String nombreBuscar) {
//        for (int i = 0; i < actividades.size(); i++) {
//            Actividad act = actividades.get(i);
//            if (act.getNombre().equals(nombreBuscar)
//                    && act.getClass().getSimpleName().equals("Paseo")) {
//                return (Paseo) act;
//            }
//        }
//        return null;
//    }

//    public VisitaVeterinaria getVisita(String nombreBuscar) {
//        for (int i = 0; i < actividades.size(); i++) {
//            Actividad act = actividades.get(i);
//            if (act.getNombre().equals(nombreBuscar)
//                    && act.getClass().getSimpleName().equals("VisitaVeterinaria")) {
//                return (VisitaVeterinaria) act;
//            }
//        }
//        return null;
//    }

//    public OtraActividad getOtraActividad(String nombreBuscar) {
//        for (int i = 0; i < actividades.size(); i++) {
//            Actividad act = actividades.get(i);
//            if (act.getNombre().equals(nombreBuscar)
//                    && act.getClass().getSimpleName().equals("ActividadCualquiera")) {
//                return (OtraActividad) act;
//            }
//        }
//        return null;
//    }

//    public Alimentacion getAlimentacion(String nombreBuscar) {
//        for (int i = 0; i < actividades.size(); i++) {
//            Actividad act = actividades.get(i);
//            if (act.getNombre().equals(nombreBuscar)
//                    && act.getClass().getSimpleName().equals("Alimentacion")) {
//                return (Alimentacion) act;
//            }
//        }
//        return null;
//    }

    /* ADDERS */
    public void addPersona(Persona p) {
        switch (p.getClass().getSimpleName()) {
            case ("Adoptante"):
                adoptantes.add((Adoptante) p);
                break;
            case ("Responsable"):
                responsables.add((Responsable) p);
                break;
            case ("Padrino"):
                padrinos.add((Padrino) p);
                break;
        }
    }

    public void addAnimal(Animal animal) {
        animales.add(animal);
    }

    public void addActividad(Actividad act) {
        actividades.add(act);
        act.getUsuario().agregarActividad(act);
    }

    public void addVeterinaria(Veterinaria v) {
        veterinarias.add(v);
    }

//    /* DELETERS */
//    public void deleteActividad(Actividad act) throws AnimalException {
//        if (actividades.contains(act)) {
//            actividades.remove(act);
//        } else {
//            throw new AnimalException("no existe esa actividad");
//        }
//    }

}
