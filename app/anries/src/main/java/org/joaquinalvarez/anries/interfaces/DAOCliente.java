package org.joaquinalvarez.anries.interfaces;

import org.joaquinalvarez.anries.model.Cliente;

import java.util.List;

public interface DAOCliente {
    public void registrar(Cliente cliente) throws Exception;
    public void modificar(Cliente cliente) throws Exception;
    public void eliminar(Integer idCliente) throws Exception;
    public List<Cliente> listar() throws Exception;
}
