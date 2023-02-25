package org.joaquinalvarez.anries.model;

import org.joaquinalvarez.anries.dao.DAOLocalidadImpl;
import org.joaquinalvarez.anries.dao.DAOProvinciaImpl;
import org.joaquinalvarez.anries.interfaces.DAOLocalidad;
import org.joaquinalvarez.anries.interfaces.DAOProvincia;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Localidad {
    private Integer id;
    private String nombre;

    public Localidad() {
    }

    public Localidad(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static void registrar(String nombre, String nombreProvincia) throws Exception {
        Localidad localidad = new Localidad(nombre); //creamos la instancia de localidad
        DAOProvincia daoProvincia = new DAOProvinciaImpl(); //instanciamos un daoProvincia para obtener el id de la provincia seleccionada
        Stream<Provincia> streamProvincia = daoProvincia.listar().stream();
        //buscamos el id de la provincia seleccionada
        Optional<Provincia> provinciaDeLocalidad= streamProvincia.filter(p -> p.getNombre().equals(nombreProvincia))
                .findFirst();

        DAOLocalidad daoLocalidad = new DAOLocalidadImpl(); //instanciamos un daoLocalidad para registrar la localidad
        provinciaDeLocalidad.ifPresent(provincia -> {
            try {
                daoLocalidad.registrar(localidad, provincia.getId());
                //localidad.setId(daoLocalidad.buscarLocalidadPorNombre(localidad.getNombre()).getId());
                //provincia.getLocalidades().add(localidad.getId());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        //buscamos el id del elemento registrado y lo guardamos en el objeto

    }

    public static void modificarLocalidad(Integer id, String nombreLocalidad, String nombreProvincia) throws Exception {
        Localidad localidad = new Localidad();
        localidad.setId(id);
        localidad.setNombre(nombreLocalidad);

        DAOProvincia daoProvincia = new DAOProvinciaImpl(); //instanciamos un daoProvincia para obtener el id de la provincia seleccionada
        Stream<Provincia> streamProvincia = daoProvincia.listar().stream();
        //buscamos el id de la provincia seleccionada
        Optional<Provincia> provinciaDeLocalidad= streamProvincia.filter(p -> p.getNombre().equals(nombreProvincia))
                .findFirst();

        DAOLocalidad daoLocalidad = new DAOLocalidadImpl();
        provinciaDeLocalidad.ifPresent(provincia -> {
            try {
                daoLocalidad.modificar(localidad, provincia.getId());
            }catch(Exception e) {
                e.printStackTrace();
            }
        });
    }

}
