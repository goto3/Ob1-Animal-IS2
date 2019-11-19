package dominio.modelo.personas;

import dominio.modelo.Persona;

public class Usuario extends Persona {

    String password;

    public Usuario(String nombre, String apellido, String mail, String pass) {
        super(nombre, apellido, mail);
        password = pass;
    }

    public String getPassword() {
        return password;
    }

}
