package dominio.modelo.personas;

import dominio.modelo.Persona;

public class Usuario extends Persona {

    String password;

    public Usuario(String nombre, String mail, String pass) {
        super(nombre, mail);
        password = pass;
    }
    
    public String getPassword(){
        return password;
    }

}
