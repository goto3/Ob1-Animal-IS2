package dominio;

import javax.swing.ImageIcon;

public class Perro {

    private String nombre;
    private double altura;
    private double peso;
    private String comentarios;
    private ImageIcon foto;

    public Perro(String nombre, double altura, double peso, String comentarios) { //Sin foto
        setNombre(nombre);
        setAltura(altura);
        setPeso(peso);
        setComentarios(comentarios);
        this.foto = null;
    }

    public Perro() { //Sin foto
        this.nombre = "Sin-Nombre";
        this.altura = 0;
        this.peso = 0;
        this.comentarios = "Sin-Comentarios";
        this.foto = null;
    }

    public String getNombre() {
        return nombre;
    }

    public final void setNombre(String nombre) {
        if (nombre.equals("")) {
            this.nombre = "Sin-Nombre";
        } else {
            this.nombre = nombre;
        }

    }

    public double getAltura() {
        return altura;
    }

    public final void setAltura(double altura) {
        if (altura < 0) {
            this.altura = 0.0;
        } else {
            this.altura = altura;
        }

    }

    public double getPeso() {
        return peso;
    }

    public final void setPeso(double peso) {
        if (peso < 0) {
            this.peso = 0.0;
        } else {
            this.peso = peso;
        }
    }

    public String getComentarios() {
        return comentarios;
    }

    public final void setComentarios(String comentarios) {
        if (comentarios.equals("")) {
            this.comentarios = "Sin-Comentarios";

        } else {
            this.comentarios = comentarios;
        }
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon imagen) {
        this.foto = imagen;
    }

    @Override
    public String toString() {
        return "Perro{" + "nombre=" + nombre + ", altura=" + altura + ", peso=" + peso + ", comentarios=" + comentarios + '}';
    }

    

}
