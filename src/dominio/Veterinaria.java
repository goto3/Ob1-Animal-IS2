/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author marce
 */
public class Veterinaria {

    private String nombre;
    private ArrayList<Actividad> actividadesAgendadas;
    private int horaInicial;
    private int horaFinal;

    public Veterinaria() {
        this.nombre = "Sin-Nombre";
        this.actividadesAgendadas = new ArrayList<>();
        this.horaInicial = -1;
        this.horaFinal = -1;
    }

    public Veterinaria(String nombre, ArrayList<Actividad> actividadesAgendadas, int horaInicial, int horaFinal) {
        setNombre(nombre);
        this.actividadesAgendadas = actividadesAgendadas;
        setHoraInicial(horaInicial);
        setHoraFinal(horaFinal);
    }

    public String getNombre() {
        return this.nombre;
    }

    public final void setNombre(String nombre) {
        if (nombre.equals("")) {
            this.nombre = "Sin-Nombre";
        } else {
            this.nombre = nombre;
        }
    }

    public ArrayList<Actividad> getActividadesAgendadas() {
        return actividadesAgendadas;
    }

    public void setActividadesAgendadas(ArrayList<Actividad> actividadesAgendadas) {
        this.actividadesAgendadas = actividadesAgendadas;
    }

    public boolean AgendarActividad(VisitaVeterinaria act) {
        int hora = act.getHora().getHour();
        if (hora >= horaInicial && hora <= horaFinal) {
            Fecha fecha = act.getFecha();
            for (int i = 0; i < actividadesAgendadas.size(); i++) {
                Actividad actAgendada = actividadesAgendadas.get(i);
                if (fecha.getDia() == actAgendada.getFecha().getDia() && fecha.getMes()== actAgendada.getFecha().getMes()&& fecha.getAno()== actAgendada.getFecha().getAno()) {
                    if (hora == actAgendada.getHora().getHour()) {
                        return false;
                    }
                }
            }
            actividadesAgendadas.add(act);
            act.setVeterinaria(this);
        } else {
            return false;
        }
        return true;
    }

    public void EliminarActividadAgendada(Actividad act) {
        if (actividadesAgendadas.contains(act)) {
            actividadesAgendadas.remove(act);
        }
    }


    public int getHoraInicial() {
        return horaInicial;
    }

    public final void setHoraInicial(int horaInicial) {
        if (horaInicial < 0) {
            this.horaInicial = 0;
        } else {
            if (horaInicial > 23) {
                this.horaInicial = 23;
            } else {
                this.horaInicial = horaInicial;
            }
        }

    }

    public int getHoraFinal() {
        return horaFinal;
    }

    public final void setHoraFinal(int horaFinal) {
        if (horaFinal < 0) {
            this.horaFinal = 0;
        } else {
            if (horaFinal > 23) {
                this.horaFinal = 23;
            } else {
                this.horaFinal = horaFinal;
            }
        }
    }

    @Override
    public String toString() {
        return "Veterinaria{" + "nombre=" + nombre + ", actividadesAgendadas=" + actividadesAgendadas + ", horaInicial=" + horaInicial + ", horaFinal=" + horaFinal + '}';
    }

}
