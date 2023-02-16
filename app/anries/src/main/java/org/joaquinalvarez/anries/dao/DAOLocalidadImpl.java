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
    public void registrar(Localidad localidad) throws Exception {
        try{
            this.conectar();
            PreparedStatement stmt = this.conexion.prepareStatement("INSERT INTO Localidad(nombre) VALUES(?)");
            conexion.setAutoCommit(false); //iniciamos la transaccion
            stmt.setString(1, localidad.getNombre());
            stmt.executeUpdate();
            conexion.commit();
        }catch(SQLException e) {
            e.printStackTrace();
            conexion.rollback();
        }finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Localidad localidad) throws Exception {
        try{
            this.conectar();
            PreparedStatement stmt = this.conexion.prepareStatement("UPDATE Localidad SET nombreLocalidad = ? WHERE nombreLocalidad = ?");
            stmt.setString(1, localidad.getNombre());
            stmt.setString(2, localidad.getNombre());
            stmt.executeUpdate();
        }catch(Exception e) {
            throw e;
        }finally {
            this.cerrar();
        }

    }

    @Override
    public void eliminar(Localidad localidad) throws Exception {
        try{
            this.conectar();
            PreparedStatement stmt = this.conexion.prepareStatement("DELETE from Localidad WHERE nombreLocalidad = ?");
            stmt.setString(1, localidad.getNombre());
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
            PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM Localidad");
            localidades = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Localidad localidad = new Localidad();
                localidad.setNombre(rs.getString("nombreLocalidad"));
                localidades.add(localidad);
            }
            rs.close();
            stmt.close();
            stmt.executeUpdate();
        }catch(Exception e) {
            throw e;
        }finally {
            this.cerrar();
        }
        return localidades;
    }
}
