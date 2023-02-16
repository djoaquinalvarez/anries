package org.joaquinalvarez.anries.model;

import org.joaquinalvarez.anries.dao.DAOLocalidadImpl;
import org.joaquinalvarez.anries.interfaces.DAOLocalidad;

public class Localidad {
    private String nombre;

    public Localidad() {
    }

    public Localidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static void registrar(String nombre) {
        Localidad localidad = new Localidad(nombre);
        DAOLocalidad dao = new DAOLocalidadImpl();
        try {
            dao.registrar(localidad);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
