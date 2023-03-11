package org.joaquinalvarez.anries.interfaces;

import org.joaquinalvarez.anries.model.Articulo;

import java.rmi.server.ExportException;
import java.util.List;

public interface DAOArticulo {

    public void registrar(Articulo articulo) throws Exception;
    public void modificar(Articulo articulo) throws Exception;
    public void eliminar(Integer idArticulo) throws Exception;
    public List<Articulo> listar() throws Exception;
}
