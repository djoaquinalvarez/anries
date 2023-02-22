package org.joaquinalvarez.anries.interfaces;

import org.joaquinalvarez.anries.model.Provincia;

import java.util.List;

public interface DAOProvincia {

    public void registrar(Provincia provincia) throws Exception;
    public void modificar(Provincia provincia) throws Exception;
    public void eliminar(Provincia provincia) throws Exception;
    public List<Provincia> listar() throws Exception;

}
