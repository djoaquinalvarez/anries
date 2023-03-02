package org.joaquinalvarez.anries.model;

import java.time.*;

public class Empleado extends Persona{
    private Integer legajo;
    private LocalDate fechaIngreso;
    private Rol rol;

    public Empleado(String nombre, String apellido, String direccion, Integer dni, LocalDate fechaNacimiento, Integer numeroTelefono, Integer legajo, LocalDate fechaIngreso, Rol rol) {
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

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public static void registrar() {

    }
}
