package org.joaquinalvarez.anries.model;

import java.util.ArrayList;

public class Provincia {
    private Integer id;
    private String nombre;
    private ArrayList<Localidad> localidades;

    public Provincia(String nombre, ArrayList<Localidad> localidades) {
        this.nombre = nombre;
        this.localidades = localidades;
    }

    public Provincia() {
        this.localidades = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
