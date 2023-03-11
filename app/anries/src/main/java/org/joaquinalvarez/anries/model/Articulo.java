package org.joaquinalvarez.anries.model;


import org.joaquinalvarez.anries.dao.DAOArticuloImpl;
import org.joaquinalvarez.anries.dao.DAOMarcaImpl;
import org.joaquinalvarez.anries.dao.DAOUnidadMedidaImpl;
import org.joaquinalvarez.anries.interfaces.DAOArticulo;
import org.joaquinalvarez.anries.interfaces.DAOMarca;
import org.joaquinalvarez.anries.interfaces.DAOUnidadMedida;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Articulo {
    private Integer id;
    private String nombre;
    private Integer marca;
    private Integer cantidadDisponible;
    private double costoCompra;
    private double precioPorUnidad;
    private Integer unidadMedida;
    private Integer minimaCantidadStock;

    public Articulo() {
    }

    public Articulo(String nombre, Integer marca, Integer cantidadDisponible, double costoCompra, double precioPorUnidad, Integer unidadMedida, Integer minimaCantidadStock) {
        this.nombre = nombre;
        this.marca = marca;
        this.cantidadDisponible = cantidadDisponible;
        this.costoCompra = costoCompra;
        this.precioPorUnidad = precioPorUnidad;
        this.unidadMedida = unidadMedida;
        this.minimaCantidadStock = minimaCantidadStock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMarca() {
        return marca;
    }

    public void setMarca(Integer marca) {
        this.marca = marca;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public double getCostoCompra() {
        return costoCompra;
    }

    public void setCostoCompra(double costoCompra) {
        this.costoCompra = costoCompra;
    }

    public double getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public void setPrecioPorUnidad(double precioPorUnidad) {
        this.precioPorUnidad = precioPorUnidad;
    }

    public Integer getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(Integer unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getMinimaCantidadStock() {
        return minimaCantidadStock;
    }

    public void setMinimaCantidadStock(Integer minimaCantidadStock) {
        this.minimaCantidadStock = minimaCantidadStock;
    }

    public static void registrar(String nombre, Integer idMarca, Integer cantidadDisponible, Double costoCompra, Double precioPorUnidad, String nombreUnidadMedida, Integer minimaCantidadStock) throws Exception {
        Articulo articulo = new Articulo();
        articulo.setNombre(nombre);
        articulo.setCantidadDisponible(cantidadDisponible);
        articulo.setCostoCompra(costoCompra);
        articulo.setPrecioPorUnidad(precioPorUnidad);
        articulo.setMinimaCantidadStock(minimaCantidadStock);
        articulo.setMarca(idMarca);

        //Buscamos la unidad de medida seleccionada en la base de datos
        DAOUnidadMedida daoUnidadMedida = new DAOUnidadMedidaImpl();
        List<UnidadMedida> unidades = daoUnidadMedida.listar();
        Stream<UnidadMedida> streamUnidades = unidades.stream();
        Optional<UnidadMedida> unidadSeleccionada = streamUnidades
                .filter(u -> u.getNombre().equals(nombreUnidadMedida))
                .findFirst();

        //Seteamos el id de la unidad de medida en el articulo
        unidadSeleccionada.ifPresent(u -> {
            try{
                articulo.setUnidadMedida(u.getId());
                DAOArticulo daoArticulo = new DAOArticuloImpl();
                daoArticulo.registrar(articulo);
            }catch(Exception e){
                e.printStackTrace();
            }
        });
    }

    public static void modificar(Integer idArticulo, String nombre, Integer idMarca, Integer cantidadDisponible, Double costoCompra, Double precioPorUnidad, Integer idUnidad, Integer minimaCantidadStock) throws Exception {
        Articulo articulo = new Articulo();
        articulo.setId(idArticulo);
        articulo.setNombre(nombre);
        articulo.setMarca(idMarca);
        articulo.setCantidadDisponible(cantidadDisponible);
        articulo.setCostoCompra(costoCompra);
        articulo.setPrecioPorUnidad(precioPorUnidad);
        articulo.setUnidadMedida(idUnidad);
        articulo.setMinimaCantidadStock(minimaCantidadStock);

        DAOArticulo daoArticulo = new DAOArticuloImpl();
        daoArticulo.registrar(articulo);
    }
}
