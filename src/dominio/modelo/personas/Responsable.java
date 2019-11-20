package dominio.modelo.personas;

import dominio.modelo.Actividad;
import dominio.modelo.Persona;
import java.util.ArrayList;
import java.util.List;

public class Responsable extends Persona {

    private List<Actividad> actividades;

    public Responsable(String nombre, String apellido, String mail) {
        super(nombre, apellido, mail);
        actividades = new ArrayList<>();
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void agregarActividad(Actividad act) {
        actividades.add(act);
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return this.nombre + " " + this.apellido;
=======
        return "Persona => Responsable: Nombre = "
                + this.nombre + ", apellido = " + this.apellido +
                ", mail = " + this.email;
>>>>>>> 0eb771c1bd56a9af8c96f68c6e615c756009d41d
    }
}
