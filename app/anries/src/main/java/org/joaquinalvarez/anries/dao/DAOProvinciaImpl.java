package org.joaquinalvarez.anries.dao;

import org.joaquinalvarez.anries.interfaces.DAOProvincia;
import org.joaquinalvarez.anries.model.Provincia;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
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
            e.printStackTrace();
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
                provincia.setLocalidades(buscarLocalidadesDeProvincia(provincia.getId()));
                provincias.add(provincia);
            }
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

    @Override
    public Provincia buscarProvinciaPorNombre(String nombre) throws Exception {
        this.conectar();
        PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM Provincia WHERE nombre = ?");
        stmt.setString(1, nombre);
        ResultSet rs = stmt.executeQuery();
        Provincia provincia = new Provincia();
        provincia.setId(rs.getInt("provincia_id"));
        provincia.setNombre(rs.getString("nombre"));
        provincia.setLocalidades(buscarLocalidadesDeProvincia(provincia.getId()));
        return provincia;
    }

    public ArrayList<Integer> buscarLocalidadesDeProvincia(Integer idProvincia) throws Exception {
        ArrayList<Integer> localidades = new ArrayList<>();
        this.conectar();
        PreparedStatement stmt = this.conexion.prepareStatement("SELECT localidad_id FROM Localidad JOIN Provincia ON (Localidad.provincia_id = ?)");
        stmt.setInt(1, idProvincia);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            localidades.add(rs.getInt("localidad_id"));
        }
        return localidades;
    }
}
