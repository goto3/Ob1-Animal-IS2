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

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setListaAnimales(List<Animal> listaAnimales) {
        this.listaAnimales = listaAnimales;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public void setPeriodoPago(Periodo periodoPago) {
        this.periodoPago = periodoPago;
    }

    public void setTipoPago(Pago tipoPago) {
        this.tipoPago = tipoPago;
    }    
}
