package org.joaquinalvarez.anries.model;

import java.util.ArrayList;
import java.util.Date;

public class Venta {
    private Cliente cliente;
    private Date fechaVenta;
    private double montoTotalVenta;
    private ArrayList<DetalleVenta> detalleVenta;

    public Venta() {
        this.detalleVenta = new ArrayList<>();
    }

    public Venta(Cliente cliente, Date fechaVenta, double montoTotalVenta, ArrayList<DetalleVenta> detalleVenta) {
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
        this.montoTotalVenta = montoTotalVenta;
        this.detalleVenta = detalleVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getMontoTotalVenta() {
        return montoTotalVenta;
    }

    public void setMontoTotalVenta(double montoTotalVenta) {
        this.montoTotalVenta = montoTotalVenta;
    }

    public ArrayList<DetalleVenta> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(ArrayList<DetalleVenta> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }
}
