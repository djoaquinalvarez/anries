package org.joaquinalvarez.anries.model;


public class Articulo {
    private String nombre;
    private Marca marca;
    private Integer cantidadDisponible;
    private double costoCompra;
    private double precioPorUnidad;
    private UnidadMedida unidadMedida;
    private Integer minimaCantidadStock;

    public Articulo() {
    }

    public Articulo(String nombre, Marca marca, Integer cantidadDisponible, double costoCompra, double precioPorUnidad, UnidadMedida unidadMedida, Integer minimaCantidadStock) {
        this.nombre = nombre;
        this.marca = marca;
        this.cantidadDisponible = cantidadDisponible;
        this.costoCompra = costoCompra;
        this.precioPorUnidad = precioPorUnidad;
        this.unidadMedida = unidadMedida;
        this.minimaCantidadStock = minimaCantidadStock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public double getCostoCompra() {
        return costoCompra;
    }

    public void setCostoCompra(double costoCompra) {
        this.costoCompra = costoCompra;
    }

    public double getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public void setPrecioPorUnidad(double precioPorUnidad) {
        this.precioPorUnidad = precioPorUnidad;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getMinimaCantidadStock() {
        return minimaCantidadStock;
    }

    public void setMinimaCantidadStock(Integer minimaCantidadStock) {
        this.minimaCantidadStock = minimaCantidadStock;
    }

    public static void registrar(String nombre, String nombreMarca, Integer cantidadDisponible, Double costoCompra, Double precioPorUnidad, String nombreUnidadMedida, Integer minimaCantidadStock) {

    }
}
