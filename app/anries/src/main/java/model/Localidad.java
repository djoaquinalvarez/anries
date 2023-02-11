package model;

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
    }
}
