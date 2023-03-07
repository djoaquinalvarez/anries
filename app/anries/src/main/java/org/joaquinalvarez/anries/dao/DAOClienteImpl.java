package org.joaquinalvarez.anries.dao;

import org.joaquinalvarez.anries.interfaces.DAOCliente;
import org.joaquinalvarez.anries.model.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    }

    @Override
    public void eliminar(Integer idCliente) throws Exception {

    }

    @Override
    public List<Cliente> listar() throws Exception {
        return null;
    }

    public Integer buscarIdUltimaPersonaRegistrada() throws Exception {
        //this.conectar();
        PreparedStatement stmt = this.conexion.prepareStatement("SELECT TOP 1 persona_id FROM Persona ORDER BY persona_id DESC");
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getInt("persona_id");
    }
}
