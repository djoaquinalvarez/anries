package org.joaquinalvarez.anries.model;

public class Marca {
    private String nombre;
    private String descripcion;
    private double porcentajeGanancia;
    private Integer proveedor;

    public Marca() {
    }

    public Marca(String nombre, String descripcion, double porcentajeGanancia, Integer proveedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.porcentajeGanancia = porcentajeGanancia;
        this.proveedor = proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    public void setPorcentajeGanancia(double porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }

    public Integer getProveedor() {
        return proveedor;
    }

    public void setProveedor(Integer proveedor) {
        this.proveedor = proveedor;
    }
}
