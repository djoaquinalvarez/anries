package org.joaquinalvarez.anries.dao;

import org.joaquinalvarez.anries.interfaces.DAOEmpleado;
import org.joaquinalvarez.anries.model.Empleado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.time.*;

public class DAOEmpleadoImpl extends Conexion implements DAOEmpleado  {

    @Override
    public void registrar(Empleado empleado) throws Exception {
        this.conectar();
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

        PreparedStatement stmtEmpleado = this.conexion
                .prepareStatement("INSERT INTO Empleado(fechaIngreso, rol_id, persona_id) VALUES(?,?,?)");
        //Cargamos los datos corresopndientes al Empleado
        stmtEmpleado.setDate(1, java.sql.Date.valueOf(empleado.getFechaIngreso()));
        stmtEmpleado.setInt(2, empleado.getRol()); //tengo que buscar el id del rol elegido
        stmtEmpleado.setInt(3, buscarIdUltimaPersonaRegistrada()); //tengo que buscar el id de la persona registrada anteriormente
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
        List<Empleado> empleados = new ArrayList<>();
        this.conectar();
        PreparedStatement stmt = this.conexion.prepareStatement("SELECT " +
                "e.empleado_id," +
                "e.rol_id," +
                "p.nombre," +
                "p.nombre," +
                "p.apellido," +
                "p.direccion," +
                "p.dni," +
                "p.fechaNacimiento," +
                "p.numeroTelefono," +
                "e.fechaIngreso " +
                "FROM Persona as p " +
                "INNER JOIN Empleado AS e ON (e.persona_id = p.persona_id)");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            Empleado empleado = new Empleado();
            empleado.setId(rs.getInt("empleado_id"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setApellido(rs.getString("apellido"));
            empleado.setDireccion(rs.getString("direccion"));
            empleado.setDni(rs.getInt("dni"));
            empleado.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
            empleado.setNumeroTelefono(rs.getInt("numeroTelefono"));
            empleado.setFechaIngreso(rs.getDate("fechaIngreso").toLocalDate());
            empleado.setRol(rs.getInt("rol_id"));
            empleados.add(empleado);
        }
        System.out.println("listado de empleados: " + empleados);
        return empleados;
    }

    public Integer buscarIdUltimaPersonaRegistrada() throws Exception {
        //this.conectar();
        PreparedStatement stmt = this.conexion.prepareStatement("SELECT TOP 1 persona_id FROM Persona ORDER BY persona_id DESC");
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getInt("persona_id");
    }
}
