package model;

public class DetalleVenta {
    private Articulo articulo;
    private Integer cantidadVendida;

    public DetalleVenta() {
    }

    public DetalleVenta(Articulo articulo, Integer cantidadVendida) {
        this.articulo = articulo;
        this.cantidadVendida = cantidadVendida;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Integer getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(Integer cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }
}
