package dominio.modelo;

import dominio.tools.RandomID;

public abstract class Persona {

    protected String id;
    protected String nombre;
    protected String apellido;
    protected String email;

    public Persona(String nombre, String apellido, String mail) {
        this.id = RandomID.getInstance().getNewID();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = mail;
    }

    public String getId() {
        return id;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        if (mail.equals("")) {
            this.email = "Sin-Mail";
        } else {
            this.email = mail;
        }
    }

    @Override
    public String toString() {
        return "Nombre=" + nombre + ", mail=" + email + '}';
    }

}
