package dominio.modelo.usuarios;

import dominio.modelo.Actividad;
import dominio.modelo.Persona;
import java.util.ArrayList;
import java.util.List;

public class Responsable extends Persona {

    List<Actividad> actividades;

    public Responsable() {
        super("Sin-Nombre", "Sin-Email");
        actividades = new ArrayList<>();
    }

    public Responsable(String nombre, String mail) {
        super(nombre, mail);
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
        return "Persona => Responsable: Nombre = "
                + this.nombre + ", mail = " + this.mail;
    }
}
