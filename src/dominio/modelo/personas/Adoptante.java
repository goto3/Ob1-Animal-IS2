package dominio.modelo.personas;

import dominio.modelo.Animal;
import dominio.modelo.Persona;
import excepciones.AnimalException;
import java.util.ArrayList;
import java.util.List;

public class Adoptante extends Persona {

    private String apellido;
    private String telefono;
    private List<Animal> animales;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
    
    public void addAnimal(Animal animal) throws AnimalException{
        if (animales.contains(animal)){
            throw new AnimalException("Animal ya adoptado por este adoptante.");
        }else{
            animales.add(animal);
        }
    }

    public Adoptante(String apellido, String telefono) {
        this.apellido = apellido;
        this.telefono = telefono;
        this.animales = new ArrayList<>();
    }

    public Adoptante(String apellido, String telefono, String nombre, String mail) {
        super(nombre, mail);
        this.apellido = apellido;
        this.telefono = telefono;
        this.animales = new ArrayList<>();
    }
}
