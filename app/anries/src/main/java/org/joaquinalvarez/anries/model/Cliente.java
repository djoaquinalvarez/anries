package org.joaquinalvarez.anries.model;

import org.joaquinalvarez.anries.dao.DAOClienteImpl;
import org.joaquinalvarez.anries.dao.DAOLocalidadImpl;
import org.joaquinalvarez.anries.interfaces.DAOCliente;
import org.joaquinalvarez.anries.interfaces.DAOLocalidad;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Cliente extends Persona{
    private Integer id;
    private Integer nroCliente;
    private Integer localidad;


    public Cliente() {
        super();
    }

    public Cliente(Integer nroCliente, Integer localidad) {
        super();
        this.nroCliente = nroCliente;
        this.localidad = localidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNroCliente() {
        return nroCliente;
    }

    public void setNroCliente(Integer nroCliente) {
        this.nroCliente = nroCliente;
    }

    public Integer getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Integer localidad) {
        this.localidad = localidad;
    }

    public static void registrar(String nombre, String apellido, String direccion, Integer dni, String fechaNacimiento, Integer numeroTelefono, String nombreLocalidad) throws Exception {
        //Convertimos las fechas en formato LocalDate
        LocalDate fechaNacimientoTransf = LocalDate.parse(fechaNacimiento);

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccion(direccion);
        cliente.setDni(dni);
        cliente.setFechaNacimiento(fechaNacimientoTransf);
        cliente.setNumeroTelefono(numeroTelefono);


        //Buscamos la localidad seleccionada en la base de datos
        DAOLocalidad daoLocalidad = new DAOLocalidadImpl();
        List<Localidad> localidades = daoLocalidad.listar();
        Stream<Localidad> streamLocalidades = localidades.stream();
        Optional<Localidad> localidadSeleccionada = streamLocalidades
                .filter(l -> l.getNombre().equals(nombreLocalidad))
                .findFirst();

        DAOCliente daoCliente = new DAOClienteImpl();
        localidadSeleccionada.ifPresent(l -> {
            try {
                cliente.setLocalidad(l.getId());
                daoCliente.registrar(cliente);
            }catch(Exception e){
                e.printStackTrace();
            }
        });
    }

    public static void modificar(Integer idCliente, String nombre, String apellido, String direccion, Integer dni, String fechaNacimiento, Integer numeroTelefono, String nombreLocalidad) throws Exception {
        Cliente cliente = new Cliente();

        //Convertimos las fechas en formato LocalDate
        LocalDate fechaNacimientoTransf = LocalDate.parse(fechaNacimiento);


        cliente.setId(idCliente);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccion(direccion);
        cliente.setDni(dni);
        cliente.setFechaNacimiento(fechaNacimientoTransf);
        cliente.setNumeroTelefono(numeroTelefono);

        //Buscamos la localidad seleccionada en la base de datos
        DAOLocalidad daoLocalidad = new DAOLocalidadImpl();
        List<Localidad> localidades = daoLocalidad.listar();
        Stream<Localidad> streamLocalidades = localidades.stream();
        Optional<Localidad> localidadSeleccionada = streamLocalidades
                .filter(l -> l.getNombre().equals(nombreLocalidad))
                .findFirst();

        //Persistimos el objeto
        DAOCliente daoCliente = new DAOClienteImpl();
        localidadSeleccionada.ifPresent(l -> {
            try {
                cliente.setLocalidad(l.getId());
                daoCliente.modificar(cliente);
            }catch(Exception e){
                e.printStackTrace();
            }
        });

    }
}
