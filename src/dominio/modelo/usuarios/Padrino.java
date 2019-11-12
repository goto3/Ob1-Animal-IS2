package dominio.modelo.usuarios;

import dominio.modelo.Animal;
import dominio.modelo.Persona;
import dominio.tools.Moneda;
import dominio.tools.Pago;
import dominio.tools.Periodo;
import java.util.ArrayList;
import java.util.List;


public class Padrino extends Persona {
    
    private String apellido;
    private String telefono;
    private String ciudad;
    private String pais;
    private List <Animal> listaAnimales;
    private int valor;
    private Moneda moneda;
    private Periodo periodoPago;
    private Pago tipoPago;
    
    public Padrino(){
        super("Sin-Nombre", "Sin-Email");
        listaAnimales = new ArrayList<Animal>();
        this.valor = 0;
        this.apellido = "Sin-Apellido";
        this.telefono = "Sin-Telefono";
        this.ciudad = "Sin-Ciudad";
        this.pais = "Sin-Pais";
        this.moneda = Moneda.NO_ESPECIFICADA;
        this.periodoPago = Periodo.NO_ESPECIFICADO;
        this.tipoPago = Pago.NO_ESPECIFICADO; 
    }
    
    public Padrino(String nombre, String mail, String telefono, String apellido,
        String ciudad, String pais, Pago TIPO_PAGO, Periodo TIPO_PERIODO ,
        Moneda TIPO_MONEDA, ArrayList<Animal> listaAnimales, int valor) {
        super(nombre, mail);
        this.listaAnimales = listaAnimales;
        this.apellido = apellido;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.valor = valor;
        this.pais = pais;
        this.moneda = TIPO_MONEDA;
        this.periodoPago = TIPO_PERIODO;
        this.tipoPago = TIPO_PAGO;
    }
    
    public void agregarAnimal(Animal animalRecibido) {
        listaAnimales.add(animalRecibido);
    }

    public List<Animal> getListaAnimales() {
        return listaAnimales;
    }
    
    public String imprimirListaAnimales(){
        String list = "";
        for (int i = 0; i < listaAnimales.size(); i++) {
            list =  listaAnimales.get(i).toString() + "\n";
        }
        return list;
    }
    
    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public Periodo getPeriodoPago() {
        return periodoPago;
    }

    public Pago getTipoPago() {
        return tipoPago;
    }
    
    public int getValor() {
        return valor;
    }
    
    @Override
    public String toString() {
        String g = "Persona => Padrino: \n  Nombre = "
                + this.nombre + "\n  Apellido = " + this.apellido
                + "\n  Email = " + this.email + "\n  Ciudad = " + this.ciudad
                + "\n  Pais = " + this.pais + "\n  Valor = " + this.valor +
                "\n  Telefono = "+ this.telefono +
                "\n  Moneda = " + this.moneda.toString() +
                "\n  Periodo de pago = " + this.periodoPago.toString() +
                "\n  Tipo de pago = " + this.tipoPago.toString() +
                "\n  Animales que apadrina: " + imprimirListaAnimales();
        System.out.println(g);
        return g;
    }
}
