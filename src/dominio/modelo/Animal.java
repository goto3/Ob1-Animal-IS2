package dominio.modelo;

import dominio.tools.EstadoAnimal;
import java.util.UUID;
import javax.swing.ImageIcon;

public class Animal {

    private String id;
    private String nombre;
    private String tipo;
    private double altura;
    private double peso;
    private String comentarios;
    private ImageIcon foto;
    private EstadoAnimal estado;

    public Animal() {
        this.id = UUID.randomUUID().toString();
        this.nombre = "Sin-Nombre";
        this.tipo = "Sin-tipo";
        this.altura = 0;
        this.peso = 0;
        this.comentarios = "Sin-Comentarios";
        this.foto = null;
        this.estado = EstadoAnimal.NO_ADOPTABLE;
    }

    public Animal(String nombre, String tipo, double altura, double peso, String comentarios) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.tipo = tipo;
        this.altura = altura;
        this.peso = peso;
        this.comentarios = comentarios;
        this.foto = null;
        this.estado = EstadoAnimal.NO_ADOPTABLE;
    }

    /* GETTERS */
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public String getComentarios() {
        return comentarios;
    }

    public ImageIcon getFoto() {
        return foto;
    }
    
    public EstadoAnimal getEstado(){
        return estado;
    }

    /* SETTERS */
    public void setNombre(String nombre) {
        if (nombre.equals("")) {
            this.nombre = "Sin-Nombre";
        } else {
            this.nombre = nombre;
        }
    }

    public void setTipo(String tipo) {
        if (tipo.equals("")) {
            this.tipo = "Sin-Nombre";
        } else {
            this.tipo = tipo;
        }
    }

    public void setAltura(double altura) {
        if (altura < 0) {
            this.altura = 0.0;
        } else {
            this.altura = altura;
        }
    }

    public void setPeso(double peso) {
        if (peso < 0) {
            this.peso = 0.0;
        } else {
            this.peso = peso;
        }
    }

    public void setComentarios(String comentarios) {
        if (comentarios.equals("")) {
            this.comentarios = "Sin-Comentarios";

        } else {
            this.comentarios = comentarios;
        }
    }

    public void setFoto(ImageIcon imagen) {
        this.foto = imagen;
    }
    
    public void setEstado(EstadoAnimal est){
        this.estado = est;
    }

    @Override
    public String toString() {
        return tipo + " {" + "\n  nombre = " + nombre + 
                            "\n  altura = " + altura + 
                            "\n  peso = " + peso +
                            "\n  comentarios = " + comentarios + "\n" + '}';
    }

}
