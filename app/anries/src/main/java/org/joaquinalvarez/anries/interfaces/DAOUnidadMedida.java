package org.joaquinalvarez.anries.interfaces;

import org.joaquinalvarez.anries.model.UnidadMedida;

import java.beans.ExceptionListener;
import java.util.List;

public interface DAOUnidadMedida {

    public void registrar(UnidadMedida unidad) throws Exception;
    public void modificar(UnidadMedida unidad) throws Exception;
    public void eliminar(Integer idUnidad) throws Exception;
    public List<UnidadMedida> listar() throws Exception;

}
