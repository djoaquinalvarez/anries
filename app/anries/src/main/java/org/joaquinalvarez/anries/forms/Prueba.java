package org.joaquinalvarez.anries.forms;

import org.joaquinalvarez.anries.dao.DAOLocalidadImpl;
import org.joaquinalvarez.anries.dao.DAOProvinciaImpl;
import org.joaquinalvarez.anries.interfaces.DAOLocalidad;
import org.joaquinalvarez.anries.interfaces.DAOProvincia;
import org.joaquinalvarez.anries.model.Localidad;
import org.joaquinalvarez.anries.model.Provincia;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Prueba {
    public static void main(String[] args) throws Exception {
        List<Localidad> localidades = new ArrayList<>();
        List<Provincia> provincias = new ArrayList<>();
        DAOLocalidad daoLocalidad = new DAOLocalidadImpl();
        DAOProvincia daoProvincia = new DAOProvinciaImpl();
        localidades = daoLocalidad.listar();
        provincias = daoProvincia.listar();
        Stream<Provincia> streamProvincia = provincias.stream();
        for(Localidad localidad: localidades) {
            Optional<Provincia> provinciaDeLocalidad = streamProvincia.filter(p -> {
                        return p.getLocalidades().contains(localidad.getId());
                    })
                    .findFirst();
            provinciaDeLocalidad.ifPresent(p -> {
                System.out.println("El nombre de la provincia de la localidad es: " + p.getNombre());
            });
        };
    }
}
