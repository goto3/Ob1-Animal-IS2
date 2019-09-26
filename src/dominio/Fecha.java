package dominio;

import java.util.ArrayList;

public class Fecha {

    private int dia;
    private int mes;
    private int ano;
    private final ArrayList<Actividad> actividades;

    public Fecha(int dia, int mes, int ano) {
        if (dia > 0) {
            if (dia > 31) {
                this.dia = 31;
            } else {
                this.dia = dia;
            }
        } else {
            this.dia = 1;
        }
        if (mes > 0 && mes < 13) {
            this.mes = mes;
            if (mes == 2 && dia > 29) {
                this.dia = 29;
            }
        } else {
            if (mes < 1) {
                this.mes = 1;
            }
            if (mes > 12) {
                this.mes = 12;
            }
        }
        if (ano > 0) {
            this.ano = ano;
        } else {
            this.ano = 2018;
        }
        this.actividades = new ArrayList<>();
    }

    public Fecha() {
        this.dia = 1;
        this.mes = 1;
        this.ano = 2018;
        this.actividades = new ArrayList<>();
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dia > 0) {
            if (dia > 31) {
                this.dia = 31;
            } else {
                this.dia = dia;
            }
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
        if (ano > 0) {
            this.ano = ano;
        } else {
            this.ano = 2018;
        }
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
