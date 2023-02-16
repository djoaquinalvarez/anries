package org.joaquinalvarez.anries.model;

public class Proveedor {
    private String nombre;
    private String direccion;
    private String razonSocial;
    private Localidad localidad;

    public Proveedor() {
    }

    public Proveedor(String nombre, String direccion, String razonSocial, Localidad localidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.razonSocial = razonSocial;
        this.localidad = localidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}
