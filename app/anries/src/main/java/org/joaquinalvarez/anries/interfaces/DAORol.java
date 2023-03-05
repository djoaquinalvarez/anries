package org.joaquinalvarez.anries.interfaces;

import org.joaquinalvarez.anries.model.Rol;

import java.util.List;

public interface DAORol {

    public void registrar(Rol rol) throws Exception;
    public void modificar(Rol rol) throws Exception;
    public void eliminar(Integer idRol) throws Exception;
    public List<Rol> listar() throws Exception;

}
