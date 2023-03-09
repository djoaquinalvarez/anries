package org.joaquinalvarez.anries.dao;

import org.joaquinalvarez.anries.interfaces.DAOMarca;
import org.joaquinalvarez.anries.model.Marca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOMarcaImpl extends Conexion implements DAOMarca {

    @Override
    public void registrar(Marca marca) throws Exception {

    }

    @Override
    public void modificar(Marca marca) throws Exception {

    }

    @Override
    public void eliminar(Integer idMarca) throws Exception {

    }

    @Override
    public List<Marca> listar() throws Exception {
        this.conectar();
        List<Marca> marcas = new ArrayList<>();
        PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM Marca");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Marca marca = new Marca();
            marca.setNombre(rs.getString("nombre"));
            marca.setDescripcion(rs.getString("descripcion"));
            marca.setPorcentajeGanancia(rs.getDouble("porcentajeGanancia"));
            marca.setProveedor(rs.getInt("proveedor_id"));
            marcas.add(marca);
        }
        return marcas;
    }
}
