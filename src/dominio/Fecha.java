package dominio;

import dominio.modelo.Actividad;
import java.util.ArrayList;

public class Fecha {

    private int dia;
    private int mes;
    private int ano;
    private final ArrayList<Actividad> actividades;

    private final int PRIMER_DIA_MES = 1;
    private final int ULTIMO_DIA_MES = 31;
    private final int DIA_ANO_BISIESTO = 29;
    private final int FEBRERO = 2;
    private final int PRIMER_MES_ANO = 1;
    private final int ULTIMO_MES_ANO = 12;

    private void calcularDia(int diaRecibido) {
        if (diaRecibido < PRIMER_DIA_MES) {
            this.dia = PRIMER_DIA_MES;
        } else if (diaRecibido > ULTIMO_DIA_MES) {
            this.dia = ULTIMO_DIA_MES;
        } else {
            this.dia = diaRecibido;
        }
    }

    private void calcularMes(int mesRecibido) {
        if (mesRecibido < PRIMER_MES_ANO) {
            this.mes = PRIMER_MES_ANO;
        } else if (mesRecibido > ULTIMO_MES_ANO) {
            this.mes = ULTIMO_MES_ANO;
        } else if (mesRecibido >= PRIMER_MES_ANO
                && mesRecibido <= ULTIMO_MES_ANO) {
            this.mes = mesRecibido;
            if (mes == FEBRERO && dia > DIA_ANO_BISIESTO) {
                this.dia = DIA_ANO_BISIESTO;
            }
        }
    }

    private void calcularAno(int anoRecibido) {
        this.ano = anoRecibido > 0 ? anoRecibido : 2019;
    }

    public Fecha(int dia, int mes, int ano) {
        calcularDia(dia);
        calcularMes(mes);
        calcularAno(ano);
        this.actividades = new ArrayList<>();
    }

    public Fecha() {
        this.dia = 1;
        this.mes = 1;
        this.ano = 2019;
        this.actividades = new ArrayList<>();
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dia > 0) {
            this.dia = dia > 31 ? 31 : dia;
        } else {
            this.dia = 1;
        }
        setMes(mes);
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (mes > 0 && mes < 13) {
            this.mes = mes;
            if (mes == 2 && dia > 29) {
                dia = 29;
            }
        } else {
            if (mes < 1) {
                this.mes = 1;
            }
            if (mes > 12) {
                this.mes = 12;
            }
        }

    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano > 0 ? ano : 2019;
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void agregarActividad(Actividad actividad) {
        actividades.add(actividad);
    }

    public void borrarActividad(Actividad actividad) {
        if (actividades.contains(actividad)) {
            actividades.remove(actividad);
        } else {
            System.out.println("No se pudo borrar actividad");
        }
    }

    @Override
    public String toString() {
        return "Fecha{" + "dia=" + dia + ", mes=" + mes + ", año=" + ano + ", actividades=" + actividades + '}';
    }

}
