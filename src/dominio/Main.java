package dominio;


import interfaz.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        Sistema sis = new Sistema();
        new VentanaPrincipal().setVisible(true);
    } 
}
