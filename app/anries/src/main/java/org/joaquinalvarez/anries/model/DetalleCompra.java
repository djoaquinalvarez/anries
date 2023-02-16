package org.joaquinalvarez.anries.model;

public class DetalleCompra {
    private Articulo articulo;
    private Integer cantidadComprada;

    public DetalleCompra() {
    }

    public DetalleCompra(Articulo articulo, Integer cantidadComprada) {
        this.articulo = articulo;
        this.cantidadComprada = cantidadComprada;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Integer getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(Integer cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }
}
