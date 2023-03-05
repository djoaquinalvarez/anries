package org.joaquinalvarez.anries.model;

import org.joaquinalvarez.anries.dao.DAOEmpleadoImpl;
import org.joaquinalvarez.anries.dao.DAORolImpl;
import org.joaquinalvarez.anries.interfaces.DAOEmpleado;
import org.joaquinalvarez.anries.interfaces.DAORol;

import java.time.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Empleado extends Persona{
    private Integer id;
    private Integer legajo;
    private LocalDate fechaIngreso;
    private Integer rol;

    public Empleado(String nombre, String apellido, String direccion, Integer dni, LocalDate fechaNacimiento, Integer numeroTelefono, Integer legajo, LocalDate fechaIngreso, Integer rol) {
        super(nombre, apellido, direccion, dni, fechaNacimiento, numeroTelefono);
        this.legajo = legajo;
        this.fechaIngreso = fechaIngreso;
        this.rol = rol;
    }

    public Empleado() {
        super();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }


    public static void registrar(String nombreEmpleado, String apellidoEmpleado, String direccion, Integer dni, String fechaNacimiento, Integer numeroTelefono, String fechaIngreso, String nombreRol) throws Exception {
        Empleado empleado = new Empleado();
        //conversiones de fechas
        LocalDate fechaNacimientoTransf = LocalDate.parse(fechaNacimiento);
        LocalDate fechaIngresoTransf = LocalDate.parse(fechaIngreso);

        empleado.setNombre(nombreEmpleado);
        empleado.setApellido(apellidoEmpleado);
        empleado.setDireccion(direccion);
        empleado.setDni(dni);
        empleado.setFechaNacimiento(fechaNacimientoTransf);
        empleado.setNumeroTelefono(numeroTelefono);
        empleado.setFechaIngreso(fechaIngresoTransf);;

        //Buscamos el id del rol seleccionado
        DAORol daoRol = new DAORolImpl();
        List<Rol> roles = daoRol.listar();
        Stream<Rol> streamRoles = roles.stream();
        Optional<Rol> rolSeleccionado = streamRoles.filter(r -> r.getNombre().equals(nombreRol))
                .findFirst();

        DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
        rolSeleccionado.ifPresent(r -> {
            try {
                empleado.setRol(r.getId());
                System.out.println("El rol del empleado es: " + empleado.getRol());
                daoEmpleado.registrar(empleado);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


    }
}
