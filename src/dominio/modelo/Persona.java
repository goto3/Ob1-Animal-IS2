package dominio.modelo;

public abstract class Persona {

    protected String nombre;
    protected String email;

    public Persona() {
        this.nombre = "Sin-Nombre";
        this.email = "Sin-Mail";
    }

    public Persona(String nombre, String mail) {
        this.nombre = nombre;
        this.email = mail;
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
