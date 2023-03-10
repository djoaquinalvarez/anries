package org.joaquinalvarez.anries.dao;

import org.joaquinalvarez.anries.interfaces.DAOUnidadMedida;
import org.joaquinalvarez.anries.model.UnidadMedida;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOUnidadMedidaImpl extends Conexion implements DAOUnidadMedida {

    @Override
    public void registrar(UnidadMedida unidad) throws Exception {

    }

    @Override
    public void modificar(UnidadMedida unidad) throws Exception {

    }

    @Override
    public void eliminar(Integer idUnidad) throws Exception {

    }

    @Override
    public List<UnidadMedida> listar() throws Exception {
        this.conectar();
        List<UnidadMedida> unidades = new ArrayList<>();
        PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM UnidadMedida");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            UnidadMedida unidad = new UnidadMedida();
            unidad.setId(rs.getInt("unidadmedida_id"));
            unidad.setNombre(rs.getString("nombre"));
            unidad.setDescripcion(rs.getString("descripcion"));
            unidades.add(unidad);
        }
        return unidades;
    }
}
