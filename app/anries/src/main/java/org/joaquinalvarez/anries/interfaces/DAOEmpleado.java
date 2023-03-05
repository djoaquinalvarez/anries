package org.joaquinalvarez.anries.interfaces;

import org.joaquinalvarez.anries.model.Empleado;

import java.sql.SQLException;
import java.util.List;

public interface DAOEmpleado {

    public void registrar(Empleado empleado) throws Exception;
    public void modificar(Empleado empleado) throws Exception;
    public void eliminar(Integer idEmpleado) throws Exception;
    public List<Empleado> listar() throws Exception;

}
