package org.joaquinalvarez.anries.dao;

import org.joaquinalvarez.anries.interfaces.DAOEmpleado;
import org.joaquinalvarez.anries.model.Empleado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.time.*;

public class DAOEmpleadoImpl extends Conexion implements DAOEmpleado  {

    @Override
    public void registrar(Empleado empleado, Integer idRol) throws Exception {
        this.conectar();
        this.conexion.setAutoCommit(false);
        PreparedStatement stmtPersona = this.conexion
                .prepareStatement("INSERT INTO Persona(nombre, apellido, direccion, " +
                        "dni, fechaNacimiento, numeroTelefono) VALUES (?,?,?,?,?,?)");
        PreparedStatement stmtEmpleado = this.conexion
                .prepareStatement("INSERT INTO Empleado(legajo, fechaIngreso, rol_id, persona_id)");
        //Cargamos los datos correspondientes a la PERSONA
        stmtPersona.setString(1, empleado.getNombre());
        stmtPersona.setString(2, empleado.getApellido());
        stmtPersona.setString(3, empleado.getDireccion());
        stmtPersona.setInt(4, empleado.getDni());
        stmtPersona.setDate(5, java.sql.Date.valueOf(empleado.getFechaNacimiento()));
        stmtPersona.setInt(6, empleado.getNumeroTelefono());
        stmtPersona.executeUpdate();
        this.conexion.commit();


        //Cargamos los datos corresopndientes al Empleado
        stmtEmpleado.setInt(1, empleado.getLegajo());
        stmtEmpleado.setDate(2, java.sql.Date.valueOf(empleado.getFechaIngreso()));
        stmtEmpleado.setInt(3, idRol); //tengo que buscar el id del rol elegido
        stmtEmpleado.setInt(4, buscarIdUltimaPersonaRegistrada()); //tengo que buscar el id de la persona registrada anteriormente
        stmtEmpleado.executeUpdate();
        this.conexion.commit();
    }

    @Override
    public void modificar(Empleado empleado) throws Exception {

    }

    @Override
    public void eliminar(Integer idEmpleado) throws Exception {

    }

    @Override
    public List<Empleado> listar() throws Exception {
        return null;
    }

    public Integer buscarIdUltimaPersonaRegistrada() throws Exception {
        this.conectar();
        PreparedStatement stmt = this.conexion.prepareStatement("SELECT TOP 1 persona_id FROM Persona ORDER BY persona_id DESC");
        ResultSet rs = stmt.executeQuery();
        rs.next();

        return rs.getInt("persona_id");
    }
}
