package org.joaquinalvarez.anries.dao;

import org.joaquinalvarez.anries.interfaces.DAOProvincia;
import org.joaquinalvarez.anries.model.Provincia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOProvinciaImpl extends Conexion implements DAOProvincia {

    @Override
    public void registrar(Provincia provincia) throws Exception {
        try {
            this.conectar();
            PreparedStatement stmt = this.conexion.prepareStatement("INSERT INTO provincia(nombre) VALUES (?)");
            conexion.setAutoCommit(false);
            stmt.setString(1, provincia.getNombre());
            stmt.executeUpdate();
            conexion.commit();
        } catch(SQLException e) {
            e.printStackTrace();
            conexion.rollback();
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void modificar(Provincia provincia) throws Exception {
        try {
            this.conectar();
            conexion.setAutoCommit(false);
            PreparedStatement stmt = this.conexion.prepareStatement("UPDATE provincia SET nombre = ? WHERE provincia_id = ?");
            stmt.setString(1, provincia.getNombre());
            stmt.setInt(2, provincia.getId());
            stmt.executeUpdate();
            conexion.commit();
        }catch(SQLException e) {
            conexion.rollback();
            e.printStackTrace();
        }finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Provincia provincia) throws Exception {
        try {
            this.conectar();
            PreparedStatement stmt = this.conexion.prepareStatement("DELETE FROM provincia WHERE provincia_id = ?");
            stmt.setInt(1, provincia.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.getNextException();
        }finally {
            this.cerrar();
        }
    }

    @Override
    public List<Provincia> listar() throws Exception {
        List<Provincia> provincias = null;
        try {
            this.conectar();
            PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM provincia");
            conexion.setAutoCommit(false);
            provincias = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Provincia provincia = new Provincia();
                provincia.setId(rs.getInt("provincia_id"));
                provincia.setNombre(rs.getString("nombre"));
                provincias.add(provincia);
            }
            stmt.executeUpdate();
            conexion.commit();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            conexion.rollback();
            e.printStackTrace();
        }finally {
            this.cerrar();
        }
        return provincias;
    }
}
