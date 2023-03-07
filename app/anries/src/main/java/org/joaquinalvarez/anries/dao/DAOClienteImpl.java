package org.joaquinalvarez.anries.dao;

import org.joaquinalvarez.anries.interfaces.DAOCliente;
import org.joaquinalvarez.anries.model.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOClienteImpl extends Conexion implements DAOCliente {

    @Override
    public void registrar(Cliente cliente) throws Exception {
        this.conectar();
        this.conexion.setAutoCommit(false);
        PreparedStatement stmtPersona = this.conexion
                .prepareStatement("INSERT INTO Persona(nombre, apellido, direccion, " +
                        "dni, fechaNacimiento, numeroTelefono) VALUES (?,?,?,?,?,?)");
        //Cargamos los datos correspondientes a la PERSONA
        stmtPersona.setString(1, cliente.getNombre());
        stmtPersona.setString(2, cliente.getApellido());
        stmtPersona.setString(3, cliente.getDireccion());
        stmtPersona.setInt(4, cliente.getDni());
        stmtPersona.setDate(5, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
        stmtPersona.setInt(6, cliente.getNumeroTelefono());
        stmtPersona.executeUpdate();
        this.conexion.commit();

        PreparedStatement stmtCliente = this.conexion.prepareStatement("INSERT INTO Cliente(localidad_id, persona_id) VALUES(?,?)");
        stmtCliente.setInt(1, cliente.getLocalidad());
        stmtCliente.setInt(2, buscarIdUltimaPersonaRegistrada());
        stmtCliente.executeUpdate();
        this.conexion.commit();
    }

    @Override
    public void modificar(Cliente cliente) throws Exception {
        this.conectar();
        this.conexion.setAutoCommit(false);
        PreparedStatement stmtCliente = this.conexion.prepareStatement("UPDATE Cliente SET localidad_id = ? WHERE cliente_id = ?");
        stmtCliente.setInt(1, cliente.getLocalidad());
        stmtCliente.setInt(2, cliente.getId());
        stmtCliente.executeUpdate();
        this.conexion.commit();


        PreparedStatement stmtPersona = this.conexion.prepareStatement("UPDATE Persona SET nombre = ?,"+
                "apellido = ?," +
                "direccion = ?," +
                "dni = ?," +
                "numeroTelefono = ?," +
                "fechaNacimiento = ? " +
                "WHERE Persona.persona_id = (SELECT persona_id FROM Cliente WHERE cliente_id = ?)");
        stmtPersona.setString(1, cliente.getNombre());
        stmtPersona.setString(2, cliente.getApellido());
        stmtPersona.setString(3, cliente.getDireccion());
        stmtPersona.setInt(4, cliente.getDni());
        stmtPersona.setInt(5, cliente.getNumeroTelefono());
        stmtPersona.setDate(6, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
        stmtPersona.setInt(7, cliente.getId());
        stmtPersona.executeUpdate();
        this.conexion.commit();
    }

    @Override
    public void eliminar(Integer idCliente) throws Exception {

    }

    @Override
    public List<Cliente> listar() throws Exception {
        this.conectar();
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement stmtCliente = this.conexion.prepareStatement("SELECT " +
                "p.nombre, " +
                "p.apellido, " +
                "p.direccion, " +
                "p.dni, " +
                "p.fechaNacimiento, " +
                "p.numeroTelefono, " +
                "c.cliente_id, " +
                "c.localidad_id " +
                "FROM Cliente AS c " +
                "INNER JOIN Persona AS p ON (c.persona_id = p.persona_id)");
        ResultSet rs = stmtCliente.executeQuery();
        while(rs.next()){
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("cliente_id"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellido(rs.getString("apellido"));
            cliente.setDireccion(rs.getString("direccion"));
            cliente.setDni(rs.getInt("dni"));
            cliente.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
            cliente.setNumeroTelefono(rs.getInt("numeroTelefono"));
            cliente.setLocalidad(rs.getInt("localidad_id"));
            clientes.add(cliente);
        }
        return clientes;
    }

    public Integer buscarIdUltimaPersonaRegistrada() throws Exception {
        //this.conectar();
        PreparedStatement stmt = this.conexion.prepareStatement("SELECT TOP 1 persona_id FROM Persona ORDER BY persona_id DESC");
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getInt("persona_id");
    }
}
