package dominio.modelo;

import dominio.Fecha;
import dominio.modelo.actividades.VisitaVeterinaria;
import java.util.ArrayList;

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

    public void setNombre(String nombre) {
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

    private boolean existeActividadEnEseMomento(Fecha fecha, int hora) {
        for (int i = 0; i < actividadesAgendadas.size(); i++) {
            Actividad actAgendada = actividadesAgendadas.get(i);
            if (fecha.getDia() == actAgendada.getFecha().getDia()
                    && fecha.getMes() == actAgendada.getFecha().getMes()
                    && fecha.getAno() == actAgendada.getFecha().getAno()
                    && hora == actAgendada.getHora().getHour()) {
                return true;
            }
        }
        return false;

    }

    public boolean agendarActividad(VisitaVeterinaria act) {
        int hora = act.getHora().getHour();
        if (hora >= horaInicial && hora <= horaFinal) {
            Fecha fecha = act.getFecha();
            if (!existeActividadEnEseMomento(fecha, hora)) {
                actividadesAgendadas.add(act);
                act.setVeterinaria(this);
                return true;
            }
        }
        return false;
    }

    public void EliminarActividadAgendada(Actividad act) {
        if (actividadesAgendadas.contains(act)) {
            actividadesAgendadas.remove(act);
        }
    }

    public int getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(int horaInicial) {
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

    public void setHoraFinal(int horaFinal) {
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
