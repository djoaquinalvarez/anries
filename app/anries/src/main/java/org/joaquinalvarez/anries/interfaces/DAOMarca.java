package org.joaquinalvarez.anries.interfaces;

import org.joaquinalvarez.anries.model.Marca;

import java.util.List;

public interface DAOMarca {

    public void registrar(Marca marca) throws Exception;
    public void modificar(Marca marca) throws Exception;
    public void eliminar(Integer idMarca) throws Exception;
    public List<Marca> listar() throws Exception;

}
