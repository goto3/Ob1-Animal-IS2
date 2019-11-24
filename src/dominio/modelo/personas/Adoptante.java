package dominio.modelo.personas;

import dominio.modelo.Animal;
import dominio.modelo.Persona;
import java.util.ArrayList;
import java.util.List;

public class Adoptante extends Persona {

    private String telefono;
    private List<Animal> animales;

    public Adoptante(String nombre, String apellido, String email, String telefono) {
        super(nombre, apellido, email);
        this.apellido = apellido;
        this.telefono = telefono;
        this.animales = new ArrayList<>();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Animal> getAnimales() {
        return animales;
    }
    
    public void setAnimales(List<Animal> animales){
        this.animales = animales;
    }
    
    public void addAnimal(Animal a){
        this.animales.add(a);
    }

}
