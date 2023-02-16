package org.joaquinalvarez.anries.model;

import java.util.ArrayList;

public class Provincia {
    private String nombre;
    private ArrayList<Localidad> localidades;

    public Provincia(String nombre, ArrayList<Localidad> localidades) {
        this.nombre = nombre;
        this.localidades = localidades;
    }

    public Provincia() {
        this.localidades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(ArrayList<Localidad> localidades) {
        this.localidades = localidades;
    }
}
