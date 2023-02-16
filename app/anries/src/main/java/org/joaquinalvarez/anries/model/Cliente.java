package org.joaquinalvarez.anries.model;

public class Cliente extends Persona{
    private Integer nroCliente;
    private Localidad localidad;


    public Cliente() {
        super();
    }

    public Cliente(Integer nroCliente, Localidad localidad) {
        super();
        this.nroCliente = nroCliente;
        this.localidad = localidad;
    }

    public Integer getNroCliente() {
        return nroCliente;
    }

    public void setNroCliente(Integer nroCliente) {
        this.nroCliente = nroCliente;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}
