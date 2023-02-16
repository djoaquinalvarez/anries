package org.joaquinalvarez.anries.model;

import java.util.ArrayList;
import java.util.Date;

public class Compra {
    private Proveedor proveedor;
    private Date fechaCompra;
    private double montoTotalCompra;
    private ArrayList<DetalleCompra> detalleCompra;

    public Compra() {
        this.detalleCompra = new ArrayList<>();
    }

    public Compra(Proveedor proveedor, Date fechaCompra, double montoTotalCompra, ArrayList<DetalleCompra> detalleCompra) {
        this.proveedor = proveedor;
        this.fechaCompra = fechaCompra;
        this.montoTotalCompra = montoTotalCompra;
        this.detalleCompra = detalleCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getMontoTotalCompra() {
        return montoTotalCompra;
    }

    public void setMontoTotalCompra(double montoTotalCompra) {
        this.montoTotalCompra = montoTotalCompra;
    }

    public ArrayList<DetalleCompra> getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(ArrayList<DetalleCompra> detalleCompra) {
        this.detalleCompra = detalleCompra;
    }
}
