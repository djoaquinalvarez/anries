package org.joaquinalvarez.anries.dao;

import org.joaquinalvarez.anries.interfaces.DAORol;
import org.joaquinalvarez.anries.model.Rol;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAORolImpl extends Conexion implements DAORol {

    @Override
    public void registrar(Rol rol) throws Exception {

    }

    @Override
    public void modificar(Rol rol) throws Exception {

    }

    @Override
    public void eliminar(Integer idRol) throws Exception {

    }

    @Override
    public List<Rol> listar() throws Exception {
        this.conectar();
        List<Rol> roles = new ArrayList<>();
        PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM Rol");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Rol rol = new Rol();
            rol.setId(rs.getInt("rol_id"));
            rol.setNombre(rs.getString("nombre"));
            rol.setDescripcion(rs.getString("descripcion"));
            roles.add(rol);
        }
        return roles;
    }
}
