package model;

public class Marca {
    private String nombre;
    private String descripcion;
    private double porcentajeGanancia;
    private Proveedor proveedor;

    public Marca() {
    }

    public Marca(String nombre, String descripcion, double porcentajeGanancia, Proveedor proveedor) {
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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
