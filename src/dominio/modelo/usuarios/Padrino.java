package dominio.modelo.usuarios;

import dominio.modelo.Animal;
import dominio.modelo.Persona;
import java.util.ArrayList;
import java.util.List;

public class Padrino extends Persona {

    private String apellido;
    private String telefono;
    private String ciudad;
    private String pais;
    private List <Animal> listaAnimales;
    private String moneda;
    private String periodoPago;
    private String tipoPago;
    
    Padrino(){
        super("Sin-Nombre", "Sin-Email");
        listaAnimales = new ArrayList<Animal>();
        this.apellido = "Sin-Apellido";
        this.ciudad = "Sin-Ciudad";
        this.pais = "Sin-Pais";
        this.moneda = "Sin-Moneda";
        this.periodoPago = "Sin-Periodo de pago";
        this.tipoPago = "Sin-Tipo de pago";
        
    }
    
    Padrino(String nombre, String mail, String telefono, String apellido,
        String ciudad, String pais, String moneda, String periodoPago,
        String tipoPago, ArrayList<Animal> listaAnimales) {
        super(nombre, mail);
        this.listaAnimales = listaAnimales;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.pais = pais;
        this.moneda = moneda;
        this.periodoPago = periodoPago;
        this.tipoPago = tipoPago;
    }
    
    public void agregarAnimal(Animal animalRecibido) {
        listaAnimales.add(animalRecibido);
    }

    public List<Animal> getListaAnimales() {
        return listaAnimales;
    }
    
    private String imprimirListaAnimales(){
        String list = "";
        for (int i = 0; i < listaAnimales.size(); i++) {
            list =  listaAnimales.get(i).toString() + "\n";
        }
        return list;
    }
    
    @Override
    public String toString() {
        return "Persona => Padrino: \n  Nombre = "
                + this.nombre + "\n  Apellido = " + this.apellido
                + "\n  Email = " + this.email + "\n  Ciudad = " + this.ciudad
                + "\n  Pais = " + this.pais + "\n  Moneda = " + this.moneda
                +"\n  Periodo de pago = " + this.periodoPago +
                "\n  Tipo de pago = " + this.tipoPago +
                "\n  Animales que apadrina: " + imprimirListaAnimales();
    }
}
