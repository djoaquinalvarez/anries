package org.joaquinalvarez.anries.dao;

import org.joaquinalvarez.anries.interfaces.DAOEmpleado;
import org.joaquinalvarez.anries.model.Empleado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.time.*;

public class DAOEmpleadoImpl extends Conexion implements DAOEmpleado  {

    @Override
    public void registrar(Empleado empleado) throws Exception {
        System.out.println("ANTES DEL CONECTAR");
        this.conectar();
        System.out.println("DESPUES DEL CONECTAR");
        this.conexion.setAutoCommit(false);
        PreparedStatement stmtPersona = this.conexion
                .prepareStatement("INSERT INTO Persona(nombre, apellido, direccion, " +
                        "dni, fechaNacimiento, numeroTelefono) VALUES (?,?,?,?,?,?)");
        //Cargamos los datos correspondientes a la PERSONA
        stmtPersona.setString(1, empleado.getNombre());
        stmtPersona.setString(2, empleado.getApellido());
        stmtPersona.setString(3, empleado.getDireccion());
        stmtPersona.setInt(4, empleado.getDni());
        stmtPersona.setDate(5, java.sql.Date.valueOf(empleado.getFechaNacimiento()));
        stmtPersona.setInt(6, empleado.getNumeroTelefono());
        stmtPersona.executeUpdate();
        this.conexion.commit();

        System.out.println("EJECUTAMOS EL PRIMER COMMIT");

        PreparedStatement stmtEmpleado = this.conexion
                .prepareStatement("INSERT INTO Empleado(fechaIngreso, rol_id, persona_id) VALUES(?,?,?)");
        System.out.println("PASAMOS EL STATEMENT DE EMPLEADO");
        //Cargamos los datos corresopndientes al Empleado
        stmtEmpleado.setDate(1, java.sql.Date.valueOf(empleado.getFechaIngreso()));
        System.out.println("PASAMOS EL PRIMER PARAMETRO");
        stmtEmpleado.setInt(2, empleado.getRol()); //tengo que buscar el id del rol elegido
        System.out.println("PASAMOS EL SEGUNDO PARAMETRO");
        stmtEmpleado.setInt(3, buscarIdUltimaPersonaRegistrada()); //tengo que buscar el id de la persona registrada anteriormente
        System.out.println("ANTES DE LLEGAR AL 2DO UPDATE");
        stmtEmpleado.executeUpdate();
        System.out.println("LLEGAMOS HASTA ANTES DEL COMMIT");
        this.conexion.commit();
        System.out.println("SE EJECUTO TODO CORRECTAMENTE");
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
        //this.conectar();
        PreparedStatement stmt = this.conexion.prepareStatement("SELECT TOP 1 persona_id FROM Persona ORDER BY persona_id DESC");
        ResultSet rs = stmt.executeQuery();
        System.out.println("Ejecutamos la query");
        rs.next();
        System.out.println("EL id de la ultima persona registrada es: " + rs.getInt("persona_id"));
        return rs.getInt("persona_id");
    }
}
