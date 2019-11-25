package dominio.modelo;

import dominio.tools.EstadoAnimal;
import dominio.tools.RandomID;
import javax.swing.ImageIcon;

public class Animal {

    private String id;
    private String nombre;
    private String tipo;
    private int altura;
    private int peso;
    private String comentarios;
    private ImageIcon foto;
    private EstadoAnimal estado;

    public Animal() {
        this.id = RandomID.getInstance().getNewID();
    }

    public Animal(String nombre, String tipo, int altura, int peso, String comentarios) {
        this.id = RandomID.getInstance().getNewID();
        this.nombre = nombre;
        this.tipo = tipo;
        this.altura = altura;
        this.peso = peso;
        this.comentarios = comentarios;
        this.foto = null;
        this.estado = EstadoAnimal.NO_ADOPTABLE;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAltura() {
        return altura;
    }

    public int getPeso() {
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public void setFoto(ImageIcon imagen) {
        this.foto = imagen;
    }
    
    public void setEstado(EstadoAnimal est){
        this.estado = est;
    }

    @Override
    public String toString() {
        return tipo + " - " + nombre;
    }

}
