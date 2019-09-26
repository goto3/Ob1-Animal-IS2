package dominio;

import java.util.ArrayList;




public class Sistema {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Perro> perros;
    private final ArrayList<Actividad> listaActividades;
    private ArrayList<Fecha> listaFechas;
    private ArrayList<Veterinaria> listaVeterinarias;
    private ArrayList<ActividadCualquiera> listaActividadesCualquiera;
    private ArrayList<Paseo> listaPaseos;
    private ArrayList<Alimentacion> listaAlimentaciones;
    private ArrayList<VisitaVeterinaria> listaVisitas;

    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.perros = new ArrayList<>();
        this.listaActividades = new ArrayList<>();
        this.listaFechas = new ArrayList<>();
        this.listaVeterinarias = new ArrayList<>();
        this.listaPaseos = new ArrayList<>();
        this.listaAlimentaciones = new ArrayList<>();
        this.listaVisitas = new ArrayList<>();
        this.listaActividadesCualquiera = new ArrayList<>();
    }

    public ArrayList<Actividad> listaActividadesPorFecha(int dia, int mes, int ano) {
        ArrayList<Actividad> retLista = new ArrayList<>();
        if (dia >= 1 && dia <= 31 && mes >= 0 && mes <= 12 && ano >= 1) {
            for (int i = 0; i < listaActividades.size(); i++) {
                Actividad act = listaActividades.get(i);
                if (act.getFecha().getDia() == dia && act.getFecha().getMes() == mes && act.getFecha().getAno() == ano) {
                    retLista.add(act);
                }
            }
        }
        return retLista;
    }

    public ArrayList<Veterinaria> getVeterinarias() {
        return listaVeterinarias;
    }

    public void setVeterinarias(ArrayList<Veterinaria> veterinarias) {
        this.listaVeterinarias = veterinarias;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setPerros(ArrayList<Perro> perros) {
        this.perros = perros;
    }

    public ArrayList<Perro> getPerros() {
        return perros;
    }

    public ArrayList<Actividad> getActividades() {
        return listaActividades;
    }

    public void AnadirPerro(Perro perroAnadir) {
        perros.add(perroAnadir);
    }

    public void EliminarPerro(Perro perro) {
        if (perros.contains(perro)) {
            perros.remove(perro);
        } else {
            System.out.println("No existe tal perro");
        }
    }

    public void AnadirUsuario(Usuario personaAnadir) {
        usuarios.add(personaAnadir);
    }

    public void EliminarUsuario(Usuario persona) {
        if (usuarios.contains(persona)) {
            usuarios.remove(persona);
        } else {
            System.out.println("No existe tal persona");
        }
    }

    public void AnadirActividad(Actividad act) {
        listaActividades.add(act);
        act.getUsuario().agregarActividad(act);
    }

    public void EliminarActividad(Actividad act) {
        if (listaActividades.contains(act)) {
            listaActividades.remove(act);
        } else {
            System.out.println("No existe tal actividad");
        }
    }

    public void AnadirFecha(Fecha fecha) {
        listaFechas.add(fecha);
    }

    public void EliminarFecha(Fecha fecha) {
        if (listaFechas.contains(fecha)) {
            listaFechas.remove(fecha);
        } else {
            System.out.println("No existe tal fecha");
        }
    }

    public Usuario buscarUsuarioPorNombre(String nombreBuscar) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (nombreBuscar.equals(usuarios.get(i).getNombre())) {
                return usuarios.get(i);
            }
        }
        return null;
    }

    public Perro buscarPerroPorNombre(String nombreBuscar) {
        for (int i = 0; i < perros.size(); i++) {
            if (nombreBuscar.equals(perros.get(i).getNombre())) {
                return perros.get(i);
            }
        }
        return null;
    }

    public Veterinaria buscarVetPorNombre(String nombreBuscar) {
        for (int i = 0; i < listaVeterinarias.size(); i++) {
            if (nombreBuscar.equals(listaVeterinarias.get(i).getNombre())) {
                return listaVeterinarias.get(i);
            }
        }
        return null;
    }

    public Paseo buscarPaseoPorNombre(String nombreBuscar) {
        for (int i = 0; i < listaPaseos.size(); i++) {
            if (nombreBuscar.equals(listaPaseos.get(i).getNombre())) {
                return listaPaseos.get(i);
            }
        }
        return null;
    }

    public VisitaVeterinaria buscarVisitaPorNombre(String nombreBuscar) {
        for (int i = 0; i < listaVisitas.size(); i++) {
            if (nombreBuscar.equals(listaVisitas.get(i).getNombre())) {
                return listaVisitas.get(i);
            }
        }
        return null;
    }

    public ActividadCualquiera buscarActCualquieraPorNombre(String nombreBuscar) {
        for (int i = 0; i < listaActividadesCualquiera.size(); i++) {
            if (nombreBuscar.equals(listaActividadesCualquiera.get(i).getNombre())) {
                return listaActividadesCualquiera.get(i);
            }
        }
        return null;
    }

    public Alimentacion buscarAlimentacionPorNombre(String nombreBuscar) {
        for (int i = 0; i < listaAlimentaciones.size(); i++) {
            if (nombreBuscar.equals(listaAlimentaciones.get(i).getNombre())) {
                return listaAlimentaciones.get(i);
            }
        }
        return null;
    }

    public ArrayList<ActividadCualquiera> getActsCualquieras() {
        return listaActividadesCualquiera;
    }

    public void setActsCualquieras(ArrayList<ActividadCualquiera> actsCualquieras) {
        this.listaActividadesCualquiera = actsCualquieras;
    }

    public ArrayList<Paseo> getPaseos() {
        return listaPaseos;
    }

    public void setPaseos(ArrayList<Paseo> paseos) {
        this.listaPaseos = paseos;
    }

    public ArrayList<Alimentacion> getAlimentaciones() {
        return listaAlimentaciones;
    }

    public void setAlimentaciones(ArrayList<Alimentacion> alimentaciones) {
        this.listaAlimentaciones = alimentaciones;
    }

    public ArrayList<VisitaVeterinaria> getVisitas() {
        return listaVisitas;
    }

    public void setVisitas(ArrayList<VisitaVeterinaria> visitas) {
        this.listaVisitas = visitas;
    }

    public ArrayList<Fecha> getFechas() {
        return listaFechas;
    }

    public void setFechas(ArrayList<Fecha> fechas) {
        this.listaFechas = fechas;
    }

}
