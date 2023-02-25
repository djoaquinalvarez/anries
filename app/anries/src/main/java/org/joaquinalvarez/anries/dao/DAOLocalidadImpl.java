package org.joaquinalvarez.anries.dao;

import com.sun.tools.jconsole.JConsoleContext;
import org.joaquinalvarez.anries.interfaces.DAOLocalidad;
import org.joaquinalvarez.anries.model.Localidad;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOLocalidadImpl extends Conexion implements DAOLocalidad {


    @Override
    public void registrar(Localidad localidad, Integer idProvincia) throws Exception {
        try{
            this.conectar();
            PreparedStatement stmt = this.conexion.prepareStatement("INSERT INTO anries.dbo.localidad(nombre, provincia_id) VALUES(?, ?)");
            conexion.setAutoCommit(false); //iniciamos la transaccion
            stmt.setString(1, localidad.getNombre());
            stmt.setInt(2, idProvincia);
            stmt.executeUpdate();
            conexion.commit();

            //conseguimos el id del objeto registrado
            PreparedStatement stmt2 = this.conexion.prepareStatement("SELECT localidad_id FROM localidad WHERE nombre = ?");
            ResultSet rs = stmt2.executeQuery();
            localidad.setId(rs.getInt("localidad_id"));
            System.out.println("Id de la localidad registrada: " + localidad.getId());
        }catch(SQLException e) {
            e.printStackTrace();
            conexion.rollback();
        }finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Localidad localidad, Integer idProvincia) throws Exception {
        try{
            this.conectar();
            PreparedStatement stmt = this.conexion.prepareStatement("UPDATE anries.dbo.localidad SET nombre = ?, provincia_id = ? WHERE localidad_id = ?");
            conexion.setAutoCommit(false);
            stmt.setString(1, localidad.getNombre());
            stmt.setInt(2, idProvincia);
            stmt.setInt(3, localidad.getId());
            stmt.executeUpdate();
            conexion.commit();
        }catch(Exception e) {
            conexion.rollback();
            e.printStackTrace();
        }finally {
            this.cerrar();
        }

    }

    @Override
    public void eliminar(Localidad localidad) throws Exception {
        try{
            this.conectar();
            PreparedStatement stmt = this.conexion.prepareStatement("DELETE from anries.dbo.localidad WHERE localidad_id = ?");
            stmt.setInt(1, localidad.getId());
            stmt.executeUpdate();
        }catch(Exception e) {
            throw e;
        }finally {
            this.cerrar();
        }

    }

    @Override
    public List<Localidad> listar() throws Exception {
        List<Localidad> localidades = null;
        try{
            this.conectar();
            PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM anries.dbo.localidad");
            conexion.setAutoCommit(false);
            localidades = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Localidad localidad = new Localidad();
                localidad.setId(rs.getInt("localidad_id"));
                localidad.setNombre(rs.getString("nombre"));
                localidades.add(localidad);
            }
            stmt.executeUpdate();
            conexion.commit();
            rs.close();
            stmt.close();
        }catch(SQLException e) {
            conexion.rollback();
            e.printStackTrace();
        }finally {
            this.cerrar();
        }
        return localidades;
    }

    @Override
    public Localidad buscarLocalidadPorNombre(String nombre) throws Exception {
        this.conectar();
        PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM anries.dbo.localidad WHERE nombre = ?");
        stmt.setString(1, nombre);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        Localidad localidad = new Localidad();
        localidad.setId(rs.getInt("localidad_id"));
        localidad.setNombre(rs.getString("nombre"));

        return localidad;
    }
}
