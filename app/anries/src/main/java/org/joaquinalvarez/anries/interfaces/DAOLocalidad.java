package org.joaquinalvarez.anries.interfaces;

import org.joaquinalvarez.anries.model.Localidad;

import java.util.List;

public interface DAOLocalidad {

    public void registrar(Localidad localidad, Integer idProvincia) throws Exception;
    public void modificar(Localidad localidad, Integer idProvincia) throws Exception;
    public void eliminar(Integer idLocalidad) throws Exception;
    public List<Localidad> listar() throws Exception;
    public Localidad buscarLocalidadPorNombre(String nombre) throws Exception;

}
