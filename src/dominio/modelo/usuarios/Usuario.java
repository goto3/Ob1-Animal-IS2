package dominio.modelo.usuarios;

import dominio.modelo.Persona;

public class Usuario extends Persona {

    String password;

    Usuario(String nombre, String mail) {
        super(nombre, mail);
        password = "";
    }

}
