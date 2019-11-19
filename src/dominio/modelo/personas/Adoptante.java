package dominio.modelo.personas;

import dominio.modelo.Animal;
import dominio.modelo.Persona;
import excepciones.AnimalException;
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

    public void addAnimal(Animal animal) throws AnimalException {
        if (animales.contains(animal)) {
            throw new AnimalException("Animal ya adoptado por este adoptante.");
        } else {
            animales.add(animal);
        }
    }

}
