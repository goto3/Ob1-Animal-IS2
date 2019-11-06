package dominio;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nombre;
    private String mail;
    private final List <Actividad> actividades;

    public Usuario(String nombre, String mail) {
        this.nombre = nombre;
        this.mail = mail;
        this.actividades = new ArrayList<>();
    }
    
    public Usuario() {
        this.nombre = "Sin-Nombre";
        this.mail = "Sin-Mail";
        this.actividades = new ArrayList<>();
    }

    public List <Actividad> getActividades() {
        return actividades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.equals("")) {
            this.nombre = "Sin-Nombre";
        } else {
            this.nombre = nombre;
        }
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        if (mail.equals("")) {
            this.mail = "Sin-Mail";
        } else {
            this.mail = mail;
        }
    }
    
    public void agregarActividad(Actividad act){
        actividades.add(act);
    }

    @Override
    public String toString() {
        return "Nombre=" + nombre + ", mail=" + mail + '}';
    }

}
