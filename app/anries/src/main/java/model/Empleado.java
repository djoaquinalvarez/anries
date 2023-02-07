package model;

import java.util.Date;

public class Empleado extends Persona{
    private Integer legajo;
    private Date fechaIngreso;
    private Rol rol;

    public Empleado(String nombre, String apellido, String direccion, Integer dni, Date fechaNacimiento, Integer numeroTelefono, Integer legajo, Date fechaIngreso, Rol rol) {
        super(nombre, apellido, direccion, dni, fechaNacimiento, numeroTelefono);
        this.legajo = legajo;
        this.fechaIngreso = fechaIngreso;
        this.rol = rol;
    }

    public Empleado() {
        super();
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
