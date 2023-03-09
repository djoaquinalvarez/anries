package org.joaquinalvarez.anries.dao;

import org.joaquinalvarez.anries.interfaces.DAOArticulo;
import org.joaquinalvarez.anries.model.Articulo;

import java.sql.PreparedStatement;
import java.util.List;

public class DAOArticuloImpl extends Conexion implements DAOArticulo {
    @Override
    public void registrar(Articulo articulo) throws Exception {
        this.conectar();
        this.conexion.setAutoCommit(false);
        PreparedStatement stmt = this.conexion.prepareStatement("INSERT INTO Articulo" +
                "(nombre,marca_id,cantidadDisponible,costoCompra,precioPorUnidad,unidadmedida_id,minimaCantidadStock) " +
                "VALUES(?,?,?,?,?,?,?)");
        stmt.setString(1, articulo.getNombre());
        stmt.setInt(2, articulo.getMarca());
        stmt.setInt(3, articulo.getCantidadDisponible());
        stmt.setDouble(4, articulo.getCostoCompra());
        stmt.setDouble(5, articulo.getPrecioPorUnidad());
        stmt.setInt(6, articulo.getUnidadMedida());
        stmt.setInt(7, articulo.getMinimaCantidadStock());
        stmt.executeUpdate();
        this.conexion.commit();
    }

    @Override
    public void modificar(Articulo articulo) throws Exception {

    }

    @Override
    public void eliminar(Integer idArticulo) throws Exception {

    }

    @Override
    public List<Articulo> listar() throws Exception {
        return null;
    }
}
