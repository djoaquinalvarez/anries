package org.joaquinalvarez.anries.dao;

import org.joaquinalvarez.anries.interfaces.DAOArticulo;
import org.joaquinalvarez.anries.model.Articulo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        this.conectar();
        this.conexion.setAutoCommit(false);
        PreparedStatement stmt = this.conexion.prepareStatement("UPDATE Articulo SET nombre = ?, " +
                "marca_id = ?, " +
                "cantidadDisponible = ?, " +
                "costoCompra = ?, " +
                "precioPorUnidad = ?, " +
                "unidadmedida_id = ?, " +
                "minimaCantidadStock = ? " +
                "WHERE articulo_id = ?");
        stmt.setString(1, articulo.getNombre());
        stmt.setInt(2, articulo.getMarca());
        stmt.setInt(3, articulo.getCantidadDisponible());
        stmt.setDouble(4, articulo.getCostoCompra());
        stmt.setDouble(5, articulo.getPrecioPorUnidad());
        stmt.setInt(6, articulo.getUnidadMedida());
        stmt.setInt(7, articulo.getMinimaCantidadStock());
        stmt.setInt(8, articulo.getId());
        stmt.executeUpdate();
        this.conexion.commit();
    }

    @Override
    public void eliminar(Integer idArticulo) throws Exception {

    }

    @Override
    public List<Articulo> listar() throws Exception {
        this.conectar();
        List<Articulo> articulos = new ArrayList<>();
        this.conexion.setAutoCommit(false);
        PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM Articulo");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            Articulo articulo = new Articulo();
            articulo.setId(rs.getInt("articulo_id"));
            articulo.setNombre(rs.getString("nombre"));
            articulo.setMarca(rs.getInt("marca_id"));
            articulo.setCantidadDisponible(rs.getInt("cantidadDisponible"));
            articulo.setCostoCompra(rs.getDouble("costoCompra"));
            articulo.setPrecioPorUnidad(rs.getDouble("precioPorUnidad"));
            articulo.setUnidadMedida(rs.getInt("unidadmedida_id"));
            articulo.setMinimaCantidadStock(rs.getInt("minimaCantidadStock"));
            articulos.add(articulo);
        }
        return articulos;
    }
}
