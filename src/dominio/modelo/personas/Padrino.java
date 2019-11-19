package dominio.modelo.personas;

import dominio.modelo.Animal;
import dominio.modelo.Persona;
import dominio.tools.Moneda;
import dominio.tools.Pago;
import dominio.tools.Periodo;
import java.util.ArrayList;
import java.util.List;

public class Padrino extends Persona {

    private String telefono;
    private String ciudad;
    private String pais;
    private List<Animal> listaAnimales;
    private int valor;
    private Moneda moneda;
    private Periodo periodoPago;
    private Pago tipoPago;

    public Padrino(String nombre, String apellido, String mail, String telefono,
            String ciudad, String pais, Pago tipoPago,
            Periodo tipoPeriodo, Moneda tipoMoneda, int valor) {
        super(nombre, apellido, mail);
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.pais = pais;
        this.listaAnimales = new ArrayList<>();
        this.valor = valor;
        this.moneda = tipoMoneda;
        this.periodoPago = tipoPeriodo;
        this.tipoPago = tipoPago;
    }

    public void agregarAnimal(Animal animalRecibido) {
        listaAnimales.add(animalRecibido);
    }

    public List<Animal> getListaAnimales() {
        return listaAnimales;
    }

    public String imprimirListaAnimales() {
        String list = "";
        for (int i = 0; i < listaAnimales.size(); i++) {
            list += listaAnimales.get(i).toString() + "\n";
        }
        return list;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona => Padrino "
                + "\nNombre = " + this.nombre
                + "\nApellido = " + this.apellido
                + "\nEmail = " + this.email
                + "\nCiudad = " + this.ciudad
                + "\nPais = " + this.pais
                + "\nValor = " + this.valor
                + "\nTelefono = " + this.telefono
                + "\nMoneda = " + this.moneda.toString()
                + "\nPeriodo de pago = " + this.periodoPago.toString()
                + "\nTipo de pago = " + this.tipoPago.toString()
                + "\nAnimales que apadrina:\n" + imprimirListaAnimales();
    }
}
