package dominio.modelo;

import javax.swing.ImageIcon;

public class Animal {

    private String nombre;
    private String tipo;
    private double altura;
    private double peso;
    private String comentarios;
    private ImageIcon foto;

    public Animal() {
        this.nombre = "Sin-Nombre";
        this.tipo = "Sin-tipo";
        this.altura = 0;
        this.peso = 0;
        this.comentarios = "Sin-Comentarios";
        this.foto = null;
    }

    public Animal(String nombre, String tipo, double altura, double peso, String comentarios) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.altura = altura;
        this.peso = peso;
        this.comentarios = comentarios;
        this.foto = null;
    }

    /* GETTERS */
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

    @Override
    public String toString() {
        return "Perro{" + "nombre=" + nombre + ", altura=" + altura + ", peso=" + peso + ", comentarios=" + comentarios + '}';
    }

}
